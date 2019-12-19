import React from 'react';
import { connect } from 'react-redux';
import './statistics.css';
const Statistics = props => {
  console.log(props);

  let renderList = <span>Loading ... </span>;
  if (props.attemptList) {
    renderList = props.attemptList.map((item, index) => {
      return (
        <tr key={item.id}>
          <td>{item.user.name}</td>
          <td>{item.answer}</td>
          <td>{item.result ? 'Correct' : 'InCorrect'}</td>
        </tr>
      );
    });
  }

  return (
    <div className="Statistics">
      <h1>Attempt Statistics </h1>
      <table>
        <thead>
          <tr>
            <th>Name/Alias</th>
            <th>Answered</th>
            <th>Result</th>
          </tr>
        </thead>
        <tbody>{renderList}</tbody>
      </table>
    </div>
  );
};

const mapStateToProps = state => {
  return {
    attemptList: state.attemptList
  };
};

export default connect(mapStateToProps)(Statistics);
