import React from 'react';
import superagent from 'superagent';

export default {

  queryAll: function(callback) {
    //var url = g.dynamicResRoot + "/cc/creditratinglistjson";
    var url = "./mock/teamlistjson.json";
    //var url = "http://127.0.0.1:18080/cc/creditratinglist";
      url = "http://127.0.0.1:18080/teams";
    superagent
      .get(url)
      .set('Accept', 'application/json')
      .end(function (err, agRes) {
        if (err) throw err;
        console.log('inbox:-----------' + JSON.stringify(agRes.body));
        callback(agRes.body.data);
      });
  },
  queryBy: function(conditon,callback) {
    //var url = g.dynamicResRoot + "/cc/creditratinglistjson";
    console.log('查询条件:' + conditon);
    var url = "./mock/teamlistjsonsmall.json";
      url = "http://127.0.0.1:18080/teams";
    superagent
      .get(url)
      .set('Accept', 'application/json')
      .end(function (err, agRes) {
        if (err) throw err;
        console.log('inbox:-----------' + JSON.stringify(agRes.body));
        callback(agRes.body.data);
      });
  }
};
