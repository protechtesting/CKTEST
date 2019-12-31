package com.pps.wordpress.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utility.Log;
import utility.TestSetUp;

public class WPICICILogin extends TestSetUp {
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPICICILogin.class);
	
	
	public WPICICILogin(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Waiting for the ICICI Login Page To Load";
		String pass="Successfully landed on the ICICI Login Page";
		String fail="Unable to land on the ICICI Login Page";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		
		 try { wait.until(ExpectedConditions.visibilityOf(txtreference));
		  Log.info(pass); reportStep(pass, "PASS"); } catch (Exception e) {
		  Log.error(fail); reportStep(fail, "FAIL");
		  
		  }
		 
	}
	
	@FindBy(id = "mobileNumberId")
	private static WebElement txtreference;
	
	@FindBy(id = "proceedBtnId")
	private static WebElement proceedbtn;
	
	
	
	
	
}
