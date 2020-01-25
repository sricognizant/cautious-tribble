import React from "react";
import { connect } from "react-redux";
import "./attempts.css";
const Attempts = (props) => {

  let renderList = <span>Loading ... </span>;
  if (props.attemptList) {
    
    renderList = props.attemptList.map((item, index) => {
      return (
        <tr key={index}>
          <td>{item.localDateTime}</td>
          <td>{item.question}</td>
          <td>{item.answer}</td>
          <td>{item.isCorrect}</td>
        </tr>
      );
    });
  }

  return (
    <div className="MedalTally">
      <h1>Attempts</h1>
      <table>
        <thead style = {{width: '50%'}}>
          <tr>
            <th style = {{width: '30%'}}>Date</th>
            <th>Question</th>
            <th>Answer</th>
            <th>Correct</th>
          </tr>
        </thead>
        <tbody>
         {renderList}
        </tbody>
      </table>
    </div>
  );
};

const mapStateToProps = state => {
  return {
    attemptList: state.attemptList
  };
};

export default connect(mapStateToProps, null)(Attempts);
