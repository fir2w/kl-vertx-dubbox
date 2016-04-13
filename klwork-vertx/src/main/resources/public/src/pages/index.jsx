import React from 'react';

import { Progress, Icon } from 'antd';
const ProgressCircle = Progress.Circle;


export default React.createClass({
  render: function () {
    return (
      <div>
        <ProgressCircle percent={30} width={80} />
        <ProgressCircle percent={70} width={80} status="exception" format={<Icon type="exclamation" />} />
        <ProgressCircle percent={100} width={80} />
      </div>
    )
  }
});