import React, {PropTypes} from 'react';
import {cx} from './utils';

const tabBarExtraContentStyle = {
  float: 'right',
};

function noop() {
}

const TabNav = React.createClass({
  propTypes: {
    tabPosition: PropTypes.string,
    tabBarExtraContent: PropTypes.any,
    onTabClick: PropTypes.func,
  },

  mixins: [require('./InkBarMixin')],

  getInitialState() {
    return {
      next: false,
      offset: 0,
      prev: false,
    };
  },

  componentDidMount() {
    this.componentDidUpdate();
  },

  componentDidUpdate(prevProps) {

  },


  onTabClick(key) {
    this.props.onTabClick(key);
  },

  // work around eslint warning
  setNextPrev(nextPrev, callback) {
    this.setState(nextPrev, callback);
  },

  getTabs() {
    const props = this.props;
    const children = props.panels;
    const activeKey = props.activeKey;
    const rst = [];
    const prefixCls = props.prefixCls;

    React.Children.forEach(children, (child)=> {
      const key = child.key;
      let cls = activeKey === key ? `active` : '';
      cls += ` J_menuTab`;
      let events = {};
      if (child.props.disabled) {
        cls += ` tab-disabled`;
      } else {
        events = {
          onClick: this.onTabClick.bind(this, key),
        };
      }
      const ref = {};
      if (activeKey === key) {
        ref.ref = 'activeTab';
      }
      rst.push(
        <a {...events} key={key}  {...ref} href="javascript:;" className={cls}
                       data-id="">{child.props.tab}</a>
      );
    });

    return rst;
  },

  getOffsetWH(node) {
    const tabPosition = this.props.tabPosition;
    let prop = 'offsetWidth';
    if (tabPosition === 'left' || tabPosition === 'right') {
      prop = 'offsetHeight';
    }
    return node[prop];
  },

  getOffsetLT(node) {
    const tabPosition = this.props.tabPosition;
    let prop = 'left';
    if (tabPosition === 'left' || tabPosition === 'right') {
      prop = 'top';
    }
    return node.getBoundingClientRect()[prop];
  },

  setOffset(offset) {
    const target = Math.min(0, offset);
    if (this.state.offset !== target) {
      this.setState({
        offset: target,
      });
    }
  },

  setPrev(v) {
    if (this.state.prev !== v) {
      this.setState({
        prev: v,
      });
    }
  },

  setNext(v) {
    if (this.state.next !== v) {
      this.setState({
        next: v,
      });
    }
  },

  isNextPrevShown(state) {
    return state.next || state.prev;
  },

  scrollToActiveTab() {
    const {activeTab, navWrap} = this.refs;
    if (activeTab) {
      const activeTabWH = this.getOffsetWH(activeTab);
      const navWrapNodeWH = this.getOffsetWH(navWrap);
      let {offset} = this.state;
      const wrapOffset = this.getOffsetLT(navWrap);
      const activeTabOffset = this.getOffsetLT(activeTab);
      if (wrapOffset > activeTabOffset) {
        offset += (wrapOffset - activeTabOffset);
        this.setState({offset});
      } else if ((wrapOffset + navWrapNodeWH) < (activeTabOffset + activeTabWH)) {
        offset -= (activeTabOffset + activeTabWH) - (wrapOffset + navWrapNodeWH);
        this.setState({offset});
      }
    }
  },

  prev() {
    const navWrapNode = this.refs.navWrap;
    const navWrapNodeWH = this.getOffsetWH(navWrapNode);
    const state = this.state;
    const offset = state.offset;
    this.setOffset(offset + navWrapNodeWH);
  },

  next() {
    const navWrapNode = this.refs.navWrap;
    const navWrapNodeWH = this.getOffsetWH(navWrapNode);
    const state = this.state;
    const offset = state.offset;
    this.setOffset(offset - navWrapNodeWH);
  },

  render() {
    const props = this.props;
    const state = this.state;
    const prefixCls = props.prefixCls;
    const tabNavs = this.getTabs();

    return (

      <div className="row content-tabs">
        <button className="roll-nav roll-left J_tabLeft"><i className="fa fa-backward"/>
        </button>
        <nav className="page-tabs J_menuTabs">
          <div className="page-tabs-content">
            {tabNavs}
          </div>
        </nav>
        <button className="roll-nav roll-right J_tabRight"><i className="fa fa-forward"/>
        </button>
        <div className="btn-group roll-nav roll-right">
          <button className="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span className="caret"/></button>
          <ul role="menu" className="dropdown-menu dropdown-menu-right">
            <li className="J_tabShowActive"><a>定位当前选项卡</a>
            </li>
            <li className="divider"/>
            <li className="J_tabCloseAll"><a>关闭全部选项卡</a>
            </li>
            <li className="J_tabCloseOther"><a>关闭其他选项卡</a>
            </li>
          </ul>
        </div>
        <a href="login.html" className="roll-nav roll-right J_tabExit"><i className="fa fa fa-sign-out"/> 退出</a>
      </div>
    );
  },
});

export default TabNav;
