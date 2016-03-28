var
  app = require('../app.js'),
  assert = require('chai').assert,
  crypto = require('crypto');

describe('Hidden', function() {
  it('ensure', function() {

    var algo = 'aes-256-ecb';
    var cipher, key, data, original;
    for (var i = 0; i < 10; i++) {
      key = crypto.randomBytes(32);
      data = crypto.randomBytes(16);
      original = new Buffer(16);
      data.copy(original);
      cipher = crypto.createCipheriv(algo, key, new Buffer(''));
      cipher.setAutoPadding(false);
      // Test app decrypt encrypt against original data
      assert.equal(app.decrypt(app.encrypt(data, key), key).toString('hex'), original.toString('hex'));
      // Test app encrypt against verified version of encrypt
      assert.equal(cipher.update(original).toString('hex'), app.encrypt(data, key).toString('hex'));
    }
  });
});