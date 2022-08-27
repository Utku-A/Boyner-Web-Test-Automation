package PageModel;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By productTitleTextLocator = By.className("o-productDetail__description");
    By productPriceTextLocator = By.className("m-price__new");
    By selectSizeButtonLocator = By.cssSelector(".m-variation__item:not(.-disabled)");
    By addBasketButtonLocator = By.id("addBasket");
    By myBasketPopupButtonLocator = By.className("m-notification__button");
    By popupMessageTextLocator = By.className("m-notification__message");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage getProductData() {
        String title = find(productTitleTextLocator).getText();
        String price = find(productPriceTextLocator).getText();
        logger.info("Seçilen Ürün = "+title);
        logger.info("Seçilen Ürün Fiyatı = "+price);
        return this;
    }

    public String getPrice() {
        return find(productPriceTextLocator).getText();
    }

    public ProductDetailPage selectSize() {
        click(selectSizeButtonLocator);
        return this;
    }

    public ProductDetailPage addBasketButton() {
        click(addBasketButtonLocator);
        pause(1500);
        assertion(popupMessageTextLocator,"Ürün sepetinize eklenmiştir.");
        return this;
    }

    public ProductDetailPage myBasketPopUpButton() {
        click(myBasketPopupButtonLocator);
        return this;
    }

}
