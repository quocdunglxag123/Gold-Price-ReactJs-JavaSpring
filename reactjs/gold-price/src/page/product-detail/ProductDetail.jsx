import React, { useEffect, useCallback, useState, Fragment } from "react";
import "./ProductDetail.css";
import { useNavigate, useParams } from "react-router-dom";
import { useSelector } from "react-redux";
import { PRODUCT_IMG_INFORMATION, PRODUCT_PURITY_INFORMATION, PRODUCT_TYPE_INFORMATION, PRODUCT_MATERIAL_INFORMATION  } from "../../config/configName";

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
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  
  //Change Img Function
  const changeMainImg = (imgId) => {
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
          <div className="text-center">
            <h1>Price: {product.price} VND</h1>
            <button type="button" className=" buttonBuyProductDetail btn btn-warning btn-lg">BUY NOW</button>
            <button type="button" className="btn btn-secondary btn-lg">ADD TO CART</button>
          </div>
        </div>
      </div>
      <div className="productDisplayRight">
        <h1>{product.name}</h1>
        {/* <div className="productDisplayRightPrice">
          <div className="productDisplayRightPrice">${product.price}</div>
        </div> PRODUCT_PURITY_INFORMATION,PRODUCT_TYPE_INFORMATION,PRODUCT_MATERIAL_INFORMATION*/}
        <div className="productDisplayRightDescription w-100">
          <h2>Product Detail Information:</h2>
          <h5>
          <div>Purity: {product[PRODUCT_PURITY_INFORMATION].name}</div>
          <div>Type: {product[PRODUCT_TYPE_INFORMATION].name}</div>
          <div>Material: {product[PRODUCT_MATERIAL_INFORMATION].name}</div>
          <div>Description: {product.description}</div>
          </h5>
        </div>
        {/* <button>ADD TO CART</button>
        <p className="productDisplayRightCategory">
          <span>Category :</span>
          {product.productPurityDto.name}, {product.productMaterialDto.name}
        </p>
        <p className="productDisplayRightCategory">
          <span>Tags :</span>
          {product.productTypeDto.name}
        </p> */}
      </div>
      </Fragment>
    )}
    </div>
  );
};

export default ProductDetail;
