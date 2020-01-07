import React from 'react';
import './remarks.css';
const Remarks = props => {
  return (
    <div className="Remarks">
      <span>{props.answerDetails}</span>
    </div>
  );
};

export default Remarks;
