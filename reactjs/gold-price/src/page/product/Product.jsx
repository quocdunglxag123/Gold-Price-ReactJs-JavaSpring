import React from "react";
import './Product.css';
import ProductCard from "../../component/product-card/ProductCard";

import { useSelector } from "react-redux";

function Product() {
  const globalData = useSelector((state) => state.theStore.value);

  return (
    <div className="body d-flex">
      {globalData[0].productName}
      <br />
      <ProductCard />
      <ProductCard />
    </div>
   
  );
}

export default Product;
