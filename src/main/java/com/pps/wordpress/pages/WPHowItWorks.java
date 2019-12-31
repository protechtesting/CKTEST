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

public class WPHowItWorks extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPHowItWorks.class);
	public WPHowItWorks(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Waiting for the How It Works Page To Load";
		String pass="Successfully landed on the How It Works Page";
		String fail="Unable to land on the How It Works Page";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		
		 try { wait.until(ExpectedConditions.visibilityOf(imgGenericHowItWorks));
		  Log.info(pass); reportStep(pass, "PASS"); } catch (Exception e) {
		  Log.error(fail); reportStep(fail, "FAIL");
		  
		  }
		 
	}
	
	
	public WPHowItWorks verifyurl(String urltext)
	{
		if (driver.getCurrentUrl().contains(urltext))
			reportStep("navigated to How it Works Page", "PASS");
		else
			reportStep("Not navigated to How it Works Page", "FAIL");
		return this;
		
	}
	

	public WPHowItWorks verifynavigationToHowitworksPage(String urltext)
	{
		if (driver.getPageSource().contains(urltext))
			reportStep("navigated to How it Works Page", "PASS");
		else
			reportStep("Not navigated to How it Works Page", "FAIL");
		return this;
		
	}
	
	
	
	@FindBy(xpath= "//a[text()='HOW CASHBACK WORKS']")
	private static WebElement imgGenericHowItWorks;
}
