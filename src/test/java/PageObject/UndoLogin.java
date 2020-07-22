/**
 *
 */
package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BrowserUtil;
import utilities.ConfigReader;
import utilities.DriverUtil;

/**
 * @author X133477
 *
 */
public class UndoLogin {
    public UndoLogin() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\'usrname\']")
    WebElement username;

    @FindBy(xpath = "//*[@id='psw']")
    WebElement password;

    @FindBy(xpath = "//*[@id='recaptcha-anchor']/div[1]")
    WebElement captchaClick;

    @FindBy(xpath = "//*[@id='loginForm']/div[4]/div/div/iframe")
    WebElement captchaFrame;

    @FindBy(css = "[type='submit']")
    WebElement loginClick;


    public void login() throws InterruptedException {

        // username
        getUsername().sendKeys(ConfigReader.getProperty("username"));
        // password
        getPassword().sendKeys(ConfigReader.getProperty("password"));
        BrowserUtil.wait(2000);
        // captcha verification
        WebElement fr = getCaptchaFrame();
        DriverUtil.getDriver().switchTo().frame(fr);
        getCaptchaClick().click();
        DriverUtil.getDriver().switchTo().defaultContent();
        // login submit
        getLoginClick().click();


    }

    /**
     * @return the captchaClick
     */
    public WebElement getCaptchaClick() {
        return captchaClick;
    }

    /**
     * @return the username
     */
    public WebElement getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public WebElement getPassword() {
        return password;
    }

    public WebElement getCaptchaFrame() {
        return captchaFrame;
    }

    public WebElement getLoginClick() {
        return loginClick;
    }


}
