import React, { useState, useEffect } from 'react';
import './question.css';
import randomQuestion from '../../utils/randomQuestion';
import Remarks from '../remarks/remarks';
import { connect } from 'react-redux';
import * as actionTypes from '../../store/actions';

const Question = props => {
  const [question, setQuestion] = useState({});
  const [answer, setAnswer] = useState(-1);
  const [answerDetails, setAnswerDetails] = useState('');
  const [alias, setAlias] = useState('');
  const [inputStyle, setInputStyle] = useState({ border: 'gray solid 1px' });
  const [isCorrect, setIsCorrect] = useState(false);

  useEffect(() => {
    randomQuestion().then(response => {
      setQuestion(response);
    });
  }, []);

  useEffect(() => {
    if (alias) {
      fetch(`http://localhost:53375/results/users/${alias}`)
        .then(response => response.json())
        .then(data => {
          props.loadAttempts(data);
        });
    }
  }, [alias, props]);

  const handleAnswer = event => {
    if (alias) {
      setInputStyle({ border: 'gray solid 1px' });
      if (parseInt(answer) === parseInt(question.answer)) {
        setAnswerDetails('Your answer is correct');
        setIsCorrect(true);
        randomQuestion().then(response => {
          setQuestion(response);
        });
      } else {
        setAnswerDetails('The answer is wrong. Please try again.');
        setIsCorrect(false);
      }
    } else {
      setIsCorrect(false);
      setInputStyle({ border: 'red solid 1px' });
      setAnswerDetails('Name or Alias is needed. Please try again.');
    }

    const payLoad = {
      user: {
        name: alias
      },
      answer: question.choices[parseInt(answer)],
      quizId: question.id,
      result: isCorrect
    };

    // console.log('payload ', payLoad);
    // console.log(JSON.stringify(payLoad));

    fetch('http://localhost:53375/results/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(payLoad)
    })
      .then(response => response.json())
      .then(data => {
        props.onAttempt(data);
        console.log(data);
      });

    event.preventDefault();
  };

  const handleChoices = event => {
    setAnswer(event.target.value);
  };

  return (
    <div className="Question">
      <form onSubmit={handleAnswer}>
        <div className="User">
          <label>Name:</label>
          <input
            type="text"
            name="name"
            onChange={event => setAlias(event.target.value)}
            value={alias}
            style={inputStyle}
            placeholder="Please enter name/alias"
          />
        </div>
        {alias ? (
          <div>
            <label>{question.question}</label>
            <div className="choices">
              {question.choices ? (
                question.choices.map((choice, index) => {
                  return (
                    <div key={index}>
                      <input
                        className="radio-btn-choices"
                        type="radio"
                        name="site_name"
                        value={index}
                        onChange={handleChoices}
                      />
                      {choice}
                    </div>
                  );
                })
              ) : (
                <span>Loading Questions ....</span>
              )}
            </div>
            <input type="submit" value="Submit" />
            <Remarks answerDetails={answerDetails} />
          </div>
        ) : (
          <span className="required">Required</span>
        )}
      </form>
    </div>
  );
};

const mapDispatchToProps = dispatch => {
  return {
    onAttempt: attempt =>
      dispatch({
        type: actionTypes.ANSWER_QUESTION,
        payload: attempt
      }),
    loadAttempts: attempts =>
      dispatch({
        type: actionTypes.SET_ATTEMPTS,
        payload: attempts
      })
  };
};

export default connect(null, mapDispatchToProps)(Question);
