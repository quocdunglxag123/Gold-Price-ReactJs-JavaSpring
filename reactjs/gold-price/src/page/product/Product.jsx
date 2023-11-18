import React, {useEffect} from "react";
import './Product.css';
import ProductCard from "../../component/product-card/ProductCard";
import { useNavigate, Outlet  } from "react-router-dom"

import { useSelector } from "react-redux";

const Product = () => {
  const navigate = useNavigate();
  const globalData = useSelector((state) => state.theStore.value);
  
  useEffect(() => {
    if (!globalData) {
      navigate("/homepage");
    }
  });
  return (
    <div className="products body d-flex">
    {globalData && (
      <div className="products">
        {globalData.map((product) => (
          <ProductCard key={product.id} data={product} />
        ))}
      </div>
    )}
     <Outlet/>
</div>
   
  );
}

export default Product;
