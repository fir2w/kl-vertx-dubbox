'use strict';
var webpack = require('webpack');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var config = require('./webpack');

config.plugins = [
  new webpack.DefinePlugin({
    ENVIRONMENT: JSON.stringify('test')
  }),
  new ExtractTextPlugin("[name].css")
];
config.devtool = 'inline-source-map';

module.exports = config;
