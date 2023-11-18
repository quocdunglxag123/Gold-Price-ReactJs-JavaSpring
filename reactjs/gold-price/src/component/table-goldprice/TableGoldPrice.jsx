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
              <th scope="col">Mua</th>
              <th scope="col">Bán</th>
            </tr>
          </thead>
          <tbody>
          {goldPrice.map((gold, index) => (
            <Fragment key= {index}>
              <tr style={{ height: '10px', visibility: 'hidden' }}></tr>
              <tr className="fs-5 cellPrice">
                <th className="fs-1" scope="row">{gold.code}</th>
                <td><span>x1000 VND/chỉ</span><br /><span>{gold.dateTime}</span></td>
                <td>
                  <span>{gold.buyingPrice}</span>
                  <span className="selfCenter"> 
                    {gold.buyChange > 0 ? 
                      <FontAwesomeIcon icon={faSortUp} bounce style={{color: "#00ff40",}} /> : 
                      gold.buyChange < 0 ? <FontAwesomeIcon icon={faCaretDown} fade style={{color: "#fa0000",}} /> 
                      : ''} 
                    {gold.buyChange}, ({gold.buyChangePercent}%)
                  </span>
                </td>
                <td>
                  <span>{gold.sellingPrice}</span>
                  <span className="selfCenter"> 
                    {gold.sellChange > 0 ? 
                      <FontAwesomeIcon icon={faSortUp} bounce style={{color: "#00ff40",}} /> : 
                      gold.sellChange < 0 ? <FontAwesomeIcon icon={faCaretDown} fade style={{color: "#fa0000",}} /> 
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
