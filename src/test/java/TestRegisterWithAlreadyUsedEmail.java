import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Signupage;
import pages.homepage;

public class TestRegisterWithAlreadyUsedEmail {
    homepage home;
    Signupage signup;
    @Parameters("browser")
    @BeforeMethod
    void setup(@Optional("chrome") String browser) throws Exception {

        BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
        home =new homepage();
        signup = new Signupage();
    }


@Test
public  void UserregisteredWithAleadyUsedEmail(){
    home.nagivateTOhomepage();
    home.DoubleClickonUserIcon();
    home.clickonCreateAnAccount();
    signup.FillRegisterationForm( "tester","test","mayaelbaz6@gmail.com","B*XdVmnGd5_cp9m","B*XdVmnGd5_cp9m");

    signup.isemailMSGappair();



}

    @AfterMethod(enabled = false)
    void teardown() {
        BrowerConfigrations.closeDriver();
    }

}
