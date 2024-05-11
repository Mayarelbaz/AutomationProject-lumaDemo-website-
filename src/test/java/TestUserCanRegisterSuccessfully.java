import Data.ExcelReader;
import actions.BrowerConfigrations;
import org.testng.annotations.*;
import pages.Signupage;
import pages.homepage;

public class TestUserCanRegisterSuccessfully {
    homepage home;
    Signupage signup;
@Parameters("browser")
@BeforeMethod
void setup(@Optional("chrome") String browser) throws Exception {

    BrowerConfigrations.BrowerConfigrations(BrowerConfigrations.Browsers.valueOf(browser.toLowerCase()));
     home =new homepage();
    signup = new Signupage();
}

  /*  @DataProvider(name = "registerData")
    public Object[][] getInvalidPasswords() {
        return new Object[][] {
                {"tester","test","te1stwaaxdfg45rw@gmail.com","B*XdVmnGd5_cp9m","B*XdVmnGd5_cp9m"}
        };
    }*/

//@Test(dataProvider = "registerData")
@Test(dataProvider = "readTestData", dataProviderClass = ExcelReader.class)

public void  UserCanRegisterSuccessfully( String firstName, String lastName,String email, String password,String confirmpassword){
    home.nagivateTOhomepage();
    home.DoubleClickonUserIcon();
    home.clickonCreateAnAccount();
    signup.FillRegisterationForm( firstName, lastName,email, password,confirmpassword);
    //signup.ispasswordMSGappair( passerrorstatus , passErrorMSG);
    signup.CheckSuccessfullyRegister(firstName);



}

@AfterMethod(enabled = false)
void teardown() {
    BrowerConfigrations.closeDriver();
}


}