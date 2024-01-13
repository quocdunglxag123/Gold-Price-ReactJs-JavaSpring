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
} from "mdb-react-ui-kit";
import {PRODUCT_IMG_INFORMATION} from "../../config/configName";

const ProductCard = (props) => {
  const product = props.data;
  const imageSource = product[PRODUCT_IMG_INFORMATION][0]
  ? product[PRODUCT_IMG_INFORMATION][0].url
  : "ErrorImage.png";
  return (
    <MDBContainer className="cardProduct">
      <MDBRow className= "h-100">
        <MDBCol>
          <MDBCard className="hoverImageZoom border-0 h-100">
            <Link className="textProduct" to={`/productDetail/${product.id}`}>
              <MDBCardImage
                className="cardImage"
                src={require(`../../shared/image/${imageSource}`)}
                position="top"
                alt="Apple Computer"
              />
            <MDBCardBody>
              <div className="text-center">
                <h5>{product.name}</h5>
                <h5>{product.price} VND</h5>
              </div>
            </MDBCardBody>
            </Link>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
};

export default ProductCard;
