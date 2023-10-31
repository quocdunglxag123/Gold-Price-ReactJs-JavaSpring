import React from 'react';
import { Slide } from 'react-slideshow-image';
import 'react-slideshow-image/dist/styles.css';
import './SlideShowImage.css'
const SlideShowImage = () => {
    const images = [
        "/image/ring9999.png",
        "/image/sjc.png",
        "/image/homepageimage1.png"
    ];

    return (
        <Slide>
            <div className="each-slide-effect">
                <div className="imageSlide" style={{ 'backgroundImage': `url(${images[0]})` }}>
                </div>
            </div>
            <div className="each-slide-effect">
                <div className="imageSlide" style={{ 'backgroundImage': `url(${images[1]})` }}>
                </div>
            </div>
            <div className="each-slide-effect">
                <div className="imageSlide" style={{ 'backgroundImage': `url(${images[2]})` }}>
                </div>
            </div>
        </Slide>
    );
};

export default SlideShowImage;