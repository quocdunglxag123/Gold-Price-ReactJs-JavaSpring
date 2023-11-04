import React from "react"
import "./HomePage.css"
import SlideShowImageAuto from '../../component/slide-show-image-auto/SlideShowImageAuto';
import ProductSlider from '../../component/product-slider/ProductSlider';

const HomePage = () => {
    const hotProduct = {titleSlide: "Hot Product",
    urlImageArr: [
      {
        img: "https://dummyimage.com/600x400/000/7CFC00"
      },
      {
        img: "https://dummyimage.com/600x400/000/ccccc"
      },
      {
        img: "https://dummyimage.com/600x400/000/dddddd"
      },
      {
        img: "https://dummyimage.com/600x400/000/fff"
      },
      {
        img: "https://dummyimage.com/600x400/000/B22222"
      },
      {
        img: "https://dummyimage.com/600x400/000/7CFC00"
      },
      {
        img: "https://dummyimage.com/600x400/000/ccccc"
      },
      {
        img: "https://dummyimage.com/600x400/000/dddddd"
      },
      {
        img: "https://dummyimage.com/600x400/000/B22222"
      },
      {
        img: "https://dummyimage.com/600x400/000/7CFC00"
      }
    ]
  };
    return (
        <div className="body">
            <div className= "slideShow pt-3">
                <SlideShowImageAuto/>
            </div>
            <ProductSlider slideInfo = {[hotProduct.titleSlide, hotProduct.urlImageArr]}/>
        </div>
    )
 }
 export default HomePage