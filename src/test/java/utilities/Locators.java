package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators {
    private static Logger log = LogManager.getLogger(BrowserUtil.class.getName());
    public static WebElement xpath(String xpath){
        return DriverUtil.getDriver().findElement(By.xpath(xpath));
    }
    public static WebElement id(String id){
        return DriverUtil.getDriver().findElement(By.id(id));
    }
    public static WebElement css(String css){
        return DriverUtil.getDriver().findElement(By.cssSelector(css));
    }
    public static WebElement linkText(String linkText){
        return DriverUtil.getDriver().findElement(By.linkText(linkText));
    }
    public static WebElement name(String name){
        return DriverUtil.getDriver().findElement(By.name(name));
    }
    public static WebElement className(String className){
        return DriverUtil.getDriver().findElement(By.className(className));
    }
    public static WebElement partial(String partial){
        return DriverUtil.getDriver().findElement(By.partialLinkText(partial));
    }



}
