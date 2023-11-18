import React, {useEffect, useState} from "react";
import './GoldPrice.css';
import ProductCard from "../product-card/ProductCard";
import { useNavigate, Outlet  } from "react-router-dom"

import { useSelector } from "react-redux";

const GoldPrice = () => {
  const [goldPrice, setGoldPrice] = useState({
    "success": true,
    "data": [
        {
            "buyingPrice": 7010000,
            "sellingPrice": 7060000,
            "code": "SJC",
            "sellChange": 0,
            "sellChangePercent": 0,
            "buyChange": -5000,
            "buyChangePercent": -0.07,
            "dateTime": "18/11/2023, 16:33"
        },
        {
            "buyingPrice": 5880000,
            "sellingPrice": 5940000,
            "code": "999",
            "sellChange": 20000,
            "sellChangePercent": 0.34,
            "buyChange": 20000,
            "buyChangePercent": 0.34,
            "dateTime": "17/11/2023, 07:13"
        },
        {
            "buyingPrice": 5780000,
            "sellingPrice": 5880000,
            "code": "985",
            "sellChange": 20000,
            "sellChangePercent": 0.34,
            "buyChange": 20000,
            "buyChangePercent": 0.35,
            "dateTime": "17/11/2023, 07:13"
        },
        {
            "buyingPrice": 5750000,
            "sellingPrice": 5850000,
            "code": "980",
            "sellChange": 20000,
            "sellChangePercent": 0.34,
            "buyChange": 20000,
            "buyChangePercent": 0.35,
            "dateTime": "17/11/2023, 07:13"
        },
        {
            "buyingPrice": 5550000,
            "sellingPrice": 0,
            "code": "950",
            "sellChange": 0,
            "sellChangePercent": 0,
            "buyChange": 10000,
            "buyChangePercent": 0.18,
            "dateTime": "18/11/2023, 09:39"
        },
        {
            "buyingPrice": 4090000,
            "sellingPrice": 4240000,
            "code": "750",
            "sellChange": 10000,
            "sellChangePercent": 0.24,
            "buyChange": 10000,
            "buyChangePercent": 0.24,
            "dateTime": "18/11/2023, 09:39"
        },
        {
            "buyingPrice": 3610000,
            "sellingPrice": 3710000,
            "code": "680",
            "sellChange": 10000,
            "sellChangePercent": 0.27,
            "buyChange": 10000,
            "buyChangePercent": 0.28,
            "dateTime": "18/11/2023, 09:39"
        },
        {
            "buyingPrice": 3510000,
            "sellingPrice": 3610000,
            "code": "610",
            "sellChange": 10000,
            "sellChangePercent": 0.28,
            "buyChange": 10000,
            "buyChangePercent": 0.28,
            "dateTime": "18/11/2023, 09:39"
        }
    ]
});
  const init = async () => {
    //let res = await goldPrice();
    // if (res.data != null) {
    //   setGoldPrice(res.data)
    // } else {
    //   window.alert(res.errMsg);
    // }
}
  // //Init When render
  // useEffect(() => {
  //   if (!goldPrice) {
  //     init();
  //   }
  // }, [goldPrice]);

  return (
    <div className="body centerRow">
      <div className="d-flex">
        <table className="me-5 table-responsive">
          <thead>
            <tr className="fs-1 cellPrice">
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col">Mua</th>
              <th scope="col">Bán</th>
            </tr>
          </thead>
          <tbody>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1" scope="row">SJC</th>
              <td> <td><span>x1000 VND/chỉ</span><br /><span>{goldPrice.data[0].dateTime}</span></td></td>
              <td>Otto</td>
              <td>@mdo</td>
            </tr>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr  className="fs-3 cellPrice">
              <th className="fs-1" scope="row">985</th>
              <td>Jacob</td>
              <td>Thornton</td>
              <td>@fat</td>
            </tr>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1" scope="row">950</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
            </tr>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1" scope="row">680</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
            </tr>
          </tbody>
        </table>
        <table className="table-responsive">
          <thead>
            <tr className="fs-1 cellPrice">
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col">Mua</th>
              <th scope="col">Bán</th>
            </tr>
          </thead>
          <tbody>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1" scope="row">999</th>
              <td>Mark</td>
              <td>Otto</td>
              <td>@mdo</td>
            </tr>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1" scope="row">980</th>
              <td>Jacob</td>
              <td>Thornton</td>
              <td>@fat</td>
            </tr>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1" scope="row">750</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
            </tr>
            <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
            <tr className="fs-3 cellPrice">
              <th className="fs-1"scope="row">610</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  )

}

export default GoldPrice;
