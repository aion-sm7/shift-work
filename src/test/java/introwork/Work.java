package introwork;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Work {
    private WebDriver driver;
    private DesiredCapabilities capability_chrome = DesiredCapabilities.chrome();
    private DesiredCapabilities capability_firefox = DesiredCapabilities.firefox();

    private String chromeDriverPath() {
        String path;
        if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX) {
            path = "chromedriver/mac/chromedriver"; // Mac環境の場合
        } else {
            path = "chromedriver/win/chromedriver.exe"; // Windows環境の場合
        }
        File file = new File(path);
        return file.getAbsolutePath();
    }

    private String ieDriverPath() {
        String path_ie;
        path_ie = "IEDriverServer_Win32_2.48.0/IEDriverServer.exe";
        File file_ie = new File(path_ie);
        return file_ie.getAbsolutePath();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath());
        System.setProperty("webdriver.ie.driver", ieDriverPath());

        // system propety かんきょうへんすうからうけとる
        String browser = System.getProperty("browser");

        switch(browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "remote-chrome":
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capability_chrome);
                }catch (java.net.MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "remote-firefox":
                try {
                    driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capability_firefox);
                }catch (java.net.MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                driver = new FirefoxDriver();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * メインとなるテスト処理。
     * JUnitは、「@Test」がついたメソッドをテストメソッドとして実行する。
     */

    @Test
    public void testLoginSuccess() throws Exception {
        // 指定したURLのウェブページに移動
        String url = "http://192.168.99.100/";
        String url_goods = "http://192.168.99.100/products/detail/10002";

        driver.get(url);
        driver.get(url_goods);
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.className("hover_change_image")).click();
        driver.findElement(By.className("hover_change_image")).click();
        driver.get("http://192.168.99.100/shopping/nonmember");

        driver.findElement(By.id("nonmember_name_name01")).sendKeys("松本");
        driver.findElement(By.id("nonmember_name_name02")).sendKeys("智也");
        driver.findElement(By.id("nonmember_kana_kana01")).sendKeys("まつもと");
        driver.findElement(By.id("nonmember_kana_kana02")).sendKeys("ともや");
        driver.findElement(By.id("nonmember_company_name")).sendKeys("会社名");
        driver.findElement(By.id("zip01")).sendKeys("000");
        driver.findElement(By.id("zip02")).sendKeys("0000");
        WebElement selectBox0 = (driver.findElement(By.id("pref")));
        Select select0 = new Select(selectBox0);
        select0.selectByValue("36");
        driver.findElement(By.id("addr01")).sendKeys("都道府県11111");
        driver.findElement(By.id("addr02")).sendKeys("町11111");
        driver.findElement(By.id("nonmember_tel_tel01")).sendKeys("000");
        driver.findElement(By.id("nonmember_tel_tel02")).sendKeys("0000");
        driver.findElement(By.id("nonmember_tel_tel03")).sendKeys("0000");
        driver.findElement(By.id("nonmember_fax_fax01")).sendKeys("00");
        driver.findElement(By.id("nonmember_fax_fax02")).sendKeys("0000");
        driver.findElement(By.id("nonmember_fax_fax03")).sendKeys("0000");
        driver.findElement(By.id("nonmember_email")).sendKeys("matsumoto@example.com");
        driver.findElement(By.id("nonmember_sex_1")).click();
        WebElement selectBox = (driver.findElement(By.id("nonmember_job")));
        Select select = new Select(selectBox);
        select.selectByValue("1");
        WebElement selectBox1 = (driver.findElement(By.id("nonmember_birth_year")));
        Select select1 = new Select(selectBox1);
        select1.selectByValue("1993");
        WebElement selectBox2 = (driver.findElement(By.id("nonmember_birth_month")));
        Select select2 = new Select(selectBox2);
        select2.selectByValue("1");
        WebElement selectBox3 = (driver.findElement(By.id("nonmember_birth_day")));
        Select select3 = new Select(selectBox3);
        select3.selectByValue("7");
        // driver.findElement(By.id("nonmember_sex_2")).sendKeys("");
        driver.findElement(By.id("singular")).click();

        // page changed
        // Thread.sleep(1000);
        driver.findElement(By.id("next-top")).click();

        // next page
        assertThat(driver.findElement(By.className("title")).getText(), is("ご購入完了"));
    }
}
