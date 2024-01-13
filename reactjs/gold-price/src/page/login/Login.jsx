import React, { useEffect, useState } from "react";
import './Login.css';
import { loginApi } from "../../services/ApiService";
import {ToastContainer,toast} from 'react-toastify'
import { useNavigate, Link, Outlet  } from "react-router-dom"
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBCheckbox,
}
  from 'mdb-react-ui-kit';
import Cookies from 'universal-cookie';

const Login = () => {
  const cookies = new Cookies();
  const rememberAccountFromCookies = cookies.get('rememberAccount') || false;
  const emailFromCookies = cookies.get('email') || "";
  const passwordFromCookies = cookies.get('password') || "";
  const refreshTokenFromCookies = cookies.get('refreshToken') || "";
  const accessTokenFromCookies = cookies.get('accessToken') || "";

  const [email, setEmail] = useState(emailFromCookies);
  const [password, setPassword] = useState(passwordFromCookies);
  const [rememberAccount, setRememberAccount] = useState(rememberAccountFromCookies);
  const [loadingLogin, setLoaingLogin] = useState(false);
  
  const navigate = useNavigate();

  useEffect(()=>{
    if(refreshTokenFromCookies || accessTokenFromCookies){
      navigate("/homepage");
    }
  },[navigate,refreshTokenFromCookies,accessTokenFromCookies])
  
  const handleLogin = async (event) => {
    event.preventDefault()
    cookies.remove('accessToken');
    cookies.remove('refreshToken');
    cookies.remove('lastName');
    
    if (!email || !password) {
      toast.error("Email/Password is required");
    }
    setLoaingLogin(true);
    let res = await loginApi('login', email, password);
    setLoaingLogin(false);

    if (res.status === '200' && res.data != null) {
      if(rememberAccount){
        cookies.set('email', email, { path: '/' });
        cookies.set('password', password, { path: '/' });
        cookies.set('rememberAccount', true, { path: '/' });
      }else{
        cookies.remove('email');
        cookies.remove('password');
        cookies.remove('rememberAccount');
      }
      cookies.set('refreshToken', res.data.tokenDto.refreshToken , { path: '/' });
      cookies.set('accessToken', res.data.tokenDto.accessToken , { path: '/' });
      cookies.set('lastName', res.data.userInfoDto.lastName , { path: '/' });
      navigate("/homepage");
    } else {
      window.alert(res.errMsg);
    }
  }

  return (
    <MDBContainer fluid className='p-4 background-radial-gradient overflow-hidden'>

      <MDBRow>

        <MDBCol md='6' className='text-center text-md-start d-flex flex-column justify-content-center'>

          <h1 className="my-5 display-3 fw-bold ls-tight px-3" style={{ color: 'hsl(218, 81%, 95%)' }}>
            The best offer <br />
            <span style={{ color: 'hsl(218, 81%, 75%)' }}>for your business</span>
          </h1>

          <p className='px-3' style={{ color: 'hsl(218, 81%, 85%)' }}>
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Eveniet, itaque accusantium odio, soluta, corrupti aliquam
            quibusdam tempora at cupiditate quis eum maiores libero
            veritatis? Dicta facilis sint aliquid ipsum atque?
          </p>

        </MDBCol>

        <MDBCol md='6' className='position-relative'>

          <div id="radius-shape-1" className="position-absolute rounded-circle shadow-5-strong"></div>
          <div id="radius-shape-2" className="position-absolute shadow-5-strong"></div>
          <MDBCard className='my-5 bg-glass'>
            <MDBCardBody className='p-5'>

              <MDBInput wrapperClass='mb-4'  value={email}  onChange={(event) => setEmail(event.target.value)} name='email' label='Email' id='form3' type='email' />

              <MDBInput wrapperClass='mb-4'  value={password}  onChange={(event) => setPassword(event.target.value)} name='password' label='Password' id='form4' type='password' />

              <div className='d-flex mb-4'>
                <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Remember Account' checked={rememberAccount} onChange={() => setRememberAccount(!rememberAccount)} />
              </div>

              <MDBBtn className='w-100 mb-4' size='md' disabled={(email && password) ? false : true} onClick={handleLogin}>
                {loadingLogin && <i className="fa-solid fa-sync fa-spin"></i>}
                &nbsp;Login
              </MDBBtn>
              <div className="text-center">
                <span>Don't Have Account?&nbsp; <Link to="../register">Sign Up</Link></span> 
              </div>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>

      </MDBRow>
      <Outlet/>
      <ToastContainer />

    </MDBContainer>
  );
}

export default Login;
