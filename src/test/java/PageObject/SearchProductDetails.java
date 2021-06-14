package test.java.PageObject;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.Commons.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class SearchProductDetails {

    public static WebDriver driver;
    public static String productName="";

    public SearchProductDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Click on open login popup's close icon
    public static void clickOnCloseIcon(){
        By closeIcon= By.xpath("//button[@class='_2KpZ6l _2doB4z']");
        WebElement closeElement= CommonMethods.waitForElementToBeClickable(closeIcon,20);
        closeElement.click();
        CommonMethods.printLog("Click on Close Icon");
    }

    //Verify Flipkart Logo
    public static void validateFlipkartLogoIsDisplayed(){
        By flipkartLogo= By.xpath("//img[@title='Flipkart']");
        WebElement logo= CommonMethods.waitForElementVisibility(flipkartLogo, 20);
        Assert.assertTrue(logo.isDisplayed());
        CommonMethods.printLog("Flipkart Logo is Displayed");
    }

    // Enter search string on Search text box
    public static void enterSearchTextOnSearchBox(String searchText){
        By searchTextBox = By.name("q");
        WebElement searchBox= CommonMethods.waitForElementToBeClickable(searchTextBox,20);
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.RETURN);
        CommonMethods.printLog("Enter "+searchText+" Text on Search Box.");

    }

    // Get the list of product and displayed list of product name and price
    public static void getListOfProductNameAndPrice(){
        By productName = By.xpath("//div[@class='_3pLy-c row']/div[1]/div[1]");
        By productPrice = By.xpath("//div[@class='_3pLy-c row']/div[2]/div[1]/div[1]/div[1]");
        CommonMethods.waitForElementToBeClickable(productName,20);
        List<WebElement> listOfProductName= driver.findElements(productName);
        List<WebElement> listOfProductPrice= driver.findElements(productPrice);
        CommonMethods.printLog("===================================== Product Name And Price ===========================================");

        for(int i=0; i<listOfProductName.size()-1; i++){

            CommonMethods.printLog(listOfProductName.get(i).getText()+" : "+listOfProductPrice.get(i).getText());
        }
        CommonMethods.printLog("========================================================================================================");

    }

    // Store first product name and Click on that product from the list
    public static void getFirstProductNameAndClickOnThatProductFromList(){
        By products = By.xpath("//div[@class='_3pLy-c row']/div[1]/div[1]");
        CommonMethods.waitForElementToBeClickable(products,20);
        List<WebElement> listOfProductName= driver.findElements(products);
        productName=listOfProductName.get(0).getText();
        CommonMethods.printLog("Product Name: "+productName);
        listOfProductName.get(0).click();
        CommonMethods.printLog("Click on First product From the list");
    }


    // Switch to new window and Click on Add to cart button from product details page
    public static void clickOnGoToCartButton(){
        CommonMethods.pause(2);
       CommonMethods.switchToNewTab();
        CommonMethods.pause(2);
        By button = By.xpath("//button[contains(., 'ADD TO CART')]");
        WebElement buttonElement= CommonMethods.waitForElementToBeClickable(button,20);
        buttonElement.click();
        CommonMethods.printLog("Click on Add to Cart Button");
    }

    //Verify Current page url
    public static void verifyCurrentPageUrl(String url){
        String currentPageUrl=driver.getCurrentUrl();
        Assert.assertEquals(url, currentPageUrl);
    }

    // Verify My Cart page heading
    public static void validateMyCartPageHeading(){
        By pageHeadingPath = By.xpath("//div[contains(text(), 'My Cart')]");
        WebElement pageHeading= CommonMethods.waitForElementVisibility(pageHeadingPath,20);
        Assert.assertTrue(pageHeading.getText().contains("My Cart"));
        CommonMethods.printLog("My Cart Page heading is displayed");
    }

    // Verify Product name is added in My Cart
    public static void validateProductNameIsAddedOnMyCart(){
        By products = By.xpath("//div[@class='_2nQDXZ']/div/div[1]/a");
        CommonMethods.waitForElementVisibility(products,20);
        List<WebElement> listOfProductName= driver.findElements(products);
        boolean isProduct=false;
        for(WebElement productElement: listOfProductName){
            if(productElement.getText().equalsIgnoreCase(productName)){
                isProduct=true;
            }
        }
        Assert.assertTrue(isProduct);
        CommonMethods.printLog("Product name is added in My cart list");
    }



}
