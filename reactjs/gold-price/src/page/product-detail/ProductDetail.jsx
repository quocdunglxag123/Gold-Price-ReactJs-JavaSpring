import React, { useEffect, useCallback, useState, Fragment } from "react";
import "./ProductDetail.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar, faStarHalfStroke } from "@fortawesome/free-solid-svg-icons";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import { PRODUCT_IMG_INFORMATION } from "../../config/configName";

const ProductDetail = () => {
  const { productId } = useParams();
  const navigate = useNavigate();
  const globalData = useSelector((state) => state.theStore.value);
  const [imageMainSource, setImageMainSource] = useState();
  const [imageSourceArr, setImageSourceArr] = useState([]);
  const [product, setProduct] = useState();
  const [loading, setLoading] = useState(true);

  const init = useCallback( () => {
    //Find product in global Data by Id
    const product = globalData.find(
      (product) => product.id === Number(productId)
    );
    //Check Product Is Found
    if (!product) {
      window.alert("Product Not Found!");
      navigate("/product");
    }else{
      setProduct(product)
      if(product[PRODUCT_IMG_INFORMATION]){
        setImageSourceArr(product[PRODUCT_IMG_INFORMATION]);
        if(product[PRODUCT_IMG_INFORMATION][0]){
          setImageMainSource(product[PRODUCT_IMG_INFORMATION][0]);
        }
      }
      setLoading(false);
    }

  }, [globalData, navigate, productId]);

  // Init When render
  useEffect(() => {
    if (!globalData) {
      navigate("/homepage");
    } else {
      init();
    }
  }, [init, globalData, navigate]);
  
  const changeMainImg = (imgId) => {
    console.log("changeMainImg");
    const newImageMainSource = product[PRODUCT_IMG_INFORMATION].find(
      (img) => img.id === Number(imgId)
    );
    setImageMainSource(newImageMainSource);
  };

  return (
    <div className="body productDetail">
    {loading ? null : (
      <Fragment>
      <div className="productDisplayLeft">
        <div className="productDisplayImgList">
          {imageSourceArr.map((imgInfo) => (
            <img
              key={imgInfo.id}
              src={require(`../../shared/image/${imgInfo.url}`)}
              alt={imgInfo.name}
              onClick={() => changeMainImg(imgInfo.id)}
            />
          ))}
        </div>
        <div className="productDisplayImg">
          <img
            className="productDisplayMainImg"
            src={require(`../../shared/image/${imageMainSource ? imageMainSource.url : "ErrorImage.png"}`)}
            alt={imageMainSource ? imageMainSource.name : "ErrorImage"}
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
          <span>Category :</span>
          {product.productPurityDto.name}, {product.productMaterialDto.name}
        </p>
        <p className="productDisplayRightCategory">
          <span>Tags :</span>
          {product.productTypeDto.name}
        </p>
      </div>
      </Fragment>
    )}
    </div>
  );
};

export default ProductDetail;
