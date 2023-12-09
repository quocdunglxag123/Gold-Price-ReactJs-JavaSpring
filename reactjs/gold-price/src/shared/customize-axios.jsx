// Trong file customize-axios.jsx
import axios from "axios";
import configApi from "../config/configApi";
import Cookies from 'universal-cookie';

const instance = axios.create({
    baseURL: configApi.hostName
});

instance.interceptors.request.use(function (config) {
    const cookies = new Cookies();
    const token = cookies.get('accessToken');

    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, function (error) {
    return Promise.reject(error);
});

instance.interceptors.response.use(function(response) {
    return response.data ? response.data : { statusCode: response.statusText };
}, function(error) {
    let res = {};
    if (error.response) {
        res.status = error.response.status;
        res.errMsg = error.response.errMsg;
        res.data = error.response.data;
    } else {
        res.status = '400';
        res.errMsg = error.errMsg;
        res.data = '';
    }
    return res;
});

export default instance;
