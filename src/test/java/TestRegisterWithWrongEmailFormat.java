import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Signupage;
import pages.homepage;

public class TestRegisterWithWrongEmailFormat {

    homepage home;
    Signupage signup;
    @Parameters("browser")
    @BeforeMethod
    void setup(@Optional("chrome") String browser) throws Exception {

        BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
        home =new homepage();
        signup = new Signupage();
    }

    @DataProvider(name = "WrongEmailFormatData")
    public Object[][] getInvalidPasswords() {
        return new Object[][] {

                {"tester", "test","testwsdf","A12346677q","A12346677q","Incorrect email format!"},




        };
    }

    @Test(dataProvider = "WrongEmailFormatData")
public  void  userRegisterWithWrongEmailFormat(String firstName, String lastName,String email, String password,String confirmpassword,String emailErrorMSG ){

        home.nagivateTOhomepage();
        home.DoubleClickonUserIcon();

        home.clickonCreateAnAccount();
        signup.FillRegisterationForm( firstName,lastName,email, password,confirmpassword);
        signup.isemailWrongformatmsgappair(emailErrorMSG);

    }

    @AfterMethod(enabled = false)
    void teardown() {
        BrowerConfigrations.closeDriver();
    }
}
