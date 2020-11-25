package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.DriverUtil;
import utilities.Locators;

public class Prac extends Base {

   @Test
    public void test(){
       driver.get("https://www.makemytrip.com/");
       Locators.id("fromCity").click();
       WebElement from=Locators.css("[placeholder='From']");
               from.sendKeys("Delhi");
               from.sendKeys(Keys.DOWN);
               from.sendKeys(Keys.ENTER);



   }



}
