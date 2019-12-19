import * as actionTypes from './actions';

const initialState = {
  attemptList: []
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.ANSWER_QUESTION: {
      console.log('Action', action);
      return {
        ...state,
        attemptList: [...state.attemptList, action.payload]
      };
    }
    case actionTypes.SET_ATTEMPTS: {
      return {
        ...state,
        attemptList: action.payload
      };
    }
    default:
      return state;
  }
};

export default reducer;
