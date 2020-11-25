package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.DriverUtil;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Captcha {

    public static void numberCaptcha(){
        DriverUtil.getDriver().manage().window().maximize();
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        DriverUtil.getDriver().get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
        WebElement element= DriverUtil.getDriver().findElement(By.id("ebcaptchatext"));
        String str=element.getText();
        System.out.println(str);
        //What is 2 + 8

        String val1=str.substring(8,9);
          String val2=str.substring(12,13);
          int i1=Integer.parseInt(val1);
          int i2=Integer.parseInt(val2);
          Integer ans=i1+i2;
        System.out.println(ans);

        WebElement elementInput= DriverUtil.getDriver().findElement(By.id("ebcaptchainput"));
        elementInput.sendKeys(String.valueOf(ans));
        DriverUtil.getDriver().findElement(By.cssSelector("[type='submit']")).click();

    }
    public static void complex(){
        DriverUtil.getDriver().manage().window().maximize();
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        DriverUtil.getDriver().get("http://www.nammregister.org.uk/test.asp");
        String str=JOptionPane.showInputDialog("Enter");
        DriverUtil.getDriver().findElement(By.id("captchacode")).sendKeys(str);
        DriverUtil.getDriver().findElement(By.id("btnTest")).click();

    }
    //@Test
    public void numcaptcha(){
        numberCaptcha();
    }

    @Test
    public void comp() {
        complex();
     }
    }
