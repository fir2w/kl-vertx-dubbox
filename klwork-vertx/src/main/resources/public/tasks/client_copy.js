'use strict';
var gulp = require('gulp');
var watch = require('gulp-watch');
//var devareLines = require('gulp-devare-lines');
var config = require('./config').client;

module.exports = function(singleRun, callback) {
  return function() {
    var gulpStream = gulp.src(config.source);

    if (!singleRun) {
      var clientWatch = watch(config.source, {verbose: true});

      if (callback) {
        clientWatch.on('change', function(fileName) {
          callback([fileName]);
        });
      }

      gulpStream.pipe(clientWatch);
    }
    else {
     /* gulpStream.pipe(devareLines({
        'filters': [
          /livereload/i
        ]
      }));*/
    }

    return gulpStream.pipe(gulp.dest(config.destination));
  }
};
