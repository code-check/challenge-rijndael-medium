//BEGIN_CHALLENGE
var crypto = require('crypto');
//END_CHALLENGE
exports.encrypt = function(data, key) {
  //BEGIN_CHALLENGE
  var algo = 'aes-' + (key.length * 8) + '-ecb';
  var cipher = crypto.createCipheriv(algo, key, new Buffer(''));
  cipher.setAutoPadding(false);
  return cipher.update(data);
  //END_CHALLENGE
};

exports.decrypt = function(data, key) {
  //BEGIN_CHALLENGE
  var algo = 'aes-' + (key.length * 8) + '-ecb';
  var cipher = crypto.createDecipheriv(algo, key, new Buffer(''));
  cipher.setAutoPadding(false);
  return cipher.update(data);
  //END_CHALLENGE
};