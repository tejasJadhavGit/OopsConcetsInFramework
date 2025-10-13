package mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);

    }

    public abstract String getPageTtile();

    public abstract String getPageHaeader(By locator);

    public abstract WebElement getElement(By locator);

    public abstract void waitForElementPresent(By locator);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) throws Exception {

        return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
    }
}