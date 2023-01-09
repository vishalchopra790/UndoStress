package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.DriverManager;

public final class ScreenshotUtils {
    private ScreenshotUtils() {
    }



    public static String getBase64Image() {
        return ((TakesScreenshot) DriverUtil.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
