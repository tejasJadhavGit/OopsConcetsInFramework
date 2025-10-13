package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {

    public static ExtentReports getExtentReport(){

        String path = System.getProperty("user.dir") + "//reports//ExtentReports//index.html";
                     // System.getProperty("user.dir") + "//reports//ExtentReports//" + methodName + ".html"
        ExtentSparkReporter ext= new ExtentSparkReporter(path);
        ext.config().setDocumentTitle("Automation Execution Report");
        ext.config().setReportName("Tejas");

        ExtentReports report= new ExtentReports();
       report.attachReporter(ext);

       return report;
    }
}
