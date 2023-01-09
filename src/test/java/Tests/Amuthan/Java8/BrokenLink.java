package Tests.Amuthan.Java8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.DriverUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLink {

    public static void main(String[] args) {

        DriverUtil.getDriver().get("https://amazon.in/");
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       List<WebElement> links =DriverUtil.getDriver().findElements(By.tagName("a"));

        System.out.println(links.size());
    links.parallelStream().filter(WebElement::isEnabled).distinct().map(ele -> ele.getAttribute("href")).forEach(BrokenLink::checkURL);

    }
    public static void checkURL(String urlLink){
        try {
            URL url=new URL(urlLink);
            HttpURLConnection  connection=(HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.connect();
            if(connection.getResponseCode()>=400){
                System.out.println(urlLink+" ------> "+connection.getResponseMessage()+ " is a broken link");
            }else{
                System.out.println(urlLink+"  ------>  "+connection.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
