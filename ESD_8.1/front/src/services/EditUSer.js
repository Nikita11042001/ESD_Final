import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function EditUser() {
    let navigate=useNavigate();
    const{id}=useParams()
    // const [userPrev,setUserPrev]=useState({
    //     l_name:"",
    //     f_name:"",
    //     email:"",
    //     con:"",
    //     comp_name:"",
    //     comp_add:""

    // });
    
    const [user,setUser]=useState({
        l_name:"",
        f_name:"",
        email:"",
        con:"",
        comp_name:"",
        comp_add:""

    });
    
    console.log(user)

    const onInputChange=(e)=>{
        console.log(e)
        setUser({...user,[e.target.name]:e.target.value});
    };

    useEffect(()=>{

        loadUser()
    },[]);

    const onSubmit = async (e) => {
        e.preventDefault();
        // try {
        //     const result = await axios.get(`http://localhost:8080/api/HR/getHR/${id}`);
        //     // Handle the result if needed
        //     setUser(result.data);
        //   } catch (error) {
        //     // Handle errors
        //     if (axios.isAxiosError(error) && error.response) {
        //       // Handle specific error status codes or response data if needed
        //       console.error('Error:', error.response.data);
        //       // Handle other error status codes or responses
        //     } else {
        //       // Handle other types of errors
        //       console.error('Error:', error);
        //     }
        //   }
        try {
          const response = await axios.post(`http://localhost:8080/api/HR/update/${id}`, user);
          // Handle the response if needed
          console.log(response.data);
      
          // Navigate to the desired location
          navigate("/");
        } catch (error) {
          // Handle errors
          if (axios.isAxiosError(error) && error.response) {
            // Handle specific error status codes or response data if needed
            if (error.response.status === 400) {
              alert("Enter Correct Company ID or Email ID already Exists");
              console.error('Bad Request:', error.response.data);
              navigate(`/edituser/${id}`);
            } else {
              console.error('Error:', error.response.data);
              // Handle other error status codes or responses
            }
          } else {
            // Handle other types of errors
            console.error('Error:', error);
          }
        }
      };

      const loadUser = async () => {
        try {
          const result = await axios.get(`http://localhost:8080/api/HR/getHR/${id}`);
          // Handle the result if needed
          setUser(result.data);
        } catch (error) {
          // Handle errors
          if (axios.isAxiosError(error) && error.response) {
            // Handle specific error status codes or response data if needed
            console.error('Error:', error.response.data);
            // Handle other error status codes or responses
          } else {
            // Handle other types of errors
            console.error('Error:', error);
          }
        }
      };

    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Register HR</h2>
                    <form onSubmit={(e)=>onSubmit(e)}>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            First Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder='Enter your Name'
                            name="f_name"
                            value={user.f_name}
                            onChange={(e)=>onInputChange(e)}
                            required
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Last Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder='Enter your User Name'
                            name="l_name"
                            value={user.l_name}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Email
                        </label>
                        <input
                            type={"email"}
                            className="form-control"
                            placeholder='Enter your Email'
                            name="email"
                            value={user.email}
                            onChange={(e)=>onInputChange(e)}
                            required
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Contact
                        </label>
                        <input
                            type="tel"
                            className="form-control"
                            pattern="[0-9]{10}" 
                            maxlength="10"
                            placeholder='10 Digit Phone'
                            name="con"
                            value={user.con}
                            onChange={(e)=>onInputChange(e)}
                            required
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Organisation Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder='Enter Org Name'
                            name="comp_name"
                            value={user.comp_name}
                            onChange={(e)=>onInputChange(e)}
                            
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='Name' className='form-label'>
                            Organisation Address
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder='Enter Org Address'
                            name="comp_add"
                            value={user.comp_add}
                            onChange={(e)=>onInputChange(e)}
                            
                        />
                    </div>
                    <button type='submit'  className='btn btn-outline-primary'>Submit</button>
                    <Link className='btn btn-outline-danger mx-2' to="/">Cancel</Link>
                    </form>
                </div>

            </div>
            {/* <div className="footer">
                <p>Made with ❤️ and 🧑‍💻 by <i>ng</i></p>
            </div> */}
        </div>
    );
}
