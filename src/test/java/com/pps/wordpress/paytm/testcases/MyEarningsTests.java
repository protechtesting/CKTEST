package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPAdmin;
import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPMyEarningsPage;
import com.pps.wordpress.pages.WPPaymentPage;
import com.pps.wordpress.pages.WPSearchResultsPage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class MyEarningsTests extends TestSetUp {

	/**
	 * Navigation to My earning Page and verify default components Log In /Sign
	 * Up(Link) How it Works(Link) Search Retailer or Coupons(Input box) Account
	 * Settings My Earnings Payments Missing Cashback Hamburger Menu
	 *
	 * TOTAL CASHBACK EARNED (Static Text) Paid Cashback (Label) Pending
	 * Cashback(Label) Available for Payment(Label)
	 *
	 * TOTAL REWARDS EARNED(Static Text) Paid Cashback(Label) Pending
	 * Cashback(Label) Available for Payment(Label)
	 *
	 * Cashback Earnings (Tab) Your Total Cashback Earnings (Static Text) Request
	 * Cashback Payment (Button) Request Rewards Payment(Button) Missing
	 * Cashback?(Static Text) RAISE TICKET button Static text - There are no
	 * cashback earnings.
	 *
	 * Rewards Earnings (Tab) Your Total Rewards Earnings (Static Text) Request
	 * Rewards Payment (Button) Request Rewards Payment(Button) Missing
	 * Rewards?(Static Text) RAISE TICKET button Static text - There are no Rewards
	 * earnings.
	 * 
	 * 
	 * 
	 * 
	 * Also it will verify label of "TOTAL CASHBACK EARNED" and "TOTAL REWARDS
	 * EARNED" link in the header section
	 * <p>
	 * {@link} <a href=
	 * "https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-8">Raise
	 * JIRA Issue Here</a>
	 */

	@Test(priority = 1, enabled = true)
	public void verifynavigationtoMyEarningsPageVerifyDefaultComponents() {

	}

	/**
	 * This method will validate "TOTAL CASHBACK EARNED" and "TOTAL REWARDS EARNED"
	 * link can be expanded and collapsed. Also it will verify label of "TOTAL
	 * CASHBACK EARNED" and "TOTAL REWARDS EARNED" link in the header section
	 * <p>
	 * {@link} <a href=
	 * "https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-8">Raise
	 * JIRA Issue Here</a>
	 */

	@Test(priority = 2, enabled = true)
	public void verifyTotalEarningsEarnedAndTotalCashbackEarnedCanbeExpandedAndCollapsed() {
		String start = "Validation of \"TOTAL CASHBACK EARNED\" and \"TOTAL REWARDS EARNED\" link of Header Section My Earning Page Started";
		String completed = "Validation of \"TOTAL CASHBACK EARNED\" and \"TOTAL REWARDS EARNED\" link of Header Section My Earning Page Completed";
		Log.info(start);
		reportStep(start, "INFO");
		String email = Utils.getTestData(2, "ValidUserId");
		String password = Utils.getTestData(2, "password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email);
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().enterEmailDuringSignIn(email)
				.enterPasswordDuringSignIn(password).clickOnSignInButton().clickMyAccountLabel().clickMyEarningLink()
				.verifyTotalCashBackEarnedHeaderLinkIsExpanded().verifyTotalRewardsEarnedHeaderLinkIsExpanded()
				.clickTotalCashBackEarnedHeaderLink().clickTotalRewardsEarnedHeaderLink()
				.verifyTotalCashBackEarnedHeaderLinkIsCollapsed().verifyTotalRewardsEarnedHeaderLinkIsCollapsed()
				.clickTotalCashBackEarnedHeaderLink().clickTotalRewardsEarnedHeaderLink()
				.verifyTotalCashBackEarnedHeaderLinkIsExpanded().verifyTotalRewardsEarnedHeaderLinkIsExpanded();
		Log.info(completed);
		reportStep(completed, "INFO");
	}

	/**
	 * This method will validate default content on My Earnings Label for a
	 * registered user. It will include validation of Paid Cahback, Paid Rewards,
	 * Pending Cashback, Pending Rewards, Available for Payment Cashback, Available
	 * for Payment Rewards, Your Total Earnings, etc..
	 */
	@Test(priority=3,enabled=true)
	public void verifyDefaultConetentsOfMyEarningsLeftNavPage() {
		String start = "Validation of default content of My Earning Page in left Navigation Page for existing user Started";
		String completed = "Validation of default content of My Earning Page in left Navigation for existing user Page Completed";
		String amount = Utils.getTestData(6, "thresholdAmount");
		String cashBackType = Utils.getTestData(6, "cashBackType");
		String RewardsType = Utils.getTestData(6, "RewardsType");

		Log.info(start);
		reportStep(start, "INFO");
		String email = Utils.getTestData(0, "ValidUserId");
		String password = Utils.getTestData(0, "ValidPassword");
		reportStep("Verification of Successful Login started", "PASS");
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().enterEmailDuringSignIn(email)
				.enterPasswordDuringSignIn(password).clickOnSignInButton().clickMyAccountLabel().clickMyEarningLink()
				.verifyPresenceOfPaidCashbackHeaderSection().verifyPresenceOfPaidRewardsHeaderSection()
				.verifyPresenceOfPendingCashbackHeaderSection().verifyPresenceOfPendingRewardsHeaderSection()
				.verifyPresenceOfAvailableForPaymentCashbackHeaderSection()
				.verifyPresenceOfAvailableForPaymentRewardsHeaderSection().verifyPresenceOfTotalCashbackEarnings()
				.addCashbackRewards(amount, email, cashBackType).addCashbackRewards(amount, email, cashBackType)
				.addCashbackRewards(amount, email, cashBackType).addCashbackRewards(amount, email, cashBackType)
				.addCashbackRewards(amount, email, cashBackType).addCashbackRewards(amount, email, cashBackType)
				.verifyPresenceOfCashbackShowMoreLink().verifyPresenceOfMissingCashbackLabel().clickTabRewardEarnings()
				.verifyPresenceOfMissingRewardsLabel().addCashbackRewards(amount, email, RewardsType)
				.addCashbackRewards(amount, email, RewardsType).addCashbackRewards(amount, email, RewardsType)
				.addCashbackRewards(amount, email, RewardsType).addCashbackRewards(amount, email, RewardsType)
				.addCashbackRewards(amount, email, RewardsType).verifyPresenceOfTotalRewardEarnings().

				verifyPresenceOfRewardShowMoreLink();

		Log.info(completed);
		reportStep(completed, "INFO");
	}

	/**
	 * This method will verify Show More Functionality by initially counting number
	 * of rows under Cashback Earning Tab then it will click Show More Link under
	 * this tab and count number of rows. If Number of rows after clicking Show more
	 * is greater than initial count. Show more functionality is working as
	 * expected. The same will be verified for Rewards Earnings Tab Show More.
	 * Preconditions: Atleast 6 to 7 request should be processed for the user so
	 * that Show More link is visible.
	 */
	@Test(priority=4,enabled=true)
	public void verifyShowMoreFunctionalityUnderCashBackEarningsAndRewardsEarningsTab() {
		String start = "Validation of Show More Functionality For both Cashback Earnings and Rewards Earnings Tab Started";
		String completed = "Validation of Show More Functionality For both Cashback Earnings and Rewards Earnings Tab Completed";
		Log.info(start);
		reportStep(start, "INFO");
		String email = Utils.getTestData(2, "ValidUserId");
		String password = Utils.getTestData(2, "password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email);
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().enterEmailDuringSignIn(email)
				.enterPasswordDuringSignIn(password).clickOnSignInButton().clickMyAccountLabel().clickMyEarningLink()
				.verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderCashBackEarningTab().clickTabRewardEarnings()
				.verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderRewardsEarningTab();
		Log.info(completed);
		reportStep(completed, "INFO");
	}

	/**
	 * This method will validate Month and Year drop down.
	 */
	@Test(priority=5,enabled=true)
	public void verifyMonthDropDownInMyEarningsPage() {
		String start = "Validation of presence of default component in Payment Form when a user requested Cashback payment Started";
		String completed = "Validation of presence of default component in Payment Form when a user requested Cashback payment completed";
		Log.info(start);
		reportStep(start, "INFO");
		String email = Utils.getTestData(2, "ValidUserId");
		String password = Utils.getTestData(2, "password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email);
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().enterEmailDuringSignIn(email)
				.enterPasswordDuringSignIn(password).clickOnSignInButton().clickMyAccountLabel().clickMyEarningLink()
				.verifyFirstSelectedValueInMonthYearDropDownList();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	/**
	 * This method will verify new user is will not be able to Process Cash back
	 * Payment Using If he has cash back less than Threshold limit. Set Threshold=
	 * 250 & Cash back amount =249 Precondition : User should have Rs 249 Confirm
	 * Cashback. Threashhold limit should be Rs 250. User Clicks Request Cashback
	 * Payment
	 */
	@Test(priority = 6, enabled = true)
	public void verifyUserIsUnableToProcessCashbackIfCashBackIsLessThanThresholdLimit() {
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started",
				"INFO");
		String amount = Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType = Utils.getTestData(6, "cashBackType");
		String email = Utils.generateRandomEmailId();
		String password = Utils.getTestData(1, "password");
		String mobile = Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().clickSignUpTab()
				.enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).enterEmailIDDuringSignUp(email)
				.enterPasswordSignUp(password).enterMobileNumberSignUp(mobile).clickJoinWithEmailDuringSignUp().

				enterOtpDuringSignUp(mobile).clickVerifyOTP().verifyPresenceOfMyAccountLabel().clickMyAccountLabel()
				.clickMyEarningLink().addCashbackRewards(amount, email, cashBackType)
				.clickRequestCashbackPaymentButton().verifyPresenceMessageThresholdNotReached()
				.verifyPresenceMessageUnableToProcessRequest();
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED",
				"PASS");
	}

	/**
	 * This method will verify new user is will not be able to Process Rewards
	 * Payment Request If he has Rewards less than Threshold limit. Set Threshold=
	 * 250 & Rewards amount =249 Precondition : User should have Rs 249 Confirm
	 * Cashback. Threashhold limit should be Rs 250. Click Request Rewards Payment
	 */
	@Test(priority = 7, enabled = true)
	public void verifyUserIsUnableToProcessRewardsIfRewardsIsLessThanThresholdLimit() {
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- Started");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- Started",
				"INFO");
		String amount = Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType = Utils.getTestData(6, "RewardsType");
		String email = Utils.generateRandomEmailId();
		String password = Utils.getTestData(1, "password");
		String mobile = Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().clickSignUpTab()
				.enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).enterEmailIDDuringSignUp(email)
				.enterPasswordSignUp(password).enterMobileNumberSignUp(mobile).clickJoinWithEmailDuringSignUp().

				enterOtpDuringSignUp(mobile).clickVerifyOTP().verifyPresenceOfMyAccountLabel().clickMyAccountLabel()
				.clickMyEarningLink().addCashbackRewards(amount, email, cashBackType).clickRequestRewardsPaymentButton()
				.verifyPresenceMessageThresholdNotReached().verifyPresenceMessageUnableToProcessRequest();
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- COMPLETED");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- COMPLETED",
				"PASS");
	}

	/**
	 * This method will verify Successful Payment processing for a New User using
	 * Rewards Payment Processing method. precondtion : Rewards=>250
	 */
	@Test(priority = 8, enabled = true)
	public void verifySuccessfulRewardPaymentForNewUser() {
		Log.info(
				"Validation of successful payment processing by clicking Request Rewards Payment button for New User.---- Started");
		reportStep(
				"Validation of successful payment processing by clicking Request Rewards Payment button for New User .---- Started",
				"INFO");
		String amount = Utils.getTestData(6, "thresholdAmount");
		String cashBackType = Utils.getTestData(6, "RewardsType");
		String otp = "";
		String email = Utils.generateRandomEmailId();
		String password = Utils.getTestData(1, "password");
		String mobile = Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().clickSignUpTab()
				.enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).enterEmailIDDuringSignUp(email)
				.enterPasswordSignUp(password).enterMobileNumberSignUp(mobile).clickJoinWithEmailDuringSignUp().

				enterOtpDuringSignUp(mobile).clickVerifyOTP().verifyPresenceOfMyAccountLabel().clickMyAccountLabel()
				.clickMyEarningLink().addCashbackRewards(amount, email, cashBackType)
				.clickRequestRewardsPaymentButtonToNavigateToPaymentForm().enterEmailAddress(email)
				.clickGetPaidButton();

		new WPPaymentPage(driver, logger).enterOTP(Utils.getOTPCode(mobile, driver)).clickVerifyOTPButton()
				.verifyPresenceMessageAfterSuccessfulClaimingCashback().clickClosePopUpIcon().clickTabRewardEarnings()
				.verifyPresenceOfRequestedStatusLabel();
		Utils.clearCashbackRewards(driver, email);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).clickTabRewardEarnings().verifyPresenceOfPaidStatusLabel();
		Log.info(
				"Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED");
		reportStep(
				"Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED",
				"PASS");
	}

	/**
	 * This method will verify presence of error message "A payment request from you
	 * is already Pending. This will be processed shortly. Once this is paid, you
	 * can request for another payment." User Logins and click "REQUEST REWARDS
	 * PAYMENT" Link in My Earning Panel.
	 */
	@Test(priority = 9, enabled = true)
	public void verifyPaymentRequestAlreadyPendingMessageByClickingOnRequestRewardsPayment() {
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- Started");
		reportStep(
				"Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- Started",
				"INFO");
		String amount = Utils.getTestData(6, "thresholdAmount");
		String cashBackType = Utils.getTestData(6, "cashBackType");
		String otp = "";
		String email = Utils.generateRandomEmailId();
		String password = Utils.getTestData(1, "password");
		String mobile = Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).clickOnlblSignInSignUP().clickOnlnkSignIn().clickSignUpTab()
				.enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).enterEmailIDDuringSignUp(email)
				.enterPasswordSignUp(password).enterMobileNumberSignUp(mobile).clickJoinWithEmailDuringSignUp().

				enterOtpDuringSignUp(mobile).clickVerifyOTP().verifyPresenceOfMyAccountLabel().clickMyAccountLabel()
				.clickMyEarningLink().addCashbackRewards(amount, email, cashBackType)
				.clickRequestRewardsPaymentButtonToNavigateToPaymentForm().enterEmailAddress(email)
				.clickGetPaidButton();

		new WPPaymentPage(driver, logger).enterOTP(Utils.getOTPCode(mobile, driver)).clickVerifyOTPButton()
				.clickClosePopUpIcon().addCashbackRewards(amount, email, cashBackType)
				.clickRequestRewardsPaymentButtonToNavigateToPaymentForm()
				.verifyPresenceMessagePaymentRequestAlreadyPending().clickClosePopUpIcon();
		Log.info(
				"Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- COMPLETED");
		reportStep(
				"Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- COMPLETED",
				"PASS");
	}

	/**
	 * Verify Total rewards earningsData & History Table data.
	 * This testcase Verify status and other details of Cash back Type from Pending to Confirmed using exit click id
	 * @throws Exception 
	 */
	@Test(priority=10,enabled=true)
	public void verifyStatusOfCashbackPendingAndConfirmedFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Cash back from Pending to Confirmed ----- Started";
		String completed="Validation of status of Cash back from Pending to Confirmed ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "cashBackType");
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
	 * Verify Total rewardsearningsData & History Table data.
	 * This testcase Verify status and other details of Rewardsk Type from Pending to Confirmed using exit click id
	 * @throws Exception 
	 */
	@Test(priority=11,enabled=true)
	public void verifyStatusOfRewardsPendingAndConfirmedFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Rewards from Pending to Confirmed ----- Started";
		String completed="Validation of status of Rewards from Pending to Confirmed ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "RewardsType");
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
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickTabRewardEarnings().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedRewardsType().
		verifyTextOfPendingRewardsAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToConfirm(driver,exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		clickTabRewardEarnings().
		verifyPresenceOfConfirmedStatusLabel().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfYourTotalRewardsEarningsAmountInMyEarning().
		verifyTextOfAvailableRewardsAmountAtTopInMyEarning().
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	


	/**
	 * This testcase Verify status and other details of Cash back Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(priority=12,enabled=true)
	public void verifyStatusOfCashbackPendingAndCancelledFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Cash back from Pending to Cancelled ----- Started";
		String completed="Validation of status of Cash back from Pending to Cancelled ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).clickJoinWithEmailDuringSignUp().
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



	/**
	 * This testcase Verify status and other details of Rewards Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(priority=13,enabled=true)
	public void verifyStatusOfRewardsPendingAndCancelledFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Rewards from Pending to Cancelled ----- Started";
		String completed="Validation of status of Rewards from Pending to Cancelled ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "RewardsType");
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
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickTabRewardEarnings().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedRewardsType().
		verifyTextOfPendingRewardsAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToCancel(driver, exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		clickTabRewardEarnings().
		
		verifyPresenceOfCancelledStatusLabel().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	




	/**
	 * if Cashback =249 , Rewards = 0 Verify User is unable to Process Cashback
	 * PAYMENT THRESHOLD NOT REACHED
	 * 
	 */
	@Test(priority = 14, enabled = true)
	public void VerifyUserisunabletoProcessCashbackIsLessThanThresholdLimit() {
		
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button--- Started", "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards)
		.clickRequestCashbackPaymentButton()
		.verifyPresenceMessageThresholdNotReached();

	}

	/**
	 * if Cashback =0 , Rewards = 249 Verify User is unable to Process Rewards
	 * PAYMENT THRESHOLD NOT REACHED
	 * 
	 * 
	 */
	@Test(priority = 15, enabled = true)
	public void VerifyUserisunabletoProcessRewardsIsLessThanThresholdLimit() {
		
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button--- Started", "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards)
		.clickRequestRewardsPaymentButton()
		.verifyPresenceMessageThresholdNotReached();


	}

	/**
	 * if Cashback <250 , Rewards <250 , C+R >250 Verify combined C+R option on
	 * clicking Request Rewards Combine C+R and redeem as Rewards
	 * 
	 * 
	 */
	@Test(priority = 16, enabled = true)
	public void VerifycombinedCRoptiononclickingRequestRewards() {
		
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button--- Started", "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards)
		.clickRequestRewardsPaymentButton()
		.verifyPresenceMessageToCombineCashBackPlusRewards();

	}

	/**
	 * if Cashback <250 , Rewards <250 , C+R >250 Verify combined C+R option on
	 * clicking Request Cashback • Combine C+R and redeem as Rewards
	 * 
	 * 
	 */
	@Test(priority = 17, enabled = true)
	public void VerifycombinedCRoptiononclickingRequestCashback() {
		
		
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button--- Started", "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards)
		.clickRequestCashbackPaymentButton()
		.verifyPresenceMessageToCombineCashBackPlusRewards();

	}

}
