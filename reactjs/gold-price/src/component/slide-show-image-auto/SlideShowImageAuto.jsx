import React from 'react';
import { Slide } from 'react-slideshow-image';
import 'react-slideshow-image/dist/styles.css';
import './SlideShowImageAuto.css'
import {PRODUCT_IMG_INFORMATION, ERROR_IMAGE} from '../../config/configName';
const SlideShowImageAuto = (props) => {
  const slideInfo = props.data;

  return (
    <Slide>
      {slideInfo.map((slide, index) => {
        // Import image using `import` statement
        var imageUrl = require(`../../${ERROR_IMAGE}`);
        if(slide[PRODUCT_IMG_INFORMATION][0]){
          imageUrl = require(`../../shared/image/${slide[PRODUCT_IMG_INFORMATION][0].url}`);
        }
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