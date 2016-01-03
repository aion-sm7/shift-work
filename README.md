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
1. ローカル(Windows)に立ち上げたJenkinksにアクセス 
2. JenkinsからSelenium gridに対してテストタスクを実行させる 
3. Selenium gridから渡された引数(firefox, chrome, remote-firefox)など 

1. 1番目
2. 2番目
3. 3番目


