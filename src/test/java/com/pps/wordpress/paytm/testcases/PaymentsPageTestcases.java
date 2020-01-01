package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPAdmin;
import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPMyEarningsPage;
import com.pps.wordpress.pages.WPPaymentPage;
import com.pps.wordpress.pages.WPSearchResultsPage;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *	This class will verify various successful Payment Processing Scenario.
 *  This class will also verify negative scenarios in which user will not be able to claim cashback and rewards.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-9">Raise JIRA Issue Here</a>
 *
 */

public class PaymentsPageTestcases extends TestSetUp{
	
	
	/**
	 * This method will verify default Components of Payment Form When New User request rewards Payment.
	 */
	//@Test(priority=5,enabled=true)
	public void verifyDefaultComponentsOfPaymentFormWhenNewUserRequestRewardsPayment() {
		String start="Validation of presence of default component in Payment Form when a user requested reward payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested reward payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		verifyPresenceOfRewardsAvailableForPaymentLabel().
		verifyPresenceOfRewardsAmountAvailableForPaymentLabel().
		verifyPresenceOfChoosePaymentMethodLabel().
		verifyDefaultSelectedPaymentMethod("Amazon Gift Card").
		verifyPresenceOfEnterGiftCardDetailsLabel().
		verifyPresenceOfEmailIdToSendGiftCardLabel().
		verifyPresenceOfWouldYouDonateCharityLabel().
		verifyPresenceOfSelectCharityToDonateLabel().
		verifyPresenceOfRewardsYouWishToDonateLabel().
		verifyPresenceOfRewardsAvailableAfterDonationLabel().
		verifyTextOfGetPaidButton().
		verifyPresenceOfAmountAvailableAfterDonation().
		verifyPresenceCharityAmountTextBox();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	
	
	

	/**
	 * This method will verify default Components of Payment Form When New User request Cash back Payment.
	 */
	//@Test(priority=6,enabled=true)
	public void verifyDefaultComponentsOfPaymentFormWhenNewUserRequestCashbackPayment() {
		String start="Validation of presence of default component in Payment Form when a user requested Cashback payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested Cashback payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigate().
		verifyPresenceOfCashbackAvailableForPaymentLabel().
		//verifyPresenceOfRewardsAmountAvailableForPaymentLabel().
		verifyPresenceOfChoosePaymentMethodLabel().
		verifyDefaultSelectedPaymentMethod("Bank Payment (NEFT)").
		verifyPresenceOfEnterBankDetailsLabel().
		verifyPresenceOfNameOfBankAccountHolderLabel().
		verifyPresenceOfBankNameLabel().
		verifyPresenceOfCashbackAvailableForPaymentLabel().
		verifyPresenceOfBankAccountNumberLabel().
		verifyPresenceOfBankIfscCodeLabel().
		verifyPresenceOfBankBranchNameLabel().
		verifyPresenceOfSelectCharityToDonateCashbackLabel().
		verifyPresenceOfCashbackYouWishToDonateLabel().
		verifyPresenceOfCashbackAvailableAfterDonationLabel().
		verifyPresenceOfWouldYouDonateCashbackCharityLabel().
		verifyTextOfGetPaidButton().
		verifyPresenceOfAmountAvailableAfterDonation().
		verifyPresenceCharityAmountTextBox();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	
	/**
	 * This method will verify list of Payment Method available in Payment Form for a new User.
	 * 
	 */
	//@Test(priority=4,enabled=true)
	public void verifyListOfPaymentMethodAvailableInPaymentForm() {
		String start="Validation of List of Payment Method Option Avaiable in Payment Form Started";
		String completed="Validation of List of Payment Method Option Avaiable in Payment Form Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String paymentOptions=Utils.getTestData(6, "paymentOptions");
		
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		verifyAllPaymentOptionsAreAvailable(paymentOptions);
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	

	

	
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
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
	 * This method will validate default content of Payments Page when both cashback and rewards are more than or equal to threshold.
	 * Cash Back= Rs 250 and Rewards = Rs 250
	 * Each time a new user will be created.
	 *   
	 */
	//@Test(priority=8,enabled=true)
	public void verifyDefaultContentOfPaymentPageWhenBothCashBackAndRewardsEqualToThreshold() {
		String start="Validation of Default Content Of Payment Page When Both Cash Back And Rewards Equal To Threshold for a new user Started";
		String completed="Validation of Default Content Of Payment Page When Both Cash Back And Rewards Equal To Threshold for a new user completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String rewardsType=Utils.getTestData(6, "RewardsType");
		
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
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, rewardsType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		verifyAmountAvailableForPaymentLabel().
		verifyEarningAvailableForPaymentLabel().
		verifyCashBackAndRewardsAmount250Each().
		verifyInfoAboutRequestPayment1().
		verifyInfoAboutRequestPayment2().
		clickHereLinkInPaymentPage().
		clickHereLinkCloseIconInPaymentPage().
		verifyInfoAboutRequestPayment3();
		Log.info(completed);
		reportStep(completed,"PASS");
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
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		WPPaymentPage paymentPage = new WPHomePage(driver, logger).
				clickOnlblSignInSignUP().
				clickOnlnkSignIn().
				enterEmailDuringSignIn(email).
				enterPasswordDuringSignIn(password).
				clickOnSignInButton().
				clickMyAccountLabel().
				clickMyEarningLink().
				addCashbackRewards(amount, email, cashBackType).
				clickRequestCashbackPaymentButton().
				clickOnlyRedeemCashBackEarningsLink().
				clickGetPaidButton();
		otp=Utils.getOTPCode(Utils.getTestData(2, "phoneNumberAlreadyRegistered"), driver);
		paymentPage.
		enterOTP(Utils.getOTPCode(Utils.getTestData(2, "phoneNumberAlreadyRegistered"), driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- COMPLETED", "PASS");
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
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String sortCode=Utils.getTestData(6, "sortCode");
		String bankName=Utils.getTestData(6, "bankName");
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
		enterOTP(Utils.getOTPCode(mobile, driver)).
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
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String sortCode=Utils.getTestData(6, "sortCode");
		String bankName=Utils.getTestData(6, "bankName");
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		selectPaymentMethod("UK Bank Payment (BACS)").
		enterBankAccountNumber(bankAccountNumber).
		enterNameOfAccountHolder(accountHolderName).
		enterSortCodeBacs(sortCode).
		enterBankNameBacs(bankName).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		selectPaymentMethod("Paypal").
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		selectPaymentMethod("Paypal").
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- COMPLETED", "PASS");
	}

	
	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * User Clicks Request Cash back button.
	 * Cash back + Rewards Amount should be greater than threshold limit for a new user.
	 * Payment Processing Type should be Rewards.
	 * precondition : Rewards+Cashback=>Threshold. User Clicks Request Reward
	 */
	@Test(priority=24,enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsByClickingRequestCashbackPaymentAndCombineRewardsPlusCashBackLinkCombineValueGreater() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New User .---- Started", "INFO");
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
		addCashbackRewards(amount2, email, cashBackTypeRewards).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards4().
		clickCombineRewardsPlusCashBackLink().	
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * Cash back + Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Rewards button.
	 * Payment Processing Type should be Rewards.
	 * precondition : Rewards+Cashback=>Threshold. User Clicks Request Reward
	 */
	@Test(priority=22,enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsByClickingRequestRewardPaymentAndCombineRewardsPlusCashBackLinkCombineValueGreater() {
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
		addCashbackRewards(amount2, email, cashBackTypeRewards).
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards2().
		clickCombineRewardsPlusCashBackLink().
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- COMPLETED");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Rewards button.
	 * Payment Processing Type should be Rewards.
	 */
	@Test(priority=20,enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
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
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards().
		clickCombineRewardsPlusCashBackLink().
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for Only Redeem Cash back Earnings scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button and Only Redeem Cash back Earnings.
	 * Payment Processing Type should be Cash back.	 * 
	 * precondtion : Rewards=>250 Cashback=>250
	 */
	@Test(priority=19,enabled=true)
	public void verifySuccessfulOnlyRedeemCashbackEarningsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
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
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackPlusRewards().
		clickOnlyRedeemCashBackEarningsLink().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for Only Redeem Rewards Earnings scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button and Only Redeem Cash back Earnings.
	 * Payment Processing Type should be Cash back.
	 * Precondtion :Rewards=>250 Cashback=>250
	 */
	@Test(priority=18,enabled=true)
	public void verifySuccessfulOnlyRedeemRewardsEarningsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
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
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackPlusRewards().
		clickOnlyRedeemRewardsEarningsLink().
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}
	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click Payment Link in Left navigation Panel.
	 * Precondition : A cashback Payment request is still pending
	 */

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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(Utils.getOTPCode(mobile, driver)).
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	/**
	 * This method will verify error message pop up when a new user clicks on "REQUEST REWARDS PAYMENT" button.
	 * Rewards +Cash back less than Threshold. 
	 * Precondition : User should Sign Up freshly
	 */
	@Test(priority=12,enabled=true)
	public void verifyPopUpErrorMessageWhenUserClickOnRequestREWARDSPaymentAndUserHaveLessThanThreshold() {
		String start="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST REWARDS PAYMENT ---- Started";
		String completed="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST REWARDS PAYMENT ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
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
		addCashbackRewards(amount, email, cashBackType).
		verifyRequestCashbackIsEnabled().
		verifyRequestRewardsIsEnabled();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	/**
	 * This method will verify "REQUEST REWARDS PAYMENT" button and "REQUEST Cashback PAYMENT" button is enabled even when user has less than Threshold amount.
	 * Rewards +Cash back less than Threshold. 
	 * Precondition : Rewards earned=0 Cashback earned more than or equal to threshold limit
	 */
	@Test(priority=13,enabled=true)
	public void verifyRequestCashbackAndRequestRewardsPaymentButtonIsEnabledUserAmountLessThanThreshold() {
		String start="Validation of \"REQUEST REWARDS PAYMENT\" button and \"REQUEST Cashback PAYMENT\" button is enabled ---- Started";
		String completed="Validation of \"REQUEST REWARDS PAYMENT\" button and \"REQUEST Cashback PAYMENT\" button is enabled ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
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
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButton().
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
	 * This method will Verify status and other details of Cash back Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(priority=27,enabled=true)
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
	 * This method will Verify status and other details of Rewards Type from Pending to Confirmed using exit click id
	 * @throws Exception 
	 */
	@Test(priority=28,enabled=true)
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
	 * This method will Verify status and other details of Rewards Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(priority=29,enabled=true)
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
	
	
	
	public void consecutivePayment_CB_10_RW_10_ReqCB_TC016() {
		
		
	}

	public void consecutivePayment_CB_10_RW_10_ReqRW_TC017() {
		
		
	}

	public void consecutivePayment_CB_10_RW_250_ReqRW_TC019() {
		
		
	}

	public void consecutivePayment_CB_250_RW_10_ReqCB_OnlyRedeemCashback_TC018() {
		
		
	}

	public void payment_CB_0_RW_0_ReqCB_TC001() {
		
		
	}

	public void payment_CB_0_RW_0_ReqRW_TC002() {
		
		
	}

	public void payment_CB_0_RW_250_ReqCB_Via_AmazonGC_TC005() {
		
		
	}

	public void payment_CB_0_RW_250_ReqCB_Via_FlipKartGC_TC005() {
		
		
	}

	public void payment_CB_0_RW_250_ReqRW_Via_AmazonGC_TC006() {
		
		
	}

	public void payment_CB_0_RW_250_ReqRW_Via_FlipKartGC_TC006() {
		
	}

	public void payment_CB_10_RW_240_ReqCB_Via_AmazonGC_TC007() {
		
	}

	public void payment_CB_10_RW_240_ReqCB_ViaFlipKartGC_TC007() {
		
	}

	public void payment_CB_10_RW_240_ReqRW_Via_AmazonGC_TC008() {
		
	}

	public void payment_CB_10_RW_240_ReqRW_Via_FlipKartGC_TC008() {
		
	}

	public void payment_CB_10_RW_240_ReqRW_Via_PaytmWallet_TC008() {
		
	}

	public void payment_CB_240_RW_10_ReqCB_Via_AmazonGC_TC009() {
		
	}

	public void payment_CB_240_RW_10_ReqCB_Via_FlipKartGC_TC009() {
		
	}

	public void payment_CB_240_RW_10_ReqRW_Via_AmazonGC_TC011() {
		
	}

	public void payment_CB_240_RW_10_ReqRW_Via_FlipKartGC_TC011() {
		
	}

	public void payment_CB_250_RW_0_ReqCB_TC003() {
		
	}

	public void payment_CB_250_RW_0_ReqCBWithNEFTCharityAmount_TC010_A() {
		
	}

	public void payment_CB_250_RW_0_ReqRW_Via_AmazonGC_TC004() {
		
	}

	public void payment_CB_250_RW_0_ReqRW_ViaFlipKartGC_TC004() {
		
	}

	public void payment_CB_250_RW_0_ReqRWWithAmazonCharityAmount_TC010_B() {
		
	}

	public void payment_CB_250_RW_0_ReqRWWithFlipKartCharityAmount_TC010_B() {
		
	}

	public void payment_CB_250_RW_0_ReqRWWithPaytmWalletCharityAmount_TC010_C() {
	}

	public void payment_CB_250_RW_250_ReqCB_Combine_Via_AmazonGC_TC012() {
		
	}

	public void payment_CB_250_RW_250_ReqCB_Combine_Via_FlipKartGC_TC012() {
		
	}

	public void payment_CB_250_RW_250_ReqCB_OnlyRedeemCashback_TC013() {
		
	}

	public void payment_CB_250_RW_250_ReqRW_Combine_Via_Amazon_TC014() {
		
	}

	public void payment_CB_250_RW_250_ReqRW_Combine_Via_FlipKart_TC014() {
		
	}

	public void payment_CB_250_RW_250_ReqRW_OnlyRedeemRewards_Via_AmazonGC_TC015() {
		
	}

	public void payment_CB_250_RW_250_ReqRW_OnlyRedeemRewards_Via_FlipKartGC_TC015() {
		
	}

	public void payment_negativeErrorValidationForAmazonGiftCard_TC022() {
		
	}

	public void payment_negativeErrorValidationForCharitySection_TC023() {
		
	}

	public void payment_negativeErrorValidationForFlipKartGiftCard_TC022() {
		
	}

	public void payment_negativeErrorValidationForNEFT_TC021() {
		
	}

	public void paymentOTP_NegativeValidation_TC024() {
		
	}

	public void paymentPageValidation_TCO20() {
		
	}
	
}
