package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveConfirmPage {
    private final WebDriver driver;
    private final By price = By.id("price");
    private final By dateFrom = By.id("datefrom");
    private final By dateTo = By.id("dateto");
    private final By daysCount = By.id("dayscount");
    private final By headCount = By.id("hc");
    private final By breakfastOrder = By.id("bf_order");
    private final By plan = By.id("plan");
    private final By planaOrder = By.id("plan_a_order");
    private final By planbOrder = By.id("plan_b_order");
    private final By guestName = By.id("gname");
    private final By goToNext1 = By.id("commit");
        
    public ReserveConfirmPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPrice() { return driver.findElement(price).getText(); }
    
    public String getDateFrom() {
        return driver.findElement(dateFrom).getText();
    }

    public String getDateTo() {
        return driver.findElement(dateTo).getText();
    }
    
    public String getDaysCount() {
        return driver.findElement(daysCount).getText();
    }

    public String getHeadCount() { return driver.findElement(headCount).getText(); }

    public String getBreakfastOrder() { return driver.findElement(breakfastOrder).getText(); }

    public String getPlanaOrder() {
        if (driver.findElements(planaOrder).size() == 0) {
            return "";
        }else {
            return driver.findElement(planaOrder).getText();
        }
    }

    public String getPlanbOrder() {
        if (driver.findElements(planbOrder).size() == 0) {
            return "";
        }else {
            return driver.findElement(planbOrder).getText();
        }
    }

    public String getGuestName() { return driver.findElement(guestName).getText(); }

    public ReserveCommitPage goToNext1() {
        driver.findElement(goToNext1).click();
        return new ReserveCommitPage(driver);
    }

    public class ReserveCommitPage {
        private final WebDriver driver;
        public ReserveCommitPage(WebDriver driver) { this.driver = driver; }

        public String getFinish() { return driver.findElement(By.cssSelector("h1")).getText(); }
    }
}
