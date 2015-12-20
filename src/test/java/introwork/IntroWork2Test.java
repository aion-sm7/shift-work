package introwork;

import java.io.File;

import org.junit.Test;

import core.ChromeDriverTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 入門課題その2:「クリックしてみよう」
 */
public class IntroWork2Test extends ChromeDriverTest {
    @Test
    public void testClickOKButton() throws Exception {
        File html = new File("introwork/introWork2.html");
        String url = html.toURI().toString();
        driver.get(url);

        // TODO 以下を削除して、代わりにOKボタンをクリックする処理を記述してください
        WebElement button = driver.findElement(By.id("ok_button"));
        button.click();
        // TODO ここまで削除してください
    }
}
