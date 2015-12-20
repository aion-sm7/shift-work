package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReserveInputPage {
    private final WebDriver driver;
    private final By reserveYear = By.id("reserve_year");
    private final By reserveMonth = By.id("reserve_month");
    private final By reserveDay = By.id("reserve_day");
    private final By reserveTerm = By.id("reserve_term");
    // from here
    private final By headCount = By.id("headcount");
    private final By breakFastOn = By.id("breakfast_on");
    private final By breakFastOff = By.id("breakfast_off");
    private final By planA = By.id("plan_a");
    private final By planB = By.id("plan_b");
    private final By guestName = By.id("guestname");
    private final By goToNext = By.id("agree_and_goto_next");
    private final By datePick = By.id("datePick");

    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setReserveYear(String value) {
        WebElement element = driver.findElement(reserveYear);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveMonth(String value) {
        WebElement element = driver.findElement(reserveMonth);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveDay(String value) {
        WebElement element = driver.findElement(reserveDay);
        element.clear();
        element.sendKeys(value);
    }

    public void setHeadCount(String value) {
        WebElement element = driver.findElement(headCount);
        // element.clear();
        element.sendKeys(value);
    }

    public void setBreakFast(boolean value) {
        if (value) {
            WebElement element = driver.findElement(breakFastOn);
            if (!element.isSelected()) { element.click(); }
        }else {
            WebElement element = driver.findElement(breakFastOff);
            if (!element.isSelected()) { element.click(); }
        }
    }

    // check box on and off
    public void setPlanA(Boolean value) {
        WebElement element = driver.findElement(planA);
        if (value) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public void setPlanB(Boolean value) {
        WebElement element = driver.findElement(planB);
        if (value) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }

    }

    public void setGuestName(String value) {
        WebElement element = driver.findElement(guestName);
        element.clear();
        element.sendKeys(value);
    }
    
    public void setReserveDate(String year, String month, String day) {
//        setReserveYear(year);
//        setReserveMonth(month);
//        setReserveDay(day);
        WebElement element = driver.findElement(datePick);
        element.clear();
        element.sendKeys(year + "/" + month + "/" + day);
//        element.sendKeys("2016/11/30");
        element.sendKeys(Keys.RETURN);
    }

    public void setReserveTerm(String value) {
        WebElement element = driver.findElement(reserveTerm);
        // element.clear();
        element.sendKeys(value);
    }
    
    public ReserveConfirmPage goToNext() {
        driver.findElement(goToNext).click();
        return new ReserveConfirmPage(driver);
    }
}
