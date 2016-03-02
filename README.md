## Information
Rijndael, commonly referred to as the ***Advanced Encryption Standard*** (AES), is a specification for encrypting data.

The goal of this challenge is to implement this cipher so it will validate under the various test cases.

### STEP1. Implement Rijindael
- Pass all of test by editing (Rijindael.scala)[src/main/scala/Rijndael.scala].
- The test file is [RijndaelTest.scala](src/test/scala/RijndaelTest.scala).


### STEP2. Explain about your answer
Write down your idea about how you code on (answer.md)[answer.md].

#### Links
- [Wikipedia](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)
- [Flash animation](http://www.formaestudio.com/rijndaelinspector/archivos/Rijndael_Animation_v4_eng.swf)
- [FIPS publication](http://csrc.nist.gov/publications/fips/fips197/fips-197.pdf)

#### Notes
- The data passed will be a single block.
- There will be 3 different sizes of keys passed.
    - 128 
    - 192 
    - 256
- The cipher mode will ***always*** be ECB
- It is allowed to use packages or build-in functionality for this, which means writing your own cipher code is optional.

## Test cases

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
