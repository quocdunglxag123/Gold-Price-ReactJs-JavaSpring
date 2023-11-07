import React, { useState } from "react";
import './Register.css';
import { useNavigate, Link, Outlet  } from "react-router-dom"
import {ToastContainer,toast} from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css';

import { registerApi } from "../../services/ApiService";
import {formatDateYYYYMMDD} from "../../shared/FormatDate";

import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBCardFooter,
  MDBInput,
  MDBCheckbox,
  MDBIcon,
}
  from 'mdb-react-ui-kit';

const Register = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [address, setAddress] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [birthday, setBirthday] = useState("");

  const [loadingRegister, setLoadingRegister] = useState(false);
  const navigate = useNavigate();

  /** 
   * Handler for Register
  */
  const handleRegister = async (event) => {
    event.preventDefault()
    //Check Input Field
    if (!email || !password || !firstName || !lastName || !address || !phoneNumber || !birthday) {
      toast.error("Please Fill ALL!");
    }

    //Send Api To register
    setLoadingRegister(true);
    let res = await registerApi('register', firstName, lastName, email, password, address, phoneNumber, formatDateYYYYMMDD(birthday));
    setLoadingRegister(false);
    //Check Register Is Success By response Api
    if (res.status === '200' && res.data === true) {
      //Register Success
      toast.success("Register SuccessFull, Going To Login...");
      await new Promise(resolve => setTimeout(resolve, 3000));
      navigate('/login');
    }else{
      //Failed to register
      toast.error(res.errMsg);
    }
  }
  
  return (
    <MDBContainer fluid className='p-4 background-radial-gradient overflow-hidden'>

      <MDBRow>

        <MDBCol md='6' className='text-center text-md-start d-flex flex-column justify-content-center'>

          <h1 className="my-5 display-3 fw-bold ls-tight px-3" style={{ color: 'hsl(218, 81%, 95%)' }}>
            The best offer Register<br />
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
          <form >
            <MDBCard className='my-5 bg-glass'>
              <MDBCardBody className='p-5'>

                <MDBRow>
                  <MDBCol col='6'>
                    <MDBInput wrapperClass='mb-3' onChange={(event) => setFirstName(event.target.value)} name='firstName' label='First name' id='form1' type='text' />
                  </MDBCol>

                  <MDBCol col='6'>
                    <MDBInput wrapperClass='mb-3' onChange={(event) => setLastName(event.target.value)}  name='lastName' label='Last name' id='form2' type='text' />
                  </MDBCol>
                </MDBRow>

                <MDBInput wrapperClass='mb-3' onChange={(event) => setEmail(event.target.value)}  name='email' label='Email' id='email' type='email' />
                <MDBInput wrapperClass='mb-3' onChange={(event) => setPassword(event.target.value)} name='password' label='Password' id='password' type='password' />
                <MDBInput wrapperClass='mb-3' onChange={(event) => setAddress(event.target.value)} name='address' label='address' id='form3' type='text' />
                <MDBInput wrapperClass='mb-3' onChange={(event) => setPhoneNumber(event.target.value)} name='phoneNumber' label='Phone Number' id='phoneNumber' type='tel' />
                <MDBInput wrapperClass='mb-3' onChange={(event) => setBirthday(event.target.value)} name='birthday' label='Birthday' id='form3' type='date' />
                <div className='d-flex mb-3'>
                  <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Subscribe to our newsletter' />
                </div>

                <MDBBtn className='w-100 mb-2' size='md' 
                disabled={(email && password && firstName && lastName && address && phoneNumber && birthday) ? false : true} 
                onClick={handleRegister} > {loadingRegister && <i className="fa-solid fa-sync fa-spin"></i>}
                &nbsp;sign up</MDBBtn>

                <div className="text-center">

                  <p>or sign up with:</p>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='facebook-f' size="sm" />
                  </MDBBtn>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='twitter' size="sm" />
                  </MDBBtn>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='google' size="sm" />
                  </MDBBtn>

                  <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                    <MDBIcon fab icon='github' size="sm" />
                  </MDBBtn>

                </div>

              </MDBCardBody>
              <MDBCardFooter>
                <div className='d-flex mb-2'>
                  <Link to="../login"><i class="fas fa-angles-left me-2"></i>SIGN IN</Link>
                </div>
              </MDBCardFooter>
            </MDBCard>
          </form>
        </MDBCol>

      </MDBRow>
      <Outlet />
      <ToastContainer />

    </MDBContainer>
  );
}

export default Register;
