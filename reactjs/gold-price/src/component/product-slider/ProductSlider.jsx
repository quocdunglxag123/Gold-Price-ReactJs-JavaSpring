import React from "react";
import Slider from "react-slick";

import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import "./ProductSlider.css";
import SlickProductCarousel from "../slick-product-carousel/SlickProductCarousel";
const ProductSlider = props => {
  const data = {titleSlide: props.slideInfo[0],
              productArr: props.slideInfo[1]
  };
  var settings = {
      dots: false,
      infinite: false,
      speed: 500,
      slidesToShow: 3,
      slidesToScroll: 3,
      initialSlide: 1,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3,
            slidesToScroll: 3,
            infinite: true,
            dots: true
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 2,
            initialSlide: 2
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 2
          }
        }
      ]
    };
    return (
      <div>
        <br />
        <h2 className="center"> {data.titleSlide}</h2>
        <Slider {...settings}>
          {data.productArr.map((product, index) => {
            return (
              <div key={index}>
                <SlickProductCarousel product={product} />
              </div>
            );
          })}
        </Slider>
      </div>
  );
}

export default ProductSlider;
