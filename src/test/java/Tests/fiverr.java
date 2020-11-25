package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.DriverUtil;

public class fiverr extends Base {

    @BeforeTest
    public void before(){
        DriverUtil.getDriver().get("https://www.fiverr.com/");
    }
    @Test
    public void sample(){
        DriverUtil.getDriver().findElement(By.linkText("Sign In")).click();
    }
}
