var gulp = require('gulp');
var runSequence = require('run-sequence');

var clientCopyTask = require('./tasks/client_copy');
var clientBuildTask = require('./tasks/client_build');
var clientTestTask = require('./tasks/client_test');
var liveReloadTask = require('./tasks/livereload');
var generalCopyTask = require('./tasks/general_copy');
var cleanTask = require('./tasks/clean');

var html2jsxTask = require('./tasks/html2jsx');

gulp.task('h2j', html2jsxTask());

gulp.task('general-copy-dist', generalCopyTask());

gulp.task('livereload', liveReloadTask());

gulp.task('client-copy', clientCopyTask(false, liveReloadTask.notifyChanged));
gulp.task('client-copy-dist', clientCopyTask(true));
gulp.task('client-build', clientBuildTask(false, liveReloadTask.notifyChanged));
gulp.task('client-build-dist', clientBuildTask(true));
gulp.task('client-test', clientTestTask(true));
gulp.task('client-test-dev', clientTestTask(false));

gulp.task('clean', cleanTask());

gulp.task('serve', function(done) {
  runSequence(
    'clean',
    ['client-build', 'client-copy', 'livereload'],
    done
  )
});

gulp.task('test', function(done) {
  runSequence(
    'client-test',
    done
  )
});

gulp.task('test-dev', function(done) {
  runSequence(
    'client-test-dev',
    done
  )
});

gulp.task('dist', function(done) {
  runSequence(
    'clean',
    ['client-build-dist', 'client-copy-dist', 'general-copy-dist'],
    done
  );
});

gulp.task('default', function(done) {
  runSequence(
    'client-build',
    done
  );
});
