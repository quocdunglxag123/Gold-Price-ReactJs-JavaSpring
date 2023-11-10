import React, {useState} from "react"
import "./HomePage.css"
import SlideShowImageAuto from '../../component/slide-show-image-auto/SlideShowImageAuto';
import ProductSlider from '../../component/product-slider/ProductSlider';
import { productApi } from "../../services/ApiService";

import { useDispatch } from "react-redux";
import { getData } from "../../shared/model";

const HomePage = () => {
  const dispatch = useDispatch();

  const [hotProduct, setHotProduct] = useState("");
  const [loading, setLoading] = useState(true);

  
  const init = async () => {
    try {
      let res = await productApi('getAll');

      if (res.status === '200' && res.data != null) {
        setHotProduct({
          titleSlide: "Hot Product",
          productInfoArr: res.data
        })
        dispatch(getData(hotProduct));
      } else {
        window.alert(res.errMsg);
      }
    }catch (error) {
      console.error('Error fetching data:', error);
    } finally {
      setLoading(false);
    }
  }

  init();

  return (
    <div className="body">
      <div className= "slideShow pt-3">
        <SlideShowImageAuto/>
      </div>
      {loading ? null : hotProduct && (
        <ProductSlider slideInfo={[hotProduct.titleSlide, hotProduct.productInfoArr]} />
      )}
    </div>
  )
 }
 export default HomePage