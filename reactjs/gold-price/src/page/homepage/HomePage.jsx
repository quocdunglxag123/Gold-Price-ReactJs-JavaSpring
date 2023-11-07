import React, {useState, useEffect} from "react"
import "./HomePage.css"
import SlideShowImageAuto from '../../component/slide-show-image-auto/SlideShowImageAuto';
import ProductSlider from '../../component/product-slider/ProductSlider';
import { productApi } from "../../services/ApiService";

const HomePage = () => {
  //   const hotProduct = {titleSlide: "Hot Product",
  //   urlImageArr: [
  //     {
  //         "id": 1,
  //         "updateDate": "2023/11/06 16:33:21",
  //         "createDate": "2023/11/06 16:33:21",
  //         "serviceCall": null,
  //         "productName": "ring 9999",
  //         "description": "Gold",
  //         "weight": 1000,
  //         "purity": "9999",
  //         "price": "200",
  //         "inStock": 20,
  //         "imageUrl": "ring9999.png"
  //     },
  //     {
  //         "id": 2,
  //         "updateDate": "2023/11/06 16:33:34",
  //         "createDate": "2023/11/06 16:33:34",
  //         "serviceCall": null,
  //         "productName": "ring 9999",
  //         "description": "Gold",
  //         "weight": 1000,
  //         "purity": "9999",
  //         "price": "200",
  //         "inStock": 20,
  //         "imageUrl": "ringNormal.png"
  //     },
  //     {
  //         "id": 2,
  //         "updateDate": "2023/11/06 16:33:34",
  //         "createDate": "2023/11/06 16:33:34",
  //         "serviceCall": null,
  //         "productName": "ring 9999",
  //         "description": "Gold",
  //         "weight": 1000,
  //         "purity": "9999",
  //         "price": "200",
  //         "inStock": 20,
  //         "imageUrl": "ringNormal.png"
  //     },
  //     {
  //         "id": 2,
  //         "updateDate": "2023/11/06 16:33:34",
  //         "createDate": "2023/11/06 16:33:34",
  //         "serviceCall": null,
  //         "productName": "ring 9999",
  //         "description": "Gold",
  //         "weight": 1000,
  //         "purity": "9999",
  //         "price": "200",
  //         "inStock": 20,
  //         "imageUrl": "ringNormal.png"
  //     }useState
  // ]
  //};
  const [hotProduct, setHotProduct] = useState("");
  const [loading, setLoading] = useState(true);

  
  const init = async () => {
    try {
      let res = await productApi('getAll');

      if (res.status === '200' && res.data != null) {
        setHotProduct({
          titleSlide: "Hot Product",
          urlImageArr: res.data
        })
      } else {
        window.alert(res.errMsg);
      }
    }catch (error) {
      console.error('Error fetching data:', error);
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    init();
  }, []);

  return (
    <div className="body">
      <div className= "slideShow pt-3">
        <SlideShowImageAuto/>
      </div>
      {loading ? null : hotProduct && (
        <ProductSlider slideInfo={[hotProduct.titleSlide, hotProduct.urlImageArr]} />
      )}
    </div>
  )
 }
 export default HomePage