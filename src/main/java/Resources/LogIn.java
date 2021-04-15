package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.util.resources.ms.CalendarData_ms_MY;

public class LogIn {
    //Initializing the driver
    private final WebDriver driver;
    private final String url = "https://demo.opencart.com/";

    //Find the My Account icon
    @FindBy(xpath = "//span[contains(. , 'My Account')]")
    WebElement myAccount;

    //Find the login option
    @FindBy(xpath = "//a[contains(. , 'Login')]")
    WebElement Login;

    //Find the email field
    @FindBy(id = "input-email")
    WebElement EmailAddress;

    //Find the password field
    @FindBy(id = "input-password")
    WebElement Password;

    //Find the logout option
    @FindBy(xpath = "//a[contains(. , 'Logout')]")
    WebElement LogOut;

    //Find the login button
    @FindBy(xpath = "//input[(@value = 'Login')]")
    WebElement btnLogin;

    //Find the message on the top of the main page
    @FindBy(xpath = "//a[contains(. , 'Your Store')]")
    WebElement YourStoreMessage;

    //Item on the left: Edit your account
    @FindBy(xpath = "//a[contains(. , 'Edit your account')]")
    WebElement EditYourAccountItem;

    //Item on the left: Change your password
    @FindBy(xpath = "//a[contains(. , 'Change')]")
    WebElement ChangePasswordItem;

    //Item on the left: Modify Address
    @FindBy(xpath = "//a[contains(. , 'Modify your address')]")
    WebElement ModifyAddresItem;

    //Item on the left: Modify wish list
    @FindBy(xpath = "//a[contains(. , 'Modify your wish')]")
    WebElement ModifyWishlitItem;

    public LogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Login with credentials
    public void logInDates(String Email, String pass) {
        myAccount.click();
        Login.click();
        EmailAddress.sendKeys(Email);
        Password.sendKeys(pass);
        btnLogin.click();
    }

    //Return the URL of the web
    public String getUrl() {
        return url;
    }

    //Logout from the shop
    public void Out() {
        myAccount.click();
        LogOut.click();
    }

    //Verify if the 4 items of the left were displayed
    public boolean LoginSucess() {
        boolean result = (YourStoreMessage.isDisplayed())&&(EditYourAccountItem.isDisplayed())&&(ChangePasswordItem.isDisplayed())&&(ModifyAddresItem.isDisplayed())&&(ModifyWishlitItem.isDisplayed());
        return result;
    }
}
