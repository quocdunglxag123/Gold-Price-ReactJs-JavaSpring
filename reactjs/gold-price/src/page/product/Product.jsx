import React from "react";
import './Product.css';
import ProductCard from "../../component/product-card/ProductCard";

function Product() {
  return (
    <div className="body d-flex">
      <ProductCard />
      <ProductCard />
      <ProductCard />
      <br />
    </div>
   
  );
}

export default Product;
