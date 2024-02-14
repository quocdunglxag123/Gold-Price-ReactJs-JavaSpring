import React, { useState, useEffect, useCallback } from "react";
import "./HomePage.css";
import SlideShowImageAuto from "../../component/slide-show-image-auto/SlideShowImageAuto";
import { productApi } from "../../services/ApiService";
import { useNavigate } from "react-router-dom";
import { useDispatch} from "react-redux";
import { getData } from "../../shared/model";

const HomePage = () => {
  const dispatch = useDispatch();
  const [productInfo, setProductInfo] = useState("");
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  const init = useCallback(async () => {
    let res = await productApi("getAll");
    if (res.status === "200" && res.data != null) {
      let goldPrice = res.data;    
      // Create Formart ","
      const formatNumber = (number) => {
        return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      };

      // Create Copy Array to format buyingPrice and sellingPrice with "," (1000-> 1,000)
      const formattedGoldPrice = goldPrice.map((item) => ({
        ...item,
        price: item.price ? formatNumber(item.price) : 0
      }));

      // Update state gold data
      setProductInfo(formattedGoldPrice);
    } else {
      window.alert(res.errMsg);
      await navigate("/login");
    }
  }, [navigate]);

  // Check And Set Global Data
  useEffect(() => {
    if (productInfo !== "") {
      dispatch(getData(productInfo));
    }
    setLoading(false);
  }, [productInfo, dispatch]);

  // Init When render
  useEffect(() => {
    if (!productInfo) {
      init();
    }
  }, [init, productInfo]);

  return (
    <div className="body">
      <div className="slideShow pt-3">
        {loading ? null : productInfo && Object.keys(productInfo).length > 0 && (
          <SlideShowImageAuto data={productInfo} />
        )}
      </div>
    </div>
  );
};

export default HomePage;
