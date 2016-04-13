import React from 'react';
import {  Link, IndexLink } from 'react-router';

export default React.createClass({
  render: function () {
    return (
      <nav className="navbar-default navbar-static-side" role="navigation">
        <div className="nav-close"><i className="fa fa-times-circle" />
        </div>
        <div className="sidebar-collapse">
          <ul className="nav" id="side-menu">
            <li className="nav-header">
              <div className="dropdown profile-element">
                <span><img alt="image" className="img-circle" src="img/profile_small.jpg" /></span>
                <a data-toggle="dropdown" className="dropdown-toggle" href="#">
                  <span className="clear">
                    <span className="block m-t-xs"><strong className="font-bold">Beaut-zihan</strong></span>
                    <span className="text-muted text-xs block">超级管理员<b className="caret" /></span>
                  </span>
                </a>
                <ul className="dropdown-menu animated fadeInRight m-t-xs">
                  <li><a className="J_menuItem" href="form_avatar.html">修改头像</a>
                  </li>
                  <li><a className="J_menuItem" href="profile.html">个人资料</a>
                  </li>
                  <li><a className="J_menuItem" href="contacts.html">联系我们</a>
                  </li>
                  <li><a className="J_menuItem" href="mailbox.html">信箱</a>
                  </li>
                  <li className="divider" />
                  <li><a href="login.html">安全退出</a>
                  </li>
                </ul>
              </div>
              <div className="logo-element">H+
              </div>
            </li>
            <li>
              <a href="#">
                <i className="fa fa-home" />
                <span className="nav-label">主页</span>
                <span className="fa arrow" />
              </a>
              <ul className="nav nav-second-level">
                <li>
                  <Link      to="/tab1" className="J_menuItem">主页示例一 </Link>
                </li>
                <li>
                  <Link      to="/tab2" className="J_menuItem">主页示例2 </Link>
                </li>
                <li>
                  <Link      to="/tab3" className="J_menuItem">新增 </Link>
                </li>
                <li>
                  <a href="index_v5.html" target="_blank">blank</a>
                </li>
              </ul>
            </li>
            <li>
              <a className="J_menuItem" href="layouts.html"><i className="fa fa-columns" /> <span className="nav-label">布局</span></a>
            </li>
            <li>
              <a href="#">
                <i className="fa fa fa-bar-chart-o" />
                <span className="nav-label">demo</span>
                <span className="fa arrow" />
              </a>
              <ul className="nav nav-second-level">
                <li>
                  <Link      to="/teams" className="J_menuItem">团队管理 </Link>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
    )
  }
});