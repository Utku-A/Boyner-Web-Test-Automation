package PageModel;

import Utilities.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {

    By searchBoxInputAreaLocator = By.cssSelector("[role=\"combobox\"] > input");
    By myBasketIconButtonLocator = By.className("icon-cart");

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage typeSearchArea(String search) {
        typeAreaClear(searchBoxInputAreaLocator);
        type(searchBoxInputAreaLocator,search);
        String val = find(searchBoxInputAreaLocator).getAttribute("value");
        Assert.assertEquals(val,search);
        pause(2000);
        return this;
    }

    public IndexPage search() {
        type(searchBoxInputAreaLocator,Keys.ENTER);
        pause(2500);
        return this;
    }

    public IndexPage myBasket() {
        click(myBasketIconButtonLocator);
        return this;
    }

}
