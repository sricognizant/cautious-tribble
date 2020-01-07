import React from 'react';
import './App.css';
import Question from './components/question/question';
import Statistics from './components/statistics/statistics';
import LeaderBoard from './components/leaderboard/leaderboard';
import MedalTally from './components/medaltally/medaltally';

function App() {
  return (
    <div className="App">
      <div className="container">
        <Question />
        <Statistics />
        <LeaderBoard />
        <MedalTally />
      </div>
    </div>
  );
}

export default App;
