package PageModel;

import Utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBasketPage extends BasePage {

    By firstProductPriceTextLocator = By.className("m-productPrice__salePrice");
    By firstProductMountSelectLocator = By.id("quantitySelect0-key-0");
    By firstProductRemoveButtonLocator = By.id("removeCartItemBtn0-key-0");
    By products = By.className("m-basket__content");
    By noProductTextLocator = By.className("m-empty__messageTitle");
    By popupMessageTextLocator = By.className("m-notification__message");

    public MyBasketPage(WebDriver driver) {
        super(driver);
    }

    public MyBasketPage checkPrice(String price) {
        assertion(firstProductPriceTextLocator,price);
        return this;
    }

    public MyBasketPage productQuantity(String amount) {
        selectOptions(firstProductMountSelectLocator,amount,amount+" adet");
        pause(1500);
        assertion(popupMessageTextLocator,"Ürün adetiniz güncellenmiştir.");
        return this;
    }

    public MyBasketPage deleteProduct() {
        pause(2000);
        click(firstProductRemoveButtonLocator);
        pause(2000);
        checkVisible(products,false);
        assertion(noProductTextLocator,"SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");
        return this;
    }

}
