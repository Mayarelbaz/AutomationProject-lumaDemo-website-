import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Loginpage;
import pages.homepage;

public class TestLoginWithinvalidData {
    homepage home;
    Loginpage login;
    @Parameters("browser")
    @BeforeMethod
    void setup(@Optional("chrome") String browser) throws Exception {

        BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
        home =new homepage();
        login = new Loginpage();
    }

    @DataProvider(name = "LoginData")
    public Object[][] GetInValidLoginData() {
        return new Object[][] {
                {"test@gmail.com","B*XdVmnGd5_cp9m","The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."},//With unregisterd email
                {"te1stwaaxdfg45rw@gmail.com","123456","The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."},// with registered email and wrong passwor
                 {"test@gmail.com","123456","The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."}// with wrong email and pssword

        };
    }


    @Test(dataProvider = "LoginData")
    public  void LoginWithInvalidData(String Email,String Password,String errormsg){
        home.nagivateTOhomepage();
        home.DoubleClickonUserIcon();
        login.fillloginform(Email,Password);
        login.IsInvalidEmailMsgAppair(errormsg);


    }

}
