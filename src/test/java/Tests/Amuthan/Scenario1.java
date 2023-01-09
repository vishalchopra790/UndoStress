package Tests.Amuthan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.DriverUtil;


/*Open Amazon.in
        Fetch all the links in the amazon.in home page.
        Fetch the text from the links and remove the empty links
        Remove the duplicates.
        Sort the text in the alphabetical order.
        Print only the text starting with character “C” and “D”*/

import java.util.*;

public class Scenario1 {
WebDriver driver=DriverUtil.getDriver();
    @Test
    public void amazonHomePageLondApproach(){
        driver.get("https://amazon.in");
        List<WebElement> list=DriverUtil.getDriver().findElements(By.tagName("a"));
        List<String> text=new ArrayList<>();

        for (WebElement webElement : list) {
            String temp = webElement.getText();
            //if (!temp.isBlank()) {
                text.add(temp);
            //}
        }

        List<String> removedDuplicates=new ArrayList<>(new HashSet<String>(text));
        Collections.sort(removedDuplicates);
        for(String li:removedDuplicates){
            if(li.startsWith("C") || li.startsWith("D")){
                System.out.println(li);
            }
            driver.quit();
        }


        }


    @Test
    public void amazonHomePageStreamApproach() {
        driver.get("https://amazon.in");
        driver.findElements(By.xpath("//a"))
                .stream()
                .map(WebElement::getText)
               // .filter(s->!s.isBlank())
                .distinct()
                .sorted()
                .filter(s->s.startsWith("C")||s.startsWith("D"))
                .forEach(System.out::println);
    }
}
