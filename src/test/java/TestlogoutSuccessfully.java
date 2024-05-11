import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.CustomerAccountpage;
import pages.Loginpage;
import pages.homepage;

public class TestlogoutSuccessfully {
    homepage home;
    Loginpage login;
    CustomerAccountpage cst;
    @Parameters("browser")
    @BeforeMethod
    void setup(@Optional("chrome") String browser) throws Exception {

        BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
        home =new homepage();
        login = new Loginpage();
        cst= new CustomerAccountpage();
    }

    @DataProvider(name = "LoginData")
    public Object[][] GetValidLoginData() {
        return new Object[][] {
                {"te1stwaadfg45rw@gmail.com","B*XdVmnGd5_cp9m","You are successfully logged in!","You are successfully logged out!"}
        };
    }


    @Test(dataProvider = "LoginData")
    public  void  UserCanLogoutsuccessfully(String email ,String password,String LoginMsg,String LogoutMsg)  {
        home.nagivateTOhomepage();
        home.DoubleClickonUserIcon();
        login.fillloginform(email, password);
        login.IsUserLoginSuccessfully(LoginMsg);



        cst.logout();
        cst.ChecklogoutSuccessfully(LogoutMsg);
    }

    @AfterMethod(enabled = false)
    void teardown() {
        BrowerConfigrations.closeDriver();
    }
}
