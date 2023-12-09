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

const goldPriceApi = () => {
    return  axios.get('https://mihong.vn/api/v1/gold/prices/current');
}

const goldPriceChartApi = async (gold_code, date_type) => {
    try {
        const response = await axios.get('https://mihong.vn/api/v1/gold/prices', {
          params: {
            gold_code: gold_code,
            date_type: date_type,
          },
        });
        return response;
      } catch (error) {
        console.error('Error fetching data:', error);
      }
}

export {loginApi, registerApi, productApi, goldPriceApi, goldPriceChartApi}