'use strict';
var gulp = require('gulp');
var html2jsx = require('gulp-html2jsx');

module.exports = function() {
  return function() {
    return gulp.src('./src/template/template.html')
      .pipe(html2jsx({/* if any opts */}))
      .pipe(gulp.dest('./src/template/out'));
  }
};
