import React from 'react';
import './App.css';
import Question from './components/question/question';
import Statistics from './components/statistics/statistics';
import LeaderBoard from './components/leaderboard/leaderboard';
import Attempts from "./components/attempts/attempts";

function App() {
  return (
    <div className="App">
      <div className="container">
        <Question />
        <Statistics />
        <LeaderBoard />
        <Attempts />
      </div>
    </div>
  );
}

export default App;
