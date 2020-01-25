import React, { useState, useEffect } from 'react';
import "./leaderboard.css";
import {highScores} from "../../utils/service";

const LeaderBoard = (props) => {
  const [scores, setScores] = useState([]);

  useEffect(() => {
    highScores().then(response => setScores(response));
  }, []);

  let renderList = <span>Loading ... </span>;
  if (scores) {
    renderList = scores.map((item, index) => {
      return (
        <tr key={index}>
          <td>{item.userId}</td>
          <td>{item.totalScore}</td>
        </tr>
      );
    });
  }

  return (
    <div className="LeaderBoard">
      <h1>High Scores</h1>
      <table>
        <thead>
          <tr>
            <th style = {{width: '50%'}}>Username</th>
            <th style = {{width: '50%'}}>Total Score</th>
          </tr>
        </thead>
        <tbody>
          {renderList}
        </tbody>
      </table>
    </div>
  );
};


export default LeaderBoard;
