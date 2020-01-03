package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 *This class will verify various login and error scenario in WordPress.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-20">Raise JIRA Issue Here</a>
 */

public class SearchPageTests extends TestSetUp {
	
	
	

	/**
	 *Verify successful search result in store section
	 */
	@Test(priority=1,enabled=true)
	public void verifySuccessfulSearchResultinStoreSection()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched)
		.clickOnStoreImage(itemToBeSearched);
		
	}
	
	/**
	 *Verify successful search result in coupon and offer section
	 */
	@Test(priority=2,enabled=true)
	public void verifySuccesfulSearchResultinCouponAndOffer()
	{
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched)
		.clickOnVoucherCardActivateCashBack();
		
		
	}
	
	/**
	 *Verify search result when there is no coupon for the store
	 */
	@Test(priority=3,enabled=true)
	public void verifySearchResultinCouponAndOfferWhenNoCouponforStore()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched)
		.clickOnVoucherCardActivateCashBack();
		
	}
	
	/**
	 *Verify search result when both store and coupon not available
	 */
	@Test(priority=4,enabled=true)
	public void verifySearchResulttextWhenbothCouponandStoreNotAvailable()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= "fsfsfsdfsdf";
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		verifyNoresultsFound(itemToBeSearched);

	}
	
	/**
	 *Verify search result when no coupon available
	 */
	@Test(priority=5,enabled=true)
	public void verifySearchResultWhenNOCouponAvailable()
	{
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= Utils.getTestData(7, "novoucher");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		verifyNoCouponsFound(itemToBeSearched);
		
	}
	
	/**
	 *Verify search result by clicking view all stores
	 */
	@Test(priority=6,enabled=true)
	public void verifyViewAllStores()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= "a";
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		clickViewAllLinkRetailer();
		
	}
	
	/**
	 *Verify search result by clicking view all coupons
	 */
	@Test(priority=7,enabled=true)
	public void verifyViewAllCoupons()
	{
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= "a";
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		clickViewAllLinkVoucher();
		
		
		
	}
	
	
	
	/**
	 *Verify store image in search result
	 */
	@Test(priority=8,enabled=true)
	public void verifyImageinSearchResult()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched)
		.clickOnVoucherCardActivateCashBack();
		
		
	}
	
	/**
	 *Verify store description in search result
	 */
	@Test(priority=9,enabled=true)
	public void verifyStoreDescriptioninSearchResult()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		VerifySearchResultShortdesc(itemToBeSearched);
		
		
	}
	
	/**
	 *Verify ExpiryTextinStoreDescription
	 */
	@Test(priority=10,enabled=true)
	public void VerifyExpireText()
	{
		
	}

	
	/**
	 *Verify Searchbox PlaceHolder value
	 */
	@Test(priority=11,enabled=true)
	public void VerifySearchboxPlaceholdervalue()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= "a";
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		verifyplaceholdervalue();
		
		
	}
	/**
	 *Verify suggestions in search Result Page
	 */
	@Test(priority=12,enabled=true)
	public void VerifysuggestionsinSearchResultPage()
	{
		

		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= "a";
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched)
		.VerifySearchResultssuggestione(itemToBeSearched);
		
	}
	
	/**
	 *Verify results based on the flag in admin
	 */
	
	@Test(priority=13,enabled=true)
	public void VerifySearchResultFlag()
	{
		
		String started="Validation of Successful View Ticket Functionality ----- Started";
		String completed="Validation of Successful View Ticket Functionality ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched= Utils.getTestData(7, "SearchFlag");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched)
		.VerifySearchResultsAfterStoreInactive(itemToBeSearched);
	
		
		
	}
	
	




}
