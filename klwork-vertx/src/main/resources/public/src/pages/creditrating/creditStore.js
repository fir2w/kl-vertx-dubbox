import React from 'react';
import superagent from 'superagent';

export default {

  queryAll: function(callback) {
    //var url = g.dynamicResRoot + "/cc/creditratinglistjson";
    //var url = "./mock/creditratinglistjson.json";
    var url = "http://127.0.0.1:18080/cc/creditratinglist";
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
    var url = "./mock/creditratinglistjsonsmall.json";
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
