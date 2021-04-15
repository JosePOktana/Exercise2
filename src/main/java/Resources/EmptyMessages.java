package Resources;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmptyMessages {
    private final WebDriver driver;

    //Find a message when the wish list is empty
    @FindBy(xpath = "//p[contains(. , 'Your wish list is empty.')]")
    WebElement emptyWishListMessage;

    //Find a message when the order history is empty
    @FindBy(xpath = "//p[contains(. , 'You have')]")
    WebElement emptyOrderHistoryMessage;

    //Find the list of options on the right
    @FindBy(className = "list-group-item")
    List<WebElement> ListOptions;

    public EmptyMessages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Return to the main page
    public void returnMainPage() {
        ListOptions.get(0).click();
    }

    //Return a boolean when a message is showed if the wish list is empty
    public boolean WishListEmpty () {
        ListOptions.get(4).click();
        return emptyWishListMessage.isDisplayed();
    }

    //Return a boolean when a message is showed if the order history is empty
    public boolean OrderHistoryEmpty () {
        ListOptions.get(5).click();
        return emptyOrderHistoryMessage.isDisplayed();
    }
}
