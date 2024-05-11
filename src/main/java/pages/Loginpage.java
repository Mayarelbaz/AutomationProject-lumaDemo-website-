package pages;

import actions.BrowsersUIactions;
import org.testng.Assert;

public class Loginpage {
    BrowsersUIactions uIactions;


    String EmailSelectorID="email";
    String PasswordSelectorID="password";
    String LoginBTNSelector="//button[@class=\"Button\"]";
    String loginSuccessfullyMsgSelector="//div[@class=\"Header-Welcome Header-Welcome_type_Welcome\"]";
    String loginPartialymsg="Welcome,";
    String LoginMSGSelector="//p[@class=\"Notification-Text\"]";

    String InvalidEmailMsgSelector="//p[@class=\"Notification-Text\"]";

    public Loginpage(){
        uIactions= new BrowsersUIactions();

    }

    public  void fillloginform(String Email,String password){

        uIactions.setText(EmailSelectorID ,BrowsersUIactions.Locators.id,Email);
        uIactions.setText(PasswordSelectorID,BrowsersUIactions.Locators.id,password);
        uIactions.clickOnBtn(LoginBTNSelector,BrowsersUIactions.Locators.XPath);

    }
 public  void IsUserLoginSuccessfully(String LoginMsg){
     Assert.assertTrue(uIactions.IsElementDisplayed(LoginMSGSelector, BrowsersUIactions.Locators.XPath));
     String fulltext1 = uIactions.validateExistText(LoginMSGSelector, BrowsersUIactions.Locators.XPath);
     Assert.assertEquals(fulltext1,LoginMsg,"DOESN'T found any equality i found:"+fulltext1);

     Assert.assertTrue(uIactions.IsElementDisplayed(loginSuccessfullyMsgSelector, BrowsersUIactions.Locators.XPath));
     String fulltext = uIactions.validateExistText(loginSuccessfullyMsgSelector, BrowsersUIactions.Locators.XPath);
     Assert.assertTrue(fulltext.contains( loginPartialymsg), "Expected login successfully message doesn't appair");

 }
 public void IsInvalidEmailMsgAppair(String emailErrorMsg){
     Assert.assertTrue(uIactions.IsElementDisplayed(InvalidEmailMsgSelector, BrowsersUIactions.Locators.XPath));
     String fulltext = uIactions.validateExistText(InvalidEmailMsgSelector, BrowsersUIactions.Locators.XPath);
     Assert.assertEquals(fulltext,emailErrorMsg);

 }



}
