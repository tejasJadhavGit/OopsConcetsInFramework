package mypages.DemoQA;

import mypages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardsWindow extends BasePage {

public CardsWindow(WebDriver driver){
    super(driver);


}
 private   By brwoaweWindow = By.xpath("//span[text()='Browser Windows']");


public void clickBrowswerWindow(){
   getElement(brwoaweWindow).click();
}
}
