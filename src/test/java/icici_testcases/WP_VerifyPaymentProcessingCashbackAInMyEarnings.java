package icici_testcases;

import org.testng.annotations.Test;

import pageobjects.WPAdmin;
import pageobjects.WPHomePage;
import pageobjects.WPMyEarningsPage;
import pageobjects.WPPaymentPage;
import pageobjects.WPSearchResultsPage;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *	This class will verify various successful Payment Processing Scenario.
 *  This class will also verify negative scenarios in which user will not be able to claim cashback and rewards.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-15">Raise JIRA Issue Here</a>
 *
 */

public class WP_VerifyPaymentProcessingCashbackAInMyEarnings extends TestSetUp{
	
	/**
	 * This method will verify Successful Payment processing 
	 * for a New User using Cash back Payment Processing method.
	 * Precondition:New User: User should have Rs 250 Confirm Cashback.Threashhold limit should be Rs 250.
	 */
	@Test(priority=1,enabled=true)
	public void verifySuccessfulCashBackPaymentForNewUser() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New User .---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon().
		verifyPresenceOfRequestedStatusLabel();
		Utils.clearCashbackRewards(driver, email); 
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		verifyPresenceOfPaidStatusLabel();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing by clicking Request cash back Payment button for already registered user.
	 * Precondition : Registered User: User should have Rs 250 Confirm Cashback.Threashhold limit should be Rs 250.
	 */

	@Test(priority=2,enabled=true)
	public void verifySuccessfulCashBackPaymentForAlreadyRegisteredUser() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- Started", "INFO");
		String otp="";
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType="Cashback";
		String refno=Utils.getTestData(10, "ExistingFEDID");
		String email="CK"+refno+"@pouringpounds.com";
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		WPPaymentPage paymentPage = new WPHomePage(driver, logger)
				.clickOnProceedButton()
				.clickManageCashback()
				.enterReference(refno)
				.refreshHomePage(driver)
				.verifypartner1loggedin()
				.clickManageCashback().
				clickMyEarningLink().
				addCashbackRewards(amount, email, cashBackType).
				clickRequestCashbackPaymentButton().
				clickOnlyRedeemCashBackEarningsLink().
				clickGetPaidButton();
		otp=Utils.getOTPCode(refno, driver);
		paymentPage.
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user is will not be able to Process Cash back Payment Using If he has cash back less
	 * than Threshold limit. Set Threshold= 250 & Cash back amount =249
	 * Precondition : User should have Rs 249 Confirm Cashback. Threashhold limit should be Rs 250. User  Clicks Request Cashback Payment
	 */
	@Test(priority=3,enabled=true)
	public void verifyUserIsUnableToProcessCashbackIfCashBackIsLessThanThresholdLimit() {
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started", "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED", "PASS");
	}

	
	/**
	 * This method will verify existing user is able to donate Charity
	 * using Cash back Payment Processing method.
	 * Precondtion : Rewards  earned more than or equal to threshold limit.
	 */

	@Test(priority=16,enabled=true)
	public void verifyUserIsAbleToDonateCashbackToCharity() {
		Log.info("Validation of Charity Donation via Rewards.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New User .---- Started", "INFO");
		String otp="";
		String charityName=Utils.getTestData(6, "charityName");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String sortCode=Utils.getTestData(6, "sortCode");
		String bankName=Utils.getTestData(6, "bankName");
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigate().
		selectPaymentMethod("UK Bank Payment (BACS)").
		enterBankAccountNumber(bankAccountNumber).
		enterNameOfAccountHolder(accountHolderName).
		enterSortCodeBacs(sortCode).
		enterBankNameBacs(bankName).
		selectCharityName(charityName).
		enterCharityAmount(amount).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulDonation();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 *  This method will Verify user is able to Process Payment Using BACS Bank Payment Mode.
	 *  Precondtion : Rewards  earned more than or equal to threshold limit.
	 */
	@Test(priority=15,enabled=true)
	public void verifyUserIsAbleToProcessPaymentUsingBacsUKBank() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String sortCode=Utils.getTestData(6, "sortCode");
		String bankName=Utils.getTestData(6, "bankName");
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		selectPaymentMethod("UK Bank Payment (BACS)").
		enterBankAccountNumber(bankAccountNumber).
		enterNameOfAccountHolder(accountHolderName).
		enterSortCodeBacs(sortCode).
		enterBankNameBacs(bankName).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- COMPLETED", "PASS");
	}

	/**
	 *  This method will Verify user is able to Process Payment Using Paypal Payment Mode.
	 */
	@Test(priority=14,enabled=true)
	public void verifyUserIsAbleToProcessPaymentUsingPaypalPaymentMode() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		selectPaymentMethod("Paypal").
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user is able to Process Payment Using Flipkart Gift Card.
	 * Precondition : User should have Rs 300 as cashback and Rs 300 as Rewards
	 */
	@Test(priority=10,enabled=true)
	public void verifyUserIsAbleToProcessPaymentUsingFlipkartGiftCardPaymentMode() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		selectPaymentMethod("Paypal").
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- COMPLETED", "PASS");
	}

	
	
	@Test(priority=9,enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageFromPaymentLeftNavigationForAlreadyRegisteredUser() {
		Log.info("Validation of Payment Request is Already Pening Left Navigation via Payment---- Started");
		reportStep("Validation of Payment Request is Already Pening Left Navigation via Payment---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickPaymentLinkLeftNavigationPanel().
		verifyPresenceMessagePaymentRequestAlreadyPending().
		clickClosePopUpIcon();
		Log.info("Validation of Payment Request is Already Pening Left Navigation via Payment.---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pening Left Navigation via Payment.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click "REQUEST CASHBACK PAYMENT" Link in My Earning Panel.
	 */

	@Test(priority=8,enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageByClickingOnResquestCashbackPayment() {
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- Started");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(refno, driver)).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		verifyPresenceMessagePaymentRequestAlreadyPending().
		clickClosePopUpIcon();
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- COMPLETED", "PASS");
	}

	

	/**
	 * This method will verify error message pop up when a new user clicks on "REQUEST CASHBACK PAYMENT" button.
	 * Rewards +Cash back less than Threshold. 
	 * precondition: User should Sign Up freshly
	 */
	@Test(priority=11,enabled=true)
	public void verifyPopUpErrorMessageWhenUserClickOnRequestCashBackPaymentAndUserHaveLessThanThreshold() {
		String start="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST CASHBACK PAYMENT ---- Started";
		String completed="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST CASHBACK PAYMENT ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	

	/**
	 * This method will Verify status and other details of Cash back Type from Pending to Confirmed using exit click id
	 * @throws Exception 
	 */
	@Test(priority=26,enabled=true)
	public void verifyStatusOfCashbackPendingAndConfirmedFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Cash back from Pending to Confirmed ----- Started";
		String completed="Validation of status of Cash back from Pending to Confirmed ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		searchForVoucherOrStore(itemToBeSearched).
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedCashBackType().
		verifyTextOfPendingCashBackAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToConfirm(driver,exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		verifyTextOfYourTotalCashBackEarningsAmountInMyEarning().
		verifyTextOfAvailableCashBackAmountAtTopInMyEarning().
		verifyPresenceOfConfirmedStatusLabel().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType().
		verifyTextOfPendingCashBackAmountAtTopInMyEarning();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will Verify status and other details of Cash back Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(priority=27,enabled=true)
	public void verifyStatusOfCashbackPendingAndCancelledFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Cash back from Pending to Cancelled ----- Started";
		String completed="Validation of status of Cash back from Pending to Cancelled ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		
		searchForVoucherOrStore(itemToBeSearched).
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedCashBackType().
		verifyTextOfPendingCashBackAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToCancel(driver,exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		verifyPresenceOfCancelledStatusLabel().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	
}
