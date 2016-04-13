import React from 'react';
/*import {Modal,Input} from 'react-bootstrap';*/

import CreditQueryForm from './creditQueryForm';

import OpenModel from './openModel';
import postal from 'postal';

import MyAddProductContent from './creditContent';
import { Table,Modal,notification} from 'antd';

import CreditStore from './creditStore';

const channel = postal.channel("task");



export default React.createClass({


  getInitialState: function () {
    return {
      creditratings: [],
      entity:{},
      visible: false,
      visible2:false
    };
  },

  _queryAll: function (condition) {//查询所有评分
    var that = this;
    if (condition) {
      CreditStore.queryBy(condition, function (data) {
        that.setState({
          creditratings: data
        });
      });
    } else {
      CreditStore.queryAll(function (data) {
        that.setState({
          creditratings: data
        });
      });
    }
  },

    openNotificationWithIcon : function(type,message) {
      notification[type](message)();
    },

  showModal: function (dataId) {
    console.log("选择的id:" + dataId);
    this.setState({
      visible: true,
      entity:{
        id: dataId,
        name: '' + dataId + "abc"
      }
    });
  },

  showModal2: function (dataId) {
    console.log("选择的id:" + dataId);
    this.setState({
      visible2: true,
      entity:{
        id: dataId,
        name: '' + dataId + "abc"
      }
    });
  },

  handleOk: function () {
    channel.publish("credit.saved", "abc");
    console.log('点击了确定');
    this.setState({
      visible: false
    });
  },

  handleCancel: function () {
    this.setState({
      visible: false
    });
  },

  handleOk2: function () {

    this.setState({
      visible2: false
    });

    setTimeout(() => {
      this.openNotificationWithIcon('warn',{
        message: '标题',
        description: '修改成功'
      });
    }, 1000);
  },

  handleCancel2: function () {
    this.setState({
      visible2: false
    });
  },
  componentDidMount: function () {
    var that = this;
    CreditStore.queryAll(function (data) {
      that.setState({
        creditratings: data
      });
    });
  },
  render: function () {
    var that = this;
    console.log('init reder');

    const rowSelection = {};


    const rowKey = function (record) {
      return record.id;  // 比如你的数据主键是 uid
    };

    const columns = [{
      title: '信用评级',
      dataIndex: 'creditRatingCode',
    }, {
      title: '评级说明',
      dataIndex: 'description',
    }, {
      title: '最大授信额度',
      dataIndex: 'maxCreditLimit'
    },
      {
        title: '操作',
        key: 'operation',
        render: function (text, record) {
          return <div><OpenModel record={record} open={that.showModal}>修改</OpenModel>&nbsp;
            <OpenModel record={record} open={that.showModal2}>update</OpenModel>
          </div>;
        }
      }
    ];

    return (

      <div className="box box-info">
        <div className="box-header with-border">
          <h3 className="box-title">订单查询</h3>
        </div>
        <div className="box-body">
          <CreditQueryForm queryDatas={this._queryAll}></CreditQueryForm>


          <div id="table_all">
            <div className="btn-group btn-group-xs" role="group"
                 aria-label="...">
            </div>

            <div>
              <Table rowKey={rowKey} rowSelection={rowSelection} columns={columns}
                     dataSource={this.state.creditratings}/>
              <Modal title="第一个 Modal" visible={this.state.visible}
                     onOk={this.handleOk} onCancel={this.handleCancel}>
                <p>{this.state.entity.id}</p>
                <p>{this.state.entity.name}</p>
              </Modal>
              <Modal title="第2个 Modal" visible={this.state.visible2}
                     onOk={this.handleOk2} onCancel={this.handleCancel2}>
                <p>{this.state.entity.name}</p>
              </Modal>
            </div>
          </div>
        </div>
      </div>
    )
  }
});