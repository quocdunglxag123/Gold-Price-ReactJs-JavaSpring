import React, {useEffect, useState} from "react";
import './GoldPrice.css';
import TableGoldPrice from "../../component/table-goldprice/TableGoldPrice";
import { goldPriceApi, goldPriceChartApi } from "../../services/ApiService";
import LineChart from "../../component/line-chart/LineChart";

const GoldPrice = () => {
  //Time Gold Price To Draw Chart
  const timeOptionLineChart = ["1H", "24H", "15D", "1M", "6M", "1Y"];

  //Info Gold
  const [goldPrice, setGoldPrice] = useState("");

  //Set-Get value of the selected option.
  const [goldCodeLineChart, setGoldCodeLineChart] = useState("SJC");
  const [timeGoldLineChart, setTimeGoldLineChart] = useState("1Y");
  
  //Data Line Chart
  const [dataLine1, setDataLine1] = useState("");
  const [dataLine2, setDataLine2] = useState("");
  const [labels, setLabels] = useState("");

  // const dataLine1 = [10, 20, 30, 40, 50];
  // const dataLine2 = [5, 15, 25, 35, 45];
  // const labels = ['Label 1', 'Label 2', 'Label 3', 'Label 4', 'Label 5'];


  //Init Function
  const init = async ()  => {
    //Call Api GoldPrice Mi Hong
    let res = await goldPriceApi();
    if (res.success && res.data != null) {
      let goldPrice = res.data;    
      // Create Formart ","
      const formatNumber = (number) => {
        return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
      };

      // Create Copy Array to format buyingPrice and sellingPrice with "," (1000-> 1,000)
      const formattedGoldPrice = goldPrice.map((item) => ({
        ...item,
        buyingPrice: formatNumber(item.buyingPrice),
        sellingPrice: item.sellingPrice ? formatNumber(item.sellingPrice) : 0,
      }));

      // Update state gold data
      setGoldPrice(formattedGoldPrice);
    } else {
      window.alert(res.errMsg);
    }
  }
  
  useEffect(() => {
    //Call Api To Get Data When Data Is Null Or Empty
    if (!goldPrice) {
      init();
    }
    //Call Api Every 1 hours To Get New Data Because Gold Price Change By Time 
    const intervalId = setInterval(() => {
        init();
    }, 3600000); 

    //clearInterval When component unmount to avoid memory leak
    return () => clearInterval(intervalId);
   
  });

  //Get New Data Line Chart When Option Change
  const handleDataLineChart = async ()  => {
    const indexTimeOption = timeOptionLineChart.findIndex((value) => value === timeGoldLineChart);
    let res = await goldPriceChartApi(goldCodeLineChart,indexTimeOption+1);
    if (res.success && res.data != null) {
      let goldPriceChart = res.data;    
      const buyValues = goldPriceChart.map((item) => item.buy);
      const sellValues = goldPriceChart.map((item) => item.sell);
      const timeValues = goldPriceChart.map((item) => item.date);
      setDataLine1(buyValues);
      setDataLine2(sellValues);
      setLabels(timeValues);
    } 
  }

  //Draw New Chart When Choose New Option Base On Gold Type And Time
  useEffect(() => {
    if(goldCodeLineChart && timeGoldLineChart){
      handleDataLineChart();
    }
  },[goldCodeLineChart, timeGoldLineChart]);
  
  //Split the data into two parts to render two tables of the TableGoldPrice component.
  const middleIndex = Math.floor(goldPrice.length / 2);
  const tableGoldPrice1 = goldPrice.slice(0, middleIndex);
  const tableGoldPrice2 = goldPrice.slice(middleIndex);

  
  return(
    <div className="body">
      <div className="centerRow">
        {Object.keys(tableGoldPrice1).length > 0 && (
          <TableGoldPrice key='tableGoldPrice1' data = {tableGoldPrice1} />
        )}
        {Object.keys(tableGoldPrice2).length > 0 && (
          <TableGoldPrice key='tableGoldPrice2' data = {tableGoldPrice2} />
        )}
      </div>
      <div className="centerRow mt-4">  
        {/* Line Chart */}
        <LineChart dataLine1={dataLine1} nameLine1= "BUY" dataLine2={dataLine2} nameLine2="SELL" labelsX={labels} />
        {/* Select Option Draw Line Chart */}
        <div className="multipleOptionDrawLineChart">
          <h5 className="d-flex align-items-center">GOLD TYPE<div className="line"></div></h5>
          <div className="grid4Column">
            {Object.keys(goldPrice).length > 0 && 
              (goldPrice.map((gold)=>(
                <button 
                  onClick={()=>setGoldCodeLineChart(gold.code)} 
                  className={`buttonOptionDrawLineChart ${gold.code === goldCodeLineChart ? "active" : ""}`} 
                  key={gold.code}>
                      {gold.code}
                </button>
              ))
            )}
          </div>
          <br/>
          <h5 className="d-flex align-items-center">TIME<div className="line"></div></h5>
          <div className="grid4Column">
            {
              timeOptionLineChart.map((time, index)=>(
                <button 
                  onClick={()=>setTimeGoldLineChart(time)}  
                  className={`buttonOptionDrawLineChart ${time === timeGoldLineChart ? "active" : ""}`} 
                  key={index}>
                    {time}
                </button>
              ))
            }
          </div>
        </div>
      </div>
    </div>
    
  )

}

export default GoldPrice;
