import React, { useState, useEffect } from "react";
import { Link, Outlet, useLocation } from 'react-router-dom'
import { Fragment } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCoins, faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'
import './Header.css';
import { searchProductApi } from "../../services/ApiService";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { getData } from "../../shared/model";

import 'bootstrap/dist/css/bootstrap.css';
import Dropdown from 'react-bootstrap/Dropdown';
import Cookies from 'universal-cookie';

const Header = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const cookies = new Cookies();
    const [lastName] = useState(cookies.get("lastName"));
    const [showSearch, setShowSearch] = useState(false);  //is show search element
    const [searchProductName, setSearchProductName] = useState("");  //Product Name To Search

    const location = useLocation();
    
    useEffect(() => {
        // If page is product then show search element
        setShowSearch(location.pathname.includes('/product'));
        setSearchProductName(()=>"");
    }, [location.pathname]);

    const handleLogout = () => {
        cookies.remove('accessToken');
        cookies.remove('refreshToken');
        cookies.remove('lastName');
    }

    const handleSearch = async (event) => {
        event.preventDefault();
        let res = await searchProductApi('search', searchProductName);
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
            // Update global gold data
            dispatch(getData(formattedGoldPrice));
            navigate("/product");
        } else {
            window.alert(res.errMsg);
            navigate("/homepage");
        }
    }

    return (
        <Fragment>
            <nav className="navbar navbar-expand-lg navbar-light header-container">
                <Link className="navbar-brand" to="../homepage"><FontAwesomeIcon icon={faCoins} spin size="xl" style={{ color: "#fbff00", }} /></Link>
                <div className="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto">
                        <li className="nav-item active">
                            <Link className="nav-link textLayout" to="../homepage">Home<span className="sr-only">(current)</span></Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link textLayout" to="../product">Trang Sức</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link textLayout" to="../goldprice">Gold Price</Link>
                        </li>
                    </ul>
                    <div className="form-inline my-2 my-lg-0 d-flex">
                        <div className={`form-inline my-2 my-lg-0  ${showSearch ? 'd-flex' : 'd-none'}`}>
                            <div className="input-group md-form form-sm form-1 pl-0">
                                <input value={searchProductName} onChange={(event) => setSearchProductName(event.target.value)}
                                    name='searchProductName'
                                    label='searchProductName'
                                    id='searchProductName'
                                    autoComplete="off"
                                    className="form-control my-0 py-1"
                                    type="text"
                                    placeholder="Search"
                                    aria-label="Search"
                                />
                                <div className="input-group-prepend searchIcon">
                                    <button className="input-group-text purple lighten-3 bg-warning" id="basic-text1" onClick={handleSearch}>
                                        <FontAwesomeIcon icon={faMagnifyingGlass} size="lg" style={{ color: "#ff0000", }} />
                                    </button>
                                </div>
                            </div>
                        </div>
                        <ul className="navbar-nav me-auto">
                            <li className="nav-item">
                                <Dropdown>
                                    <Dropdown.Toggle className=" nav-link textLayout custom-dropdown-menu">
                                        Hello {lastName}
                                    </Dropdown.Toggle>
                                    <Dropdown.Menu>
                                        <Dropdown.Item href="#">
                                            Home Page
                                        </Dropdown.Item>
                                        <Dropdown.Item href="#">
                                            Settings
                                        </Dropdown.Item>
                                        <Dropdown.Item href="../login" onClick={() => handleLogout()}>
                                            Logout
                                        </Dropdown.Item>
                                    </Dropdown.Menu>
                                </Dropdown>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <Outlet />
        </Fragment>
    );
};

export default Header;
