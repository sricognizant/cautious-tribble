import React from 'react';
import './user.css';

const User = props => {
  return (
    <div className="User">
      <label>Name:</label>
      <input type="text" name="name" />
    </div>
  );
};

export default User;
