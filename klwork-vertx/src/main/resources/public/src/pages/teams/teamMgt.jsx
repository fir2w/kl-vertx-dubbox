import React from 'react';

import CreditQueryForm from './teamQueryForm';

import OpenModel from './openModel';
import postal from 'postal';

import MyAddProductContent from './teamContent';
import { Table,Modal,notification} from 'antd';

import CreditStore from './teamStore';

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
      title: 'ID',
      dataIndex: 'id',
    }, {
      title: '名称',
      dataIndex: 'name',
    }, {
      title: '描述',
      dataIndex: 'description'
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
        <div className="wrapper wrapper-content">
          <div className="row">
            <div className="col-sm-3">
              <div className="ibox float-e-margins">
                <div className="ibox-content mailbox-content">
                  <div className="file-manager">
                    <div className="space-25" />
                    <h5>团队管理</h5>
                    <ul className="folder-list m-b-md" style={{padding: 0}}>
                      <li>
                        <a href="mailbox.html"> <i className="fa fa-inbox " /> 团队1 <span className="label label-warning pull-right">16</span>
                        </a>
                      </li>
                      <li>
                        <a href="mailbox.html"> <i className="fa fa-inbox " /> 团队2 <span className="label label-warning pull-right">3</span>
                        </a>
                      </li>
                    </ul>
                    <div className="clearfix" />
                  </div>
                </div>
              </div>
            </div>
            <div className="col-sm-9 animated fadeInRight">
              <div className="mail-box-header">
                <form method="get" action="index.html" className="pull-right mail-search">
                  <div className="input-group">
                    <input type="text" className="form-control input-sm" name="search" placeholder="搜索用户名称等" />
                    <div className="input-group-btn">
                      <button type="submit" className="btn btn-sm btn-primary">
                        搜索
                      </button>
                    </div>
                  </div>
                </form>
                <h2>
                  团队成员(16)
                </h2>
                <div className="mail-tools tooltip-demo m-t-md">
                  <div className="btn-group pull-right">
                    <button className="btn btn-white btn-sm"><i className="fa fa-arrow-left" />
                    </button>
                    <button className="btn btn-white btn-sm"><i className="fa fa-arrow-right" />
                    </button>
                  </div>
                  <button className="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="刷新邮件列表"><i className="fa fa-refresh" /> 刷新</button>
                  <button className="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为垃圾邮件"><i className="fa fa-trash-o" />
                  </button>
                </div>
              </div>
              <div className="mail-box">
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