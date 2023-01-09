package Tests.Amuthan.Java8;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.AllureListener;
import utilities.DriverUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
@Listeners({AllureListener.class})
public class Predicatee {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Story: Predicate")
    @Description("Maths Test")
    @Test(description="Predicate")
    public void test() {
        List<Integer> li = Arrays.asList(5,8,225,55,455,85,66,44,22);
        sumUsingJava8(li,i->i%2==0);
        sumUsingJava8(li,i->true);
    }

    private void sumUsingJava8(List<Integer> li, Predicate<Integer> predicate) {
        System.out.println(li.stream().filter(predicate)
                .reduce(0, Integer::sum));
    }


    @Test(description="Amazon")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story: Predicate")
    @Description("Predicate Amazon Test")
    public void amazon() {
        DriverUtil.getDriver().get("https://www.amazon.in/");
        List<WebElement> list=DriverUtil.getDriver().findElements(By.xpath("//div[@id='nav-xshop']/a"));
        clickElementMatchingText(list,e->e.getText().equalsIgnoreCase("Moiles"));
        clickElementMatchingText(list,e->e.getAttribute("data-csa-c-content-id").equalsIgnoreCase("nav_cs_apay_fe0c735739554ca1a7cccf7c41941f2f"));
    }
    private void clickElementMatchingText(List<WebElement>  li,Predicate<WebElement> predicate) {
      WebElement element=  li.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(()->new RuntimeException("Element not present"));
        element.click();
    }
}
