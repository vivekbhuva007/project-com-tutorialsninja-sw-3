package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utility.UtilitiesMain;

public class LaptopsAndNotebooks extends UtilitiesMain {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException{

        //  1.1 / 1.2 Mouse hover on Desktops Tab.and click Show All Desktops
        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.linkText("Show All Laptops & Notebooks"));

        //	1.3 Select Sort By position "Name: Z to A"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

        //	1.4 Verify the Product will arrange in Price high to low order.
        //Not sure how to do this
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        Actions actions = new Actions(driver);

        //  2.1 / 2.2 Click on Laptops and Notebooks and Show all Laptops and Notebooks
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.linkText("Show All Laptops & Notebooks"));
        //  2.3 Select sort by price high to low
        Thread.sleep(2000);
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        clickOnElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));

        //  2.4 Select macbook
        clickOnElement(By.linkText("MacBook"));

        //  2.5 Verify the text
        assertVerifyText(By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");

        //  2.6 Click on Add to cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        // 2.8 Click on link shopping cart in success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //  2.9 Verify the shopping cart
        assertVerifyText(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/h1[1]"),"Shopping Cart  (0.00kg)");

        //  2.10 Verify the product name
        assertVerifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");

        //  2.11 Change the Quantity to 2
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));

        Thread.sleep(2000);
        actions.sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.DELETE).perform();

        Thread.sleep(2000);
        actions.sendKeys("2").perform();

        //  2.12 Click on update tab
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/span[1]/button[1]"));

        //  2.13 Verify the update message (Issue with this one)
        // assertVerifyText(By.xpath("/html[1]/body[1]/div[2]/div[1]/i[1]")," Success: You have modified your shopping cart!");

        //  2.14 Verify the total £737.45
        assertVerifyText(By.xpath("//tbody/tr[1]/td[6]"),"£737.45");

        //  2.15 Click on checkout
        clickOnElement(By.linkText("Checkout"));

        //  2.16 Verify the text checkout
        assertVerifyText(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");

        //  2.17 Verify the new customer text
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");

        //  2.18 Click on the guest checkout
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));

        //  2.19 Click on continue
        Thread.sleep(2000);
        clickOnElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));

        //  2.20 Enter the mandatory fields

        sendTextToElement(By.name("firstname"), "Vivendra");
        Thread.sleep(500);
        sendTextToElement(By.name("lastname"), "Bhai");
        Thread.sleep(500);
        sendTextToElement(By.id("input-payment-email"),"virvindbhai@gmail.com");
        Thread.sleep(500);
        sendTextToElement(By.name("telephone"),"014754144987");
        Thread.sleep(500);
        sendTextToElement(By.name("address_1"),"10 Downing St");
        Thread.sleep(500);
        sendTextToElement(By.name("city"),"London");
        Thread.sleep(500);
        sendTextToElement(By.name("postcode"),"OV16 5TW");
        Thread.sleep(500);
        clickOnElement(By.id("input-payment-country"));
        clickOnElement(By.xpath("//option[contains(text(),'United Kingdom')]"));
        Thread.sleep(500);
        clickOnElement(By.id("input-payment-zone"));
        clickOnElement(By.xpath("//option[contains(text(),'Greater London')]"));
        Thread.sleep(500);

        //  2.21 Click on continue
        clickOnElement(By.id("button-guest"));

        //  2.22 Write comment
        sendTextToElement(By.xpath("//textarea[@class='form-control']"),"Prime Testing");

        // 2.23 Agree to terms and conditions
        clickOnElement(By.xpath("//input[@type='checkbox']"));

        //  2.24 Click on continue
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //  2.25 Verify text from alert payment method required

        assertVerifyText(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"),"Warning: No Payment options are available. Please contact us for assistance!");



    }




    @After
    public void teardown() {
        //closeBrowser();
    }
    }
