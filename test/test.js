var
    app = require('../app.js'),
    assert = require('chai').assert,
    bEnc = new Buffer('3243f6a8885a308d313198a2e0370734', 'hex'),
    bCase1 = new Buffer('3925841d02dc09fbdc118597196a0b32', 'hex'),
    bCase2 = new Buffer('f9fb29aefc384a250340d833b87ebc00', 'hex'),
    bCase3 = new Buffer('1a6e6c2c662e7da6501ffb62bc9e93f3', 'hex'),
    bKey1 = new Buffer('2b7e151628aed2a6abf7158809cf4f3c', 'hex'),
    bKey2 = new Buffer('2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5', 'hex'),
    bKey3 = new Buffer('2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe', 'hex');

describe('App specs', function() {
    it('encrypt should return a buffer', function() {
        assert.equal(Buffer.isBuffer(app.encrypt(bEnc, bKey1)), true);
    });
    it('decrypt should return a buffer', function() {
        assert.equal(Buffer.isBuffer(app.decrypt(bCase1, bKey1)), true);
    });
});

describe('Encrypt', function() {
    it('case 1', function() {
        assert.equal(app.encrypt(bEnc, bKey1).toString('hex'), bCase1.toString('hex'));
    });

    it('case 2', function() {
        assert.equal(app.encrypt(bEnc, bKey2).toString('hex'), bCase2.toString('hex'));
    });

    it('case 3', function() {
        assert.equal(app.encrypt(bEnc, bKey3).toString('hex'), bCase3.toString('hex'));
    });
});

describe('Decrypt', function() {
    it('case 1', function() {
        assert.equal(app.decrypt(bCase1, bKey1).toString('hex'), bEnc.toString('hex'));
    });

    it('case 2', function() {
        assert.equal(app.decrypt(bCase2, bKey2).toString('hex'), bEnc.toString('hex'));
    });

    it('case 3', function() {
        assert.equal(app.decrypt(bCase3, bKey3).toString('hex'), bEnc.toString('hex'));
    });
});