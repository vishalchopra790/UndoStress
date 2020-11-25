package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.DriverUtil;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

public class Greenkart {

    @Test
    public void adddItems(){
        String[] vegie={"Brocolli","Cucumber"};
        e2e(vegie);
    }

    public static void e2e(String [] vegie){
        int j=0;
        DriverUtil.getDriver().get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> web=DriverUtil.getDriver().findElements(By.xpath("//div[@class='product']"));

        int productSize=web.size();
        System.out.println(productSize);
        for(int i =0;i<productSize;i++){
            String text=web.get(i).findElement(By.xpath("h4")).getText().split("-")[0].trim();
            System.out.println(text);
            List<String> nameList=Arrays.asList(vegie);
            if(nameList.contains(text)){
                j++;
                DriverUtil.getDriver().findElements(By.xpath("//div[@class='product']/div/button")).get(i).click();
                if(j==vegie.length){
                    break;
                }
            }


        }

    }
}
