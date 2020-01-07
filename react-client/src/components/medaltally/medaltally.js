import React from 'react';
import './medaltally.css';
const MedalTally = () => {
  return (
    <div className="MedalTally">
      <h1>Medal Tally</h1>
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

export default MedalTally;
