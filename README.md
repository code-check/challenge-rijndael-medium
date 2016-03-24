## rijndael
Rijndael, commonly referred to as the ***Advanced Encryption Standard*** (AES), is a specification for encrypting data.
Solve the challenge to implement this cipher and pass [tests](test).

## Challenge Description
### Step 1: Encryption
Create your encrypt function in [app.js](app.js) under `encrypt`.
This function will be called from the test cases with the following parameters;
- `byte`
 - The data to encrypt as an array of bytes.
- `key`
 - The key to use for the encryption, as an array of bytes.
The function should return the encrypted data as an array of bytes.

#### Encrypt
<table>
    <tr>
        <th>#</th>
        <th>Key input</th>
        <th>Data input</th>
        <th>Expected output</th>
    </tr>
    <tr>
        <td>1</td>
        <td>2b7e151628aed2a6abf7158809cf4f3c</td>
        <td>3243f6a8885a308d313198a2e0370734</td>
        <td>3925841d02dc09fbdc118597196a0b32</td>
    </tr>
    <tr>
        <td>2</td>
        <td>2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5</td>
        <td>3243f6a8885a308d313198a2e0370734</td>
        <td>f9fb29aefc384a250340d833b87ebc00</td>
    </tr>
    <tr>
        <td>3</td>
        <td>2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe</td>
        <td>3243f6a8885a308d313198a2e0370734</td>
        <td>1a6e6c2c662e7da6501ffb62bc9e93f3</td>
    </tr>
</table>

### Step 2: Decryption
Create your decrypt function in [app.js](app.js) under `decrypt`.
This function will be called from the test cases with the following parameters;
- `byte`
 - The data to decrypt as an array of bytes.
- `key`
 - The key to use for the decryption, as an array of bytes.

The function should return the decrypted data as an array of bytes.

#### Decrypt
<table>
    <tr>
        <th>#</th>
        <th>Key input</th>
        <th>Data input</th>
        <th>Expected output</th>
    </tr>
    <tr>
        <td>1</td>
        <td>2b7e151628aed2a6abf7158809cf4f3c</td>
        <td>3925841d02dc09fbdc118597196a0b32</td>
        <td>3243f6a8885a308d313198a2e0370734</td>
    </tr>
    <tr>
        <td>2</td>
        <td>2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5</td>
        <td>f9fb29aefc384a250340d833b87ebc00</td>
        <td>3243f6a8885a308d313198a2e0370734</td>
    </tr>
    <tr>
        <td>3</td>
        <td>2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe</td>
        <td>1a6e6c2c662e7da6501ffb62bc9e93f3</td>
        <td>3243f6a8885a308d313198a2e0370734</td>
    </tr>
</table>
 
#### Note
- The data passed will be a single block.
- There will be 3 different sizes of keys passed.
    - 128 
    - 192 
    - 256
- The cipher mode will ***always*** be ECB
- *It is allowed to use packages or build-in functionality for this, which means writing your own cipher code is optional.*

### Test Results *before* solving the challenge  
```
codecheck: Finish with code 9
codecheck: tests  : 9
codecheck: success: 0
codecheck: failure: 9
```

### Test Results *after* solving the challenge
```
codecheck: Finish with code 0
codecheck: tests  : 9
codecheck: success: 9
codecheck: failure: 0
```
--- --- ---
## Run Tests
To run tests locally install `codecheck` by running the following command in terminal 
```
$ npm install codecheck -g
```
To run tests in web editor please click in `RUN` button on left side of web editor

## Explain your code
In [answer.md](answer.md) write a brief explanation 
- About how your code works
- Problems faced while solving the challenge
- How you solved those problems
- Improvements/Feedbacks are also welcomed

#### References
- [Wikipedia](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)
- [Flash animation](http://www.formaestudio.com/rijndaelinspector/archivos/Rijndael_Animation_v4_eng.swf)
- [FIPS publication](http://csrc.nist.gov/publications/fips/fips197/fips-197.pdf)
