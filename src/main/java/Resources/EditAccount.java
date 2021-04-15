package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditAccount {
    private final WebDriver driver;

    //Select the list of all options on the right
    @FindBy(className = "list-group-item")
    List<WebElement> ListOptions;

    //Find the First Name field
    @FindBy(id = "input-firstname")
    WebElement inputFirstName;

    //Find the Last name field
    @FindBy(id = "input-lastname")
    WebElement inputLastName;

    //Find the email field
    @FindBy(id = "input-email")
    WebElement inputEmail;

    //Find the telephone field
    @FindBy(id = "input-telephone")
    WebElement inputTelephone;

    //Find the continue button
    @FindBy(xpath = "//input[(@value = 'Continue')]")
    WebElement btnContinue;

    //Find the message the the changes were applied correctly
    @FindBy(xpath = "//div[contains(. , 'Success: Your account')]")
    WebElement SucessMessage;

    //Find the message when the email does not have ".com"
    @FindBy(xpath = "//div[contains(.,'E-Mail Address does not appear to be valid!')]")
    WebElement EmailErrorCom;

    public EditAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Receive the information to edit the field
    public void EditInformation (String FirstName, String LastName, String Email, String Telephone) {
        ListOptions.get(1).click();

        if (FirstName != null) {
            inputFirstName.clear();
            inputFirstName.sendKeys(FirstName);
        }
        if (LastName != null) {
            inputLastName.clear();
            inputLastName.sendKeys(LastName);
        }
        if (Email != null) {
            inputEmail.clear();
            inputEmail.sendKeys(Email);
        }
        if (Telephone != null) {
            inputTelephone.clear();
            inputTelephone.sendKeys(Telephone);
        }
        btnContinue.click();
    }

    //Receive an email without ".com" and click on continue
    public void InvalidEmailCom(String email) {
        ListOptions.get(1).click();
        if (email != null) {
            inputEmail.clear();
            inputEmail.sendKeys(email);
        }
        btnContinue.click();
    }

    //Return to the main page
    public void returnMainPage() {
        ListOptions.get(0).click();
    }

    //Return a boolean when the message that the edition was success
    public boolean SucessMessageDisplayed() {
        return SucessMessage.isDisplayed();
    }

    //Return a boolean if the error message from incorrect email is displayed
    public boolean ErrorEmailcom () {
        return EmailErrorCom.isDisplayed();
    }

    //Return a boolean when find a pop-up from the incorrect email (withouh "@") it's written
    public boolean ErrorEmailArro() {
        WebElement inputElement = driver.findElement(By.name("email"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputElement);
        return isRequired;
    }
}
