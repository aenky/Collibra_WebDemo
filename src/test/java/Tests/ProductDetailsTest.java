package test.java.Tests;

import test.java.Commons.CommonMethods;
import test.java.Commons.InitBrowser;
import org.testng.annotations.Test;
import test.java.PageObject.SearchProductDetails;

public class ProductDetailsTest  extends InitBrowser {
    CommonMethods com=new CommonMethods();

    @Test
    public void getProductNameAndPriceList()
    {
        com.openUrl("https://www.flipkart.com/");
        SearchProductDetails.clickOnCloseIcon();
        SearchProductDetails.validateFlipkartLogoIsDisplayed();
        SearchProductDetails.enterSearchTextOnSearchBox("ac 1.5 ton");
        SearchProductDetails.getListOfProductNameAndPrice();


    }

    @Test
    public void addProductToCart()
    {
        com.openUrl("https://www.flipkart.com/");
        SearchProductDetails.clickOnCloseIcon();
        SearchProductDetails.validateFlipkartLogoIsDisplayed();
        SearchProductDetails.enterSearchTextOnSearchBox("mobiles");
        SearchProductDetails.getListOfProductNameAndPrice();
        SearchProductDetails.getFirstProductNameAndClickOnThatProductFromList();
        SearchProductDetails.clickOnGoToCartButton();
        SearchProductDetails.validateMyCartPageHeading();
        SearchProductDetails.verifyCurrentPageUrl("https://www.flipkart.com/viewcart?otracker=PP_GoToCart");
        SearchProductDetails.validateProductNameIsAddedOnMyCart();



    }
}
