package utilities;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.reports.ExtentLogger;
import utilities.reports.ExtentReport;


public class Listeners extends BrowserUtil implements ITestListener {
    /*ExtentReports extent = ExtentReportUtil.extentReportGenerator();
    public ExtentTest test;
    public ThreadLocal<ExtentTest> extentLocal = new ThreadLocal<ExtentTest>();*/


    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
        //extentLocal.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
        ExtentLogger.fail(result.getThrowable().toString());
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
        ExtentReport.flushReports();

        try {
            MyScreenRecorder.stopRecording();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        /*test = extent.createTest(result.getMethod().getMethodName());
        extentLocal.set(test);*/
        ExtentReport.createTest(result.getMethod().getMethodName());
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
        ExtentReport.initReports();
    }
}
