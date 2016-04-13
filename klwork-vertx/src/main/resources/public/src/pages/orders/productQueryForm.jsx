import React from 'react';

import { DatePicker } from 'antd';


export default React.createClass({
  componentDidMount: function () {
  },
  render: function () {
    var that = this;
    return (
      <form id="queryForm" className="text-right" onsubmit="return false;">
        <p className="row">
        </p>

        <div className="col-sm-2">
          <label className="control-label">关联产品</label>
        </div>
        <div className="col-sm-4">
          <input type="text" className="form-control " placeholder="请输入产品名称或编号查询相关订单" tabIndex={0}
                 aria-invalid="false"/>
        </div>
        <div className="col-sm-2">
          <label className="control-label">订单类型</label>
        </div>
        <div className="col-sm-4">
          <select className="form-control " ng-model="params.type" name="product_productSpecies"
                  tabIndex={0} aria-invalid="false">
            <option value>全部</option>
            {/* ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="INVEST" className=" ">申购</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="REFUND" className=" ">退款</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="TOTALPROFIT" className=" ">总收益
            </option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="LOAN" className=" ">放款</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="SELL" className=" ">出售</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="REDEEM" className=" ">赎回</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="BUY" className=" ">购买</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="REPAYMENT" className=" ">还款</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="PROFIT" className=" ">收益</option>
            {/* end ngRepeat: (key,value) in orderType */}
            <option ng-repeat="(key,value) in orderType" value="ATTORN" className=" ">转让</option>
            {/* end ngRepeat: (key,value) in orderType */}
          </select>
        </div>
        <p />

        <p className="row">
        </p>

        <div className="col-sm-2">
          <label className="control-label">关联投资者</label>
        </div>
        <div className="col-sm-4">
          <input type="text" className="form-control " placeholder="请输入用户名或ID查询相关订单" tabIndex={0}
                 aria-invalid="false"/>
        </div>
        <div className="col-sm-2">
          <label className="control-label">订单状态</label>
        </div>
        <div className="col-sm-4">
          <select className="form-control " tabIndex={0} aria-invalid="false">
            <option value>全部</option>
            {/* ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="TO_AFFIRM" className=" ">待确认
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="PAY_FAILED" className=" ">支付失败
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="CANCEL_FAIL" className=" ">撤消失败
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="REFUND" className=" ">已退款</option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="EXECUTED_FAIL" className=" ">
              执行失败
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="ESTABLISHED_SUCCESS"
                    className=" ">已成立
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="CANCEL_SUCCESS" className=" ">
              撤消成功
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="EXECUTED_SUCCESS" className=" ">
              执行成功
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="TO_CANCEL" className=" ">待撤消
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="INIT" className=" ">初创</option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="PAY_SUCCESS" className=" ">支付成功
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="DISCARD" className=" ">已作废
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="NOT_EXIST" className=" ">不存在
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="TO_PAY" className=" ">待支付</option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="ESTABLISHED_FAILED" className=" ">
              成立失败
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="TO_EXECUTE" className=" ">待执行
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="TIMEOUT" className=" ">订单超时
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="AFFIRM_SUCCESS" className=" ">
              确认成功
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
            <option ng-repeat="(key,value) in orderStatus" value="REJECTED" className=" ">已拒绝待退款
            </option>
            {/* end ngRepeat: (key,value) in orderStatus */}
          </select>
        </div>
        <p />

        <p className="row">
        </p>

        <div className="col-sm-2">
          <label className="control-label">创建时间</label>
        </div>
        <div className="col-sm-2">
          <DatePicker placeholder="开始时间"/>
        </div>
        <div className="col-sm-2">
          <DatePicker placeholder="结束时间"/>
        </div>
        <div className="col-sm-6">
          <button type="reset" className="btn btn-primary" onClick={this._handlerReset} tabIndex={0}>重置
          </button>
          <button type="button" className="btn btn-primary" onClick={this.props.queryProducts}
                  tabIndex={0}>查询
          </button>
        </div>
        <p />
      </form>
    )
  },
  _handlerReset: function () {
   // this.refs.notifier.notice('error', false, "Pressed ESC can cancel");
  }
});
