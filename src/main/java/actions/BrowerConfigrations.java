package actions;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowerConfigrations {
    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();



   public  static void  BrowerConfigrations(Browsers browser){
           switch(browser)
           {
               case chrome:
                   drivers.set(new ChromeDriver());
                   break;
               case firefox:
                   drivers.set(new FirefoxDriver());
                   break;
               default:
                   throw new IllegalStateException("Unexpected value: " + browser);
           }

   }

   public  static  void maximizeWindow(){

       drivers.get().manage().window().maximize();


   }
    public  static  void minimizeWindow(){

        drivers.get().manage().window().minimize();


    }
   public  static void   refreshPage(){
       drivers.get().navigate().refresh();

   }

   public  static  void  navigateBack(){drivers.get().navigate().back();}

    public  static void  navigateForward(){drivers.get().navigate().forward();}

    public static void closeDriver(){
        drivers.get().quit();
    }


    public enum Browsers{
        chrome,
        firefox
    }
}
