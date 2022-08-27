package Tests;

import PageModel.IndexPage;
import PageModel.MyBasketPage;
import PageModel.ProductDetailPage;
import PageModel.SearchResultPage;
import Utilities.BaseDriver;
import Utilities.Retry;
import Utilities.TestData;
import org.junit.Test;

public class ShoppingSteps extends BaseDriver {

    IndexPage indexPage;
    TestData testData;
    SearchResultPage searchResultPage;
    ProductDetailPage productDetailPage;
    MyBasketPage myBasketPage;

    @Test()
    @Retry()
    public void TS002() {
        indexPage = new IndexPage(driver);
        searchResultPage = new SearchResultPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        myBasketPage = new MyBasketPage(driver);
        testData = new TestData();
        String price;

        setUrl("https://www.beymen.com/");

        indexPage
                .typeSearchArea(testData.read("SearchData",0,0))
                .typeSearchArea(testData.read("SearchData",1,0))
                .search();
        searchResultPage
                .selectRandomProduct();
        productDetailPage
                .getProductData();
        price = productDetailPage.getPrice();
        productDetailPage
                .selectSize()
                .addBasketButton()
                .myBasketPopUpButton();
        myBasketPage
                .checkPrice(price)
                .productQuantity("2")
                .deleteProduct();

        pause(5000);

    }

}
