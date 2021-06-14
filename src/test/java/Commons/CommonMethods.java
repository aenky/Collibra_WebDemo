package test.java.Commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.ArrayList;

public class CommonMethods extends InitBrowser{

    /**
     * Navigate to given URL
     * @param url
     * @author Ankit Mistry
     */
    public static void openUrl(String url){
        driver.get(url);
        printLog("Open '"+url+"'");
    }

    /**
     * Wait till Given Second
     * @param sec
     * @author Ankit Mistry
     */
    public static void pause(int sec) {

        try {
            printLog("Wait for "+sec+" sec.");
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait till Element is clickable
     * @param by
     * @param maxWaitTimeInSecond
     * @return --> WebElement
     * @author Ankit Mistry
     */
    public static WebElement waitForElementToBeClickable(By by, int maxWaitTimeInSecond) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, maxWaitTimeInSecond);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return element;

    }

    /**
     * Wait for element to be visible on the page
     *
     * @return   return WebElement
     * @author Ankit Mistry
     */
    public static WebElement waitForElementVisibility(By by, int maxWaitTimeInSecond) {

        WebElement returnElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, maxWaitTimeInSecond);
            returnElement=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            returnElement=driver.findElement(by);
        }  catch (Exception we) {
            we.printStackTrace();

        }
        return returnElement;
    }

    /**
     * Print to given String
     * @param printString
     * @author Ankit Mistry
     */
    public static void printLog(String printString){
        System.out.println(printString);
        Reporter.log(printString+"</br>");

    }

    /**
     * Switch to new browser tab
     * @author Ankit Mistry
     */
    public static void switchToNewTab(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }

}
