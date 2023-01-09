package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.*;
import utilities.reports.ExtentLogger;
import utilities.reports.ExtentManager;

import java.util.List;
import java.util.Locale;

public class Zimyo extends Base {


    @Test
    public void zimyo(){

        BrowserUtil.url("https://www.zimyo.com/");

        ExtentLogger.pass("Vishal Rocks");
        /*DriverUtil.getDriver().manage().deleteAllCookies();
        DriverUtil.getDriver().findElement(By.linkText("Accept")).click();

        test.log(Status.PASS,"Pass");
        WebElement web= DriverUtil.getDriver().findElement(By.xpath("//*[@class='flex-col hide-for-medium flex-right']/ul/li[1]"));
        Actions action=new Actions(DriverUtil.getDriver());
        action.moveToElement(web).perform();
        WebElement hr=web.findElement(By.xpath("ul/li"));
        hr.click();

        DriverUtil.getDriver().findElement(By.xpath("//*[@class='row row-full-width align-bottom']/div[2]/div/a[3]")).click();
//        try{
//        DriverUtil.getDriver().findElement(By.linkText("Accept")).click();}
//        catch(Exception e){
//
//        }
        Locators.linkText("360 Degree Review").click();
       List<WebElement>  li=DriverUtil.getDriver().findElements(By.xpath("//*[@class='row align-equal']/div/div/h5"));
       for(WebElement names:li){
           System.out.println(names.getText());
       }*/


    }
}
