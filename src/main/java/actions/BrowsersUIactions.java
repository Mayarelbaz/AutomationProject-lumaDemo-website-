package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class BrowsersUIactions {
    public WebDriver driver;

    public BrowsersUIactions(){
       this.driver=BrowerConfigrations.drivers.get();//retrieves the WebDriver instance stored in the ThreadLocal variable


    }

    public  void  gotohomeurl(String url){

        driver.get(url);
        BrowerConfigrations.maximizeWindow();




    }

    public  void GoToRegisterationPage(String elementselector, Locators elementmethod,String EXpelementselector, Locators EXPelementmethod)
    {
        By element= returnElementLocatorBy(elementselector,elementmethod);
        if(waitUntil(ExpectedConditions.elementToBeClickable(element))){
            clickOnBtn(elementselector,elementmethod,EXpelementselector,EXPelementmethod);

        }


    }


    //wait and validate
    public boolean waitUntil( ExpectedCondition<WebElement> s){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(s);
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    public By returnElementLocatorBy(String selector, Locators l){
        switch (l){
            case XPath:
                return new By.ByXPath(selector);

            case id:
                return new By.ById(selector);


            case CSS:
                return new By.ByCssSelector(selector);


            default:
                Assert.fail("Wrong condition");

                return  null;
        }
    }
    public void clickOnBtn(String elementselector, Locators elementlocator, String expectedElementselector, Locators EXPelementLocator) {
        try {
            By element = returnElementLocatorBy(elementselector, elementlocator);
            if (waitUntil(ExpectedConditions.elementToBeClickable(element))) {
                driver.findElement(element).click();
            }
            if (EXPelementLocator != null && expectedElementselector != null) {
                By expectedElement = returnElementLocatorBy(expectedElementselector, EXPelementLocator);
                waitUntil(ExpectedConditions.presenceOfElementLocated(expectedElement));
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Element with selector '" + elementselector + "' and locator '" + elementlocator + "' not found.");
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Timed out waiting for element with selector '" + elementselector + "' and locator '" + elementlocator + "' to be clickable.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void clickOnBtn(String elementselector ,Locators elementlocator) {


        clickOnBtn(elementselector,elementlocator, null,null); // Call the other method with null for expectedElement
    }

    public  void setImplicitWait( int timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
    }

    public void MoveToelment(String selector, Locators l){
        By element = returnElementLocatorBy(selector, l);
        Actions actions = new Actions(driver);

        // Move the mouse to the element
        actions.moveToElement(driver.findElement(element)).perform();

    }
    // Hover over the element
    public void MoveToelmentAndClickOnIt(String selector, Locators l){
        By element = returnElementLocatorBy(selector, l);
    Actions actions = new Actions(driver);

    // Move the mouse to the element
    actions.moveToElement(driver.findElement(element)).click().build().perform();

}
    public String validateExistText(String selector, Locators l) {
        String fullText = null;
        try {
            By element = returnElementLocatorBy(selector, l);
            if (waitUntil(ExpectedConditions.presenceOfElementLocated(element))) {
               fullText = driver.findElement(element).getText();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Element with selector '" + selector + "' and locator '" + l + "' not found.");
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("Timed out waiting for element with selector '" + selector + "' and locator '" + l + "' to be present.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        return fullText;
    }


    public void setText(String selector,Locators l, String text){
    try{
        By b= returnElementLocatorBy(selector,l);
        if (waitUntil(ExpectedConditions.presenceOfElementLocated(b))) {
            driver.findElement(b).sendKeys(text);
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
    public  boolean IsElementDisplayed(String selecotor,Locators l)
    {
        try {
            By b = returnElementLocatorBy(selecotor, l);
            if (waitUntil(ExpectedConditions.visibilityOfElementLocated(b))) {
                if (driver.findElement(b).isDisplayed())
                    return true;
                else
                    return false;
            }
            return false;
        } catch (Exception e) {

            e.printStackTrace();// use a logger to log the exception
            return false;
        }}
    public  boolean IsElementenabled(String selecotor,Locators l)
    {
        try {
            By b = returnElementLocatorBy(selecotor, l);
            if (waitUntil(ExpectedConditions.visibilityOfElementLocated(b))) {
                if (driver.findElement(b).isEnabled())
                    return true;
                else
                    return false;
            }
            return false;
        } catch (Exception e) {

            e.printStackTrace();// use a logger to log the exception
            return false;
        }
    }

    //check if the radiobutton is selected or not
    public  boolean IsElementSelected(String selecotor,Locators l)
    {
        try {
            By b = returnElementLocatorBy(selecotor, l);
            if (waitUntil(ExpectedConditions.presenceOfElementLocated(b))) {
                if (driver.findElement(b).isSelected())
                    return true;
                else
                    return false;
            }
            return false;
        } catch (Exception e) {

            e.printStackTrace();// use a logger to log the exception
            return false;
        }
    }
    public boolean selectAnOption(String selector, Locators l, Methods m, String value) {
        try {
            By element = returnElementLocatorBy(selector, l);
            if (waitUntil(ExpectedConditions.visibilityOfElementLocated(element))) {
                Select DropDownElement = new Select(driver.findElement(element));
                switch (m) {
                    case ByIndex:
                        DropDownElement.selectByIndex(Integer.parseInt(value));
                        return true;
                    case ByVisibleText:
                        DropDownElement.selectByVisibleText(value);
                        return true;
                    case ByValue:
                        DropDownElement.selectByValue(value);
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + m);
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void DoubleClickOnElement(String selector, Locators l) {
        try {
            By element = returnElementLocatorBy(selector, l);
            Actions action = new Actions(driver);
            action.doubleClick(driver.findElement(element)).perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to perform double click on element: " + e.getMessage());
        }
    }

    public void RightClickOnElement(String selector, Locators l) {
        try {
            By element = returnElementLocatorBy(selector, l);
            Actions action = new Actions(driver);
            action.contextClick(driver.findElement(element)).perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to perform right-click on element: " + e.getMessage());
        }
    }

    public void DragAndDrop(String sourceSelector, Locators sourceLocator, String destinationSelector, Locators destinationLocator) {
        try {
            By source = returnElementLocatorBy(sourceSelector, sourceLocator);
            By destination = returnElementLocatorBy(destinationSelector, destinationLocator);
            Actions action = new Actions(driver);
            action.dragAndDrop(driver.findElement(source), driver.findElement(destination)).perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to perform drag and drop: " + e.getMessage());
        }
    }

    public void releaseAwebElement(String selector, Locators l) {
        try {
            By element = returnElementLocatorBy(selector, l);
            Actions action = new Actions(driver);
            action.release(driver.findElement(element)).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to release web element: " + e.getMessage());
        }
    }





    public  enum  Methods{
        ByIndex,
        ByVisibleText,
        ByValue

    }
    public enum Locators {
        XPath,
        CSS,
        id
    }

}
