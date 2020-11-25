package Tests;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtil;
import utilities.DriverUtil;

import javax.swing.*;

/**
 *
 * @author NaveenKhunteta
 *
 */
public class AmazonOTPHandle {

    public static final String  ACCOUNT_SID= "ACe637e46a4455951bece638f1dd21f482";
    public static final String  AUTH_TOKEN= "1d5f517e1726ea8335dce4744573913c";

    public static void main(String[] args) {

     
        DriverUtil.getDriver().get("https://www.amazon.in");
        DriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions action=new Actions(DriverUtil.getDriver());
        action.moveToElement(DriverUtil.getDriver().findElement(By.cssSelector("a#nav-link-accountList>span>span"))).build().perform();
        DriverUtil.getDriver().findElement(By.linkText("Start here.")).click();

        DriverUtil.getDriver().findElement(By.id("ap_customer_name")).sendKeys("NaveenTestOTP");
        DriverUtil.getDriver().findElement(By.id("auth-country-picker-container")).click();

        DriverUtil.getDriver().findElement(By.xpath("//ul[@role='application']//li/a[contains(text(),'United States +1')]")).click();
        DriverUtil.getDriver().findElement(By.id("ap_phone_number")).sendKeys("2058989658");
        DriverUtil.getDriver().findElement(By.id("ap_password")).sendKeys("TestAutomation@123");
        DriverUtil.getDriver().findElement(By.id("continue")).click();
        String str= JOptionPane.showInputDialog("Enter your input");
        DriverUtil.getDriver().findElement(By.cssSelector("[name='cvf_captcha_input']")).sendKeys(str);
        BrowserUtil.wait(3000);
        DriverUtil.getDriver().findElement(By.cssSelector(".a-button-input")).click();

        // get the OTP using Twilio APIs:

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+2058989658"),
                new com.twilio.type.PhoneNumber("+2058989658"),
                "body")
                .create();

        System.out.println(message.getSid());

    }

    public static String getMessage() {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+13343734019")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }

}