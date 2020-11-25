package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.*;

import java.sql.Driver;

public class SingleTest extends Base {

    @Test
    public void test(){


        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void page(){

        DriverUtil.getDriver().get("https://www.google.com");
        System.out.println(DriverUtil.getDriver().getTitle());
    }
    @Test
    public void angry(){

        DriverUtil.getDriver().get("https://www.google.com");
        System.out.println(DriverUtil.getDriver().getTitle());
//        String title=driver.getTitle();
//        Assert.assertEquals(title, "Firefox");
    }
}
