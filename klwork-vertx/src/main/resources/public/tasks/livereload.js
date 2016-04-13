var miniLr = require('mini-lr');
var liveReload = miniLr();
var config = require('./config').liveReload;

module.exports = function() {
  return function() {
    liveReload.listen(config.port);
  }
};

module.exports.notifyChanged = function (files) {
  liveReload.changed({
    body: {
      files: files
    }
  });
};
