package DataProvide;

import org.testng.annotations.DataProvider;

public class RegisterDataProvide {

    //Values to verify the edition of account, editing one field by test
    @DataProvider(name = "Edit Account")
    public Object[][] EditAccount() {
        return new Object[][]{
                {"Luis",null, null,null},
                {null,"Miguel", null,null},
                {null,null, "jose123@hello123.com",null},
                {null,null, null,"987654"}
        };
    }

    //Value to test when email does not have ".com"
    @DataProvider(name = "Invalid Email without com")
    public Object[][] InvalidEmailCom() {
        return new Object[][]{
                {"jose123@hello123"}
        };
    }

    //Value to test when email does not have "@"
    @DataProvider(name = "Invalid Email without arrob")
    public Object[][] InvalidEmailArro() {
        return new Object[][]{
                {null,null, "jose123hello123.com",null},
        };
    }
}
