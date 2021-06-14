package test.java.Commons;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import test.java.PageObject.SearchProductDetails;


public class InitBrowser {

   public static WebDriver driver;
   public SearchProductDetails searchProductDetails ;
    @BeforeMethod
    public void initBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        CommonMethods.printLog("Open the Browser!!!");
        searchProductDetails = new SearchProductDetails(driver);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
        CommonMethods.printLog("Close the Browser!!!");
    }




}
