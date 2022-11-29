package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.UtilitiesMain;

public class MyAccountTest extends UtilitiesMain {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    //1.1 selectMenu method
    public void selectMyAccountOptions(String option) throws InterruptedException {

        if (option == "Register") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
            //Get title
            String title = driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ", "Register Account", title);

        } else if (option == "Login") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            Thread.sleep(2000);
            clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
            Thread.sleep(2000);
            assertVerifyText(By.xpath("//h2[contains(text(),'Returning Customer')]"),"Returning Customer");


        } else {
            System.out.println("Please enter valid name or check entry");
        }
    }

    //1.2 / 1.3 Click on  and verify navigation
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        selectMyAccountOptions("Register");
        assertVerifyText(By.xpath("//h1[contains(text(),'Register Account')]"),"Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPAgeSuccessfully() throws InterruptedException {
        selectMyAccountOptions("Login");
        assertVerifyText(By.xpath("By.xpath(\"//h1[contains(text(),'Account Logout')]"),"Account Logout");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException{

        //  3.1 / 3.2 Navigate to register page
        selectMyAccountOptions("Register");

        //  3.3 Enter first name
        sendTextToElement(By.name("firstname"),"Vivendra");
        Thread.sleep(500);
        //  3.4 Enter last name
        sendTextToElement(By.name("lastname"),"Bhai");
        Thread.sleep(500);
        //  3.5 Enter email
        sendTextToElement(By.id("input-email"),"primetesting001@gmail.com");
        Thread.sleep(500);
        //  3.6 Enter telephone
        sendTextToElement(By.name("telephone"),"07753448779");
        Thread.sleep(500);
        //  3.7 Enter password
        sendTextToElement(By.id("input-password"),"test123");
        Thread.sleep(500);
        //  3.8 Enter password confirm
        sendTextToElement(By.id("input-confirm"),"test123");
        Thread.sleep(500);
        //  3.9 Subscribe radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]"));
        //  3.10 Click on privacy policy
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //  3.11 Click on continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //  3.12 Verify the message Your account has been created
        assertVerifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");
        //  3.13 Click on continue
        clickOnElement(By.linkText("Continue"));
        //  3.14 Click on my account link
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]"));
        //  3.15 Click on logout
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //  3.16 Verify the logout text
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //  3.17 Press Continue
        clickOnElement(By.linkText("Continue"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{

        //  4.1 / 4.2 Navigate to login page
        selectMyAccountOptions("Login");
        //  4.3 Email Address
        sendTextToElement(By.id("input-email"),"primetesting124@gmail.com");
        Thread.sleep(500);
        //  4.5 Password
        sendTextToElement(By.id("input-password"),"test123");
        Thread.sleep(500);
        //  4.6 Click on Login Button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        Thread.sleep(500);
        //  4.7 Verify my account text
        assertVerifyText(By.xpath("//h2[contains(text(),'My Account')]"),"My Account");
        Thread.sleep(500);
        //  4.8  Click on my account link
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]"));
        //  4.9 Click on logout
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //  4.10 Verify the logout text
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //  4.11 Press Continue
        clickOnElement(By.linkText("Continue"));

    }

    @After
    public void teardown() {
        closeBrowser();
    }

}
