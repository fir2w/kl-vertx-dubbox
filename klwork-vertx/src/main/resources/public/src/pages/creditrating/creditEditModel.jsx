import React from 'react';

export default React.createClass({
  componentDidMount: function () {

  },
  render: function () {
    var that = this;
    return (
      <div>
        <label>abc:</label><input type="text" id="name" onChange={function() {}}/>
      </div>
    )
  }
});