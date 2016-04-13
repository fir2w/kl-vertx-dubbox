import React from 'react';
import superagent from 'superagent';
var orderStore = {

  queryAll: function(callback) {
    var url = "./products.json";
    console.log("queryAll");
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

export default orderStore;