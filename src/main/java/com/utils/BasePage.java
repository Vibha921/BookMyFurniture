package com.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pages.AutomationPractice;
import com.pages.RegisterPage;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class BasePage{

	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger(BasePage.class);
	public ITestResult result;
	static String reportPath = new File("").getAbsolutePath().toString().trim()+"/Reports/";

	public static ExtentHtmlReporter report;
	public static ExtentTest test;
	public static ExtentReports extent;
	public RegisterPage registerPage;
	public static Properties propertyReader = new Properties();
	public static InputStream inputStream;
	public static ArrayList<String> list = new ArrayList<>();
	public RequestSpecification request = null;
	public AutomationPractice auotmationPracticePage;
	

	@BeforeSuite
	public void launchUrl() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\com\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		loadPropertyFile();

		startReport();
		driver.manage().window().maximize();
		driver.get(propertyReader.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		initElements();
	}

	public void startReport() {
		report = new ExtentHtmlReporter(reportPath+ "ExtentReports.html");

		//initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(report);

		//To add system or environment info by using the setSystemInfo method.
		//    extent.setSystemInfo("OS", OS);
		//    extent.setSystemInfo("Browser", browser);

		//configuration items to change the look and feel
		//add content, manage tests etc
		report.config().setDocumentTitle("Book My Furniture");
		report.config().setReportName("Test Report");
		report.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	public void initElements() {
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		auotmationPracticePage = PageFactory.initElements(driver, AutomationPractice.class);
	}

	public void loadPropertyFile() {
		String propFileName = "data.properties";
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			try {
				propertyReader.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		String path = takeScreenShot(result.getName());
		if(result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, result.getName()+" FAILED ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//			test.fail(result.getThrowable());
			test.fail("Test case is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, "Test case " +result.getName()+ " Passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		    test.pass("Test case is passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		
	}

	public String takeScreenShot(String text) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = null;


		try {
             path = System.getProperty("user.dir") + "\\Reports\\Screenshots\\" + text + ".png";
             log.info(path);
			FileUtils.copyFile(src, new File(path));
			test.log(Status.INFO, text, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} 

		catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	@AfterSuite
	public void tearDown() {  
		driver.close();
		driver.quit();
		extent.flush();
	}
	
	public RequestSpecification setBaseUri(String service) {
		RequestSpecification req = RestAssured.given();
		req.baseUri("http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/signup/");
		req.header("Content-Type", "application/json");
		return req;
		
	}
}

