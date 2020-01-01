package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPMyEarningsPage;
import com.pps.wordpress.pages.WPPaymentPage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class MyEarningsPageTestcases extends TestSetUp {

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

	@Test(priority = 1, enabled = true)
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
	// @Test(priority=2,enabled=true)
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
	// @Test(priority=3,enabled=true)
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
	// @Test(priority=7,enabled=true)
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
	@Test(priority = 3, enabled = true)
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
	@Test(priority = 4, enabled = true)
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
	@Test(priority = 25, enabled = true)
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
	@Test(priority = 6, enabled = true)
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
	 * Verify Total cashbackearningsData.
	 */
	// @Test(priority=7,enabled=true)
	public void verifyTotalCashbackEarningsData() {

	}

	/**
	 * Verify Total cashbackearningsData.
	 */
	// @Test(priority=7,enabled=true)
	public void verifyTotalRewardsEarningsData() {

	}

	/**
	 * Verify My earnings History Table data.
	 */
	// @Test(priority=7,enabled=true)
	public void verifyMyEarningsHostoryTableData() {

	}

	/**
	 * if Cashback =249 , Rewards = 0 Verify User is unable to Process Cashback
	 * PAYMENT THRESHOLD NOT REACHED
	 * 
	 */
	@Test(priority = 4, enabled = true)
	public void VerifyUserisunabletoProcessCashbackIsLessThanThresholdLimit() {

	}

	/**
	 * if Cashback =0 , Rewards = 249 Verify User is unable to Process Rewards
	 * PAYMENT THRESHOLD NOT REACHED
	 * 
	 * 
	 */
	@Test(priority = 4, enabled = true)
	public void VerifyUserisunabletoProcessRewardsIsLessThanThresholdLimit() {

	}

	/**
	 * if Cashback <250 , Rewards <250 , C+R >250 Verify combined C+R option on
	 * clicking Request Rewards Combine C+R and redeem as Rewards
	 * 
	 * 
	 */
	@Test(priority = 4, enabled = true)
	public void VerifycombinedCRoptiononclickingRequestRewards() {

	}

	/**
	 * if Cashback <250 , Rewards <250 , C+R >250 Verify combined C+R option on
	 * clicking Request Cashback • Combine C+R and redeem as Rewards
	 * 
	 * 
	 */
	@Test(priority = 4, enabled = true)
	public void VerifycombinedCRoptiononclickingRequestCashback() {

	}

}
