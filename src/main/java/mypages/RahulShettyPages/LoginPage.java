package mypages.RahulShettyPages;

import mypages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {
WebDriver driver;
   public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='userEmail']")
   private WebElement email;

    @FindBy(xpath ="//input[@id='userPassword']")
    private WebElement password;

    @FindBy(xpath ="//input[@id='login']")
    private WebElement loginButton;

    By Cards =(By.xpath("//div[@class='card-body']//h5//b"));


    public void login(){

        email.sendKeys("tejasjadhav8888@gmail.com");
        password.sendKeys("Practice123");
        loginButton.click();
    }

    public void getAllItems(){

        List<WebElement> elements = getElements(Cards);
        System.out.println(elements.size());
        for(WebElement item:elements){
            System.out.println(item.getText());
        }

    }
}
