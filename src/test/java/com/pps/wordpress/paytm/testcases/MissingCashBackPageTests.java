package com.pps.wordpress.paytm.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPAdmin;
import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPMissingTicket;
import com.pps.wordpress.pages.WPSearchResultsPage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *
 *This Test Case will contains various methods both positive and negative related with Missing Cash back.
 *It will take help of an external Jar known as admin Jar for fetching exit ID
 *Pre-requisite: Amazon Store needs to be present on an environment where scripts will be executed.
 *
 */
public class MissingCashBackPageTests extends TestSetUp{
	
	
	/**
	 * <p><strong>Navigate to Login Page and Verify Default Components</strong><dd> 
	 * Log In /Sign Up(Link))<dd>
	 * How it Works(Link)<dd>
     * Search Retailer or Coupons(Input box)<dd>
     * Account Settings<dd>
     * My Earnings<dd>
     * Payments<dd>
     * Missing Cashback<dd>
     * Hamburger Menu<dd>
     * Static Text<dd>
     * “I” Icon popup<dd>
     * Add Ticket button<button>
     * 
     * <strong>Ticket History Grid</strong>
     * Date
     * Retailer
     * Transaction Amount
     * Status
     * Info

	 * <p>PreCondition: User must be guest
	 */
	
	@Test(priority=1)
	public void VerifyDefaultComponentsofMissingCashbackPageBeforeExitClick()
	{
		
		String started="Verification of default content of Missing Cashback Form before raining ticket----- Started";
		String completed="verification of default content of Missing Cashback Form before raining ticket ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		try {
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
			clickMyAccountLabel().
			clickMissingCashBackLink().
			verifyHeaderFooterFieldsPresent().
			verifyMissingcashbackdefaultcomponentsBeforeRaisningTicketPresent();
			reportStep(completed, "pass");
		} catch (Exception e) {
			reportStep("verification of default content of Missing Cashback Form before raining ticket failed", "fail");
		}
	}
	
	

	
	
	
	/**
	 * <p><strong>Navigate to view ticket form and Verify Default Components</strong><dd> 
	 *  View Ticket popup
	 *  Date of Query
	 *  Merchant Name
	 *  Transaction Amount
	 *  Transaction Reference
	 *  Coupon code used
	 *  Purchase Details
	 *  Ticket Status
	 *  Last Status Update
	 *  Have Something to Tell (Text Area Box
	 *  Submit Button


	 * <p>PreCondition: User must be guest
	 */
	@Test(priority=2)
	public void VerifyDefaultComponentsofViewTicketForm()
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
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
		retrieveExitClick(driver, email);
		Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		clickSubmitButton().
		clickCloseIconInPopUp().
		clickViewTicketLink().
		enterInReplyTextArea().
		clickSubmitButtonForReply().
		verifyPresenceOfinfoMessageQuerySubmittedSuccessFully().
		clickCloseIconInPopUp();
		Log.info(completed);
		reportStep(completed, "PASS");
		
	}
	
	
	
	/**
	 * <p><strong>Verify pagination of ticket history</strong><dd> 
	 * <p>PreCondition: User must be guest
	 */
	@Test(priority=3)
	public void VerifyPaginationinMissingCashbackPage
	()
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
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
		retrieveExitClick(driver, email);
		Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		clickSubmitButton().
		clickCloseIconInPopUp().
		clickViewTicketLink().
		enterInReplyTextArea().
		clickSubmitButtonForReply().
		verifyPresenceOfinfoMessageQuerySubmittedSuccessFully().
		clickCloseIconInPopUp();
		Log.info(completed);
		reportStep(completed, "PASS");
		
	}
	
	
	

	

	

	/**
	 * This method will verify status of missing ticket is changed to "Sent To Retailer" and then
	 * status of the same ticket getting changed to Resolved.
	 * @throws InterruptedException 
	 */
	@Test(priority=4,enabled=true)
	public void verifyPhasesOfMissingCashBackTicketsForANewUser()  {
		String started="Validation of Phases of Tickets for Missing Cashback ----- Started";
		String completed="Validation of Phases of Tickets for Missing Cashback ----- Completed";
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
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
		retrieveExitClick(driver, email);
		Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		clickSubmitButton().
		clickCloseIconInPopUp().
		verifyPresenceOfReceivedStatus();
		Utils.switchToNewlyOpenWindow(driver);
		
		new WPAdmin(driver, logger).
		changeStatusMissingCashBackTicketToSentToRetailer(driver, exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMissingTicket(driver, logger).
		verifyPresenceOfSentToRetailerStatus();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changeStatusMissingCashBackTicketToResolved(driver);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMissingTicket(driver, logger).
		verifyPresenceOfResolvedStatus();
		//Log.info(completed);
		//reportStep(completed, "PASS");
	}

	
	/**
	 * This method will validate value of Date, Retailer Name, Transaction Amount, etc of a ticket raised
	 * in Missing CashBack Page.
	 * @throws AWTException 
	 */
	@Test(priority=5,enabled=true)
	public void validateValuesOfDateRetailerNameTransactionAmountInMissingCashbackPage() throws AWTException {
		String started="Validation of Successful Adding a Ticket for Missing Cashback ----- Started";
		String completed="Validation of Successful Adding a Ticket for Missing Cashback ----- Completed";
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
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
		retrieveExitClick(driver, email);
		Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/testLessThan2MB.jpeg").
		clickSubmitButton().
		clickCloseIconInPopUp().
		verifyValueOfDate(Utils.todaysDateDdMmmYyyy()).
		verifyNameOfRetailer(Utils.getTestData(7, "retailerName")).
		verifyTransactionAmountValue(totalAmountPaid);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * This method will validate View Ticket Summary functionality and User will send a query
	 * in Missing CashBack Page.
	 */
	@Test(priority=6,enabled=true)
	public void validateViewTicketFunctionalityInbMissingCashbackPage() {
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
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
		retrieveExitClick(driver, email);
		Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		clickSubmitButton().
		clickCloseIconInPopUp().
		clickViewTicketLink().
		enterInReplyTextArea().
		clickSubmitButtonForReply().
		verifyPresenceOfinfoMessageQuerySubmittedSuccessFully().
		clickCloseIconInPopUp();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	
	
}
