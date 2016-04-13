import React from 'react';
import {  Link, IndexLink } from 'react-router';
import HeaderMessages from './header-messages';

import HeaderNotifications from './header-notifications';
import HeaderTasks from './header-tasks';
import postal from 'postal';
import { message } from 'antd';
const channel = postal.channel("task");



const signAction = channel.subscribe("credit.saved", function(data, envelope) {
  message.success("评分已经修改" + data);
});

export default React.createClass({
  getInitialState: function () {
    return {
      messages: [],
      notifications: [],
      tasks: []
    }
  },
  pushMenu: function () {
    var body = document.body;
    if (body.clientWidth > 768) {
      if (body.className.indexOf('sidebar-collapse') === -1) {
        body.className += ' sidebar-collapse';
      } else {
        body.className = body.className.replace(' sidebar-collapse', '');
      }
    } else {
      if (body.className.indexOf('sidebar-open') === -1) {
        body.className += ' sidebar-open';
      } else {
        body.className = body.className.replace(' sidebar-open', '');
      }
    }
  },
  componentDidMount: function () {
    var messages = [{
      displayName: 'Support Team',
      displayPicture: 'dist/img/user2-160x160.jpg',
      messageSubject: 'Why not buy a new awesome theme?',
      messageTime: '5 mins',
    }, {
      displayName: 'AdminLTE Design Team',
      displayPicture: 'dist/img/user3-128x128.jpg',
      messageSubject: 'Why not buy a new awesome theme?',
      messageTime: '2 hours',
    }, {
      displayName: 'Developers',
      displayPicture: 'dist/img/user4-128x128.jpg',
      messageSubject: 'Why not buy a new awesome theme?',
      messageTime: 'Today',
    }, {
      displayName: 'Sales Department',
      displayPicture: 'dist/img/user3-128x128.jpg',
      messageSubject: 'Why not buy a new awesome theme?',
      messageTime: 'Yesterday',
    }, {
      displayName: 'Reviewers',
      displayPicture: 'dist/img/user4-128x128.jpg',
      messageSubject: 'Why not buy a new awesome theme?',
      messageTime: '2 days',
    }];

    var notifications = [{
      subject: '5 new members joined today',
      className: 'fa fa-users text-aqua'
    }, {
      subject: 'Very long description here that may not fit into the page and may cause design problems',
      className: 'fa fa-warning text-yellow'
    }, {
      subject: '5 new members joined',
      className: 'fa fa-users text-red'
    }, {
      subject: '25 sales made',
      className: 'fa fa-shopping-cart text-green'
    }, {
      subject: 'You changed your username',
      className: 'fa fa-user text-red'
    }];

    var tasks = [{
      subject: 'Design some buttons',
      percentage: 20
    }, {
      subject: 'Create a nice theme',
      percentage: 40
    }, {
      subject: 'Some task I need to do',
      percentage: 60
    }, {
      subject: 'Make beautiful transitions',
      percentage: 80
    }];

    this.setState({
      messages: messages,
      notifications: notifications,
      tasks: tasks
    });
  },
  render: function () {
    var that = this;
    return (
      <div className="row border-bottom">
        <nav className="navbar navbar-static-top" role="navigation" style={{marginBottom: 0}}>
          <div className="navbar-header"><a className="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i className="fa fa-bars" /> </a>
            <form role="search" className="navbar-form-custom" method="post" action="search_results.html">
              <div className="form-group">
                <input type="text" placeholder="请输入您需要查找的内容 …" className="form-control" name="top-search" id="top-search" />
              </div>
            </form>
          </div>
          <ul className="nav navbar-top-links navbar-right">
            <li className="dropdown">
              <a className="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                <i className="fa fa-envelope" /> <span className="label label-warning">18</span>
              </a>
              <ul className="dropdown-menu dropdown-messages">
                <li className="m-t-xs">
                  <div className="dropdown-messages-box">
                    <a href="profile.html" className="pull-left">
                      <img alt="image" className="img-circle" src="img/a7.jpg" />
                    </a>
                    <div className="media-body">
                      <small className="pull-right">46小时前</small>
                      <strong>小四</strong> 这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？
                      <br />
                      <small className="text-muted">3天前 2014.11.8</small>
                    </div>
                  </div>
                </li>
                <li className="divider" />
                <li>
                  <div className="dropdown-messages-box">
                    <a href="profile.html" className="pull-left">
                      <img alt="image" className="img-circle" src="img/a4.jpg" />
                    </a>
                    <div className="media-body ">
                      <small className="pull-right text-navy">25小时前</small>
                      <strong>国民岳父</strong> 如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶
                      <br />
                      <small className="text-muted">昨天</small>
                    </div>
                  </div>
                </li>
                <li className="divider" />
                <li>
                  <div className="text-center link-block">
                    <a className="J_menuItem" href="mailbox.html">
                      <i className="fa fa-envelope" /> <strong> 查看所有消息</strong>
                    </a>
                  </div>
                </li>
              </ul>
            </li>
            <li className="dropdown">
              <a className="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                <i className="fa fa-bell" /> <span className="label label-primary">8</span>
              </a>
              <ul className="dropdown-menu dropdown-alerts">
                <li>
                  <a href="mailbox.html">
                    <div>
                      <i className="fa fa-envelope fa-fw" /> 您有16条未读消息
                      <span className="pull-right text-muted small">4分钟前</span>
                    </div>
                  </a>
                </li>
                <li className="divider" />
                <li>
                  <a href="profile.html">
                    <div>
                      <i className="fa fa-qq fa-fw" /> 3条新回复
                      <span className="pull-right text-muted small">12分钟钱</span>
                    </div>
                  </a>
                </li>
                <li className="divider" />
                <li>
                  <div className="text-center link-block">
                    <a className="J_menuItem" href="notifications.html">
                      <strong>查看所有 </strong>
                      <i className="fa fa-angle-right" />
                    </a>
                  </div>
                </li>
              </ul>
            </li>
            <li className="hidden-xs">
              <a href="index_v1.html" className="J_menuItem" data-index={0}><i className="fa fa-cart-arrow-down" /> 订单</a>
            </li>
            <li className="dropdown hidden-xs">
              <a className="right-sidebar-toggle" aria-expanded="false">
                <i className="fa fa-tasks" /> 主题
              </a>
            </li>
          </ul>
        </nav>
      </div>
    )
  }
});
