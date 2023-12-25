import React, { useEffect } from "react";
import "./ProductDetail.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar, faStarHalfStroke } from "@fortawesome/free-solid-svg-icons";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector } from "react-redux";
const ProductDetail = () => {
  const { productId } = useParams();
  const navigate = useNavigate();
  const globalData = useSelector((state) => state.theStore.value);

  useEffect(() => {
    const checkAndNavigate = () => {
      // Check globalData is Empty
      if (!globalData) {
        navigate("/homepage");
      } else {
        //Find product in global Data by Id
        const product = globalData.find(
          (product) => product.id === Number(productId)
        );

        //Check Product Is Found
        if (!product) {
          window.alert("Product Not Found!");
          navigate("/product");
        }
      }
    };

    checkAndNavigate();
  }, [globalData, navigate, productId]);

  if (!globalData) {
    return null; // or show loading spinner
  }

  const product = globalData.find((product) => product.id === Number(productId));

  return (
    <div className="body productDetail">
      <div className="productDisplayLeft">
        <div className="productDisplayImgList">
          <img src={require(`../../shared/image/${product.imageUrl}`)} alt="" />
          <img src={require(`../../shared/image/${product.imageUrl}`)} alt="" />
          <img src={require(`../../shared/image/${product.imageUrl}`)} alt="" />
        </div>
        <div className="productDisplayImg">
          <img
            className="productDisplayMainImg"
            src={require(`../../shared/image/${product.imageUrl}`)}
            alt=""
          />
        </div>
      </div>
      <div className="productDisplayRight">
        <h1>{product.name}</h1>
        <div className="productDisplayRightStar">
          <FontAwesomeIcon icon={faStar} style={{ color: "#fff700" }} />
          <FontAwesomeIcon icon={faStar} style={{ color: "#fff700" }} />
          <FontAwesomeIcon icon={faStar} style={{ color: "#fff700" }} />
          <FontAwesomeIcon icon={faStar} style={{ color: "#fff700" }} />
          <FontAwesomeIcon
            icon={faStarHalfStroke}
            style={{ color: "#fff700" }}
          />
        </div>
        <div className="productDisplayRightPrice">
          <div className="productDisplayRightPrice">${product.price}</div>
        </div>
        <div className="productDisplayRightDescription">
          {product.description}
        </div>
        <div>
          <h1>Select Size</h1>
          <div className="productDisplayRightSize">
            <div>S</div>
            <div>M</div>
            <div>L</div>
          </div>
        </div>
        <button>ADD TO CART</button>
        <p className="productDisplayRightCategory">
          <span>Category :</span>{product.productPurityDto.name}, {product.productMaterialDto.name}
        </p>
        <p className="productDisplayRightCategory">
          <span>Tags :</span>{product.productTypeDto.name}
        </p>
      </div>
    </div>
  );
};

export default ProductDetail;
