import React from 'react';

import { DatePicker } from 'antd';


export default React.createClass({

  _handlerReset: function () {
    // this.refs.notifier.notice('error', false, "Pressed ESC can cancel");
  },
  _handlerQuery: function () {
    this.props.queryDatas(
      this.refs.filterTextInput.value
    );
  },
  componentDidMount: function () {
  },
  render: function () {
    var that = this;
    return (
      <form id="queryForm" className="text-right" onsubmit="return false;">
        <p className="row">
        </p>

        <div className="col-sm-2">
          <label className="control-label">信用评级名称:</label>
        </div>
        <div className="col-sm-4">
          <input type="text" className="form-control " placeholder="可输入信用评级搜索" tabIndex={0}
                 aria-invalid="false"  ref="filterTextInput"/>
        </div>
        <div className="col-sm-6">
          <button type="reset" className="btn btn-primary" onClick={this._handlerReset} tabIndex={0}>重置
          </button>
          <button type="button" className="btn btn-primary" onClick={this._handlerQuery} tabIndex={0}>查询
          </button>
        </div>
        <p />
      </form>
    )
  }

});
