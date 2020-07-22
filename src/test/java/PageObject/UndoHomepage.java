package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ConfigReader;
import utilities.DriverUtil;
import utilities.JSUtil;

public class UndoHomepage {
    public static Logger log = LogManager.getLogger(UndoHomepage.class.getName());


    public UndoHomepage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class,'menulist')]//a[1]")
    WebElement rechargeSection;
    @FindBy(css = "input[name='operator']")
    WebElement selectOperatorClick;
    @FindBy(xpath = "//div[@class='suggestion']//li[1]")
    WebElement telcelOperator;
    @FindBy(xpath = "//div[@id='col-sm-12']/form/div/div/div/div[2]/ul/li[2]//input")
    WebElement mobileNumber;
    @FindBy(xpath = "//div[@id='col-sm-12']/form/div/div/div/div[2]/ul/li[3]//input")
    WebElement rechargePack;
    @FindBy(xpath = "//div[@for='cat1']")
    WebElement rechargeCategory;
    @FindBy(xpath = "//div[@class='suggestion']/ul[1]/li[1]")
    WebElement rechargeTopUp;
    @FindBy(xpath = "//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[3]/div/button")
    WebElement rechargeClick;

    //1st
    public void verifyHomepage() {
        DriverUtil.getDriver().get(ConfigReader.getProperty("url"));
        JSUtil.pageLoadColplte();
        String actualTitle = "UnDosTres - Recargas en línea Telcel, Movistar, AT&T, Unefon, Virgin, Televia, Pase, Boletos de Cine, Pagos CFE";
        if (actualTitle.equalsIgnoreCase(DriverUtil.getDriver().getTitle())) {
            Assert.assertEquals(actualTitle, DriverUtil.getDriver().getTitle());
            log.info("Navigated to Home webpage and title is as expected");
        } else {
            log.error("Didn't navigate to Home webpage");
            Assert.assertTrue(false);
        }

    }


    public void recharge() {

        // recharge section
        getRechargeSection().click();
        // operator
        getSelectOperatorClick().click();
        getTelcelOperator().click();
        // mobile number
        getMobileNumber().sendKeys(ConfigReader.getProperty("mobileNumber"));
        // recharge pack click
        getRechargePack().click();
        // Recharges category
        getRechargeCategory().click();
        /// top up
        getRechargeTopUp().click();
        // Siguiente click
        getRechargeClick().click();

    }


    /**
     * @return the rechargeSection
     */
    public WebElement getRechargeSection() {
        return rechargeSection;
    }


    /**
     * @return the selectOperatorClick
     */
    public WebElement getSelectOperatorClick() {
        return selectOperatorClick;
    }


    /**
     * @return the telcelOperator
     */
    public WebElement getTelcelOperator() {
        return telcelOperator;
    }


    /**
     * @return the mobileNumber
     */
    public WebElement getMobileNumber() {
        return mobileNumber;
    }


    /**
     * @return the rechargePack
     */
    public WebElement getRechargePack() {
        return rechargePack;
    }


    /**
     * @return the rechargeCategory
     */
    public WebElement getRechargeCategory() {
        return rechargeCategory;
    }


    /**
     * @return the rechargeTopUp
     */
    public WebElement getRechargeTopUp() {
        return rechargeTopUp;
    }


    /**
     * @return the rechargeClick
     */
    public WebElement getRechargeClick() {
        return rechargeClick;
    }


}
