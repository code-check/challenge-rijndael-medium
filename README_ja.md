# 暗号化問題(ラインダール)
これはラインダール(Rijindael)を実装するアルゴリズムチャレンジです。  

## 内容
Rijndaelとは、ベルギーの数学者Joan Daemen氏とVincent Rijmen氏によって開発された秘密鍵暗号化アルゴリズムです。
2000年10月に、アメリカ政府標準技術局（NIST）によって次世代の暗号化標準**AES（Advanced Encryption Standard）**に選定されました。

### 参考
- [Wikipedia](https://en.wikipedia.org/wiki/Advanced_Encryption_Standard)
- [Flash animation](http://www.formaestudio.com/rijndaelinspector/archivos/Rijndael_Animation_v4_eng.swf)
- [FIPS publication](http://csrc.nist.gov/publications/fips/fips197/fips-197.pdf)

## 問題
この問題では、いくつかのテストケースが与えられており、それらをすべて満たす暗号化の実装をします。

### ステップ1, 暗号化を実装してください
- [test1.js](test/test1.js) にテストコードが記載されています。
- [app.js](app.js)内の `exports.encrypt` 内を編集して、暗号化の関数を実装してください。
- この関数は、暗号化されたデータをバッファで正しく返す必要があります。
- この関数は以下のパラメータを使用してテストケースで呼びだされます。
  - `byte`
    - バッファとして暗号化されるデータ
  - `key`
    - バッファとして暗号化に使用されるキー

#### テストケース
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

#### 正しいテストの実行結果
- 正しく問題を解答できた場合、テストケースのうちの以下の4つが通過することができます
```
ok 1 App specs encrypt should return a buffer
ok 3 Encrypt case 1
ok 4 Encrypt case 2
ok 5 Encrypt case 3
```

### ステップ2, 暗号解読を実装してください
- [test1.js](test/test1.js) にテストコードが記載されています。
- [app.js](app.js)内の `exports.decrypt` 内を編集して、暗号解読の関数を実装してください。
- この関数は、暗号解読されたデータをバッファで正しく返す必要があります。
- また、この関数は以下のパラメータを使用してテストケースで呼びだされます。
  - `byte`
    - バッファとして暗号化解読されるデータ
  - `key`
    - バッファとして暗号化解読に使用されるキー

#### テストケース
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

#### 正しいテストの実行結果
- 正しく問題を解答できた場合、テストケースのうちの以下の4つが通過することができます
```
ok 2 App specs decrypt should return a buffer
ok 6 Decrypt case 1
ok 7 Decrypt case 2
ok 8 Decrypt case 3
```

### ステップ3, あなたの書いたコードについて説明してください
[answer.md](./answer.md) というファイルを用意してあるので、その中に
- どのように実装したか
- どのような事に気をつけて実装したか、工夫した点は何か
- チャレンジに挑戦する中で起きた問題、難しかった箇所
- またそれをどのようにして対処したのか

等を書いてください。

## 期待するテストの実行結果
- テストの実行結果として以下の表示がされればクリアです。

```
ok 1 App specs encrypt should return a buffer
ok 2 App specs decrypt should return a buffer
ok 3 Encrypt case 1
ok 4 Encrypt case 2
ok 5 Encrypt case 3
ok 6 Decrypt case 1
ok 7 Decrypt case 2
ok 8 Decrypt case 3
# tests 8
# pass 8
# fail 0
codecheck: Finish with code 0
codecheck: tests : 8
codecheck: success: 8
codecheck: failure: 0
```

### 補足
- データはシングルブロックで渡されます
- 渡されたキーには、3種類のサイズの異なるものがあります
    - 128 
    - 192 
    - 256

- 暗号利用モードは ***常に*** ECBです
- この問題では暗号化のパッケージを自由に使うことを許可しております
- 独自に暗号化コードを実装するかどうかを選択することが出来ます。

---
## テストの実行方法
- codecheckでは、テストコードを実行して自分が正しく回答できているかどうかを確かめることができます
- Webエディタで受験している場合は、エディタ下にあるコンソールの”Run”ボタンをクリックしてください
- GitHubを活用したローカル受験では、以下の手順に従ってcodecheck CLIをインストールし、テストを実行してください

- クローンしたプロジェクトのroot folderに移動し、以下のコマンドでCLIをインストールします
```
$ npm install codecheck -g
```

- テストを実行するにはroot folderから `codecheck`と入力し、実行してください