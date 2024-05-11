import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Signupage;
import pages.homepage;

public class TestRegisterWithMismatchedpassword {
    homepage home;
    Signupage signup;
    @Parameters("browser")
    @BeforeMethod
    void setup(@Optional("chrome") String browser) throws Exception {

        BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
        home =new homepage();
        signup = new Signupage();
    }

    @DataProvider(name = "DismatchedPasswordData")
    public Object[][] getInvalidPasswords() {
        return new Object[][] {

                {"tester", "test","testwsdf","A12346677q","A123","Passwords do not match!"}




        };}
@Test(dataProvider = "DismatchedPasswordData")
public  void  RegisterWithMismatchedpassword(String firstName, String lastName,String email, String password,String confirmpassword ,String DismatchedpassErrorMSG){

    home.nagivateTOhomepage();
    home.DoubleClickonUserIcon();

    home.clickonCreateAnAccount();
    signup.FillRegisterationForm( firstName,lastName,email, password,confirmpassword);
    signup.isDismatchedPasswordmsgAppair(DismatchedpassErrorMSG);
}

    @AfterMethod(enabled = false)
    void teardown() {
        BrowerConfigrations.closeDriver();
    }
}
