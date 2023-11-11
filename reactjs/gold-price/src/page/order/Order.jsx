import React from "react";
import './Order.css';
import ProductCard from "../../component/product-card/ProductCard";

import { useSelector } from "react-redux";

function Order() {
  const globalData = useSelector((state) => state.theStore.value);

  return (
    <div className="body d-flex">
      
    </div>
   
  );
}

export default Order;
