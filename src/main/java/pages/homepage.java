package pages;

import actions.BrowsersUIactions;
import org.testng.Assert;

public class homepage {
    String homepageURL = "https://luma-demo.scandipwa.com/";
    String reachedthewebsitesuccessfullyselector="//div[@href=\"https://readymage.com/\"]";
    String expectedrehomepagetext="Demo store is hosted on readymage.com.";
    String getExpectedcreateANAccountmsg="Create new account";



    String registerationformselector ="myAccount";
    String createANAccountSelector="//button[@class=\"Button Button_likeLink\"]";
    String expectedcreateANAccountSelector="//p[@class=\"MyAccountOverlay-Heading\"]";







BrowsersUIactions uIactions;

public homepage(){
    uIactions= new BrowsersUIactions();

}

public void  nagivateTOhomepage(){
    uIactions.gotohomeurl(homepageURL);
    String fulltext =uIactions.validateExistText(reachedthewebsitesuccessfullyselector,BrowsersUIactions.Locators.XPath);
    Assert.assertEquals(expectedrehomepagetext,fulltext);
    uIactions.clickOnBtn("//div[@class=\"CookiePopup-CTA\"]",BrowsersUIactions.Locators.XPath);




}

public  void clickonCreateAnAccount(){

uIactions.clickOnBtn(createANAccountSelector,BrowsersUIactions.Locators.XPath);
    String fulltext =uIactions.validateExistText(expectedcreateANAccountSelector,BrowsersUIactions.Locators.XPath);
    Assert.assertEquals(getExpectedcreateANAccountmsg,fulltext);

}
public  void DoubleClickonUserIcon(){
    uIactions.DoubleClickOnElement(registerationformselector,BrowsersUIactions.Locators.id);

}


}
