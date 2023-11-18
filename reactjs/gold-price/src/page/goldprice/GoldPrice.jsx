import React, {useEffect, useState} from "react";
import './GoldPrice.css';
import TableGoldPrice from "../../component/table-goldprice/TableGoldPrice";
import { goldPriceApi } from "../../services/ApiService";

const GoldPrice = () => {
  const [goldPrice, setGoldPrice] = useState("");

  const init = async ()  => {
    let res = await goldPriceApi();
    if (res.success && res.data != null) {
      let goldPrice = res.data;    
      // Hàm định dạng số với dấu phẩy
      const formatNumber = (number) => {
        return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      };

      // Tạo một bản sao của mảng và cập nhật buyingPrice và sellingPrice
      const formattedGoldPrice = goldPrice.map((item) => ({
        ...item,
        buyingPrice: formatNumber(item.buyingPrice),
        sellingPrice: item.sellingPrice ? formatNumber(item.sellingPrice) : 0,
      }));

      // Cập nhật state
      setGoldPrice(formattedGoldPrice);
    } else {
      window.alert(res.errMsg);
    }
  }

  useEffect(() => {
    if (!goldPrice) {
      init();
    }
  });
  

  //Chia Mảng data để set vào 2 table
  const middleIndex = Math.floor(goldPrice.length / 2);
  const tableGoldPrice1 = goldPrice.slice(0, middleIndex);
  const tableGoldPrice2 = goldPrice.slice(middleIndex);
 

  return(
    <div className="body centerRow">
      {Object.keys(tableGoldPrice1).length > 0 && (
        <TableGoldPrice key='tableGoldPrice1' data = {tableGoldPrice1} />
      )}
      {Object.keys(tableGoldPrice2).length > 0 && (
        <TableGoldPrice key='tableGoldPrice2' data = {tableGoldPrice2} />
      )}
    </div>
  )

}

export default GoldPrice;
