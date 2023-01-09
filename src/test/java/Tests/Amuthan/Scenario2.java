package Tests.Amuthan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Scenario2 extends Base {

    @Test
    public void test() {
        driver.get("https://demoqa.com/select-menu");
        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        selectFromDropdown(e -> e.selectByValue("2"), element);
        List<WebElement> li = new Select(driver.findElement(By.id("cars"))).getOptions();

        li.stream().skip(2).forEach(s -> {
            s.click();
            System.out.println(s.getText());
        });
    }

    public void selectFromDropdown(Consumer<Select> consumer, WebElement webElement) {
        consumer.accept(new Select(webElement));
    }

    @Test
    public void map() {
        Map<String,String> map=new HashMap<String,String>();
        map.put("Vishal","Chopra");
        map.put("Sahil","Chopra");

        map.forEach((k,v)-> System.out.println(k+" "+v));
        map.entrySet().forEach(s-> System.out.println(s.getKey()+" "+s.getValue()));
    }
}
