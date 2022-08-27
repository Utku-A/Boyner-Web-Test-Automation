package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BaseDriver {

    public WebDriver driver;
    public Logger logger = Logger.getLogger(BaseDriver.class);

    @Before
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("----------------------------------------------------------");
    }

    public void setUrl(String url) {
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url );
    }

    @After
    public void tearDown() {
        logger.info("----------------------------------------------------------");
        if (driver != null) {
            driver.quit();
        }
    }

    public void pause(int milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public RetryRule retryRule = new RetryRule(2);

}
