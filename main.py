# coding: utf-8

from bs4 import BeautifulSoup
import urllib

def main():
    html = """
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width">
    <title>EC-CUBE SHOP / 非会員購入</title>
                    <link rel="shortcut icon" href="/img/common/favicon.ico">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/slick.css">
    <link rel="stylesheet" href="/css/theme_origin.css"><!-- for original theme CSS -->
        
              </head>
  <body class="front_page">
    <div id="wrapper">
    <header id="header">

                            
        <div class="container-fluid inner">
            <div class="header_logo_area">

                                                
            </div>

                                    
            <p id="btn_menu"><a class="nav-trigger" href="#nav">Menu<span></span></a></p>
        </div>
    </header>
    
    <div id="contents" class="main_only">

        <div id="primary">

                                    
                                    
            <div class="container-fluid inner">
                <div id="undercolumn">
        <div id="undercolumn_customer">
            <p class="flow_area"><img src="/user_data/packages/default/img/picture/img_flow_01.jpg" alt="購入手続きの流れ" /></p>
            <h2 class="title">非会員購入</h2>

            <div class="information" id="hogehoge">
                <p>下記項目にご入力ください。「<span class="attention">※</span>」印は入力必須項目です。<br />
                                    </p>
            </div>

            <form name="form1" id="form1" method="post" action="/shopping/nonmember">
                <input type="hidden" id="nonmember__token" name="nonmember[_token]" class="form-control" value="64421dc59fcbf6c9f3476180ececc3fb84e33305" />
                <table summary="会員登録フォーム">

                    <col width="30%" />
                    <col width="70%" />
                    <tr>
                        <th>お名前<span class="attention">※</span></th>
                        <td>
                            <input type="text" id="nonmember_name_name01" name="nonmember[name][name01]" required="required" maxlength="50" class="form-control" /><input type="text" id="nonmember_name_name02" name="nonmember[name][name02]" required="required" maxlength="50" class="form-control" />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>お名前(フリガナ)<span class="attention">※</span></th>
                        <td>
                            <input type="text" id="nonmember_kana_kana01" name="nonmember[kana][kana01]" required="required" maxlength="50" class="form-control" /><input type="text" id="nonmember_kana_kana02" name="nonmember[kana][kana02]" required="required" maxlength="50" class="form-control" />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>会社名</th>
                        <td>
                            <input type="text" id="nonmember_company_name" name="nonmember[company_name]" class="form-control" />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>郵便番号<span class="attention">※</span></th>
                        <td>
                            <p class="top">
            〒&nbsp;<input type="text" id="zip01" name="nonmember[zip][zip01]" maxlength="3" class="box60 form-control" style="ime-mode: disabled;" />&nbsp;-&nbsp;<input type="text" id="zip02" name="nonmember[zip][zip02]" maxlength="4" class="box60 form-control" style="ime-mode: disabled;" />　
            <span><svg class="cb cb-question"><use xlink:href="#cb-question" /></svg></span> <a href="http://www.post.japanpost.jp/zipcode/" target="_blank">郵便番号検索</a>
        </p><p class="zipimg">
            <a href="#" id="zip-search">
                <img src="/user_data/packages/default/img/button/btn_address_input.jpg" alt="住所自動入力" /></a>
            <span class="mini">&nbsp;郵便番号を入力後、クリックしてください。</span>
        </p><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>住所<span class="attention">※</span></th>
                        <td>
                            <select id="pref" name="nonmember[address][pref]" class="form-control"><option value="">都道府県を選択</option><option value="1">北海道</option><option value="2">青森県</option><option value="3">岩手県</option><option value="4">宮城県</option><option value="5">秋田県</option><option value="6">山形県</option><option value="7">福島県</option><option value="8">茨城県</option><option value="9">栃木県</option><option value="10">群馬県</option><option value="11">埼玉県</option><option value="12">千葉県</option><option value="13">東京都</option><option value="14">神奈川県</option><option value="15">新潟県</option><option value="16">富山県</option><option value="17">石川県</option><option value="18">福井県</option><option value="19">山梨県</option><option value="20">長野県</option><option value="21">岐阜県</option><option value="22">静岡県</option><option value="23">愛知県</option><option value="24">三重県</option><option value="25">滋賀県</option><option value="26">京都府</option><option value="27">大阪府</option><option value="28">兵庫県</option><option value="29">奈良県</option><option value="30">和歌山県</option><option value="31">鳥取県</option><option value="32">島根県</option><option value="33">岡山県</option><option value="34">広島県</option><option value="35">山口県</option><option value="36">徳島県</option><option value="37">香川県</option><option value="38">愛媛県</option><option value="39">高知県</option><option value="40">福岡県</option><option value="41">佐賀県</option><option value="42">長崎県</option><option value="43">熊本県</option><option value="44">大分県</option><option value="45">宮崎県</option><option value="46">鹿児島県</option><option value="47">沖縄県</option></select><p><input type="text" id="addr01" name="nonmember[address][addr01]" class="box380 form-control" style="ime-mode: active;" /><br />
            市区町村名 (例：千代田区神田神保町)
        </p>
        <p><input type="text" id="addr02" name="nonmember[address][addr02]" class="box380 form-control" style="ime-mode: active;" /><br />
            番地・ビル名 (例：1-3-5)
        </p><p class="mini"><span class="attention">住所は2つに分けてご記入ください。マンション名は必ず記入してください。</span></p><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>電話番号</th>
                        <td>
                            <input type="text" id="nonmember_tel_tel01" name="nonmember[tel][tel01]" maxlength="3" class="box60 form-control" style="ime-mode: disabled;" />&nbsp;-&nbsp;<input type="text" id="nonmember_tel_tel02" name="nonmember[tel][tel02]" maxlength="4" class="box60 form-control" style="ime-mode: disabled;" />&nbsp;-&nbsp;<input type="text" id="nonmember_tel_tel03" name="nonmember[tel][tel03]" maxlength="4" class="box60 form-control" style="ime-mode: disabled;" /><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>FAX</th>
                        <td>
                            <input type="text" id="nonmember_fax_fax01" name="nonmember[fax][fax01]" maxlength="3" class="box60 form-control" style="ime-mode: disabled;" />&nbsp;-&nbsp;<input type="text" id="nonmember_fax_fax02" name="nonmember[fax][fax02]" maxlength="4" class="box60 form-control" style="ime-mode: disabled;" />&nbsp;-&nbsp;<input type="text" id="nonmember_fax_fax03" name="nonmember[fax][fax03]" maxlength="4" class="box60 form-control" style="ime-mode: disabled;" /><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>メールアドレス<span class="attention">※</span></th>
                        <td>
                            <input type="email" id="nonmember_email" name="nonmember[email]" required="required" class="form-control" /><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>性別</th>
                        <td>
                            <div id="nonmember_sex"><div class="radio">                                                            <label class=""><input type="radio" id="nonmember_sex_1" name="nonmember[sex]" value="1" />男性</label>
    </div><div class="radio">                                                            <label class=""><input type="radio" id="nonmember_sex_2" name="nonmember[sex]" value="2" />女性</label>
    </div></div><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>職業</th>
                        <td>
                            <select id="nonmember_job" name="nonmember[job]" class="form-control"><option value="">選択してください</option><option value="1">公務員</option><option value="2">コンサルタント</option><option value="3">コンピューター関連技術職</option><option value="4">コンピューター関連以外の技術職</option><option value="5">金融関係</option><option value="6">医師</option><option value="7">弁護士</option><option value="8">総務・人事・事務</option><option value="9">営業・販売</option><option value="10">研究・開発</option><option value="11">広報・宣伝</option><option value="12">企画・マーケティング</option><option value="13">デザイン関係</option><option value="14">会社経営・役員</option><option value="15">出版・マスコミ関係</option><option value="16">学生・フリーター</option><option value="17">主婦</option><option value="18">その他</option></select><br />
                            
                        </td>
                    </tr>
                    <tr>
                        <th>生年月日</th>
                        <td>
                            <div id="nonmember_birth" class="form-inline"><select id="nonmember_birth_year" name="nonmember[birth][year]" class="form-control"><option value="">----</option><option value="1895">1895</option><option value="1896">1896</option><option value="1897">1897</option><option value="1898">1898</option><option value="1899">1899</option><option value="1900">1900</option><option value="1901">1901</option><option value="1902">1902</option><option value="1903">1903</option><option value="1904">1904</option><option value="1905">1905</option><option value="1906">1906</option><option value="1907">1907</option><option value="1908">1908</option><option value="1909">1909</option><option value="1910">1910</option><option value="1911">1911</option><option value="1912">1912</option><option value="1913">1913</option><option value="1914">1914</option><option value="1915">1915</option><option value="1916">1916</option><option value="1917">1917</option><option value="1918">1918</option><option value="1919">1919</option><option value="1920">1920</option><option value="1921">1921</option><option value="1922">1922</option><option value="1923">1923</option><option value="1924">1924</option><option value="1925">1925</option><option value="1926">1926</option><option value="1927">1927</option><option value="1928">1928</option><option value="1929">1929</option><option value="1930">1930</option><option value="1931">1931</option><option value="1932">1932</option><option value="1933">1933</option><option value="1934">1934</option><option value="1935">1935</option><option value="1936">1936</option><option value="1937">1937</option><option value="1938">1938</option><option value="1939">1939</option><option value="1940">1940</option><option value="1941">1941</option><option value="1942">1942</option><option value="1943">1943</option><option value="1944">1944</option><option value="1945">1945</option><option value="1946">1946</option><option value="1947">1947</option><option value="1948">1948</option><option value="1949">1949</option><option value="1950">1950</option><option value="1951">1951</option><option value="1952">1952</option><option value="1953">1953</option><option value="1954">1954</option><option value="1955">1955</option><option value="1956">1956</option><option value="1957">1957</option><option value="1958">1958</option><option value="1959">1959</option><option value="1960">1960</option><option value="1961">1961</option><option value="1962">1962</option><option value="1963">1963</option><option value="1964">1964</option><option value="1965">1965</option><option value="1966">1966</option><option value="1967">1967</option><option value="1968">1968</option><option value="1969">1969</option><option value="1970">1970</option><option value="1971">1971</option><option value="1972">1972</option><option value="1973">1973</option><option value="1974">1974</option><option value="1975">1975</option><option value="1976">1976</option><option value="1977">1977</option><option value="1978">1978</option><option value="1979">1979</option><option value="1980">1980</option><option value="1981">1981</option><option value="1982">1982</option><option value="1983">1983</option><option value="1984">1984</option><option value="1985">1985</option><option value="1986">1986</option><option value="1987">1987</option><option value="1988">1988</option><option value="1989">1989</option><option value="1990">1990</option><option value="1991">1991</option><option value="1992">1992</option><option value="1993">1993</option><option value="1994">1994</option><option value="1995">1995</option><option value="1996">1996</option><option value="1997">1997</option><option value="1998">1998</option><option value="1999">1999</option><option value="2000">2000</option><option value="2001">2001</option><option value="2002">2002</option><option value="2003">2003</option><option value="2004">2004</option><option value="2005">2005</option><option value="2006">2006</option><option value="2007">2007</option><option value="2008">2008</option><option value="2009">2009</option><option value="2010">2010</option><option value="2011">2011</option><option value="2012">2012</option><option value="2013">2013</option><option value="2014">2014</option><option value="2015">2015</option></select>-<select id="nonmember_birth_month" name="nonmember[birth][month]" class="form-control"><option value="">--</option><option value="1">01</option><option value="2">02</option><option value="3">03</option><option value="4">04</option><option value="5">05</option><option value="6">06</option><option value="7">07</option><option value="8">08</option><option value="9">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>-<select id="nonmember_birth_day" name="nonmember[birth][day]" class="form-control"><option value="">--</option><option value="1">01</option><option value="2">02</option><option value="3">03</option><option value="4">04</option><option value="5">05</option><option value="6">06</option><option value="7">07</option><option value="8">08</option><option value="9">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option></select></div><br />
                            
                        </td>
                    </tr>
                </table>
                                <div class="btn_area">
                    <ul>
                                                <li>
                            <input type="image" class="hover_change_image" src="/user_data/packages/default/img/button/btn_next.jpg" alt="次へ" name="singular" id="singular" />
                        </li>
                                            </ul>
                </div>
            </form>
        </div>
    </div>

            </div>

                                    
                                            </div>

                        
        <footer id="footer">
            <div class="container-fluid inner">
                                <div class="footer_logo_area">
                    <p class="logo"><a href="http://192.168.99.100/">EC-CUBE SHOP</a></p>
                    <p class="copyright"><small>copyright (c) EC-CUBE SHOP all rights reserved.</small></p>
                </div>
            </div>

                                    
        </footer>

    </div>
    <div id="drawer" class="drawer sp">
    </div>

    <div class="overlay"></div>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="/js/jquery-1.11.3.min.js"><\/script>')</script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/slick.min.js"></script>
    <script src="/js/function.js"></script>
    <script src="/js/eccube.js"></script>
        <script type="text/javascript">
        $(function(){
            $('.main_visual').slick({
              dots: true,
              arrows: false,
              autoplay: true,
              speed: 300
            });

            $("#drawer").append($("#drawer_pc").clone(true).children());

            /*
             * for svg icon
             */
            $.ajax({
                type: 'GET',
                url: '/img/common/svg.html',
                dataType: 'html',
                success: function(data){
                    $('body').prepend(data);
                },
                error: function() {
                    console.log('error');
                }
            });
            
        });
    </script>
  </body>
</html>"""
    html = BeautifulSoup(html)
    form = html.find("form")
    input_tags = form.find_all("input")
    for tag in input_tags:
        print ''.join(["driver.findElement(By.id(\"",str(dict(tag.attrs)['id']).strip(),"\").sendKeys(\"\"));"])
    
main()
