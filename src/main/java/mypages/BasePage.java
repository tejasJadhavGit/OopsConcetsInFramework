package mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends AbstractPage {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTtile() {

       return driver.getTitle();
    }

    public String getPageHaeader(By locator) {

      return getElement(locator).getText();

    }

    public WebElement getElement(By locator) {

        WebElement element=null;
        try
        {
     element = driver.findElement(locator);
        }
        catch (Exception e){

            e.printStackTrace();
        }

        return element;

    }

    public List getElements(By locator) {


        return driver.findElements(locator);

}

    public void waitForElementPresent(By locator ) {
        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e){

            e.printStackTrace();
        }

    }


}
