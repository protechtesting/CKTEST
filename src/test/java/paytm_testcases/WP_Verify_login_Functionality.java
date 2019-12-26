package paytm_testcases;

import org.testng.annotations.Test;

import pageobjects.WPHomePage;
import pageobjects.WPSignUpSignInPopUp;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**
 * This class will verify the login functionalities
 * <p>
 * If any issues,
 * {@link} <a href="http://google.com">Raise Jira Ticket here</a>
 */

public class WP_Verify_login_Functionality extends TestSetUp{
	
	
	
	
	/**
	 * This test will Verify the Email format validations
	 * Upon Login with Invalid Email, An Error message "Enter Valid Email Address" will be shown
	 * Test Data: abc@, abc@mn@n.com, @gmail.com, 12345
	 * @throws Exception
	 */
	@Test(priority=1,enabled=true)
	public void verifyFormatOfEmailID() throws Exception{
		try {
			reportStep("Verification of Email format validation started", "INFO");
			Log.info("Verification of Email format validation started");
			String email=Utils.getTestData(0,"InvalidFormatEmailID");;
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail();
			reportStep("Verification of Email format validation Completed", "PASS");
			Log.info("Verification of Email format validation Completed");
			
		}catch(Exception e) {
			reportStep("Verification of Email format validation failed", "FAIL");
			Log.error("Verification of Email format validation failed");
			throw e;
		}
	}
	
	/**
	 * This test will verify the successful login
	 * Upon successful login "My Account" label will be shown.
	 * Test Data: Registered Email & Password.
	 * PreCondition: Registered User

	 */
	@Test(priority=2,enabled=true)
	public void verifySuccessfulLoginWithCorrectCredential() {
		try {
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login started", "INFO");
			Log.info("Verification of Successful Login started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel();
			reportStep("Verification of Successful Login completed", "PASS");
			Log.info("Verification of Successful Login completed");
		}catch(Exception e) {
			reportStep("Verification of Successful Login failed", "FAIL");
			Log.error("Verification of Successful Login failed");
			throw e;
		}
	}

	/**
	 * This Test Verify validation for UnRegistered Login.
	 * Upon Login with Unregistered Email ID , An error message "The username/password is invalid" should show
	 * Test Data: Unregistered Email ID and password
	 * PreCondition: Guest User

	 * @throws Exception
	 */
	@Test(priority =3,enabled=true)
	public void verifyUnsuccessfulLoginUsingUnregisteredEmailID() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login with unregistered email ID is started", "INFO");
			Log.info("Verification of unsuccessful Login with unregistered email ID is started");
			String email=Utils.getTestData(0,"InvalidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsg();
			reportStep("Verification of unsuccessful Login with unregistered email ID is completed", "PASS");
			Log.info("Verification of unsuccessful Login with unregistered email ID is completed");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login with unregistered email ID is failed", "FAIL");
			Log.error("Verification of unsuccessful Login with unregistered email ID is failed");
			throw e;
		}
	}
	/**
	 * This Test Verify validation for wrong password.
	 * Upon login with wrong password, An error message "The username/password is invalid" should show
	 * Test Data: Registered User ID and wrong Password
	 * PreCondition: Guest User

	 * @throws Exception
	 */
	@Test(priority =4,enabled=true)
	public void verifyUnsuccessfulLoginUsingInvalidPassword() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login with wrong password started", "INFO");
			Log.info("Verification of unsuccessful Login with wrong password started");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsg();
			reportStep("Verification of unsuccessful Login with wrong Email ID Completed", "PASS");
			Log.info("Verification of unsuccessful Login with wrong Email ID Completed");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login with wrong Password failed", "FAIL");
			Log.error("Verification of unsuccessful Login with wrong Password failed");
			throw e;
		}
	}
	
	
	
	/**
	 * This Test Verify validation for blank Email ID
	 * Upon Login with blank Email ID, An Error message "Please enter valid Email" should show
	 * Test Data : Blank Email ID
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority =5,enabled=true)
	public void verifyPresenceOfErrorMessageWithBlankEmailID()throws Exception {
		try {
			reportStep("Verification of unsuccessful Login with Blank Email ID Started", "INFO");
			Log.info("Verification of unsuccessful Login with Blank Email ID Started");
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail();
			reportStep("Verification of unsuccessful Login with Blank Email ID Completed", "PASS");
			Log.info("Verification of unsuccessful Login with Blank Email ID Completed");
		}catch(Exception e) {
			Log.error("Verification of unsuccessful Login with Blank Email ID Failed");
			reportStep("Verification of unsuccessful Login with Blank Email ID Failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * This Test Verify validation for blank password
	 * Upon Login with blank password, An Error message "Please enter valid Password" should show
	 * Test Data : Blank Password
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority =6,enabled=true)
	public void verifyPresenceOfErrorMessageWithBlankPassword()throws Exception {
		try {
			reportStep("Verification of unsuccessful Login with Blank password Started", "INFO");
			Log.info("Verification of unsuccessful Login with Blank Email password Started");
			String email=Utils.getTestData(0,"ValpasswordUserpassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankPwd();
			reportStep("Verification of unsuccessful Login with Blank password Completed", "PASS");
			Log.info("Verification of unsuccessful Login with Blank password Completed");
		}catch(Exception e) {
			Log.error("Verification of unsuccessful Login with Blank password Failed");
			reportStep("Verification of unsuccessful Login with Blank password Failed", "FAIL");
			throw e;
		}
	}
	
	
	/**
	 * This Test Verify validation for blank email and password
	 * Upon Login with blank email and password, An Error message "Please enter valid Password" should show
	 * Test Data : Blank email and Password
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority =7,enabled=true)
	public void verifyPresenceOfErrorMessageBothUserNamePwdBlank()throws Exception {
		try {
			reportStep("Verification of validation with blank email and Blank Password started", "INFO");
			Log.info("Verification of validation with blank email and Blank Password --- started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			clickOnSignInButtonFail().
			verifyErrorMsgInCaseBothUserNamePwdBlank();
			reportStep("Verification of validation with Blank email and Password completed", "PASS");
			Log.info("Verification of validation with Blank Username and Password completed");
		}catch(Exception e) {
			Log.error("Verification of validation with Blank Username and Password failed");
			reportStep("Verification of validation with Blank Username and Password failed", "FAIL");
			throw e;
		}
	}
	
	
	
	/**
	 * This test Verify Presence of "SIGN IN" Link At top of login Form
	 * Upon navigating to sign in pop up, "SIGN IN" link must be present
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority =8,enabled=true)
	public void verifyPresenceOfSignInLinkAtTopOfLoginForm()throws Exception {
		try {
			reportStep("Verification of Presence of Sign In Link at top of Login Form started", "INFO");
			Log.info("Verification of Presence of Sign In Link at top of Login Form started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifySignInLinkOnLoginFrom();
			reportStep("Verification of Presence of Sign In Link at top of Login Form completed", "PASS");
			Log.info("Verification of Presence of Sign In Link at top of Login Form completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Sign In Link at top of Login Form failed");
			reportStep("Verification of Presence of Sign In Link at top of Login Form failed", "FAIL");
			throw e;
		}
	}
	
	
	/**
	 * This test Verify Place holder value of both Email ID and Password Text boxes
	 * Place Holder value should be "Enter Email" , "Enter Password"
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority=9,enabled=true)
	public void verifyPlaceHolderValueOfEmailAndPasswordTextBoxes()throws Exception {
		try {
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes started", "INFO");
			Log.info("Verification of Presence of Placeholder Value of Email and Password Textboxes  started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyPasswordPlaceHolderValue().
			verifyEmailPlaceHolderValue();	  			
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes completed", "PASS");
			Log.info("Verification of Presence of Placeholder Value of Email and Password Textboxes completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Placeholder Value of Email and Password Textboxes  failed");
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes failed", "FAIL");
			throw e;
		}
	}
	
	
	/**
	 * Verify Minimum character of password field. It should be six.
	 * Upon login with less than six character in the password field, An Error message "Please enter Valid password" should show
	 * Test Data : less than 6 digit password
	 * PreCondition:Guest User
	 * @throws Exception
	 */
	
	@Test(priority=10,enabled=true)
	public void verifyMinimumCharacterForPasswordField()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message for minimum characters in Password field started", "INFO");
			Log.info("Verification of Presence of Error Message for minimum characters in Password field started");
			String minimumChar=Utils.getTestData(0,"minCharPassword");
			String email=Utils.getTestData(0,"ValidUserId");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(minimumChar).
			clickOnSignInButton();
			new WPSignUpSignInPopUp(driver,logger).
			verifyPresenceOfErrorMsgBlankPwd();
			reportStep("Verification of Presence of Error Message for minimum characters in Password field completed", "PASS");
			Log.info("Verification of Presence of Error Message for minimum characters in Password field completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message for minimum characters in Password field failed");
			reportStep("Verification of Presence of Error Message for minimum characters in Password field failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify maximum character allowance in the password field
	 * Password field should not allow more than 20 characters
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority=11,enabled=true)
	public void verifyMaximumCharacterForPasswordField()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message for maximum characters in Password field started", "INFO");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyMaxCharacterInPasswordField();
			reportStep("Verification of Presence of Error Message for maximum characters in Password field completed", "PASS");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with maximum characters password field failed");
			reportStep("Verification of Presence of Error Message with maximum characters in Password field failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Reset functionality of login popup
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority=12,enabled=true) 
	public void verifyResetFunctionalityOfLoginPopUp() throws Exception {
		try {
			reportStep("Verification of Reset Functionality Of Login Pop Up started", "INFO");
			Log.info("Verification of Reset Functionality Of Login Pop Up started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail().
			closeLoginPopUp().
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyCountOfErrorMessages();
			reportStep("Verification of Reset Functionality Of Login Pop Up completed successfully", "PASS");
			Log.info("Verification of Reset Functionality Of Login Pop Up completed successfully");
		}catch(Exception e) {
			reportStep("Verification of Reset Functionality Of Login Pop Up failed", "FAIL");
			Log.info("Verification of Reset Functionality Of Login Pop Up failed");
			throw e;
		}
	}

	
	/**
	 * Verify Maximum Character allowance in the email field
	 * Email field should not allow more than 50 character
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority=13,enabled=true)
	public void verifyMaxCharInEmailField()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message for maximum characters in Password field started", "INFO");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyMaxCharacterAllowedInEmailField();
			reportStep("Verification of Presence of Error Message for maximum characters in Password field completed", "PASS");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with maximum characters password field failed");
			reportStep("Verification of Presence of Error Message with maximum characters in Password field failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify successful login via store page main CTA
	 * HomePage->ClickOn Store card Image->Store_Page-> Click on Main CTA(Activate button)->SuccessfulLogin.
	 * Upon successful login, reload the current page. My Account label should be shown
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=14	,enabled=true)
	public void successfulLoginViaHomePageImageMainCTA() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			
			clickFirstStoreCard().
			clickMainCtaActivateCashBackLink().
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
	
	
	/**
	 * HomePage->ClickOnImage->Store_Page-> Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=15,enabled=true)
	public void successfulLoginViaHomePageImageVoucherCTA() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickFirstStoreCard().
			clickActivateRewardsGuestUser().
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
	
	/**
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> 
	 * Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=16,enabled=true)
	public void successfulLoginViaMainCategoryAndVoucherCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickVoucherCtaActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA FAILED");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA FAILED", "FAIL");
		}
	}
	
	
	
	/**
	 * Verify Reset Functionality. Home Page> Sign In Link ->
	 * Click Sign In Button without entering email id and password.> Close Login Form. > Open Login Form> Verify those error message are not visible.
	 * PreCondition:
	 * @throws Exception
	 */
	

	
	/**
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> Click on Main CTA (Activate button)->SuccessfulLogin
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=17,enabled=true)
	public void successfulLoginViaMainCategoryAndMainCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login Through Main Category and Main CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickMainCtaActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Through Main Category and Main CTA Failed");
			reportStep("Verification of Through Main Category and Main CTA Failed", "FAIL");
		}
	}
	
	/**
	 * Home page ->HamburgerMenu->Select_A_Category->Click on STORESCARD CTA (Activate button)->SuccessfulLogin
	 * Upon successful login ,reload the current page with pagination"
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=18,enabled=true)
	public void successfulLoginViaMainCategoryAndStoreCardCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category1");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login Through Main Category and Main CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickActivateCashBackInSCP().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
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
	 * HomePage->SearchStore->ClickOnStoreCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page. 
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority=21,enabled=true)
	public void successfulLoginViaSearchAndStoreCardActivateCashBack() throws Exception{
		try {
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Verification of Successful Login Through Search Functionality  and Voucher CTA started");
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnStoreCardActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * HomePage->SearchStore->ClickOnVoucherCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page. 
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	@Test(priority=22,enabled=true)
	public void successfulLoginViaSearchAndVoucherCardActivateCashBack() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnVoucherCardActivateCashBackLink().
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
	
	/**
	 * HomePage->SearchResult->Search_Retailer_Page-> ViewAll->Click on StoreCardCTA>>SuccessfulLogin
 	 * Upon successful login, reload the current page with pagination"
 	 * PreCondition: Regsistered User
	 * @throws Exception
	 */
	
	@Test(priority=19,enabled=true)
	public void successfulLoginViaViewAllFunctionalityStoreCardCTAForRetailer() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStoreViewAll");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkRetailer().
			clickActivateCashBackInSLP().
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
	
	/**
	 *  HomePage->SearchResult-->Search_Coupon_Page-> >ViewAll->Click on StoreCardCTA>(Activate button)->SuccessfulLogin
 	 *  Upon successful login , reload the current page.
 	 *  PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=20,enabled=true)
	public void successfulLoginViaViewAllFunctionalityStoreCardCTAForVoucher() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchVoucherViewAll");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkVoucher().
			clickActivateCashBackInSLP().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA not Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA not Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->ClickOnStorecardButton(Activate CashBack)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * @throws Exception
	 * PreCondition: Guest User
	 */
	
	@Test(priority=23,enabled=true)
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
	
	
	

}



