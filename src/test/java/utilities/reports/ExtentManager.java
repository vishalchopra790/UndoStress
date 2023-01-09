package utilities.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {

    private ExtentManager() {

    }

    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {

        return extentTest.get();
    }

    public static void setExtent(ExtentTest test) {
        if (Objects.nonNull(test)) {
            extentTest.set(test);
        }
    }

    public static void unload() {

        extentTest.remove();
    }
}
