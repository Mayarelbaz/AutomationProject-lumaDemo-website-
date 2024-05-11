import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Signupage;
import pages.homepage;

public class TestRegisterWithWrongPasswordFormat {
    homepage home;
    Signupage signup;
    @Parameters("browser")
    @BeforeMethod
    void setup(@Optional("chrome") String browser) throws Exception {

        BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
        home =new homepage();
        signup = new Signupage();
    }
    @DataProvider(name = "invalidPasswords")
    public Object[][] getInvalidPasswords() {
        return new Object[][] {

                {"tester", "test","testwsdfg2qw111rw@gmail.com","","","This field is required!"},
                {"tester", "test","testwsdfg2qw111rw@gmail.com", "123","123" ,"Minimum 8 characters!"},
                {"tester", "test","testwsdfg2qw111rw@gmail.com", "A12345655","A12345655" ,"Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."}


        };
    }

    @Test(dataProvider = "invalidPasswords")
    public  void  UserRegisteredWithWeakPasswordFormat( String firstName, String lastName,String email, String password,String confirmpassword ,String passErrorMSG){
        home.nagivateTOhomepage();
        home.DoubleClickonUserIcon();
        home.clickonCreateAnAccount();
        signup.FillRegisterationForm( firstName,  lastName,email, password,confirmpassword);
        signup.ispasswordMSGappair(  passErrorMSG);


    }

    @AfterMethod()
    void teardown() {
        BrowerConfigrations.closeDriver();
    }

}
