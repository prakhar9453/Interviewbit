import React, { useState } from 'react';
import { render } from "react-dom";
const axios = require('axios');
import 'regenerator-runtime/runtime'
import "../m.css";
import Create from './inputs/Create';
import Table from "./inputs/Table";

const Main = ({ }) => {

  const [details, setDetails] = useState('')
  const [tableVisible , setTableVisible]= useState(false);

  const get_data = async () => {
    const response = await axios.get('https://interviewbit1.herokuapp.com/interview');
    setDetails(response.data)
  }

  const list = () => {
    get_data();
    setTableVisible(true)
  }

  const close = () => {
    setTableVisible(false)
  }


  return (
    <div style={{textAlign:'center'}}>
      <Create message='Create' />
      <div >
       
          <button style={{ color:'white',backgroundColor:'green',fontSize:'larger',padding: '15px 40px', marginTop: '25px'}} onClick={list}>
            Click Here to display the scheduled interviews
          </button>
    
      </div>
      {tableVisible === true && details &&
        <div style={{textAlign:'center'}}>
          <Table isOpen={tableVisible} details={details}></Table>
          <div style={{marginTop:'15px'}}>
          <span style={{color: 'blue'}}>Click on the row to edit</span>
          </div>
          <button style={{ color:'white',backgroundColor:'red', fontSize:'larger', padding: '15px 40px', marginTop: '25px'}} onClick={close}>
            Close
           </button>
        </div>
      }
    </div>
  )
}


render(<Main />, window.document.getElementById("App"));
