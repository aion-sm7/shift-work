# SHIFT INTERN 2015.12.19-21
## Project title
PHPで書かれたECサイトフレームワークであるEC-cubeについて，クロスプロットフォーム環境における基本購入フローの自動化を行った．
  テスト自動化のコアとなるコードは，
/src/test/java/introwork/Work.java
にある．
## Description
### 使用言語
Java
### 使用したライブラリ・フレームワーク
Selenium WebDriver
### 技術
#### Jenkins
Windowsローカルマシン上にJenkinsを構築し，後述するDocker上のSelenium gridに命令を飛ばせるようにタスクを設定した．
#### Selenium grid with Docker
##### hub on Docker
Selenium gridのhubは，Docker上のCentOS上に構築してある．
##### node on Docker and local
hubに対するnodeとしては，以下の3つがある．
1. Chrome of CentOS on Docker
2. Firefox of CentOS on Docker
3. IE, Firefox, Chrome of Windows

### Test flow
1. ローカル(Windows)に立ち上げたJenkinksにアクセスし，タスクを実行ボタンを押す 
2. Jenkinsが，Githubからsource codeをとってきて，Selenium gridに対して渡し，テストタスクを実行させる 
3. テストレポートを出力

![alt text](https://github.com/aion-sm7/shift-work/blob/master/image/slide.jpg?raw=true)
