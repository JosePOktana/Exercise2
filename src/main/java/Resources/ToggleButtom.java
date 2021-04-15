package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ToggleButtom {
    private final WebDriver driver;

    //Find a list of all item on the right
    @FindBy(className = "list-group-item")
    List<WebElement> ListOptions;

    //Find a list of the 2 option (Yes or No)
    @FindBy(name = "newsletter")
    List<WebElement> button;

    //Find the continue buttom
    @FindBy(xpath = "//input[(@value = 'Continue')]")
    WebElement btnContinue;

    //Find the message when the newsletter is updated
    @FindBy(xpath = "//div[contains(.,' Success: Your newsletter subscription has been successfully updated!')]")
    WebElement newsletterMessage;

    public ToggleButtom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Return to the main page
    public void returnMainPage() {
        ListOptions.get(0).click();
    }

    //Return a boolean when change the state of the newsletter and a message is displayed
    public boolean Newletter() {
        ListOptions.get(11).click();
        button.get(1).click();
        btnContinue.click();
        return newsletterMessage.isDisplayed();
    }
}
