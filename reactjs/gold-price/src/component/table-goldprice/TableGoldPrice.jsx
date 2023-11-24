import React, {Fragment} from "react";
import './TableGoldPrice.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSortUp, faCaretDown } from '@fortawesome/free-solid-svg-icons'

const TableGoldPrice = (props) => {
  const goldPrice = props.data

  return (
      <table className="me-5 table-responsive">
          <thead>
            <tr className="fs-1 cellPrice">
              <th scope="col"></th>
              <th scope="col"></th>
              <th scope="col">BUY</th>
              <th scope="col">SELL</th>
            </tr>
          </thead>
          <tbody>
          {goldPrice.map((gold, index) => (
            <Fragment key= {index}>
              <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
              <tr className="fs-5 cellPrice">
                <th className="fs-1" scope="row">{gold.code}</th>
                <td><span>x1000 VND/Ounce</span><br /><span>{gold.dateTime}</span></td>
                <td>
                  <span>
                    {gold.buyingPrice}
                    </span>
                  <br />
                  <span className={`selfCenter ${gold.buyChange > 0? "colorIncrease" : "colorDecrease"}`}  > 
                    {gold.buyChange > 0 ? 
                      <FontAwesomeIcon className="mt-auto" icon={faSortUp} bounce /> : 
                      gold.buyChange < 0 ? <FontAwesomeIcon className="mt-auto" icon={faCaretDown} fade /> 
                      : ''} 
                    {gold.buyChange}, ({gold.buyChangePercent}%)
                  </span>
                </td>
                <td>
                  <span>
                    {gold.sellingPrice}
                  </span>
                  <br />
                  <span className={`selfCenter ${gold.buyChange > 0? "colorIncrease" : "colorDecrease"}`}  > 
                    {gold.sellChange > 0 ? 
                      <FontAwesomeIcon className="mt-auto" icon={faSortUp} bounce /> : 
                      gold.sellChange < 0 ? <FontAwesomeIcon className="mt-auto" icon={faCaretDown} fade/> 
                      : ''} 
                    {gold.sellChange}, ({gold.sellChangePercent}%)
                  </span>
                </td>
              </tr>
            </Fragment>
          ))}
          </tbody>
      </table>
  )

}

export default TableGoldPrice;
