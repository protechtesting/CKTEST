package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;

import utility.Log;
import utility.Utils;
import utility.WrapperMethods;

public class HomePageTestCase extends WrapperMethods {
	
	/**
	 * Verify Default components in home page 
	 * @throws Exception
	 * PreCondition: Guest User
	 */
	
	//@Test(priority=26,enabled=true)
	public void VerifyDefaultComponentsofHomePage() throws Exception{
		try {
			reportStep("verification of Default components in home page started", "INFO");
			Log.info("verification of Default components in home page started started");
			
			new WPHomePage(driver, logger).
			verifyHeaderFooterFieldsPresent().
			verifyhomepagesectionsPresent();
			
			Log.info("verification of Default components in home page Completed");
			reportStep("verification of Default components in home page Completed", "PASS");
		}catch(Exception e) {
			Log.info("verification of Default components in home page Completed");
			reportStep("verification of Default components in home page Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->ClickOnStorecardButton(Activate CashBack)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * @throws Exception
	 * PreCondition: Guest User
	 */
	
	//@Test(priority=26,enabled=true)
	public void successfulLoginViaHomePageStoreCardActivateCashBackLink() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickStoreCardActivateCashbackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	//@Test(priority=26,enabled=true)
	public void verifypopularAndTrendingRetailerfunctionality() throws Exception{
		try {
			reportStep("Validation of popular retailer functionality started", "INFO");
			Log.info("Validation of popular retailer functionality started");
			
			new WPHomePage(driver, logger).
			verifyPopularRetailer("Amazon India Apple iPhone X")
			.verifyTrendingRetailer("Zoomcar")
			.verifyPickoftheDayRetailer("Cashback Store :2019.12.31.17.12.030046");
			
			Log.info("Validation of popular retailer functionality started Completed");
			reportStep("Validation of popular retailer functionality started Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of popular retailer functionality failed");
			reportStep("Validation of popular retailer functionality failed", "FAIL");
		}
	}
	
	@Test
	public void N18StoreNavigationFromHomePage()
	{      
		
		String locator="Locating Grab Deal in Store Page.";
		String pass="Successfully clicked Grab Deal in Store Page.";
		String fail="Unable to locate Grab Deal in Store Page.";
		
		log.info(locator);
		
		new WPHomePage(driver, logger).
		clickGrabDealLink(0);
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains("swiggy");
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		log.info(pass);
		reportStep(pass, "pass");
		
		
	}
	
	
}
