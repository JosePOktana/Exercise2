import DataProvide.RegisterDataProvide;
import Resources.EditAccount;
import Resources.EmptyMessages;
import Resources.LogIn;
import Resources.ToggleButtom;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise2 extends Base {

    //Initializing objects
    private LogIn login;
    private EmptyMessages emptyMessages;
    private EditAccount editAccount;
    private ToggleButtom toggleButtom;


    //Open shopcart, Log In and verify 4 items
    @BeforeTest
    public void initialize() {
        //Memory for the variables
        driver  = InitializeDriver();
        login = new LogIn(driver);
        emptyMessages = new EmptyMessages(driver);
        editAccount = new EditAccount(driver);
        toggleButtom = new ToggleButtom(driver);

        //Go to the main page and verify the 4 items on the left
        driver.get(login.getUrl());
        login.logInDates("jose123@hello123.com", "Shiroyama123");
        Assert.assertTrue(login.LoginSucess());
    }

    //Verify the messages when are not items on the cart
    @Test
    public void EmptyMessages() {
        Assert.assertTrue(emptyMessages.WishListEmpty());
        emptyMessages.returnMainPage();
        Assert.assertTrue(emptyMessages.OrderHistoryEmpty());
        emptyMessages.returnMainPage();
    }

    //Edit the information of the account
    @Test (dataProvider = "Edit Account", dataProviderClass = RegisterDataProvide.class)
    public void EditAccount(String FirstName, String LastName, String Email, String Telephone) {
        editAccount.EditInformation(FirstName,LastName,Email,Telephone);
        Assert.assertTrue(editAccount.SucessMessageDisplayed());
        editAccount.returnMainPage();
    }

    //Verify is the email does noy have ".com"
    @Test (dataProvider = "Invalid Email without com", dataProviderClass = RegisterDataProvide.class)
    public void InvalidEmailCom(String email) {
        editAccount.InvalidEmailCom(email);
        Assert.assertTrue(editAccount.ErrorEmailcom());
        editAccount.returnMainPage();
    }

    //Verify is the email does noy have "@"
    @Test (dataProvider = "Invalid Email without arrob", dataProviderClass = RegisterDataProvide.class)
    public void InvalidEmailArro(String FirstName, String LastName, String Email, String Telephone) {
        editAccount.EditInformation(FirstName,LastName,Email,Telephone);
        Assert.assertFalse(editAccount.ErrorEmailArro());
        editAccount.returnMainPage();
    }

    //Verify if is possible change the state of newsletter
    @Test
    public void ToggleButtomUpdate() {
        Assert.assertTrue(toggleButtom.Newletter());
        toggleButtom.returnMainPage();
    }

    //Finish the test
    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}