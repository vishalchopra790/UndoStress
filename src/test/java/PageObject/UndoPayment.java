package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.DriverUtil;

public class UndoPayment {
    public UndoPayment() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }
    public static Logger log = LogManager.getLogger(UndoPayment.class.getName());

    @FindBy(xpath = "//div[@id=\'payform\']/div/a[2]")
    WebElement cardPayment;

    @FindBy(xpath = "//*[@id='payment-form']/div[1]/div[1]/div/div/input")
    WebElement cardName;

    @FindBy(xpath = "//*[@id=\'cardnumberunique\']")
    WebElement cardNumber;
    @FindBy(xpath = "(//*[@data-openpay-card='expiration_month'])[2]")
    WebElement cardExpMonth;

    @FindBy(xpath = "(//input[@name='expyear'])[2]")
    WebElement cardExpYear;
    @FindBy(xpath = "(//input[@name='cvvno'])[2]")
    WebElement cardCVV;

    @FindBy(xpath = "(//*[@id='email_block']/div/div/input)[1]")
    WebElement Email;


    @FindBy(css = "#paylimit")
    WebElement Activate;



    public void verifyPaymentPage() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), 20);
        String expectedTitle = "undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, Televia, Pase Urbano, IAVE, Viapass";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        try {
            Assert.assertEquals(expectedTitle, DriverUtil.getDriver().getTitle());
            log.info("Navigated to Payment webpage");
        } catch (Throwable pageNavigationError) {
            log.error("Didn't navigate to payment webpage");
        }

    }


    public void payment() {
        System.out.println(DriverUtil.getDriver().getTitle());

        // select card paymment
        getCardPayment().click();
        // card name
        getCardName().sendKeys(ConfigReader.getProperty("creditCName"));
        // card number
        getCardNumber().sendKeys(ConfigReader.getProperty("cardNumber"));
        // card exp month
        getCardExpMonth().sendKeys(ConfigReader.getProperty("cardExpMon"));
        // card exp year
        getCardExpYear().sendKeys(ConfigReader.getProperty("cardExpYear"));
        // card cvv
        getCardCVV().sendKeys(ConfigReader.getProperty("cardCVV"));
        // email
        getEmail().click();
        getEmail().sendKeys(ConfigReader.getProperty("email"));
        // submit
        getActivate().click();

    }


    /**
     * @return the card
     */
    public WebElement getCardPayment() {
        return cardPayment;
    }


    /**
     * @return the cardName
     */
    public WebElement getCardName() {
        return cardName;
    }


    /**
     * @return the cardNumber
     */
    public WebElement getCardNumber() {
        return cardNumber;
    }


    /**
     * @return the cardExpMonth
     */
    public WebElement getCardExpMonth() {
        return cardExpMonth;
    }


    /**
     * @return the cardExpYear
     */
    public WebElement getCardExpYear() {
        return cardExpYear;
    }


    /**
     * @return the cardCVV
     */
    public WebElement getCardCVV() {
        return cardCVV;
    }


    /**
     * @return the email
     */
    public WebElement getEmail() {
        return Email;
    }


    /**
     * @return the activate
     */
    public WebElement getActivate() {
        return Activate;
    }


}
