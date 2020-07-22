package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.Base;

public class Recharge extends Base {


    public static Logger log = LogManager.getLogger(Recharge.class.getName());

    @Test(groups = {"regression"})
    public void e2E() throws InterruptedException {
        pages.undoHomepage.verifyHomepage();
        pages.undoHomepage.recharge();
        pages.undoPayment.verifyPaymentPage();
        pages.undoPayment.payment();
        pages.undoLogin.login();
        pages.undoRechStatus.successfullRecharge();
        pages.undoRechStatus.Status();
    }


}
