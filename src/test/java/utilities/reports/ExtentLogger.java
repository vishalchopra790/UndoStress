package utilities.reports;

import com.aventstack.extentreports.MediaEntityBuilder;


import utilities.ScreenshotUtils;

import java.io.IOException;

public final class ExtentLogger {
    private ExtentLogger() {
    }


    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) throws IOException {


                ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());



    }

    public static void fail(String message, boolean isScreenshotNeeded) throws IOException {

                            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());



    }

    public static void skip(String message, boolean isScreenshotNeeded) throws IOException {

                ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());


    }


}
