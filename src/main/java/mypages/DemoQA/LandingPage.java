package mypages.DemoQA;

import mypages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this.getClass());
    }
    private final By allCards = By.xpath("//div[@class='category-cards']/div");

    private final By pageHearder = By.xpath("//*[@id=\"app\"]/header/a/img");

    public void getAllCards(String CardName) {

        List<WebElement>  CardNames = getElements(allCards);
        for (WebElement cardname:CardNames) {

            if(cardname.getText().contains(CardName)){

                cardname.click();
                break;
            }

        }
    }

    public String getPageHearder() {

        String LandingPageHeader = getElement(pageHearder).getText();

        return LandingPageHeader;
    }



}
