package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url and tittle
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Nurdan
     * note: usually we do not do validation in method, this is for practising purposes
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedUrl = expectedUrl.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

//This is not a good methocd


    }

    //THIS IS GOOD METHOD

    /**
     * switched to new window by the exact tittle
     * returns to original window if windows with given tittle not found
     *
     * @param driver
     * @param targetTitle
     * @author Nurdan
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {             //I NEED TITLE FOR GOOD METHOD BEC URL CAN BE DIFFICULT, IT CAN BE WRITTEN WRONG OR MISSING

        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin); //this method switch me to the target Tittle
    }

    /**
     *
     * @param driver
     * @param expectedTitle
     * returns void, assertion is implemented
     * @author Nurdan
     */


    public static void validateTitle (WebDriver driver, String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle), "actual does NOT match expected");

        /**
         * Click any link from loop practice
         * @param nameOfPage
         * @author Nurdan
         */
    }
        public static void loopLinkClick (String nameOfPage) {
            WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
            /**
             * method that will hover over
             * @param element
             * @author Nurdan
             */

            public static void hoverOverAnyElement(WebElement element) {
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(element).perform();
            }

                /**
                 * method that will Scroll to the given element
                 * @param element
                 * @author Nurdan
                 */

                public static void scrollToElement (WebElement element) {
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);


                }


                /**
                 * method which scroll to element and click js
                 * @param element
                 * @author Nurdan
                 */
                public static void scrollAndClick (WebElement element){
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoVie(true);",element);
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;",element);
                }


                /**
                 * method will double click any given element
                 * @param element
                 * @author Nurdan
                 */

                public static void doubleClick (WebElement element){
                   new Actions(Driver.getDriver()).doubleClick().perform();
                }

    /**
     * waits for providing element to be visible
     * @param element
     * @param timeToWaitSec
     * @return element
     * @author Nurdan
     *
     */

    public static WebElement waitForVisibility(WebElement element,int timeToWaitSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * wait for providing element to be visible on the page
     * @param element
     * @param timeToWait
     * @return
     * @author Nurdan
     */

    public static void waitForInvisibility (WebElement element, int timeToWait) {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWait));
     wait.until(ExpectedConditions.invisibilityOf(element));

}


    /**
     * method that will wait until the element becomes clickable
     * @param element
     * @param timeOut
     * @return
     * @author Nurdan
     */

    public static WebElement waitForClickable(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));


    }

    /**
     * method performs a pause
     * @param seconds
     * @author Nurdan
     *
     */
    public static void justWait (int seconds)  {
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();


    }

}

    public static void selectCheckBox (WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        }else {
            if (element.isSelected()){
                element.click();
            }
        }

    }


    public static void dragDrop (WebElement elementDrag, WebElement elementDrop){
    new Actions(Driver.getDriver()).dragAndDrop(elementDrag, elementDrop).perform();
    }

}







































