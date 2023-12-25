import React, {useEffect} from "react";
import './Product.css';
import ProductCard from "../../component/product-card/ProductCard";
import { useNavigate, Outlet  } from "react-router-dom"
import Dropdown from 'react-bootstrap/Dropdown';

import { useSelector } from "react-redux";

const Product = () => {
  const navigate = useNavigate();
  const globalData = useSelector((state) => state.theStore.value);
  useEffect(() => {
    if (!globalData) {
      navigate("/homepage");
    }
  });
  return (
    <div className="body">
      {/* <div>
        <h5>Filter:</h5> 
          <div className="d-flex">
            <div>
            <Dropdown>
              <Dropdown.Toggle className=" nav-link textLayout custom-dropdown-menu">
                  Hello
              </Dropdown.Toggle>
              <Dropdown.Menu>
                  <Dropdown.Item href="#">
                      Home Page
                  </Dropdown.Item>
                  <Dropdown.Item href="#">
                      Settings
                  </Dropdown.Item>
                  <Dropdown.Item href="../login">
                      Logout
                  </Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
            </div>
            <div>
            <Dropdown>
              <Dropdown.Toggle className=" nav-link textLayout custom-dropdown-menu">
                  Hello
              </Dropdown.Toggle>
              <Dropdown.Menu>
                  <Dropdown.Item href="#">
                      Home Page
                  </Dropdown.Item>
                  <Dropdown.Item href="#">
                      Settings
                  </Dropdown.Item>
                  <Dropdown.Item href="../login">
                      Logout
                  </Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
            </div>
          </div>

      </div> */}
      <div className="products d-flex">
        {globalData && (
          <div className="products">
            {globalData.map((product) => (
                <ProductCard key={product.id} data={product} />
            ))}
          </div>
        )}
        
      </div>  
      <Outlet/>
    </div>
  );
}

export default Product;
