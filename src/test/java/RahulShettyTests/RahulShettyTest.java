package RahulShettyTests;

import helpers.Base;
import mypages.RahulShettyPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RahulShettyTest extends Base {

 public WebDriver driver;
 public  LoginPage lp;

 @BeforeMethod
 public void setupRahulShetty() throws IOException {
     driver = initialzeWebdriver("RahulShetty");
     driver.manage().window().maximize();
     System.out.println("User is on Login Page");
     lp= new LoginPage(driver) ;

 }
    @Test
    public void selectItem() {
         lp.login();
         lp.getAllItems();

    }

}
