package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import mypages.AbstractPage;
import mypages.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public AbstractPage page;
    public Properties prop;
    public FileInputStream fis;
    public ExtentSparkReporter reporter;
    public ExtentReports ext;
    String browser;

    public JavascriptExecutor js;


    public WebDriver initialzeWebdriver() throws IOException {

        prop = new Properties();
        String path = "D:\\Git\\OopsConcetsInFramework\\src\\main\\java\\utils.properties";
        fis = new FileInputStream(path);
        prop.load(fis);
        browser = prop.getProperty("browser");
        WebDriverManager.chromedriver().setup();

        if (browser.equals("chrome")) {

            driver = new ChromeDriver();

        } else {

            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        page = new BasePage(driver);

        driver.get(prop.getProperty("URL"));

        return driver;

    }

    public WebDriver initialzeWebdriver(String URL) throws IOException {
        prop = new Properties();
        String path = "D:\\Git\\OopsConcetsInFramework\\src\\main\\java\\utils.properties";
        fis = new FileInputStream(path);
        prop.load(fis);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(prop.getProperty(URL));

        return driver;

    }

    public String getScreenshot(String methodName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File typefile = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "//reports/snaps//" + methodName + ".jpg";
        File fl = new File(path);
        FileUtils.copyFile(typefile, fl);
return path;
    }


    public void scrollWindow(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 350)");


    }

    public ExtentReports initializeExtentReport(String methodName) {

        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//ExtentReports//" + methodName + ".html");

         ext = new ExtentReports();
        ext.attachReporter(reporter);
        return ext;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}

