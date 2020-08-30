import React, { useState } from 'react';
import PropTypes from 'prop-types';
import Modal from "react-modal";
import BootstrapTable from "react-bootstrap-table-next";
import 'regenerator-runtime/runtime';
import Create from './Create';

const Table = ({ details }) => {
    const [openmodal , setmodalopen] = useState(false);
    const [interviewer, setInterviewer] = useState('');
    const [interviewee, setInterviewee] = useState('');
    const [interviewerMail, setInterviewerMail] = useState('');
    const [intervieweeMail, setIntervieweeMail] = useState('');
    const [startTime, setStartTime] = useState('');
    const [endTime, setEndTime] = useState('');
    const [row, setRow] = useState(-1)

    const columns = [
        {
            dataField: "id",
            text: "Interview ID",

        },
        {
            dataField: "interviewer",
            text: "Interviewer Name",

        },
        {
            dataField: "interviewerMail",
            text: "Interviewer Mail ID"
        },
        {
            dataField: "interviewee",
            text: "Interviewee Name",

        },
        {
            dataField: "intervieweeMail",
            text: "Interviewee Mail ID"
        },
        {
            dataField: "startTime",
            text: "Start Time",
        },
        {
            dataField: "endTime",
            text: "End Time"
        }

    ];

    const close =()=> {
        setmodalopen(false)
    }

    const rowEvents = {
        onClick: (e, row, rowIndex) => {
            setmodalopen(true);
            setInterviewer(row.interviewer);
            setInterviewerMail(row.interviewerMail)
            setInterviewee(row.interviewee)
            setIntervieweeMail(row.intervieweeMail)
            setStartTime(row.startTime)
            setEndTime(row.endTime)
            setRow(row.id)
        }
    };

    return (
        <div style={{textAlign:'center'}}>

            <BootstrapTable
                bootstrap4
                keyField="id"
                data={details}
                columns={columns}
                rowEvents={rowEvents}
            />
            <Modal isOpen={openmodal} >
                <Create
                    message='Submit'
                    interviewers={interviewer}
                    interviewerMails={interviewerMail}
                    interviewees={interviewee}
                    intervieweeMails={intervieweeMail}
                    startTimes={startTime}
                    endTimes={endTime}
                    Ispost={false}
                    row={row}
                />
                <button 
                    style={{ 
                        padding: '15px 40px', 
                        marginTop: '25px', 
                        color: 'white',
                        backgroundColor: 'red',
                        fontSize: 'larger',
                        bottom: '20px',
                        position: 'absolute',
                        right:'10px'
                    }} 
                    onClick={close}
                >
                    Close
               </button>
            </Modal>
        </div>

    );
};

Table.propTypes = {
    details: PropTypes.shape({}),
};

export default Table;
