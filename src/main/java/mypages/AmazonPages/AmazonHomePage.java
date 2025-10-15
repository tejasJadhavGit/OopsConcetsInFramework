package mypages.AmazonPages;

import mypages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonHomePage extends BasePage {

     String  MobileNamesByPrice;
    By   prices;
    By mobileNames;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    By searchTextBox = By.xpath("//input[@id='twotabsearchtextbox']");

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;

//    "//span[@class='a-price-whole' and text()='"+mobilePrice+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/span")
//
//    By mobileName = By.xpath("//span[contains(text(),'"+mobilePrice+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/span");
//



    public void searchDesiredItem(String searchItem) {
        getElement(searchTextBox).sendKeys(searchItem);
        submit.click();

    }

    public WebElement getMobileByPrice(String mobilePrice){

      try{
          mobileNames = By.xpath("//span[@class='a-price-whole' and text()='"+mobilePrice+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/span");
      }
catch (Exception e){
          e.printStackTrace();
}
        By mobileName = By.xpath("//span[contains(text(),'"+mobilePrice+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::h2/span");
      return  getElement(mobileNames);

    }

    public List getMobileByNames(String mobileNmePrice){
           prices = By.xpath("//span[contains(text(),'" + mobileNmePrice + "')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']//span[@class='a-price-whole']");
        return getElements(prices);
    }
}
