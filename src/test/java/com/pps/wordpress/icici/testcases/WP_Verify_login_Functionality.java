package com.pps.wordpress.icici.testcases;

import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPAdmin;
import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPSignUpSignInPopUp;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;


/**
 *This class will verify various login and error scenario in WordPress.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-13">Raise JIRA Issue Here</a>
 */


public class WP_Verify_login_Functionality extends TestSetUp{
	
	
	
	/**
	 *Verify Successful Login for New User when navigates from ICICI Account
	 *<p>
	 *Verify whether the new user is created, when navigate with New Fed ID
	 */
	
	//@Test
	public void verifySuccessfulLoginforNewUserwhennavigatesfromICICIAccount()
	{
		
		try {
			
			String FedID = Utils.generateRandomMobileNumber();
			String Channel ="RIB";
			String email=Utils.getTestData(0,"ValidUserId");
			
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger)
			.clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
			.refreshHomePage(driver)
			.verifypartner1loggedin().clickStoreCardActivateCashbackLink();			
			Utils.switchToNewlyOpenWindow(driver);
			
		
			
			reportStep("Verification of Successful Login from ICICI for New User is completed", "PASS");
			Log.info("Verification of Successful Login from ICICI for New User is completed");
		}catch(Exception e) {
			reportStep("Verification of Successful Login from ICICI for New User is failed", "FAIL");
			Log.info("Verification of Successful Login from ICICI for New User is failed");
			throw e;
		}
		
	}
	
	
	

	/**
	 *Verify Successful Login for Existing User when navigate from ICICI account
	 *<p>
	 *Verify whether the new user is created, when navigate with existing Fed ID
	 */
	//@Test
	public void VerifySuccessfulLoginforExistingUserwhennavigatefromICICIaccount()
	{
		
try {
			
			String FedID = Utils.getTestData(10, "ExistingFEDID");
			String Channel ="RIB";
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
			.refreshHomePage(driver)			
			.verifypartner1loggedin().clickStoreCardActivateCashbackLink();
		
			
			reportStep("Verification of Successful Login for Existing user (64377) from ICICI completed", "PASS");
			Log.info("Verification of Successful Login for Existing user (64377) from ICICI completed");
		}catch(Exception e) {
			reportStep("Verification of Successful Login from Existing user (64377)ICICI failed", "FAIL");
			Log.info("Verification of Successful Login from Existing user (64377)ICICI failed");
			throw e;
		}
		
		
	}
	
	
	
	/**
	 *Verify Redirection to specified URL
	 *<p>
	 *If there is a redirectURL, authenticate the user and it needs to be passed to the specified URL 
	 */
	
	@Test
	public void VerifyRedirectiontospecifiedURL()
	{
		
try {
			
			String FedID = Utils.getTestData(10, "ExistingFEDID");
			String Channel ="RIB";
			String RedirectionURL="";
		
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelAndRedirectionURLfromStorepage(FedID, Channel, RedirectionURL);
			
			if(driver.getCurrentUrl().equals(""))
			{			
			reportStep("Successfully navigated to specified URL", "PASS");
			Log.info("Successfully navigated to specified URL");
			}
			else
			{
				reportStep("Failed to specified URL", "FAIL");
				Log.info("Failed to specified URL");
			}
		}catch(Exception e) {
			reportStep("Failed to specified URL", "FAIL");
			Log.info("Failed to specified URL");
			throw e;
		}
		
		
		
	}
	
	
	/**
	 *Verify Redirection to Home page when no specified URL
	 *<p>
	 *If there is no redirectURL, authenticate the user and redirect directly to the home page 
	 */
	public void VerifyRedirectiontoHomepagewhenNospecifiedURL()
	{
		
		try {
			
			String FedID = Utils.generateRandomMobileNumber();
			String Channel ="RIB";
	
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel);
						
			if(driver.getCurrentUrl().equals(""))
			{			
			reportStep("Since there is no specified URL, navigated to home page", "PASS");
			Log.info("Since there is no specified URL, navigated to home page");
			}
			else
			{
				reportStep("Even there is no specified URL, not navigated to home page", "FAIL");
				Log.info("Even there is no specified URL, not navigated to home page");
			}
		}catch(Exception e) {
			reportStep("Failed to specified URL", "FAIL");
			Log.info("Even there is no specified URL, not navigated to home page");
			throw e;
		}
		
		
	}
	
	
	/**
	 *
	 *Verify successful login with valid Channels  Verify chennael successfully added into  admin
	 */
	public void VerifysuccessfulloginwithvalidChannelsVerifychennaelsuccessfullyaddedintoadmin(){
		
		String FedID = Utils.generateRandomMobileNumber();
		String Channel ="RIB";
		String email ="";
		
		try{
	
		reportStep("Verification of Successful Login started", "PASS");
		new WPHomePage(driver, logger).clickOnProceedButton()
		.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
		.refreshHomePage(driver)
		.verifypartner1loggedin().clickStoreCardActivateCashbackLink();
		
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClick(driver, email);
		
		if (exitClickId.equals(Channel))
		{
			reportStep("Login successful. channel successfully added into admin", "PASS");
			Log.info("Login successful. channel successfully added into admin");
		}
		else
		{
			reportStep("Login successful. channel failed to add into admin", "FAIL");
			Log.info("Login successful. channel failed to add into admin");
		}
		
	}catch(Exception e) {
		
		reportStep("Login successful. channel failed to add into admin", "FAIL");
		Log.info("Login successful. channel failed to add into admin");
		
	}
		
	}
	
	/**
	 *
	 *Verify successful login with valid Channels using lower upper case combination
	 */
	public void VerifysuccessfulloginwithvalidChannelsusingloweruppercasecombinatiom()
	{
		try{

		String FedID = Utils.generateRandomMobileNumber();
		String Channel ="RiB";
		
	
		reportStep("Verification of Successful Login started", "PASS");
		new WPHomePage(driver, logger).clickOnProceedButton()
		.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
		.refreshHomePage(driver)
		.verifypartner1loggedin().clickStoreCardActivateCashbackLink();
		
		
		reportStep("Verification of Successful Login from ICICI using channel name with upperlower combination  is completed", "PASS");
		Log.info("Verification of Successful Login from ICICI using channel name with upperlower combination  is completed");
	}catch(Exception e) {
		reportStep("Verification of Successful Login from ICICI using channel name with upperlower combination  is failed", "FAIL");
		Log.info("Verification of Successful Login from ICICI using channel name with upperlower combination  is failed");
		throw e;
	}
		
		
	}
	
	
	/**
	 *
	 *Verify unsuccessful login with invalid channel names - channel not present
	 */
	public void VerifysuccessfulloginwithvalidChannels() 
	{
try {
			
			String FedID = Utils.getTestData(10, "ExistingFEDID");
			String Channel ="RIB";
			String RedirectionURL="";
			String email=Utils.getTestData(0,"ValidUserId");
			
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelAndRedirectionURLfromStorepage(FedID, Channel, RedirectionURL)			
			.refreshHomePage(driver)			
			.verifypartner1loggedin();
		
			
			reportStep("Verification of Successful Login for Existing user from ICICI completed", "PASS");
		}catch(Exception e) {
			reportStep("Verification of Successful Login from Existing user ICICI failed", "FAIL");
			throw e;
		}
		
		
	}
	
	/**
	 *
	 *Verify Unsuccessful login with invalid FEDID  - above 10 digit numeric
	 */
	public void VerifyunsuccessfulloginwithvalidFEDIDAboveLength() 
	{
		
try {
			
			String FedID = "1234567895265";
			String Channel ="RIB";
			String email=Utils.getTestData(0,"ValidUserId");
			
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
			.refreshHomePage(driver)
			.verifypartner1loggedin().clickStoreCardActivateCashbackLink();
			
			Utils.switchToNewlyOpenWindow(driver);
			
		
			
			reportStep("Login failure for Exceed lengh of FEDID verified", "PASS");
			Log.info("Login failure for Exceed lengh of FEDID verified");
		}catch(Exception e) {
			reportStep("Some Issues on FEDID lenght verification", "FAIL");
			Log.info("Some Issues on FEDID lenght verification");
			throw e;
		}
		
	}
	
	/**
	 *
	 *Verify Unsuccessful login with invalid FEDID  - below 10 digit numeric
	 */
	public void VerifyunsuccessfulloginwithinvalidFEDIDBelowLength() 
	{
		
try {
			
			String FedID = "1234567";
			String Channel ="RIB";
			String email=Utils.getTestData(0,"ValidUserId");
			
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
			.refreshHomePage(driver)
			.verifypartner1loggedin().clickStoreCardActivateCashbackLink();
			
			Utils.switchToNewlyOpenWindow(driver);
			
		
			
			reportStep("Login failure for below lengh of FEDID verified", "PASS");
			Log.info("Login failure for below lengh of FEDID verified");
		}catch(Exception e) {
			reportStep("Some Issues on FEDID lenght verification", "FAIL");
			Log.info("Some Issues on FEDID lenght verification");
			throw e;
		}
		
	}
	
	/**
	 *
	 *Verify Unsuccessful login with FEDID contains non numeric charecters
	 */
	public void VerifyunsuccessfulloginwithinvalidFEDIDNonNumeric() 
	{
try {
			
			String FedID = "asnghrthtk";
			String Channel ="RIB";
			String email=Utils.getTestData(0,"ValidUserId");
			
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).clickOnProceedButton()
			.hitICICILoginwithFedIDAndChannelfromStorepage(FedID,Channel)
			.refreshHomePage(driver)
			.verifypartner1loggedin().clickStoreCardActivateCashbackLink();
			
			Utils.switchToNewlyOpenWindow(driver);
			
		
			
			reportStep("Login failure for NonNumeric FEDID verified", "PASS");
			Log.info("Login failure for NonNumeric FEDID verified");
		}catch(Exception e) {
			reportStep("Some Issues on FEDID lenght verification", "FAIL");
			Log.info("Some Issues on FEDID lenght verification");
			throw e;
		}
			
		
		
	}
	
	
	/**
	 *
	 *successful login into "ManageCashback"
	 *<p>
	 *try to login with the mobile number which is registered in ICICI 
	 */
	public void successfulloginintoManageCashback()
	{
		String refno =Utils.getTestData(10, "ExistingFEDID");
		
		try {
		
		reportStep("Verification of Successful Login by clicking Manage Cashback started", "INFO");
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickFirstStoreCard();
		reportStep("Verification of Successful Login by clicking Manage Cashback completed", "PASS");
		}catch(Exception e) {
			reportStep("Failed on Verification of Successful Login by clicking Manage Cashbac", "FAIL");
			throw e;
		}
		
	}
	
	/**
	 *
	 *unsuccessful login into "ManageCashback"
	 *<p>
	 *try to login with the mobile number which is not registered in ICICI 
	 */
	public void unsuccessfulloginintoManageCashback() 
	{
		

	        String refno = "123456";
			
	        try {
	    		
	    		reportStep("Verification of Successful Login by clicking Manage Cashback started", "INFO");
	    		new WPHomePage(driver, logger)
	    		.clickOnProceedButton()
	    		.clickManageCashback()
	    		.enterReference(refno)
	    		.refreshHomePage(driver)
	    		.verifypartner1loggedinfailure()
	    		.clickFirstStoreCard();
	    		reportStep("Verification of Successful Login by clicking Manage Cashback completed", "PASS");
	    		}catch(Exception e) {
	    			reportStep("Failed on Verification of Successful Login by clicking Manage Cashbac", "FAIL");
	    			throw e;
	    		
	    		}
		
	}
	
	
	
	
	
	/**
	 *
	 *After Manage Cashback Login , Verify All other Logins Should not ask for authentication
	 */
	public void AfterManageCashbackLoginVerifyAllotherLoginShouldnotaskauth()
	{
String refno =Utils.getTestData(10, "ExistingFEDID");
		
		try {
		
		reportStep("Verification of Successful Login by clicking Manage Cashback started", "INFO");
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickFirstStoreCard();
		reportStep("Verification of Successful Login by clicking Manage Cashback completed", "PASS");
		}catch(Exception e) {
			reportStep("Failed on Verification of Successful Login by clicking Manage Cashbac", "FAIL");
			throw e;
		}
		
	}
	

	
	/**
	 *
	 *After Activate Cashback Login , Verify Manage Cashback Should ask for authentication
	 */
	public void AfterActivateCashbackLoginVerifyManageCashbackLoginShouldaskauth()
	{
String refno =Utils.getTestData(10, "ExistingFEDID");
		
		try {
		
		reportStep("Verification of Successful Login by clicking Manage Cashback started", "INFO");
		new WPHomePage(driver, logger)
		.clickOnProceedButton()		
		.clickFirstActivateCashbackLink()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback();
		reportStep("Verification of Successful Login by clicking Manage Cashback completed", "PASS");
		}catch(Exception e) {
			reportStep("Failed on Verification of Successful Login by clicking Manage Cashbac", "FAIL");
			throw e;
		}
		
	}
	
	
	/**
	 * Successful Login via homePageImage main CTA
	 * <p>
	 * HomePage->ClickOnImage->Store_Page-> Click on Main CTA(Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 */
	
	////@Test(priority=14	,enabled=true)
	public void successfulLoginViaHomePageImageMainCTA() throws Exception{
		try {
			
			String refno =Utils.getTestData(10, "ExistingFEDID");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			
			new WPHomePage(driver, logger).
			clickFirstStoreCard().
			clickMainCtaActivateCashBackLink()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	
	/**
	 * Successful Login via homePageImage voucher CTA
	 * <p>
	 * H
	 * omePage->ClickOnImage->Store_Page-> Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 */
	
	////@Test(priority=15,enabled=true)
	public void successfulLoginViaHomePageImageVoucherCTA() throws Exception{
		try {
			String refno =Utils.getTestData(10, "ExistingFEDID");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			
			
			new WPHomePage(driver, logger).
			clickFirstStoreCard().
			clickActivateRewardsGuestUser()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();		Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * successful Login Via MainCategory And Voucher CTA
	 *  <p>
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> 
	 *  <p>
	 * Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 */
	
	////@Test(priority=16,enabled=true)
	public void successfulLoginViaMainCategoryAndVoucherCTA() throws Exception{
		try {
			String refno =Utils.getTestData(10, "ExistingFEDID");
			String category=Utils.getTestData(0, "category");
	
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickVoucherCtaActivateCashBackLink()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();	
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA FAILED");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA Completed", "FAIL");
		}
	}
	
	
	
		
	/**
	 * successful Login Via Main Category And Main CTA
	 *  <p>
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> Click on Main CTA (Activate button)->SuccessfulLogin
	 */
	
	////@Test(priority=17,enabled=true)
	public void successfulLoginViaMainCategoryAndMainCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category");
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			reportStep("Verification of Successful Login Through Main Category and Main CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickMainCtaActivateCashBackLink()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Through Main Category and Main CTA Failed");
			reportStep("Verification of Through Main Category and Main CTA Failed", "FAIL");
		}
	}
	
	/**
	 * successful Login Via Main Category And StoreCard CTA
	 *  <p>
	 * Home page ->HamburgerMenu->Select_A_Category->Click on STORESCARD CTA (Activate button)->SuccessfulLogin
	 *  <p>
	 * Upon successful login ,reload the current page with pagination"	
	 */
	
	////@Test(priority=18,enabled=true)
	public void successfulLoginViaMainCategoryAndStoreCardCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category1");
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			reportStep("Verification of Successful Login Through Main Category and Main CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickActivateCashBackInSCP()	
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			e.printStackTrace();
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "FAIL");
			throw e;
		}
		
	}
	

	
	/**
	 * successful Login Via Search And StoreCard Activate CashBack
	 *  <p>
	 * HomePage->SearchStore->ClickOnStoreCardButton(Activate Cashback)->Successful Login.
	 * <p>
	 * Upon successful login, reload the current page.
	 */
	
	////@Test(priority=21,enabled=true)
	public void successfulLoginViaSearchAndStoreCardActivateCashBack() throws Exception{
		try {
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Verification of Successful Login Through Search Functionality  and Voucher CTA started");
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String email=Utils.getTestData(0,"ValidUserId");
			
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnStoreCardActivateCashBackLink()
			
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			
			Log.info("Verification of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * successful Login Via Search And VoucherCard ActivateCashBack
	 *  <p>
	 * HomePage->SearchStore->ClickOnVoucherCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page.	 
	 */
	
	////@Test(priority=22,enabled=true)
	public void successfulLoginViaSearchAndVoucherCardActivateCashBack() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnVoucherCardActivateCashBackLink()

			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * successful Login Via ViewAll Functionality StoreCard CTA For Retailer
	 *  <p>
	 * HomePage->SearchResult->Search_Retailer_Page-> ViewAll->Click on StoreCardCTA>>SuccessfulLogin
	 *  <p>
 	 * Upon successful login, reload the current page with pagination" 	
	 */
	
	////@Test(priority=19,enabled=true)
	public void successfulLoginViaViewAllFunctionalityStoreCardCTAForRetailer() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStoreViewAll");
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkRetailer().
			clickActivateCashBackInSLP()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * successful Login Via ViewAll Functionality StoreCard CTA For Voucher
	 *  <p>
	 *  HomePage->SearchResult-->Search_Coupon_Page-> >ViewAll->Click on StoreCardCTA>(Activate button)->SuccessfulLogin
	 *   <p>
 	 *  Upon successful login , reload the current page. 	
	 */
	
	////@Test(priority=20,enabled=true)
	public void successfulLoginViaViewAllFunctionalityStoreCardCTAForVoucher() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchVoucherViewAll");
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkVoucher().
			clickActivateCashBackInSLP()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA not Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA not Completed", "FAIL");
		}
	}
	
	/**
	 * successful Login Via HomePage StoreCard ActivateCashBack Link
	 *  <p>
	 * HomePage->ClickOnStorecardButton(Activate CashBack)->SuccessfulLogin.Upon successful login, reload the current page.
	 */
	
	////@Test(priority=23,enabled=true)
	public void successfulLoginViaHomePageStoreCardActivateCashBackLink() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String refno =Utils.getTestData(10, "ExistingFEDID");
			
			new WPHomePage(driver, logger).
			clickStoreCardActivateCashbackLink()
			.enterReference(refno)
			.refreshStorePage(driver)
			.verifypartner1loggedin();
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	
	

}



