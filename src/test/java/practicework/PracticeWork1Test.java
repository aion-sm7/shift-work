package practicework;

import core.ChromeDriverTest;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PracticeWork1Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    // case 1
    @Test
    public void testReserveWith9Mmebers() throws Exception {
        File html = new File("reserveApp/index.html");
        String url = html.toURI().toString();
        driver.get(url);
        
        // TODO 以下は削除してください
        Thread.sleep(1000);
        // TODO ここまで削除してください

        // case 1
        // 1ページ目入力画面
        driver.findElement(By.id("reserve_year")).clear();
        driver.findElement(By.id("reserve_year")).sendKeys("2015"); // TODO 明日以降直近の土曜日に変更してください
        driver.findElement(By.id("reserve_month")).clear();
        driver.findElement(By.id("reserve_month")).sendKeys("12"); // TODO 明日以降直近の土曜日に変更してください
        driver.findElement(By.id("reserve_day")).clear();
        driver.findElement(By.id("reserve_day")).sendKeys("26"); // TODO 明日以降直近の土曜日に変更してください
        driver.findElement(By.id("reserve_term")).clear();
        driver.findElement(By.id("reserve_term")).sendKeys("1");
        // TODO 残りの処理を記述してください
        driver.findElement(By.id("headcount")).clear();
        driver.findElement(By.id("headcount")).sendKeys("9");
        driver.findElement(By.id("breakfast_on")).click();

        if (!driver.findElement(By.id("plan_a")).isSelected()) {
            driver.findElement(By.id("plan_a")).click();
        }
        if (!driver.findElement(By.id("plan_b")).isSelected()) {
            driver.findElement(By.id("plan_b")).click();
        }
        driver.findElement(By.id("guestname")).clear();
        driver.findElement(By.id("guestname")).sendKeys("a");
        driver.findElement(By.id("goto_next")).click();

        Thread.sleep(3000);

        // 2ページ目入力画面
        assertThat(driver.findElement(By.id("price")).getText(), is("105750"));
        assertThat(driver.findElement(By.id("datefrom")).getText(), is("2015年12月26日")); // TODO 変更してください
        assertThat(driver.findElement(By.id("dateto")).getText(), is("2015年12月27日")); // TODO 変更してください
        assertThat(driver.findElement(By.id("dayscount")).getText(), is("1"));
        assertThat(driver.findElement(By.id("hc")).getText(), is("9"));
        assertThat(driver.findElement(By.id("bf_order")).getText(), is("あり"));
        assertThat(driver.findElement(By.id("plan_a_order")).getText(), is("昼からチェックインプラン"));
        assertThat(driver.findElement(By.id("plan_b_order")).getText(), is("お得な観光プラン"));
        assertThat(driver.findElement(By.id("gname")).getText(), is("a"));
        driver.findElement(By.id("commit")).click();

        // TODO 残りの処理を記述してください
    }

    // case 2
    @Test
    public void testReserveWith1Mmebers() throws Exception {
        File html = new File("reserveApp/index.html");
        String url = html.toURI().toString();
        driver.get(url);

        // TODO 以下は削除してください
        Thread.sleep(100);
        // TODO ここまで削除してください

        // case 1
        // 1ページ目入力画面
        driver.findElement(By.id("reserve_year")).clear();
        driver.findElement(By.id("reserve_year")).sendKeys("2015"); // TODO 明日以降直近の土曜日に変更してください
        driver.findElement(By.id("reserve_month")).clear();
        driver.findElement(By.id("reserve_month")).sendKeys("12"); // TODO 明日以降直近の土曜日に変更してください
        driver.findElement(By.id("reserve_day")).clear();
        driver.findElement(By.id("reserve_day")).sendKeys("27"); // TODO 明日以降直近の土曜日に変更してください
        driver.findElement(By.id("reserve_term")).clear();
        driver.findElement(By.id("reserve_term")).sendKeys("3");
        // TODO 残りの処理を記述してください
        driver.findElement(By.id("headcount")).clear();
        driver.findElement(By.id("headcount")).sendKeys("1");
        driver.findElement(By.id("breakfast_off")).click();

        if (driver.findElement(By.id("plan_a")).isSelected()) {
            driver.findElement(By.id("plan_a")).click();
        }
        if (driver.findElement(By.id("plan_b")).isSelected()) {
            driver.findElement(By.id("plan_b")).click();
        }
        driver.findElement(By.id("guestname")).clear();
        driver.findElement(By.id("guestname")).sendKeys("aaaa");
        // Thread.sleep(10000);
        driver.findElement(By.id("goto_next")).click();

        // 2ページ目入力画面
        assertThat(driver.findElement(By.id("price")).getText(), is("22750"));
        assertThat(driver.findElement(By.id("datefrom")).getText(), is("2015年12月27日")); // TODO 変更してください
        assertThat(driver.findElement(By.id("dateto")).getText(), is("2015年12月30日")); // TODO 変更してください
        assertThat(driver.findElement(By.id("dayscount")).getText(), is("3"));
        assertThat(driver.findElement(By.id("hc")).getText(), is("1"));
        assertThat(driver.findElement(By.id("bf_order")).getText(), is("なし"));
//        assertThat(driver.findElement(By.id("plan_a_order")).getText(), is(""));
//        assertThat(driver.findElement(By.id("plan_b_order")).getText(), is(""));
        assertThat(driver.findElement(By.id("gname")).getText(), is("aaaa"));
//        Thread.sleep(10000);
        driver.findElement(By.id("commit")).click();

        // TODO 残りの処理を記述してください
    }

    // case 3
    @Test
    public void testInitState() throws Exception {
        File html = new File("reserveApp/index.html");
        String url = html.toURI().toString();
        driver.get(url);

        // TODO 以下は削除してください
        Thread.sleep(100);
        // TODO ここまで削除してください

        // case 1
        // 1ページ目入力画面
        assertThat(driver.findElement(By.id("reserve_year")).getAttribute("value"), is("2015"));
        assertThat(driver.findElement(By.id("reserve_month")).getAttribute("value"), is("12"));
        assertThat(driver.findElement(By.id("reserve_day")).getAttribute("value"), is("19"));
        assertThat(driver.findElement(By.id("reserve_term")).getAttribute("value"), is("1"));
        assertThat(driver.findElement(By.id("headcount")).getAttribute("value"), is("1"));
        assertThat(driver.findElement(By.id("breakfast_on")).isEnabled(), is(true));
        assertThat(driver.findElement(By.id("plan_a")).isSelected(), is(false));
        assertThat(driver.findElement(By.id("plan_b")).isSelected(), is(false));
        assertThat(driver.findElement(By.id("guestname")).getAttribute("value"), is(""));
        Thread.sleep(100);
    }


}
