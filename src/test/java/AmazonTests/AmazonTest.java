package AmazonTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import helpers.Base;
import mypages.AmazonPages.AmazonHomePage;
import mypages.DemoQA.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AmazonTest extends Base {

    public static WebDriver driver;
    public LandingPage lp;
    public AmazonHomePage hm;
    public ExtentReports test;
    public ExtentTest mobileDetailsByPrice;

    @BeforeMethod
    public void setupAmazon() throws IOException {

        driver = initialzeWebdriver("AmazonURL");
        hm = new AmazonHomePage(driver);

    }

    @Test(priority = 2)
    public void mobileDetailsByPrice() throws IOException {

        hm.searchDesiredItem("Samsung Mobiles");
        WebElement mobile = hm.getMobileByPrice("13,999");
        System.out.println("Expected Details of the mobile is = " + mobile.getText());
        mobile.click();
        getScreenshot("mobileDetailsByPrice", driver);

    }

  @Test(priority = 1)
    public void mobileDetailsByName() throws IOException {

        hm.searchDesiredItem("Samsung Mobiles");
        List<WebElement> mobileByNames = hm.getMobileByNames("Samsung Galaxy M36 5G");
        for (WebElement mobilePrice : mobileByNames) {

            System.out.println("Mobile prices :" + mobilePrice.getText());
        }
    }




}
