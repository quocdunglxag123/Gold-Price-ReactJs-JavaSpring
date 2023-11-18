import React, {useState, useEffect} from "react"
import "./HomePage.css"
import SlideShowImageAuto from '../../component/slide-show-image-auto/SlideShowImageAuto';
import { productApi } from "../../services/ApiService";

import { useDispatch, useSelector } from "react-redux";
import { getData } from "../../shared/model";

const HomePage = () => {
  const dispatch = useDispatch();
  const globalData = useSelector((state) => state.theStore.value);

  const [productInfo, setProductInfo] = useState("");
  const [loading, setLoading] = useState(true);

  const init = async () => {
      let res = await productApi('getAll');
      if (res.status === '200' && res.data != null) {
        setProductInfo(res.data)
      } else {
        window.alert(res.errMsg);
      }
  }

  //Check And Set Global Data
  useEffect(() => {
    if (!globalData && productInfo !== "") {
      dispatch(getData(productInfo));
    }
    setLoading(false);
  }, [productInfo, globalData, dispatch]);

  //Init When render
  useEffect(() => {
    if (!productInfo) {
      init();
    }
  }, [productInfo]);

  return (
    <div className="body">
      <div className= "slideShow pt-3">
      {loading ? null : productInfo && Object.keys(productInfo).length > 0 && (
        <SlideShowImageAuto data={productInfo} />
        )}
      </div>
    </div>
  )
 }
 export default HomePage