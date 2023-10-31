import axios from '../shared/customize-axios';

const loginApi = (serviceCall, username, password) => {
    return axios.post("login", {serviceCall, username, password});
}

const registerApi = (serviceCall, firstName, lastName, username, password, address, phoneNumber, birthday) => {
    return axios.post("register", {serviceCall, firstName, lastName, username, password, address, phoneNumber, birthday});
}

export {loginApi, registerApi}