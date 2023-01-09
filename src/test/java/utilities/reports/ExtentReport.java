package utilities.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    public static ExtentReports extentReport;
    public static ExtentTest extentTest;

    public static void initReports()  {

        if (Objects.isNull(extentReport)) {
            extentReport = new ExtentReports();
            String filePath = System.getProperty("user.dir") + "\\test-output\\ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
            extentReport.attachReporter(sparkReporter);

            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("VC Report");
            sparkReporter.config().setReportName("Automation Report");
            sparkReporter.config().setReportName("AUS Team");
        }
    }

    public static void flushReports(){
        if (Objects.nonNull(extentReport)) {
            extentReport.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "\\test-output\\ExtentReport.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testname) {

        ExtentManager.setExtent(extentReport.createTest(testname));
    }
    /*public static void addAuthors(String[] authors){
        Arrays.stream(authors).forEach(e->ExtentManager.getExtentTest().assignAuthor(e));
    }
    public static void addCategories(CategoryType[] authors){
        Arrays.stream(authors).forEach(e->ExtentManager.getExtentTest().assignCategory(e.toString()));
    }*/
}
