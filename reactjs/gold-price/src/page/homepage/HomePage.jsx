import React from "react"
import "./HomePage.css"
import SlideShowImage from '../../component/slide-show-image/SlideShowImage';
import ProductSlider from '../../component/product-slider/ProductSlider';

const HomePage = () => {
    return (
        <div className="body">
            
            <div className= "slideShow pt-3">
                <SlideShowImage/>
            </div>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            <h1 className="Center">HOT PRODUCT</h1>
            {/* <ProductSlider/> */}
        </div>
    )
 }
 export default HomePage