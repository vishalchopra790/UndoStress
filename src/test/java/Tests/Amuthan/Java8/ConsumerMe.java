package Tests.Amuthan.Java8;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Base;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerMe extends Base {
    public static void main(String[] args) {
        toConsumer(s-> System.out.println(s.length()));
        toConsumer(s-> System.out.println(s.toLowerCase()));
    }

    private static void toConsumer(Consumer<String> consumer) {
        String temp="AmuThan";
        consumer.accept(temp);
    }

    @Test
    public void test(){
        driver.get("https://amazon.com");
        List<WebElement> list=driver.findElements(By.tagName("a"));

        Consumer<WebElement> consumer=(e)->{
            //if(!e.getText().isBlank()){
                if(e.getText().startsWith("C")||e.getText().startsWith("D")){
                    System.out.println(e.getText().toLowerCase());
                }
            //}
        };
        list.forEach(consumer);
        driver.quit();
    }
}
