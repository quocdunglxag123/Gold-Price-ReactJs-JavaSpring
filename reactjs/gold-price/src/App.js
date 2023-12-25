//Common Library
import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom'

//Page
import Login from './page/login/Login';
import Register from './page/register/Register';
import HomePage from './page/homepage/HomePage';
import Header from './component/Header/Header';
import Product from './page/product/Product';
import GoldPrice from './page/goldprice/GoldPrice';

//Css Page
import './App.css';

//Font Awesome
import '@fortawesome/fontawesome-svg-core/styles.css'
import '@fortawesome/fontawesome-free/css/all.css';

//MDB React
import 'mdb-react-ui-kit/dist/css/mdb.min.css'

// BootStrap
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductDetail from './page/product-detail/ProductDetail';


function App() {
  return(
    <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route path="" element={<Login />}>
          </Route>
          <Route path="login" element={<Login />}>
          </Route>
          <Route path="register" element={<Register />}>
          </Route>
          <Route path="*" element={<Login />}></Route>
        </Route>
        <Route path="/" element={<Header />}>
          <Route path="homepage" element={<HomePage />}>
          </Route>
          <Route path="product" element={<Product />}>
          </Route>
          <Route path="goldprice" element={<GoldPrice />}>
          </Route>
          <Route path="productDetail" element={<ProductDetail />}>
            <Route path=':productId' element={<ProductDetail />} />
          </Route>
          
        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
  )

}

export default App;
