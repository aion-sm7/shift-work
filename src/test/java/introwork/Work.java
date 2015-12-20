package introwork;

import java.io.File;

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


public class Work {
    private WebDriver driver;
    private WebDriver driver_ff;
    private WebDriver driver_ie;

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
        path_ie = "IEDriverServer_x64_2.45.0/IEDriverServer.exe";
        File file_ie = new File(path_ie);
        return file_ie.getAbsolutePath();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath());
        System.setProperty("webdriver.ie.driver", ieDriverPath());

        driver = new ChromeDriver();
        driver_ff = new FirefoxDriver();
        driver_ie = new InternetExplorerDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
        driver_ff.quit();
        driver_ie.quit();
    }

    /**
     * メインとなるテスト処理。
     * JUnitは、「@Test」がついたメソッドをテストメソッドとして実行する。
     */

    @Test
    public void testLoginSuccess() throws Exception {
        // 指定したURLのウェブページに移動
        String url = "http://192.168.99.100/";

        // chrome
        driver.get(url);

        // firefox
        driver_ff.get(url);

        // IE
        driver_ie.get(url);

        // wait time
        Thread.sleep(100);

    }
}
