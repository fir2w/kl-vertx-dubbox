import React from 'react';

export default React.createClass({
  componentDidMount: function () {

  },
  render: function () {
    return (
      <a onClick={this.props.open.bind(null, this.props.record.id)}>{this.props.children}</a>
    )
  }
});