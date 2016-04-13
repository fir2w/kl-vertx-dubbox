import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute, Link, IndexLink, hashHistory} from 'react-router';

import App from './components/app';
import Index from './pages/index';
import Orders from './pages/orders/orders';
import Users from './pages/users/users';
import CreditratingMgt from './pages/creditrating/creditratingMgt';
import Teams from './pages/teams/teamMgt';

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
    }
});

const Tab3 = React.createClass({
    render() {
        return (<div>
            tab23ddd
        </div>);
    }
});

var routes = (
  <Router history={hashHistory}>
      <Route path="/" component={App}>
          <IndexRoute component={Index}/>
          <Route path="tab1" component={Tab1}/>
          <Route path="tab2" component={Tab2}/>
          <Route path="tab3" component={Tab3}/>
          <Route path="teams" component={Teams}/>
      </Route>
  </Router>
);



export default routes;
