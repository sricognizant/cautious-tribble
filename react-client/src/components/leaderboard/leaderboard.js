import React from 'react';
import './leaderboard.css';
const LeaderBoard = () => {
  return (
    <div className="LeaderBoard">
      <h1>Leader Board</h1>
      <table>
        <thead>
          <tr>
            <th>Company</th>
            <th>Contact</th>
            <th>Country</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Alfreds Futterkiste</td>
            <td>Maria Anders</td>
            <td>Germany</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default LeaderBoard;
