import React from 'react';
import { Slide } from 'react-slideshow-image';
import 'react-slideshow-image/dist/styles.css';
import './SlideShowImageAuto.css'
const SlideShowImageAuto = (props) => {
  const slideInfo = props.data;

  return (
    <Slide>
      {slideInfo.map((slide, index) => {
        // Import image using `import` statement
        const imageUrl = require(`../../shared/image/${slide.imageUrl}`);
        return (
          <div key={index} className="each-slide-effect">
            <div className="imageSlide" style={{ 'backgroundImage': `url(${imageUrl})` }}>
            </div>
          </div>
        );
      })}
    </Slide>
  );
};

export default SlideShowImageAuto;