
package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPAdmin;
import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPSearchResultsPage;

import testData.StoreTestData;
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

public class AddTicketPageTests extends TestSetUp {
	
	
	/**
	 * <p><strong>Navigate to Login Page and Verify Default Components</strong><dd> 
	 * Date of Transaction :<dd>
	 * Enter the Date of transaction<dd>
     * Retailer you shopped at:<dd>
     * Select retailer<dd>
     * Select Exit click and transaction Details :<dd>
     * Exit Click Time<dd>
     * Transaction ID<dd>
     * Transaction Amount<dd>
     * Earnings<dd>
     * Coupon Details<dd>
     * Status<button>
     * 
     * <strong>Missing Cashback details</strong>
     * Your Transaction ID<dd>
     * The Total Amount Paid<dd>
     * Coupon code used<dd>
     * Details of Transaction<dd>
     * Choose File<dd>
     * I have Read and understand...(checkbox)<dd>
     * Submit button<dd>
	 * <p>PreCondition: User must be guest<dd>
	 */
	
	
	@Test(priority=1)
	public void VerifyDefaultComponentsofAddTicketForm()
	{
		
		String started="Validation of default content of Missing Cashback Form----- Started";
		String completed="Validation of default content of Missing Cashback Form ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
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
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		verifyDateOfTransactionLabelIsVisible().
		verifyEnterDateOfTransactionLabelIsVisible().
		verifyRetailerYouShoppedAtLabelIsVisible().
		verifySelectExitClickAndTransactionDetailsLabelIsVisible().
		verifylblHaveMultipleClickSameRetailersLabelIsVisible().
		verifyExitClickTimeTableColumnIsVisible().
		verifyTransactionIdTableColumnIsVisible().
		verifyTransactionAmountTableListIsVisible().
		verifyEarningsTableListIsVisible().
		verifyCouponDetailsTableListIsVisible().
		verifyStatusTableListIsVisible().
		verifyEnterMissingCashbackDetailsLabelIsVisible().
		verifyYourTransactionIDIsVisible().
		verifyTotalAmountPaidLabelIsVisible().
		verifyCouponCodeUsedIsVisible().
		verifyDetailsOfTransactionLabelIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
		
	}
	
	
	/**
	 * <p><strong>Verify missing cashback calender enabled for 10 days</strong><dd> 

	 * <p>PreCondition: User must be guest<dd>
	 */
	@Test(priority=2)
	public void VerifyMissingCashbackCalenderEnabledfor10days()
	{
		
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
		/*searchForVoucherOrStore(itemToBeSearched).
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
		new WPSearchResultsPage(driver, logger).*/
		clickMyAccountLabel().
		clickMissingCashBackLink().
		clickAddTicketLink().
		Verify10daysEnabled();
		
	}
	
	
	
	/**
	 * <p><strong>When try to raise ticket for N18 store , should not be allowed by system</strong><dd> 

	 * <p>PreCondition: User must be guest<dd>
	 */
	@Test(priority=3)
	public void VerifyraisingticketforN18shouldnotbeallowed()
	{
		
		String start="Validation of Successful Adding a Ticket for Missing Cashback ----- Started";
		String completed="Validation of Successful Adding a Ticket for Missing Cashback ----- Completed";
		Log.info(start);
		reportStep(start, "INFO");
		
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String transactionID=Utils.getTestData(7, "transactionID");
		String couponCode=Utils.getTestData(7, "couponCode");
		String totalAmountPaid=Utils.getTestData(7, "amount");
		String transactionDetails=Utils.getTestData(7, "transactionDetails");
		
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickGrabDealLink(1);
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains("myntra");
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
		retrieveExitClick(driver, email);
		Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMissingCashBackLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.jpg").
		clickSubmitButton().
		verifyPresenceOfsuccessMessageSubmitTicket();
		Log.info(completed);
		reportStep(completed, "PASS");;
		
	}
	
	
	
	/**
	 * <p><strong>When try to raise ticket again for already raised record should not be allowed by system</strong><dd> 

	 * <p>PreCondition: User must be guest<dd>
	 */
	
	@Test(priority=4)
	public void VerifyRaisingticketAlreadyraisedrecordshouldnotallow()
	{
		
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
		clickMissingCashBackLink().
		clickDateOfTransactionTextBox().
		clickFourDaysBackDate().
		selectFirstRetailerDropDropDownListInMissingCashBackPage().
		clickSelectLink().
		enterTransactionId(transactionID).
		enterCouponCodeUsed(couponCode).
		enterTransactionDetails(transactionDetails).
		enterTotalAmountPaid(totalAmountPaid).
		clickChkBoxTermsAndConditions().
		uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.jpg").
		clickSubmitButton().
		verifyPresenceOfsuccessMessageSubmitTicket().
		clickCloseIconInPopUp();
		
	}
	
	
	/**
	 * <p><strong>When try to raise ticket before 72 hours, should not be allowed by system</strong><dd> 

	 * <p>PreCondition: User must be guest<dd>
	 */
	
	@Test(priority=5)
	public void VerifyRaisingticketbefore72hoursshouldnotallow()
	{
		
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
		
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickRaiseTicketLink().
		clickDateOfTransactionTextBox()
		.clickTodaysDateInDatePicker()
		.Verify72hrsErrordisplayed();
		Log.info(completed);
		reportStep(completed, "PASS");
		
	}
	
	/**
	 * This Method will verify Missing Cash back scenario in which exit id is generated by searching 
	 * Amazon Store and clicking first Activate Cash back Link. Once exit id is generated, it will raise a ticket successfully
	 * from My Earnings Page.
	 * Precondition : Exit Click Id needs to be back date. Items which a user is searching needs to be shown in Search Result Page
	 * @throws InterruptedException 
	 */
	@Test(priority=6,enabled=true)
	public void raiseATicketSuccessFullyFromMyEarningPage() throws InterruptedException {
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
		uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.jpg").
		clickSubmitButton().
		verifyPresenceOfsuccessMessageSubmitTicket();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	
	/**
	 * This Method will verify Missing Cash back scenario in which exit id is generated by searching 
	 * Amazon Store and clicking first Activate Cash back Link. Once exit id is generated, it will raise a ticket successfully
	 * from Missing CashBack Page.
	 * 
	 */
	
	@Test(priority=7,enabled=true)
		public void raiseATicketSuccessFullyFromMissingCashBackPage() {
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
			try {
				new WPSearchResultsPage(driver, logger).
				clickMyAccountLabel().
				clickMissingCashBackLink().
				clickAddTicketLink().
				clickDateOfTransactionTextBox().
				clickFourDaysBackDate().
				selectFirstRetailerDropDropDownListInMissingCashBackPage().
				clickSelectLink().
				enterTransactionId(transactionID).
				enterCouponCodeUsed(couponCode).
				enterTransactionDetails(transactionDetails).
				enterTotalAmountPaid(totalAmountPaid).
				clickChkBoxTermsAndConditions().
				uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.pdf").
				clickSubmitButton().
				verifyPresenceOfsuccessMessageSubmitTicket();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.info(completed);
			reportStep(completed, "PASS");
		}
		
		
		/**
		 * This method will validate error message if user is trying to 
		 * raise ticket for a date for which no exit clik id is generated.
		 */
		@Test(priority=8,enabled=true)
		public void verifyErrorMessageWhileRaisingTicketIfNoExitIdGenerated() {
			String started="Validation of Error Message: \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us\"   in Missing Cashback Form----- Started";
			String completed="Validation of Error Message: \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us\"   in Missing Cashback Form------ Completed";
			Log.info(started);
			reportStep(started, "INFO");
			
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
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
			clickMyEarningLink().
			clickRaiseTicketLink().
			clickDateOfTransactionTextBox().
			clickTodaysDateInDatePicker().
			verifySorryWeDontSeeAnyClickErrorMsgIsVisible();
			Log.info(completed);
			reportStep(completed, "PASS");
		}
		
		
		
		
		/***
		 * Below method will validate uploading a png file less than 2 mb and then submitting ticket
		 * @throws InterruptedException 
		 */
		@Test(priority=9,enabled=true)
		public void raiseATicketSuccessFullyViaUploadingAFileLessThanTwoMB() throws InterruptedException {
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
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.png").
			clickChkBoxTermsAndConditions().
			clickSubmitButton().
			verifyPresenceOfsuccessMessageSubmitTicket();
			Log.info(completed);
			reportStep(completed, "PASS");
		}
		
				
		
		/**
		 * This method will validate raising ticket when multiple exit click ID is present.
		 * @throws InterruptedException 
		 */
		@Test(priority=10,enabled=true)
		public void validateRaisingTicketMultipleExitId() throws InterruptedException {
			String started="Validation of Successful Multiple Exit ID Functionality ----- Started";
			String completed="Validation of Successful Multiple Exit ID Functionality ----- Completed";
			Log.info(started);
			reportStep(started, "INFO");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
			String itemToBeSearched1=Utils.getTestData(7, "itemToBeSearched1");
			String itemToBeSearched2=Utils.getTestData(7, "itemToBeSearched2");
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
			searchForVoucherOrStore(itemToBeSearched1).
			clickOnVoucherCardActivateCashBack();
			Utils.switchToNewlyOpenWindow(driver);
			Utils.explicitWaitForUrlContains(itemToBeSearched1);
			Utils.closeCurrentWindow(driver);
			Utils.switchToParentWindow(driver);
			Utils.switchToNewlyOpenWindow(driver);
			exitClickId=new WPAdmin(driver, logger).
			retrieveMostRecentExitClick(driver);
			Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
			new WPSearchResultsPage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched2).
			clickOnVoucherCardActivateCashBack();
			Utils.switchToNewlyOpenWindow(driver);
			Utils.explicitWaitForUrlContains(itemToBeSearched2);
			Utils.closeCurrentWindow(driver);
			Utils.switchToParentWindow(driver);
			Utils.switchToNewlyOpenWindow(driver);
			exitClickId=new WPAdmin(driver, logger).
			retrieveMostRecentExitClick(driver);
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
			verifyPresenceOfinfoMessageQuerySubmittedSuccessFully();
			//.		clickCloseIconInPopUp();
			Log.info(completed);
			reportStep(completed, "INFO");
		}
		
		
		/**
		 * Validate raise ticket same date different retailer.
		 * @throws InterruptedException 
		 */
		
		@Test(priority=11,enabled=true)
		public void validateRaiseTicketSameDateSameRetailer() throws InterruptedException {
			
			String started="Validation of Successful Multiple Exit ID Functionality ----- Started";
			String completed="Validation of Successful Multiple Exit ID Functionality ----- Completed";
			Log.info(started);
			reportStep(started, "INFO");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
			String itemToBeSearched1=Utils.getTestData(7, "itemToBeSearched1");
			String itemToBeSearched2=Utils.getTestData(7, "itemToBeSearched2");
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
			searchForVoucherOrStore(itemToBeSearched).
			clickOnVoucherCardActivateCashBack();
			Utils.switchToNewlyOpenWindow(driver);
			Utils.explicitWaitForUrlContains(itemToBeSearched);
			Utils.closeCurrentWindow(driver);
			Utils.switchToParentWindow(driver);
			Utils.switchToNewlyOpenWindow(driver);
			exitClickId=new WPAdmin(driver, logger).
			retrieveMostRecentExitClick(driver);
			Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
			new WPSearchResultsPage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnVoucherCardActivateCashBack();
			Utils.switchToNewlyOpenWindow(driver);
			Utils.explicitWaitForUrlContains(itemToBeSearched);
			Utils.closeCurrentWindow(driver);
			Utils.switchToParentWindow(driver);
			Utils.switchToNewlyOpenWindow(driver);
			exitClickId=new WPAdmin(driver, logger).
			retrieveMostRecentExitClick(driver);
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
			verifyPresenceOfinfoMessageQuerySubmittedSuccessFully();
			//.		clickCloseIconInPopUp();
			Log.info(completed);
			reportStep(completed, "INFO");
			
			
			
		}
		
		/**
		 * Validate raise ticket same date same retailer.
		 * @throws InterruptedException 
		 */
		
		@Test(priority=12,enabled=true)
		public void ValidateraiseticketSameDateDifferentRetailer() throws InterruptedException {
			
			String started="Validation of Successful Multiple Exit ID Functionality ----- Started";
			String completed="Validation of Successful Multiple Exit ID Functionality ----- Completed";
			Log.info(started);
			reportStep(started, "INFO");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
			String itemToBeSearched1=Utils.getTestData(7, "itemToBeSearched1");
			String itemToBeSearched2=Utils.getTestData(7, "itemToBeSearched2");
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
			searchForVoucherOrStore(itemToBeSearched1).
			clickOnVoucherCardActivateCashBack();
			Utils.switchToNewlyOpenWindow(driver);
			Utils.explicitWaitForUrlContains(itemToBeSearched1);
			Utils.closeCurrentWindow(driver);
			Utils.switchToParentWindow(driver);
			Utils.switchToNewlyOpenWindow(driver);
			exitClickId=new WPAdmin(driver, logger).
			retrieveMostRecentExitClick(driver);
			Utils.backDatingAnExitId(driver, exitClickId, Utils.getTestData(8, "partnerType"));
			new WPSearchResultsPage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched2).
			clickOnVoucherCardActivateCashBack();
			Utils.switchToNewlyOpenWindow(driver);
			Utils.explicitWaitForUrlContains(itemToBeSearched2);
			Utils.closeCurrentWindow(driver);
			Utils.switchToParentWindow(driver);
			Utils.switchToNewlyOpenWindow(driver);
			exitClickId=new WPAdmin(driver, logger).
			retrieveMostRecentExitClick(driver);
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
			verifyPresenceOfinfoMessageQuerySubmittedSuccessFully();
			//.		clickCloseIconInPopUp();
			Log.info(completed);
			reportStep(completed, "INFO");
					
				
		}
				
		
		
		
		/**
		 * This method will validate error if Size of a file is more than 2 MB while raising ticket.
		 * Also this will verify error message in case User is not clicking Terms and Condition Check Box
		 * <p>
	     * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-10">Raise JIRA Issue Here</a>
		 */
		@Test(priority=13,enabled=true)
		public void validateErrorIfSizeIsMoreThanTwoMB() {
			String started="Validation of Errors If Size of a File is More than Two MB Functionality ----- Started";
			String completed="Validation of Errors If Size of a File is More than Two MB Functionality----- Completed";
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
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_more_than_2mb.jpeg").
			clickChkBoxTermsAndConditions().
			clickSubmitButton().
			verifyErrorInUploadIsVisible().
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.png").
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_more_than_2mb.jpg").
			clickSubmitButton().
			verifyErrorInUploadIsVisible().
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.png").
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_more_than_2mb.pdf").
			clickSubmitButton().
			verifyErrorInUploadIsVisible().
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.png").
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_More_than_2mb.png").
			clickSubmitButton().
			verifyErrorInUploadIsVisible().
			uploadFile(System.getProperty("user.dir")+"/src/main/resources/missingCashBackFiles/test_less_than_2mb.png").
			clickChkBoxTermsAndConditions().
			clickSubmitButton().
			verifyPleaseAcceptTermsErrorMsgIsVisible();
			Log.info(completed);
			reportStep(completed, "INFO");
		}
		
		
		
		/**
		 * Missing Cashback Flag Validation
		 
		 * <p>
	     * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-10">Raise JIRA Issue Here</a>
		 */
		@Test(priority=14,enabled=true)
		public void MissingCashbackFlagValidation() {
			
			
			String started="Validation of Successful Adding a Ticket for Missing Cashback ----- Started";
			String completed="Validation of Successful Adding a Ticket for Missing Cashback ----- Completed";
			Log.info(started);
			reportStep(started, "INFO");
			
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			String itemToBeSearched=Utils.getTestData(7, "MCB");
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
				clickMissingCashBackLink().
				clickAddTicketLink().
				clickDateOfTransactionTextBox().
				clickFourDaysBackDate().
				verifySorryWeDontSeeAnyClickErrorMsgIsVisible();
			
		}
		

		
		/**
		 * Missing Cashback Order ID Validation
		 
		 * <p>
	     * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-10">Raise JIRA Issue Here</a>
		 */
		@Test(priority=15,enabled=true)
		public void MissingCashbackOrderIDValidation() {
			
			String started="Validation of Successful Adding a Ticket for Missing Cashback ----- Started";
			String completed="Validation of Successful Adding a Ticket for Missing Cashback ----- Completed";
			String fail = "Order ID format verification is failed";
			Log.info(started);
			reportStep(started, "INFO");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			String itemToBeSearched=Utils.getTestData(7, "OrderIDFormat");
			String transactionID=Utils.getTestData(7, "transactionID");
			String couponCode=Utils.getTestData(7, "couponCode");
			String totalAmountPaid=Utils.getTestData(7, "amount");
			String transactionDetails=Utils.getTestData(7, "transactionDetails");
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
				verifyPresenceOfOrderIDFormat();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Log.info(fail);
				reportStep(fail, "INFO");
			}
		}




}
