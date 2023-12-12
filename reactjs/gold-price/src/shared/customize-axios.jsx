import axios from "axios";
import configApi from "../config/configApi";
import Cookies from "universal-cookie";

const instance = axios.create({
  baseURL: configApi.hostName,
});

const cookiesToken = new Cookies();

// Function to refresh token and retry request
const refreshAndRetry = async (error) => {
  const refreshToken = cookiesToken.get("refreshToken");

  try {
    const newRestoken = await instance.post("refreshToken", { refreshToken });

    if(newRestoken.status === '200'){
        //Token Refresh Success
        const newAccessToken = newRestoken.data.tokenDto.accessToken;
        cookiesToken.set("accessToken", newAccessToken, { path: "/" });
        // Resubmit the request with a new token
        return instance(error.config);
    }else{
        //Token Refresh Faild
        cookiesToken.remove('accessToken');
        cookiesToken.remove('refreshToken');
        cookiesToken.remove('lastName');
        window.location.href = "/login";
    }
  } catch (refreshError) {
    window.alert("Error refreshing token:", refreshError);
    throw error; // Throw the original error if refresh token fails
  }
};

instance.interceptors.request.use(
  function (config) {
    const token = cookiesToken.get("accessToken");

    if (token && config.url !== "refreshToken") {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  function (error) {
    return Promise.reject(error);
  }
);

instance.interceptors.response.use(
  async function (response) {
    if (response.data.status === "403") {
      return refreshAndRetry(response);
    } else {
      return response.data
        ? response.data
        : { statusCode: response.statusText };
    }
  },
  function (error) {
    // Another Error
    let res = {};
    if (error.response) {
      res.status = error.response.status;
      res.errMsg = error.response.errMsg;
      res.data = error.response.data;
    } else {
      res.status = "400";
      res.errMsg = error.errMsg;
      res.data = "";
    }
    return res;
  }
);

export default instance;
