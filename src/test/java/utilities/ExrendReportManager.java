//package utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import TestBase.BaseClass;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//// NOTE: The 'BaseClass' and its 'captureScreen' method are external and not defined here.
//// You will need to ensure 'BaseClass' is available and the method works correctly.
//// Also, ensure you have the necessary ExtentReports and TestNG dependencies.
//
//public class ExrendReportManager implements ITestListener {
//
//    public ExtentSparkReporter sparkReporter;
//    public ExtentReports extent;
//    public ExtentTest test;
//
//    String repName;
//
//    /**
//     * Called when the test context starts (e.g., at the start of a TestNG XML suite or test).
//     */
//    public void onStart(ITestContext testContext) {
//
//        // /*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//        // Date dt=new Date();
//        // String currentdatetimestamp=df.format(dt);
//        // */
//
//        // Generate a timestamp for the report file name
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        repName = "Test-Report-" + timeStamp + ".html";
//
//        // Specify the location and name of the report file
//        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
//        
//        // Configure the report
//        sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Title
//        sparkReporter.config().setReportName("opencart Functional Testing"); // Name of report
//        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.
//            configuration.Theme.DARK);
//
//        // Initialize ExtentReports
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//
//        // Set System/Environment Information
//        extent.setSystemInfo("Application", "opencart");
//        extent.setSystemInfo("Module", "Admin");
//        extent.setSystemInfo("Sub Module", "Customers");
//
//        // Set additional system info from TestNG parameters/properties
//        extent.setSystemInfo("User Name", System.getProperty("user.name"));
//        extent.setSystemInfo("Environemnt", "QA");
//
//        String os = testContext.getCurrentXmlTest().getParameter("os");
//        extent.setSystemInfo("Operating System", os);
//
//        String browser = testContext.getCurrentXmlTest().getParameter("browser");
//        extent.setSystemInfo("Browser", browser);
//
//        // Capture included groups if any are specified
//        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
//        if(!includedGroups.isEmpty()) { // The screenshot shows .isEmpty() and no '!' so it might be a typo in the screenshot's code
//            extent.setSystemInfo("Groups", includedGroups.toString());
//        }
//
//    }
//
//    /**
//     * Called when a test method successfully finishes.
//     */
//    public void onTestSuccess(ITestResult result) {
//        // Create a new test entry in the report
//        test = extent.createTest(result.getTestClass().getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.log(Status.PASS, result.getName() + " got successfully executed");
//    }
//
//    /**
//     * Called when a test method fails.
//     */
//    public void onTestFailure(ITestResult result) {
//        // Create a new test entry in the report
//        test = extent.createTest(result.getTestClass().getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.log(Status.FAIL, result.getName() + " got failed");
//        test.log(Status.INFO, result.getThrowable().getMessage());
//
////        // Assumes 'BaseClass' contains the 'captureScreen' method
////		String imgPath = new BaseClass().captureScreen(result.getName()); 
////		test.addScreenCaptureFromPath(imgPath); // Attach screenshot to the report
//    }
//
//    /**
//     * Called when a test method is skipped.
//     */
//    public void onTestSkipped(ITestResult result) {
//        // Create a new test entry in the report
//        test = extent.createTest(result.getTestClass().getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.log(Status.SKIP, result.getName() + " got skipped");
//        test.log(Status.INFO, result.getThrowable().getMessage());
//    }
//
//    /**
//     * Called after all tests in the current context have run.
//     */
//    public void onFinish(ITestContext testContext) {
//        // Write all logs to the report file
//        extent.flush();
//
//        // --- Automatically open the report in the default browser ---
//        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
//        File extentReport = new File(pathOfExtentReport);
//
//        try {
//            // Check if Desktop is supported and the report file exists
//            if (Desktop.isDesktopSupported() && extentReport.exists()) {
//                Desktop.getDesktop().browse(extentReport.toURI());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // -----------------------------------------------------------
//    }
//    
//    // Other ITestListener methods (onTestStart, onTestFailedButWithinSuccessPercentage, etc.)
//    // are not shown in the screenshots, but they are part of the interface and can be left empty
//    // or implemented as needed.
//}







package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestBase.BaseClass;
import TestBase.BaseClass2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExrendReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    /**
     * Called when the test context starts (suite/test).
     */
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "Simplify VMS");
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        String browser = testContext.getCurrentXmlTest().getParameter("browser");

        if (os != null) extent.setSystemInfo("Operating System", os);
        if (browser != null) extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " passed successfully");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " test failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        // ✅ Capture and attach screenshot
        try {
            BaseClass2 base = (BaseClass2) result.getInstance();
            WebDriver driver = base.getDriver(); // make sure BaseClass has getDriver() method
            String screenshotPath = captureScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath, "Failed Test Screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " test skipped");
        if (result.getThrowable() != null)
            test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();

        // Automatically open the report
        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            if (Desktop.isDesktopSupported() && extentReport.exists()) {
                Desktop.getDesktop().browse(extentReport.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    // ✅ Utility Method to Capture Screenshot
    public static String captureScreenshot(WebDriver driver, String testName) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}


