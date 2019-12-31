package com.pps.wordpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WPLoginPage extends TestSetUp {
	
	
	Boolean presence;
	
	
	//Label Sign In Sign Up
		@FindBy(xpath="//span[contains(text(),'Log In')]")
		private static WebElement lblSignInSignUP;
		public WPLoginPage clickOnlblSignInSignUP() {
			try {
				reportStep("Verifying On  Sign In/ Sign UP", "INFO");
				Log.info("Verifying  Sign In/ Sign UP is Present");
				Utils.sleep();// Even if the Sign In element is not visible but present in DOM, driver is clicking on Sign In
				if(Utils.click(lblSignInSignUP)) {
					reportStep("Clicked Successfully on Sign In/ Sign UP", "PASS");
					Log.info("Clicked Successfully on Sign In/ Sign UP");
				}else {
					Log.fatal("Unable to Click Sign In/ Sign UP \", \"FAIL\"");
					reportStep("Unable to Click Sign In/ Sign UP ", "FAIL");
				}

			}catch(Exception e) {


			}
			return this;
		}



		//Sign In Link
		@FindBy(xpath="//a[text()='Sign in']")
		private static WebElement lnkSignIn;

		//Click on Sign In Link
		public WPSignUpSignInPopUp clickOnlnkSignIn() {
			try {
				reportStep("Clicking On Sign In Link", "INFO");
				Log.info("Clicking On Sign In Link");
				Utils.explicitWaitForClick(lnkSignIn);
				reportStep("Clicked Successfully on Sign In Link", "PASS");
				Log.info("Clicked Successfully on Sign In Link");
			}catch(Exception e) {
				Log.error("Unable to Click Sign In Link");
				reportStep("Unable to Click Sign In", "FAIL");
			}
			return new WPSignUpSignInPopUp(driver,logger);
		}
	
	

		

		
	
}
