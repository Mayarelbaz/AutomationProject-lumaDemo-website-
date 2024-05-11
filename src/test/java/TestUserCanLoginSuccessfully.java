import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Loginpage;
import pages.homepage;

public class TestUserCanLoginSuccessfully {

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
    public Object[][] GetValidLoginData() {
        return new Object[][] {
                {"te1stwaadfg45rw@gmail.com","B*XdVmnGd5_cp9m","You are successfully logged in!"}
        };
    }


    @Test(dataProvider = "LoginData")
    public  void  UserCanLoginSuccessfully(String email ,String password,String LoginMsg){
        home.nagivateTOhomepage();
         home.DoubleClickonUserIcon();
      login.fillloginform(email,password);
      login.IsUserLoginSuccessfully(LoginMsg);



    }


    @AfterMethod(enabled = false)
    void teardown() {
        BrowerConfigrations.closeDriver();
    }













}
