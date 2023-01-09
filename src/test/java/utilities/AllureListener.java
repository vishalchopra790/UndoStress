package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class AllureListener extends BrowserUtil implements ITestListener {
    ExtentReports extent = ExtentReportUtil.extentReportGenerator();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentLocal = new ThreadLocal<ExtentTest>();

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentLocal.get().log(Status.PASS, "Test Passed");
    }
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotLocation = BrowserUtil.getScreenshotPath(result.getName());
        WebDriver driver = DriverUtil.getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
            saveScreenshotPNG(driver);
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

        try {
            MyScreenRecorder.stopRecording();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
        extentLocal.set(test);
        // TODO Auto-generated method stub
        try {
            MyScreenRecorder.startRecording(result.getMethod().getMethodName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }
}
