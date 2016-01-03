# SHIFT INTERN 2015.12.19-21
## Abstract
PHPで書かれたECサイトフレームワークであるEC-cubeについて，クロスプロットフォーム環境における基本購入フローの自動化を行った．  
テスト自動化のコアとなるコードは，
/src/test/java/introwork/Work.java にある．
## Details
### 使用言語
Java
### 使用したライブラリ・フレームワーク
Selenium WebDriver
### 構成
#### Jenkins
Windowsローカルマシン上にJenkinsを構築し，Githubからソースコードを拾ってきて，後述するDocker上のSelenium gridにビルド・実行の命令を飛ばせるようにタスクを設定した．

またgridには，後述のようにCent OS上で動くFirefox, ChromeさらにWindows上で動くFirefox, Chrome, IEをnodeとして繋いであるので，クロスプラットフォーム環境においてテストを実行できる．
#### Selenium grid with Docker
##### hub on Docker
Selenium gridのhubは，Docker上のCentOS上に構築してある．
##### node on Docker and local
hubに対するnodeとしては，以下の3つがある．  
1. Chrome of CentOS on Docker  
2. Firefox of CentOS on Docker  
3. IE, Firefox, Chrome of Windows  

![alt text](https://github.com/aion-sm7/shift-work/blob/master/image/slide.jpg?raw=true)
### Flow
1. ローカル(Windows)に立ち上げたJenkinksにアクセスし，タスクを実行ボタンを押す 
2. Jenkinsが，Githubからsource codeをとってきて，Selenium gridに対して渡し，テストタスクを実行させる 
3. テストレポートを出力

#### Test flow
以下のいずれかの行程で，表記しているように動かない場合に，エラーみなす．
1. 各環境に構築したEC-cubeの特定商品のURLにアクセスする  
例: http://demo3.ec-cube.net/products/detail/7  
2. アクセスしたページにおいて，"カートに入れる"をクリックし，画面遷移する  
例: http://demo3.ec-cube.net/cart
3. 遷移した先で，”レジに進む"をクリックし，画面遷移する． 
例: http://demo3.ec-cube.net/shopping/login  
4. 遷移した先で，"ゲスト購入をクリックし，画面遷移する．  
例: http://demo3.ec-cube.net/shopping/nonmember  
5. 遷移した先で，各個人情報を自動入力し，"次へ"で画面遷移する．  
例: http://demo3.ec-cube.net/shopping  
6. 遷移した先で，"注文する"をクリックし，画面遷移する．  
例: http://demo3.ec-cube.net/cart  
7. 遷移した先で，"ご注文は完了しました"が表示されていることを確認し，終了する．  


