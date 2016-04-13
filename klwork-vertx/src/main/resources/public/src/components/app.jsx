import React, { PropTypes } from 'react';
import HeaderBar from './header-bar/header-bar';
import NavigationMenu from './navigation-menu';

import Tabs from './tab/Tabs';
const TabPane = Tabs.TabPane;


const Tab1 = React.createClass({
    render() {
        return (<div>
            tab1
        </div>);
    },
});

const Tab2 = React.createClass({
    render() {
        return (<div>
            tab2
        </div>);
    },
});

const Tab3 = React.createClass({
    render() {
        return (<div>
            tab23ddd
        </div>);
    }
});


export default React.createClass({
    propTypes: {
        children: PropTypes.any
    },

    componentWillMount() {
        this.data = [{
            key: 'tab1',
            component: <Tab1 />,
        }, {
            key: 'tab2',
            component: <Tab2 />,
        }

        ];
    },

    onChange(key) {
        // for demo, better use router api
        window.location.hash = key;
    },

    render() {
        console.log("app render");
        //
        let activeKey = 'tab2';

        const { children } = this.props;
        let hasOne = false;
        if (children) {
            this.data.forEach((d) => {
                if (d.component.type.displayName === children.type.displayName) {
                    // for demo, better immutable
                    d.component = children;
                    activeKey = d.key;
                    hasOne = true;
                }
            });
        }
        if(!hasOne){//没有需要新增一个
            var d = {
                key: 'tab',
                component: null,
            };
            d.component = children;
            d.key = children.type.displayName;
            this.data.push(d);
            activeKey = children.type.displayName;
        }
        const tabs = this.data.map((d) => {
            return <TabPane key={d.key} tab={d.key}>{d.component}</TabPane>;
        });
        return (
            <div className="wrapper wap-abc">
                {/*左侧导航开始*/}
                <NavigationMenu />

                {/*右侧部分开始*/}
                <div id="page-wrapper" className="gray-bg dashbard-1">
                    {/*右侧头部*/}
                    <HeaderBar></HeaderBar>

                    {/*tab区域*/}
                    <Tabs activeKey={activeKey} onChange={this.onChange}>
                        {tabs}
                    </Tabs>


                    <div className="footer">
                        <div className="pull-right">© 2014-2015 <a href="http://baidu/" target="_blank">Happy work</a>
                        </div>
                    </div>
                </div>
                {/*右侧部分结束*/}

            </div>
        )
    }
});

