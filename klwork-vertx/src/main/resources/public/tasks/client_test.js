'use strict';
var path = require('path');
var KarmaServer = require('karma').Server;
var configPath = path.resolve(__dirname, './config/karma.js');

module.exports = function(singleRun) {
  return function(done) {
    var KarmaServer = require('karma').Server;

    var server = new KarmaServer({
      configFile: configPath,
      singleRun: singleRun,
      autoWatch: !singleRun
    }, done);
    server.start();
  }
};
