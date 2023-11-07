import React, { Fragment } from "react";
import { Card, Button } from "react-bootstrap";
import "./SlickProductCarousel.css";

const SlickProductCarousel = props => {
  return (
    <Fragment>
      <Card style={{ width: "inherit" }}>
        <Card.Img variant="top" className="product-image" src={"/image/"+ props.imgSrc} />
        <Card.Body>
          <Card.Title>Card Title</Card.Title>
          <Card.Text>
            Some quick example text to build on the card title and make up the
            bulk of the card's content.
          </Card.Text>
          <div className="product-actions">
            <Button variant="primary">Buy Now</Button>
            <Button variant="secondary">Add to cart</Button>
          </div>
        </Card.Body>
      </Card>
    </Fragment>
  );
};

export default SlickProductCarousel;
