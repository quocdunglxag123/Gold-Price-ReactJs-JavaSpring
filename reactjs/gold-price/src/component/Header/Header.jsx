import React , { useState } from "react";
import { Link, Outlet } from 'react-router-dom'
import { Fragment } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCoins,faCartShopping } from '@fortawesome/free-solid-svg-icons'
import './Header.css';

import 'bootstrap/dist/css/bootstrap.css';
import Dropdown from 'react-bootstrap/Dropdown';
import Cookies from 'universal-cookie';

const Header = () => {
    const cookies = new Cookies();
    const [lastName] = useState(cookies.get("lastName"));

    const handleLogout = async (event) => {
        const cookies = new Cookies();
        cookies.remove('accessToken');
        cookies.remove('refreshToken');
    }

    return (
        <Fragment>
            <nav className="navbar navbar-expand-lg navbar-light header-container">
                <Link className="navbar-brand" to="../homepage"><FontAwesomeIcon icon={faCoins} spin size="xl" style={{ color: "#fbff00", }} /></Link>
                <form className="form-inline my-2 my-lg-0 d-flex">
                    <input className="form-control me-sm-2" type="search" placeholder="Search" aria-label="Search" />
                </form>

                <div className="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto">
                        <li className="nav-item active">
                            <Link className="nav-link textLayout" to="../homepage">Home<span className="sr-only">(current)</span></Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link textLayout" to="../product">Product</Link>
                        </li>
                        <li className="nav-item">

                        </li>
                    </ul>
                    <div className="form-inline my-2 my-lg-0 d-flex">
                    <ul className="navbar-nav me-auto">
                        <li className="nav-item">
                            <Link className="nav-link textLayout" to="../order"><FontAwesomeIcon icon={faCartShopping} size="xl" style={{color: "#fff700",}} /></Link>
                        </li>
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
                                    <Dropdown.Item href="../login"  onClick={()=>handleLogout()}>
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
