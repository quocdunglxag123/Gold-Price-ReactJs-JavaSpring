import React from "react";
import "./ProductCard.css";
import { Link } from "react-router-dom";
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBCardImage,
  MDBBtn,
} from "mdb-react-ui-kit";
import {PRODUCT_IMG_INFORMATION, PRODUCT_PURITY_INFORMATION} from "../../config/configName";

const ProductCard = (props) => {
  const product = props.data;
  const imageSource = product[PRODUCT_IMG_INFORMATION][0]
  ? product[PRODUCT_IMG_INFORMATION][0].url
  : "ErrorImage.png";
  return (
    <MDBContainer className="cardProduct">
      <MDBRow className= "h-100">
        <MDBCol>
          <MDBCard className="text-black h-100">
            <Link to={`/productDetail/${product.id}`}>
              <MDBCardImage
                className="cardImage"
                src={require(`../../shared/image/${imageSource}`)}
                position="top"
                alt="Apple Computer"
              />
            </Link>
            {/* <MDBCardBody>
              <div className="text-center">
                <h5>{product.name}</h5>
                <p className="text-muted m-0">{product.description}</p>
              </div>
              <div>
                <div className="d-flex justify-content-between">
                  <span>Purity: {product[PRODUCT_PURITY_INFORMATION].name}</span>
                  <span>weight: {product.weight} chỉ</span>
                </div>
              </div>
              <div className="d-flex justify-content-between">
                <MDBBtn rounded className="px-1 mx-0" color="success">
                  Buy Now
                </MDBBtn>
                <MDBBtn rounded className="px-1 mx-0" color="secondary">
                  Add To Cart
                </MDBBtn>
              </div>
            </MDBCardBody> */}
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
};

export default ProductCard;
