import React, { useState } from 'react';
const axios = require('axios');
import 'regenerator-runtime/runtime'
import FieldsRequired from "./Modal";
import PropTypes from 'prop-types';

const Create = ({ Ispost, row, message, interviewers, interviewerMails, interviewees, intervieweeMails, startTimes, endTimes }) => {

  const [interviewer, setInterviewer] = useState(interviewers);
  const [interviewee, setInterviewee] = useState(interviewees);
  const [interviewerMail, setInterviewerMail] = useState(interviewerMails);
  const [intervieweeMail, setIntervieweeMail] = useState(intervieweeMails);
  const [startTime, setStartTime] = useState(startTimes);
  const [endTime, setEndTime] = useState(endTimes);
  const [requiredModal, setRequiredModal] = useState(false);
  const [errorModal, setErrorModal] = useState(false);

  const post = async () => {
    const data = {
      interviewer: interviewer,
      interviewerMail: interviewerMail,
      interviewee: interviewee,
      intervieweeMail: intervieweeMail,
      startTime: startTime,
      endTime: endTime,
    };
    let response = '';
    if (Ispost) {
      response = await axios.post('https://interviewbit1.herokuapp.com/', data);
    }
    else {
      response = await axios.put('https://interviewbit1.herokuapp.com/' + row, data);
    }

    if (response.data === 1) {
      setInterviewer('');
      setInterviewerMail('')
      setInterviewee('')
      setIntervieweeMail('')
      setStartTime('')
      setEndTime('')
    }
    else if (response.data === -1) {
      setErrorModal(true)
    }
  }

  const put = () =>{
    setRequiredModal(true)
  }

  const handleClick = () => {
    if (interviewee === "" || intervieweeMail === "" || interviewer === "" || interviewerMail === "" || startTime === "" || endTime === "") {
      put();
      return;
    }
    post();
  }
  return (
    <div style={{textAlign:'center'}} >
      <div>
        <nav>
          {Ispost && <p style={{fontSize:'20px'}}>InterviewBit Assignment</p>}
          <hr></hr>
        </nav>
        <div style={{fontSize:'24px',fontWeight:'bold',color:'green'}}>
          {Ispost && <p>Create a Interview</p>}
        </div>
       
        <div style={{marginTop:'40px'}}>
          <div style={{ marginTop: '15px', marginLeft: '100px' }}>
            <label>
              Interviewer Name:
              <input
                type="text"
                value={interviewer}
                style={{ marginLeft: '78px' }}
                onChange={(event) => setInterviewer(event.target.value)}
              />
            </label>
          </div>


          <div style={{ marginTop: '15px', marginLeft: '100px' }}>
            <label>
              Interviewer Mail ID:
              <input
                type="text"
                value={interviewerMail}
                style={{ marginLeft: '65px' }}
                onChange={(event) => setInterviewerMail(event.target.value)}
              />
            </label>
          </div>

          <div style={{ marginTop: '15px', marginLeft: '100px' }} >
            <label>
              Interviewee Name:
              <input
                type="text"
                value={interviewee}
                style={{ marginLeft: '75px' }}
                onChange={(event) => setInterviewee(event.target.value)}
              />
            </label>
          </div>

          <div style={{ marginTop: '15px', marginLeft: '100px' }}>
            <label>
              Interviewee Mail ID:
              <input
                type="text"
                value={intervieweeMail}
                style={{ marginLeft: '61px' }}
                onChange={(event) => setIntervieweeMail(event.target.value)}
              />
            </label>
          </div>

          <div style={{ marginTop: '15px', marginLeft: '100px' }}>
            <label>
              Start Time:
              <input

                type="datetime-local"
                value={startTime}
                style={{ marginLeft: '125px' }}
                onChange={(event) => setStartTime(event.target.value)}
              />
            </label>
          </div>

          <div style={{ marginTop: '15px', marginLeft: '100px' }}>
            <label>
              End Time:
              <input
                type="datetime-local"
                value={endTime}
                style={{ marginLeft: '130px' }}
                onChange={(event) => setEndTime(event.target.value)}
              />
            </label>
          </div>
        </div>
      </div>
      <button
        style={{ padding: '15px 40px', marginTop: '25px',color:'white',backgroundColor:'green',fontSize:'larger' }}
        onClick={handleClick}>
          {message}
      </button>

{requiredModal && <FieldsRequired
        onClick={() => setRequiredModal(false)}
        isOpen={requiredModal}
          message='All fields are required'>
      </FieldsRequired>}
      {errorModal && <FieldsRequired
        onClick={() => setErrorModal(false)}
        isOpen={errorModal}
          message='Participants are busy please choose different time slot.'>
      </FieldsRequired>}
    </div>
  )
}
Create.defaultProps = {
  interviewers: '',
  interviewees: '',
  interviewerMails: '',
  intervieweeMails: '',
  startTimes: '',
  endTimes: '',
  row: -1,
  Ispost: true,
}
Create.propTypes = {
  interviewers: PropTypes.string,
  interviewees: PropTypes.string,
  interviewerMails: PropTypes.string,
  intervieweeMails: PropTypes.string,
  startTimes: PropTypes.string,
  endTimes: PropTypes.string,
  message: PropTypes.string.isRequired,
  row: PropTypes.number,
  Ispost: PropTypes.bool,
};
export default Create;
