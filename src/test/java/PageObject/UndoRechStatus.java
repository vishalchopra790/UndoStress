package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BrowserUtil;
import utilities.ConfigReader;
import utilities.DriverUtil;

public class UndoRechStatus {

    public static Logger log = LogManager.getLogger(UndoRechStatus.class.getName());

    public UndoRechStatus() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='col-sm-10']/div[1]/span")
    WebElement statusMessage;
    @FindBy(xpath = "//div[@class=\'col-sm-10\']/div[2]/div[2]/span")
    WebElement sucessStatus;

    public WebElement getStatusMessage() {
        return statusMessage;
    }

    public WebElement getSucessStatus() {
        return sucessStatus;
    }

    public void successfullRecharge() {
        BrowserUtil.fluentWait(statusMessage, DriverUtil.getDriver());
        String expectedMessage = "Recarga Saldo de Telcel al número " + ConfigReader.getProperty("mobileNumber");
        if (expectedMessage.equalsIgnoreCase(statusMessage.getText())) {
            Assert.assertEquals(expectedMessage, statusMessage.getText());
            log.info("Recharge sucessfully for the number" + ConfigReader.getProperty("mobileNumber"));
        } else {
            log.error("Recharge not succesfull");
            Assert.assertTrue(false);
        }
    }

    public void Status() {
        String status = sucessStatus.getText();
        if (status.contains("¡Exitosa!"))
            log.info("Recharge Successfully");
        else
            log.error("Recharge failed");
    }
}