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

const ProductCard = (props) => {
  const product = props.data;

  return (
    <MDBContainer className="cardProduct">
      <MDBRow>
        <MDBCol>
          <MDBCard className="text-black">
            <Link to={`/productDetail/${props.data.id}`}>
              <MDBCardImage
                className="cardImage"
                src={require(`../../shared/image/${product.imageUrl}`)}
                position="top"
                alt="Apple Computer"
              />
            </Link>
            <MDBCardBody>
              <div className="text-center">
                <h5>{product.name}</h5>
                <p className="text-muted m-0">{product.description}</p>
              </div>
              <div>
                <div className="d-flex justify-content-between">
                  <span>Purity: {product.productPurityDto.name}</span>
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
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
};

export default ProductCard;
