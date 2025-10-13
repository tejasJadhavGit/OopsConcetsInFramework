package demoQATests;

import helpers.Base;
import mypages.DemoQA.CardsWindow;
import mypages.DemoQA.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LandingPageNew extends Base {

    public Base bs;
    public WebDriver driver;
    public LandingPage lp;
    public CardsWindow wn;

    public void launchBrowser() throws IOException {

        bs = new Base();
        driver = bs.initialzeWebdriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectElementCard() throws Exception {
        launchBrowser();
        bs.scrollWindow(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lp = new LandingPage(driver);
        lp.getAllCards("Element");

    }

    @Test
    public void getmobileNames() throws IOException {
        driver = initialzeWebdriver("https://www.amazon.in/");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung Mobiles");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250 )");
        // WebElement mobileNames = driver.findElement(By.xpath("//span[contains(text(),'" + MobilePrice + "')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/span"));
        WebElement mobileNames = driver.findElement(By.xpath("//span[contains(text(),'12,499')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/span"));
        String text = mobileNames.getText();
        System.out.println("Expected Name of the mobile is = " + text);
        mobileNames.click();

    }

    @Test

    public void selectCardNew() throws IOException {
        driver = initialzeWebdriver();
        scrollWindow(driver);
        lp = new LandingPage(driver);
        System.out.println( lp.getPageHearder());

    }

    @Test
    public void loginAnd() throws IOException {

        driver = initialzeWebdriver("https://rahulshettyacademy.com/client/");
        driver.manage().window().maximize();
        System.out.println("User is on Login Page");

        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("tejasjadhav8888@gmail.com");

        driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Practice123");

        driver.findElement(By.xpath("//input[@id='login']")).click();
//		Base bs = new Base();
//		By buText = By.xpath("//h3[text()='Automation']");
//
//		bs.waitForElementPresent(buText);
//		String text =driver.findElement(By.xpath("//h3[text()='Automation']")).getText();
//		System.out.println(text);

        List<WebElement> cards = driver.findElements(By.xpath("//div[@class='card-body']//h5//b"));

        int crrdsize = cards.size();
        System.out.println(crrdsize);
        java.util.Iterator<WebElement> itr = cards.iterator();

        itr.next();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        for (int i = 0; i < cards.size(); i++) {
            String Category = cards.get(i).getText();

            System.out.println(Category);
        }
    }


}
