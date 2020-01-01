package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPSignUpSignInPopUp;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;


/**
 *This class will verify various login and error scenario in WordPress.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-2">Raise JIRA Issue Here</a>
 */


public class LoginPageTestcases extends TestSetUp{
	
	/**
	 * <p><strong>Navigate to Login Page and Verify Default Components</strong><dd> 
	 * SIGN IN (Link)<dd>
	 * SIGN UP(Link)<dd>
     * Email (Textbox)<dd>
     * Password(Textbox)<dd>
     * Captcha (Image, Textbox)<dd>
     * SIGN IN (Button)v
     * Forget Password (Link)
	 * <p>PreCondition: User must be guest
	 */
	//@Test(priority=1)
	public void VerifyDefaultComponentsofLoginPage()
	{
		
		reportStep("Verification of fields present in the login page started", "PASS");
		String email=Utils.getTestData(0,"InvalidFormatEmailID");;
		String password=Utils.getTestData(0,"InvalidPassword");
		try {
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().verifyFieldsPresent();
			
			reportStep("Verification of fields present in the login page completed", "PASS");
		} catch (Exception e) {
			reportStep("Verification of fields present in the login page failed", "FAIL");
		}
		
		
	}
	
	
	/**
	 * <p><strong>Verify Place holder value of both Email ID and Password Text boxes</strong><dd> 
	 * PreCondition: Guest User
	 */
	
	//@Test(priority=2)
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
			Log.error("Verification of Presence of Placeholder Value of Email and Password Textboxes  completed Unsuccessfully");
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	
	/**
	 * <p><strong>Verify alpha , numeric and special charecter allowance in Email ID and Password Text boxes</strong><dd> 
	 * PreCondition: Guest User
	 */
	@Test(priority=3)
	public void verifyAlphaNumericSpecialAllowanceInLoginWindowfields()throws Exception {
		try {
			reportStep("Verification of alpha numeric and special charecter in Email and Password Textboxes started", "INFO");
			Log.info("Verification of alpha numeric and special charecter in Email and Password Textboxes started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().verifyCharecterAllowancePositiveScenario();
		  			
			reportStep("Verification of alpha numeric and special charecter in Email and Password Textboxes completed", "PASS");
			Log.info("Verification of alpha numeric and special charecter in Email and Password Textboxes completed");
		}catch(Exception e) {
			Log.error("Verification of alpha numeric and special charecter in Email and Password Textboxes completed Unsuccessfully");
			reportStep("Verification of alpha numeric and special charecter in Email and Password Textboxes completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * <p><strong>Verify max length for Email ID and Password Text boxes</strong><dd> 
	 * PreCondition: Guest User
	 */
	
	//@Test(priority=4)
	public void verifyMaxLengthforLoginWindowfields()throws Exception {
		try {
			reportStep("Verification of field length in Email and Password Textboxes started", "INFO");
			Log.info("Verification of of field length in Email and Password Textboxes started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().VerifyFieldLength();
		  			
			reportStep("Verification of of field length in Email and Password Textboxes completed", "PASS");
			Log.info("Verification of field length in Email and Password Textboxes completed");
		}catch(Exception e) {
			Log.error("Verification of field length in Email and Password Textboxes completed Unsuccessfully");
			reportStep("Verification of field length in Email and Password Textboxes completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * <p><strong>Verify copy paste  allowance in Email ID and Password Text boxes</strong><dd> 
	 * PreCondition: Guest User
	 */
	
	//@Test(priority=5)
	public void verifyCopyPasteAllowanceInLoginWindowfields()throws Exception {
		try {
			reportStep("Verification of copy paste allowance in Email and Password Textboxes started", "INFO");
			Log.info("Verification of copy paste allowance in Email and Password Textboxes started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().VerifyCopyPasteAllowance();
		  			
			reportStep("Verification of copy paste allowance in Email and Password Textboxes completed", "PASS");
			Log.info("Verification of copy paste allowance in Email and Password Textboxes completed");
		}catch(Exception e) {
			Log.error("Verification of copy paste allowance in Email and Password Textboxes completed Unsuccessfully");
			reportStep("Verification of copy paste allowance in Email and Password Textboxes completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	

	
	/**
	 * <p><strong>Verify Error message by clicking submit button without entering email id
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority =6,enabled=true)
	public void verifyPresenceOfErrorMessageWithBlankEmailID()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message with Blank Email started", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Email started");
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail();
			reportStep("Verification of Presence of Error Message with Blank Email completed", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Email completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Email completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Email completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * <p><strong>Verify Error message by clicking submit button without entering password
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority =7,enabled=true)
	public void verifyPresenceOfErrorMessageWithBlankPassword()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message with Blank Password started", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Password started");
			String email=Utils.getTestData(0,"ValidUserId");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankPwd();
			reportStep("Verification of Presence of Error Message with Blank Password completed", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Password completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Password completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Password completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	
	/**
	 *<p><strong> Verify Error message by clicking submit button without entering email id and password both.
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority =8,enabled=true)
	public void verifyPresenceOfErrorMessageBothUserNamePwdBlank()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message with Username and Blank Password started", "INFO");
			Log.info("Verification of Presence of Error Message with Blank Username and Password --- started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			clickOnSignInButtonFail().
			verifyErrorMsgInCaseBothUserNamePwdBlank();
			reportStep("Verification of Presence of Error Message with Blank Username and Password completed", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Username and Password completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Username and Password completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Username and Password completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	

		
	/**
	 * <p><strong>This Testcase will Verify the format of email id.</strong><dd>
	 * It should accept values like: abc@abc.com , rahul@gmail.com<dd>
	 * Invalid Email id example: abc@, abc@mn@n.com, @gmail.com, 12345<dd>
	 * PreCondition: User must be guest<dd>
	 * @throws Exception
	 */
	//@Test(priority=9,enabled=true)
	public void verifyFormatOfEmailID() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login started", "PASS");
			String email=Utils.getTestData(0,"InvalidFormatEmailID");;
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail();
			reportStep("Verification of unsuccessful Login Completed", "PASS");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * <p><strong>Verify Successful login using  valid user ID and password.</strong><dd>
	 * Upon login  verify My Account label is present.<dd>
	 * Test Data: Correct EMail ID and Correct Password.<dd>
	 * PreCondition: Registered User<dd>

	 */
	//@Test(priority=10,enabled=true)
	public void verifySuccessfulLoginWithCorrectCredential() {
		try {
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel();
			reportStep("Verification of Successful Login completed", "PASS");
		}catch(Exception e) {
			reportStep("Verification of Successful Login failed", "FAIL");
			throw e;
		}
	}

	/**
	 * <p><strong>Verify Error Message while login with email id which are not registered.
	 * Test Data: Unregistered Email ID and dummy password
	 * PreCondition: Guest User

	 * @throws Exception
	 */
	//@Test(priority =11,enabled=true)
	public void verifyUnsuccessfulLoginUsingUnregisteredEmailID() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login started", "PASS");
			String email=Utils.getTestData(0,"InvalidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsg();
			reportStep("Verification of unsuccessful Login started", "PASS");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login failed", "FAIL");
			throw e;
		}
	}
	/**
	 * <p><strong>Verify Error message while login by entering wrong password.
	 * Test Data: Registered User ID and Incorrect Password
	 * PreCondition: Guest User

	 * @throws Exception
	 */
	//@Test(priority =12,enabled=true)
	public void verifyUnsuccessfulLoginUsingInvalidPassword() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login started", "PASS");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsg();
			reportStep("Verification of unsuccessful Login Completed", "PASS");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login failed", "FAIL");
			throw e;
		}
	}
	
	
	
	
	
	
	/**
	 * <p><strong>Verify Minimum character of password field. It should be six.
	 * PreCondition:Guest User
	 * @throws Exception
	 */
	
	//@Test(priority=13,enabled=true)
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
			Log.error("Verification of Presence of Error Message with Blank Password completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Password completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 *<p><strong> Verify maximum character for password field
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority=14,enabled=true)
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
			Log.error("Verification of Presence of Error Message with maximum characters password field completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with maximum characters in Password field completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * <p><strong>Verify Reset functionality of login popup
	 * Click Sign In Button without entering email id and password.> Close Login Form. > Open Login Form> Verify those error message are not visible.
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority=15,enabled=true) 
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
			reportStep("Verification of Reset Functionality Of Login Pop Up completed unsuccessfully", "FAIL");
			Log.info("Verification of Reset Functionality Of Login Pop Up completed unsuccessfully");
			throw e;
		}
	}

	
	/**
	 * <p><strong>Verify Max Character an email field should accepts. It should be 50.
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority=16,enabled=true)
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
			Log.error("Verification of Presence of Error Message with maximum characters password field completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with maximum characters in Password field completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * <p><strong>Successful login via Home Page Main CTA
	 * HomePage->ClickOnImage->Store_Page-> Click on Main CTA(Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	//@Test(priority=17	,enabled=true)
	public void successfulLoginViaStorePageMainCTA() throws Exception{
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
	 * <p><strong>Successful login via store page Voucher CTA
	 * HomePage->ClickOnImage->Store_Page-> Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	//@Test(priority=18,enabled=true)
	public void successfulLoginViaStorePageVoucherCTA() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
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
	 * <p><strong>Succesful login via store page voucher CTA from Main Category
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> 
	 * Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	//@Test(priority=19,enabled=true)
	public void successfulLoginViaMainCategoryStorePageAndVoucherCTA() throws Exception{
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
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA Completed", "FAIL");
		}
	}
	
	
	
	/**
	 * Click Sign In Button without entering email id and password.> Close Login Form. > Open Login Form> Verify those error message are not visible.Click Sign In Button without entering email id and password.> Close Login Form. > Open Login Form> Verify those error message are not visible.Successful login via Store page main CTA from Main Category
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> Click on Main CTA (Activate button)->SuccessfulLogin
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	//@Test(priority=20,enabled=true)
	public void successfulLoginViaMainCategoryStorePageAndMainCTA() throws Exception{
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
	 * <p><strong>Successful login via main category and store card CTA
	 * Home page ->HamburgerMenu->Select_A_Category->Click on STORESCARD CTA (Activate button)->SuccessfulLogin
	 * Upon successful login ,reload the current page with pagination"
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	//@Test(priority=21,enabled=true)
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
	 * <p><strong>Successful login via search and store card Activate Cashback
	 * HomePage->SearchStore->ClickOnStoreCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page. 
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority=22,enabled=true)
	public void successfulLoginViaSearchAndStoreCardActivateCashBack() throws Exception{
		try {
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
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
	 * <p><strong>Successful login via search and vouchercard Activate cashback
	 * HomePage->SearchStore->ClickOnVoucherCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page. 
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority=23,enabled=true)
	public void successfulLoginViaSearchAndVoucherCardActivateCashBack() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
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
	 * <p><strong> successful login via search view all retailer functionality and click store card CTA
	 * HomePage->SearchResult->Search_Retailer_Page-> ViewAll->Click on StoreCardCTA>>SuccessfulLogin
 	 * Upon successful login, reload the current page with pagination"
 	 * PreCondition: Regsistered User
	 * @throws Exception
	 */
	
	//@Test(priority=24,enabled=true)
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
	 *  <p><strong> successful login via search view all voucher functionality and click store card CTA
	 *  HomePage->SearchResult-->Search_Coupon_Page-> >ViewAll->Click on StoreCardCTA>(Activate button)->SuccessfulLogin
 	 *  Upon successful login , reload the current page.
 	 *  PreCondition: Registered User
	 * @throws Exception
	 */
	
	//@Test(priority=25,enabled=true)
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
	
	

	/**
	 * <p><strong>Verify Sign In Link navigation At login page
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority =27,enabled=true)
	public void verifySignInLinkNavigationAtTopOfLoginForm()throws Exception {
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
			Log.error("Verification of Presence of Sign In Link at top of Login Form completed Unsuccessfully");
			reportStep("Verification of Presence of Sign In Link at top of Login Form completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	

	/**
	 * <p><strong>Verify Forget password Link navigation At login page
	 * PreCondition: Guest User
	 * @throws Exception
	 */
	
	//@Test(priority =28,enabled=true)
	public void verifyForgetPasswordNavigationAtTopOfLoginForm()throws Exception {
		try {
			reportStep("Verification of Presence of Sign In Link at top of Login Form started", "INFO");
			Log.info("Verification of Presence of Sign In Link at top of Login Form started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			clickOnForgotPassword();
			reportStep("Verification of Presence of Sign In Link at top of Login Form completed", "PASS");
			Log.info("Verification of Presence of Sign In Link at top of Login Form completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Sign In Link at top of Login Form completed Unsuccessfully");
			reportStep("Verification of Presence of Sign In Link at top of Login Form completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	
	
	

}



