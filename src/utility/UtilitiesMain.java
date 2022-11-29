package utility;

import browserfactory.BaseTest;
import com.beust.ah.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UtilitiesMain extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    //This method get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will send to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText, actualText);
    }

    //*********************************************Alert methods******************************************************//

    //This method will switch to the alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //This method will accept the alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //**********************************************Select class******************************************************//

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int a) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }

    public void selectByGetAllOptionFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions
        ) {
            //System.out.println(element.getText());//to print all countries
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }

    //***********************************************Mouse Hover******************************************************//

    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }

    public void clickOnMouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).click().build().perform();
    }

    public void clearQuantityFromBox(By by,String text){
        Actions action = new Actions(driver);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        

    }
}




