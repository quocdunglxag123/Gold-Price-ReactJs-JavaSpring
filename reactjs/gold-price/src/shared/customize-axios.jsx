import axios from "axios";

const instance = axios.create({
    baseURL: "http://localhost:8089/"
})

instance.interceptors.request.use(
    (config) => {
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

instance.interceptors.response.use(function(response) {
    return response.data? response.data : {statusCode : response.statusText};
},function(error){
    let res = {};
    if(error.response){
        res.status = error.response.status;
        res.errMsg = error.response.errMsg;
        res.data = error.response.data;
    }else{
        res.status = '400';
        res.errMsg = error.errMsg;
        res.data = '';
    }
    return res;
});
export default instance;