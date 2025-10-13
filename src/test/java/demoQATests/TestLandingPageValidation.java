package demoQATests;

import helpers.Base;
import mypages.DemoQA.CardsWindow;
import mypages.DemoQA.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestLandingPageValidation extends Base {
    public Base bs;
    public WebDriver driver;
    public LandingPage lp;
    public CardsWindow wn;


    @BeforeMethod
    public void launchBrowser() throws IOException {

        bs = new Base();
        driver = bs.initialzeWebdriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void launchLandingPage() throws Exception {
        lp= new LandingPage(driver);
        String actualLandingPage = lp.getPageTtile();
        System.out.println(actualLandingPage);
        Assert.assertEquals(actualLandingPage, "DEMOQA");
        System.out.println(page.getInstance(LandingPage.class).getPageHearder());

    }

    @Test
    public void selectElementCard() throws Exception {

        bs.scrollWindow(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         lp= new LandingPage(driver);
        lp.getAllCards("Element");
      getScreenshot("selectElementCard", driver);

    }

    @Test
    public void alerWindows()  {

        bs.scrollWindow(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         lp= new LandingPage(driver);
        lp.getAllCards("Alerts, Frame & Windows");
         wn= new CardsWindow(driver);
wn.clickBrowswerWindow();

    }
    @Test
    public void wsitchWindow() {

        Set<String> windowHandles = driver.getWindowHandles();

        int numOfHandles = windowHandles.size();

        Iterator<String> itr = windowHandles.iterator();

        Map<String, String> windowhandleIds = new HashMap<>();

        for (int i = 0; i > numOfHandles; i++) {

            windowhandleIds.put("Window"+i , itr.next());

        }
        System.out.println(windowhandleIds);
    }
}