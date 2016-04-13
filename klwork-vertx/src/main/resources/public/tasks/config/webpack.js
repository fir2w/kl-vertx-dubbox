'use strict';
var path = require('path');
var webpack = require('webpack');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var config = require('./index').client;

module.exports = {
  entry: {
    boot: './src/boot.jsx',
    vendor: './src/vendor.jsx'
  },
  output: {
    path: path.resolve(__dirname, '../../', config.destination),
    filename: '[name].js'
  },
  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        loader: 'babel',
        exclude: /node_modules/,
        query: {
          presets: ['react','es2015'],
          plugins: [
            'transform-decorators-legacy',
            'transform-class-properties',
            'transform-flow-strip-types'
          ]
        }
      },
      {
        test: /\.html$/,
        loader: 'html?minimize=false'
      },
      {
        test: /\.less$/,
        loader: ExtractTextPlugin.extract(
            'css?sourceMap&-minimize!' + 'postcss-loader!' + 'less?sourceMap'
        )
      },
      {
        test: /\.css$/,
        loader: ExtractTextPlugin.extract('style', 'css')
      },
      {
        test: /\.woff(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=application/font-woff"
      }, {
        test: /\.woff2(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=application/font-woff"
      }, {
        test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=application/octet-stream"
      }, {
        test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
        loader: "file"
      }, {
        test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
        loader: "url?limit=10000&minetype=image/svg+xml"
      }
    ]
  },

  resolve: {
    root: __dirname,
    extensions: ['','.js','.jsx','.json']
  },

  plugins: [
    new webpack.DefinePlugin({
      ENVIRONMENT: JSON.stringify('development')
    }),
    new webpack.optimize.CommonsChunkPlugin(
      'vendor', 'vendor.js', Infinity
    ),
    new ExtractTextPlugin("[name].css")
  ],

  devtool: 'source-map'
};
