import axios from '../shared/customize-axios';

const loginApi = (serviceCall, username, password) => {
    return axios.post("login", {serviceCall, username, password});
}

const registerApi = (serviceCall, firstName, lastName, username, password, address, phoneNumber, birthday) => {
    return axios.post("register", {serviceCall, firstName, lastName, username, password, address, phoneNumber, birthday});
}

const productApi = (serviceCall, productName, description, weight, purity, price, inStock, imageUrl) => {
    return axios.post("product", {serviceCall, productName, description, weight, purity, price, inStock, imageUrl});
}
export {loginApi, registerApi, productApi}