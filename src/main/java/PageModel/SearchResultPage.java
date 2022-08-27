package PageModel;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {

    int selectRandomItem = (int) (Math.random()*(47)+2);
    By randomProductImgLocators = By.cssSelector(":nth-child("+selectRandomItem+")  .m-productCard > .m-productCard__photo");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage selectRandomProduct() {
        click(randomProductImgLocators);
        return this;
    }


}
