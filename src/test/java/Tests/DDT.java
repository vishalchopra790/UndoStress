package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.DriverUtil;
import utilities.ExcelUtils;
import utilities.Locators;

import java.io.IOException;
import java.sql.Driver;
import java.time.LocalDate;
import java.util.Arrays;

public class DDT extends Base {

    @Test(dataProvider = "dataItems")
    public void dataDriven(String user,String pwd,String res){
        driver.get("https://admin-demo.nopcommerce.com/login");

        WebElement txtEmail=driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(user);


        WebElement txtPassword=driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(pwd);

        driver.findElement(By.xpath("//input[@value='Log in']")).click(); //Login  button

        String exp_title="Dashboard / nopCommerce administration";

        String act_title=driver.getTitle();
        System.out.println(act_title);
        if(res.equals("Valid")){
            if(exp_title.equals(act_title)){
                Locators.linkText("Logout").click();
                Assert.assertTrue(true);
            }else{
                Assert.assertFalse(false);
            }

        }
        else if (res.equals("Invalid")){
            if(exp_title.equals(act_title)){
                Locators.linkText("Logout").click();
                Assert.assertFalse(false);
            }
            else{

                Assert.assertTrue(true);

            }
        }

    }
    @DataProvider()
    public Object[] dataItems() throws IOException {
//        String empData[][]={{"admin@yourstore.com","admin","Valid"},
//                {"admin@yourstore.com","adm","Invalid"},
//                {"adm@yourstore.com","admin","Invalid"},
//                {"adm@yourstore.com","adm","Invalid"}};
        String path="src\\test\\resources\\Data.xlsx";
        ExcelUtils excel=new ExcelUtils(path);
       int rowcount= excel.getRowCount("Sheet3");
       int colcout=excel.getCellCount("Sheet3",1);
       String[][] empData =new String[rowcount][colcout];
       for (int i=1;i<=rowcount;i++){
           for (int j=0;j<colcout;j++){
               empData[i-1][j]=excel.getCellData("Sheet3",i,j);           }
       }
        System.out.println(Arrays.deepToString(empData));
    return empData;
    }
}
