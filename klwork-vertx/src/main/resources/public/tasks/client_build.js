'use strict';
var gulp = require('gulp');
var webpack = require('webpack');
var util = require('gulp-util');
var config = require('./config').client;

module.exports = function(singleRun, callback) {
  return function(cb) {
    var webpackConfig = singleRun ? require('./config/webpack.dist') : require('./config/webpack');
    var webpackBuild = webpack(webpackConfig);
    var firstRun = true;

    var callbackOnBuild = function(err, stats) {
      if (err) {
        throw new util.PluginError("webpack:error", err);
      }

      var statistics = stats.toJson({
        children: false,
        source: false,
        modules: false,
        chunkModules: false
      });

      var elapsedTime = Math.round(statistics.time / 10) / 100;

      if (singleRun) {
        cb();
      }
      else {
        if (firstRun) {
          cb();
          firstRun = false;
        }
        else {
          util.log('webpack:build ${elapsedTime} s');

          callback(
            statistics.assets.map( function (file){ return file.name }));
        }
      }
    };

    if (singleRun) {
      webpackBuild.run(callbackOnBuild);
    }
    else {
      util.log('ddd not singleRun');
      webpackBuild.watch({ aggregateTimeout: 100 }, callbackOnBuild);
    }
  }
};
