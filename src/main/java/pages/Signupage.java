package pages;

import actions.BrowsersUIactions;
import org.testng.Assert;

public class Signupage {
    BrowsersUIactions uIactions;


     String FnameselectorID="firstname";
     String LnameselectorID="lastname";
     String subsecribedlocatorID="is_subscribed";
    String emailselectorID="email";
    String passwordselectorID="password";
    String confirmpasswordselectorID="confirm_password";

     String SignUpBTN="//*[@id=\"root\"]/div/section/header/nav/div[2]/div[1]/div/div/div/form/div/button";

/*........................................................................*/


     String scessregisterelementselector ="//div[@class=\"Header-Welcome Header-Welcome_type_Welcome\"]";
     String subtext= "Welcome, ";


     String EmailMsgDivselector ="//p[@class=\"Notification-Text\"]";
     String emailErrorMsg="A customer with the same email address";

    String PasswordErrorMsgstateselector="//*[@id=\"root\"]/div/section/header/nav/div[2]/div[1]/div/div/div/form/fieldset[2]/div[2]/div[1]/div[2]/div";


     String EmailWrongEmailFormatSelector="//*[@id=\"root\"]/div/section/header/nav/div[2]/div[1]/div/div/div/form/fieldset[2]/div[1]/div[2]/div";

     String DismatchedPasswordSelector="//*[@id=\"root\"]/div/section[1]/header/nav/div[2]/div[1]/div/div/div/form/fieldset[2]/div[2]/div[2]/div[2]/div";
    public Signupage() {
        this.uIactions =  new BrowsersUIactions();
    }

    public  void  FillRegisterationForm(String Fname, String Lname,String email,String password,String ConfirmPassword)
    {


        uIactions.setText(FnameselectorID,BrowsersUIactions.Locators.id,Fname);
        uIactions.setText(LnameselectorID,BrowsersUIactions.Locators.id,Lname);
        uIactions.MoveToelmentAndClickOnIt(subsecribedlocatorID,BrowsersUIactions.Locators.id);


        uIactions.setText(emailselectorID ,BrowsersUIactions.Locators.id,email);
        uIactions.setText(passwordselectorID,BrowsersUIactions.Locators.id,password);
        uIactions.setText(confirmpasswordselectorID,BrowsersUIactions.Locators.id,ConfirmPassword);


        uIactions.clickOnBtn(SignUpBTN,BrowsersUIactions.Locators.XPath);





    }
    public  void  CheckSuccessfullyRegister(String firstname)
    {
       String fulltext= uIactions.validateExistText(scessregisterelementselector,BrowsersUIactions.Locators.XPath);
       Assert.assertEquals(fulltext,(subtext+firstname+"!"));



    }

public void isemailMSGappair(){
    Assert.assertTrue(uIactions.IsElementDisplayed(EmailMsgDivselector, BrowsersUIactions.Locators.XPath));
    String fulltext = uIactions.validateExistText(EmailMsgDivselector, BrowsersUIactions.Locators.XPath);
    Assert.assertTrue(fulltext.contains(emailErrorMsg), "Expected error message not found in email message div");
}



    public void ispasswordMSGappair( String passErrorMSG) {
        Assert.assertTrue(uIactions.IsElementDisplayed(PasswordErrorMsgstateselector, BrowsersUIactions.Locators.XPath), "Password state message is not displayed.");
        String fulltext = uIactions.validateExistText(PasswordErrorMsgstateselector, BrowsersUIactions.Locators.XPath);
        Assert.assertEquals(fulltext,passErrorMSG);
    }

    public  void  isemailWrongformatmsgappair(String emailErrorMSG){

        Assert.assertTrue(uIactions.IsElementDisplayed(EmailWrongEmailFormatSelector, BrowsersUIactions.Locators.XPath), "Password state message is not displayed.");
        String fulltext = uIactions.validateExistText(EmailWrongEmailFormatSelector, BrowsersUIactions.Locators.XPath);
        Assert.assertEquals(fulltext,emailErrorMSG);
    }

    public  void  isDismatchedPasswordmsgAppair(String DismatchedpassErrorMSG){
        Assert.assertTrue(uIactions.IsElementDisplayed(DismatchedPasswordSelector, BrowsersUIactions.Locators.XPath), "Password state message is not displayed.");
        String fulltext = uIactions.validateExistText(DismatchedPasswordSelector, BrowsersUIactions.Locators.XPath);
        Assert.assertEquals(fulltext,DismatchedpassErrorMSG);


    }
}