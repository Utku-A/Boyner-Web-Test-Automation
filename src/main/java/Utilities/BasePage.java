package Utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends BaseDriver{

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator);
    }

    public void click(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(locator));
        find(locator).click();
    }

    public void type(By locator, String types) {
        find(locator).sendKeys(types);
    }

    public void type(By locator, Keys keys) {
        find(locator).sendKeys(keys);
    }

    public void type(By locator, String types, Keys keys) {
        find(locator).sendKeys(types,keys);
    }

    public void typeAreaClear(By locator) {
        find(locator).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public void selectOptions(By locator, String values, String assertion) {
        Select select = new Select(find(locator));
        select.selectByValue(values);
        String option = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option,assertion);
    }

    public void checkVisible(By locator,boolean visible) {
        boolean visibleElement;
        if (driver.findElements(locator).size() > 0) {
            visibleElement = true;
        }else {
            visibleElement = false;
        }
        Assert.assertEquals(visibleElement,visible);
    }

    public void assertion(By locator,String text) {
        String locatorText = find(locator).getText();
        Assert.assertEquals(locatorText,text);
    }

    public void assertion(Object a,Object b) {
        Assert.assertEquals(a,b);
    }

}
