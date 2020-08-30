import React, { useState } from 'react';
import PropTypes from 'prop-types';
import Modal from "react-modal";

const FieldsRequired = ({ isOpen, message, onClick}) => {

    const change = () => {
        onClick();
    }
    return (
        <Modal
            isOpen={isOpen}
            style={{ content: { width: '360px', height: '360px',marginLeft:'auto',marginRight:'auto',marginTop:'100px'} }}
        >
            <div style={{ color:'red',size: '25px', display: "block" }}>
                Alert !!!
                <button 
                    style={{ backgroundColor: "white", border: 'none', right: '10px', top: '0px', position: 'absolute' }} 
                    onClick={() => change()}>
                        &times;
                </button>
                <hr />
            </div>
            <div style={{ overflowY: 'auto', height: '280px' }}>
                {message}
            </div>
            <div>
                <hr />
                <button style={{ position: "absolute", right: "10px" }} onClick={change}>
                    Close
                </button>
            </div>
        </Modal>
    );
};

FieldsRequired.propTypes = {
    isOpen: PropTypes.bool.isRequired,
    message: PropTypes.string.isRequired,
    onClick:PropTypes.func.isRequired
};

export default FieldsRequired;
