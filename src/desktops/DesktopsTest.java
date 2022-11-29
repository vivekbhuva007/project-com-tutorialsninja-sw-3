package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.UtilitiesMain;

import java.util.List;

public class DesktopsTest extends UtilitiesMain {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);


    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        //  1.1 / 1.2 Mouse hover on Desktops Tab.and click Show All Desktops
        mouseHoverOnElement(By.linkText("Desktops"));
        clickOnElement(By.linkText("Show All Desktops"));

        //	1.3 Select Sort By position "Name: Z to A"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
       // clickOnElement(By.xpath("//option[contains(text(),'Name (Z - A)')]"));

        //	1.4 Verify the Product will arrange in Descending order.
        //Not sure how to do this
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        Actions actions = new Actions(driver);
        //  2.1 Click on Desktops
        Thread.sleep(2000);
        mouseHoverOnElement(By.linkText("Desktops"));
        Thread.sleep(2000);
        //	2.2 Click on Show All Desktops
        clickOnElement(By.linkText("Show All Desktops"));

        //	2.3 Select Sort By position "Name: A to Z"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        clickOnElement(By.xpath("//option[contains(text(),'Name (A - Z)')]"));

        //	2.4 Select product “HP LP3065”
        Thread.sleep(2000);
        clickOnElement(By.linkText("HP LP3065"));

        //  2.5 Verify the text “HP LP3065”
        assertVerifyText(By.xpath("//h1[contains(text(),'HP LP3065')]"),"HP LP3065");


        //  2.6 Select date 2022-11-30
        String year = "2022";
        String month = "November";
        String date = "30";

        //Opens the date picker
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-calendar']"));
        while (true) {

            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            //Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));

            }

        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dates :allDates){
            if(dates.getText().equalsIgnoreCase(date)){
                dates.click();
                break;
            }
        }

        //	2.7 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//input[@id='input-quantity']"));

        Thread.sleep(2000);
        actions.sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.DELETE).perform();

        Thread.sleep(2000);
        actions.sendKeys("2").perform();

        //  2.8 Click on Add to cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //  2.9 Verify the message

        //  2.10 Click on the link to shopping cart from success message
        Thread.sleep(3000);
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //  2.11 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        assertVerifyText(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/h1[1]"),"Shopping Cart  (2.00kg)");
        //  2.12 Verify the Product name "HP LP3065"
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
        //  2.13 Verify the Delivery Date
        assertVerifyText(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"),"Delivery Date: 2022-11-30");
        //  2.14 Verify the Model
        assertVerifyText(By.xpath("//td[contains(text(),'Product 21')]"),"Product 21");
        //  2.15 Verify the Total
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),"£149.45");

    }




    @After
    public void teardown() {
        closeBrowser();
    }




    }


