package pages;

import actions.BrowsersUIactions;
import org.testng.Assert;

public class CustomerAccountpage {
    BrowsersUIactions uIactions;
    String LogoutMSGSelector="//p[@class=\"Notification-Text\"][text()=\"You are successfully logged out!\"]";
    String UserIconselector ="myAccount";
    public CustomerAccountpage() {
        uIactions= new BrowsersUIactions();

    }
    String LogoutSelector="//button[@class=\"MyAccountTabListItem-Button\"][text()=\"Logout\"]";



public  void logout()  {

    uIactions.clickOnBtn(UserIconselector,BrowsersUIactions.Locators.id);
    uIactions.clickOnBtn(LogoutSelector,BrowsersUIactions.Locators.XPath);



}

public void ChecklogoutSuccessfully(String LogoutMsg){
    Assert.assertTrue(uIactions.IsElementDisplayed(LogoutMSGSelector, BrowsersUIactions.Locators.XPath));
    String fulltext = uIactions.validateExistText(LogoutMSGSelector, BrowsersUIactions.Locators.XPath);
    Assert.assertEquals(fulltext,LogoutMsg,"DOESN'T found any equality i found:"+fulltext);


}
}