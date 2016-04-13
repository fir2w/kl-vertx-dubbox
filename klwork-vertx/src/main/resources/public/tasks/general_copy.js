'use strict';
var gulp = require('gulp');
var config = require('./config').general;

module.exports = function() {
  return function() {
    return gulp.src(config.source)
      .pipe(gulp.dest(config.destination));
  }
};
