package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPStorePage;

import testData.StoreTestData;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 * This class will validate various Store Page Cashback related scenario both positive and negative.
 * For this, various kinds of data needs to be created from Admin and then needs to validate the same in front end.
 * For Test Data for this page, JSON file is being used.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-12">Raise JIRA Issue Here</a>
 */
public class StorePage_CashBackTests extends TestSetUp{
	
	
	
	/**
	 * <p><strong>This testcase will Verify Default components of Store Page</strong><dd> 
     * Log In /Sign Up(Link))<dd>
	 * How it Works(Link)<dd>
     * Search Retailer or Coupons(Input box)<dd>
     * Contact Us
     * Hamburger Menu
     * Store short description
     * Store Activate Cashback Button
     * Show Cashback Rates Dock, Undock icon
     * Primary, Secondary cashback short description
     * Verify Cashback Type (Percentage, Currency)
     * Verify Cashback Value
     * Verify Store Title
     * Verify voucher Title
     * Verify voucher short description
     * Verify See Details, Hide Details Link
     * Very Voucher Expiry


	 * <p>PreCondition: User must be guest
	 * @throws Exception 
	 */
	@Test(priority=1)
	public void VerifyDefaultComponentsofStorePage() throws Exception
	{
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		verifyHeaderFooterFieldsPresent().
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyStoreName("CB_Store_One_Name").
		verifyStorePageMainCTAButtonText("str_Store_One_ButtonText").
		clickLinkShowCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePagePrimaryCashBackDetailsText("str_Store_One_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_One_Primary_Cashback_Value").
		verifyPercentageSymbolPrimaryCashBack().
		verifyStorePageSecondaryCashBackDetailsText("str_Store_One_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_One_Secondary_Cashback_Value").
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		clickLinkHideCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("str_Store_One_Voucher_Two_Name").
		verifyStorePageVoucherTwoText("storeOneVoucherOneName").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc").
		verifyVoucherExpiry("str_Store_One_Voucher_One_Vouchers_Exclusive_Text");
		

		
		
	}
	
	
	
	/**
	 * <p><strong>verifyNormalCashbackBothPryAndSecondaryInPercentage</p></strong>
	 * This method will verify Normal Cashback for both Primary and secondary in percentage.
	 * Here Store is created with Normal Cashback data in Pecentage.
	 */
	@Test(priority=2,enabled=false )
	public void verifyNormalCashbackBothPryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyStoreName("CB_Store_One_Name").
		verifyStorePageMainCTAButtonText("str_Store_One_ButtonText").
		clickLinkShowCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePagePrimaryCashBackDetailsText("str_Store_One_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_One_Primary_Cashback_Value").
		verifyPercentageSymbolPrimaryCashBack().
		verifyStorePageSecondaryCashBackDetailsText("str_Store_One_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_One_Secondary_Cashback_Value").
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		clickLinkHideCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("storeOneVoucherOneName").
		verifyStorePageVoucherTwoText("str_Store_One_Voucher_Two_Name").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyCalenderCashbackBothPrimaryAndSecondaryInPercentage</p>
	 * </strong>
	 * This method will verify Calendar Cash back for both Primary and secondary in percentage.
	 * Here Coupon code is copied or not is also verified.
	 * voucher with code
	 * voucher without code
	 * Verify copy code
	 * Verify Coupon code
	 */
	@Test(priority=3,enabled=true)
	public void verifyCalendarCashbackBothPrimaryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreTwo("CB_Store_Two");
		String storeName=std.getStoreName("str_Store_Two_Name");
		String start="Validation of Calender Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Calender Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Two_Primary_Cashback_Details").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Two_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Two_Secondary_Cashback_Value").
		clickLinkHideCashbackRates().
		clickCopyCode().
		verifyCouponCodeIsCopied().
		verifyCouponCodeText("str_Store_Two_Voucher_Two_CODE");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentage</p><strong>
	 * This method will verify scenario where multiple secondary cash back value would
	 * be there and one primary value. All the value would be in Percentage
	 */
	@Test(priority=4,enabled=true)
	public void verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreThree("CB_Store_Three");
		String storeName=std.getStoreName("str_Store_Three_Name");
		String start="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Three_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Three_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		verifyStorePageSecondSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyInactiveStoreWillNotBeDisplayedInFrontEnd</p></strong>
	 * This method will validate that inactive store will not display in
	 * front end on searching.
	 */
	@Test(priority=5,enabled=true)
	public void verifyInactiveStoreWillNotBeDisplayedInFrontEnd() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreFour("CB_Store_Four");
		String storeName=std.getStoreName("str_Store_Four_Name");
		String start="Validation of Inactive Store Not Displaying in Front End ...... Started";
		String completed="Validation of Inactive Store Not Displaying in Front End ...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		verifyInactiveStoreNotDisplayingInSearchResultPage(storeName);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyCalendarPrimaryAndSecondaryCashbackExclusiveExpiresInDays</p></strong>
	 * This method will verify scenario where secondary calendar cash back value would
	 * be there and one primary calendar value. This will also verify Exclusive: Expires in x days text
	 */
	@Test(priority=6,enabled=true)
	public void verifyCalendarPrimaryAndSecondaryCashbackExclusiveExpiresInDays() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreSix("CB_Store_Six");
		String storeName=std.getStoreName("str_Store_Six_Name");
		String start="Validation of Multiple Secondary Calender Cashback for both Primary and secondary Voucher in Currency...... Started";
		String completed="Validation of Multiple Secondary Calender Cashback for both Primary and secondary Voucher in Currency...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Six_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Six_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Six_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Six_Secondary_Cashback_Value").
		verifyStorePageSecondaryCalenderCashBackExpiresIn().
		verifyStorePagePrimaryCalenderCashBackExpiresIn().
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyCalendarPrimaryAndSecondaryCashbackIncreasedExpiresInDays</p></strong>
	 * This method will verify scenario where secondary calendar cash back value would
	 * be there and one primary calendar value. This method will also verify Increased: Expires in x days text
	 */
	@Test(priority=7,enabled=true)
	public void verifyCalendarPrimaryAndSecondaryCashbackIncreasedExpiresInDays() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreSeven("CB_Store_Seven");
		String storeName=std.getStoreName("str_Store_Seven_Name");
		String start="Validation of Increased Expires in x days for primary and Secondary Calender Cashback ...... Started";
		String completed="Validation of Increased Expires in x days for primary and Secondary Calender Cashback ...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Seven_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Seven_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Seven_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Seven_Secondary_Cashback_Value").
		verifyStorePagePrimaryCalenderIncreasedExpiresIn().
		verifyStorePageSecondaryCalenderIncreasedExpiresIn().
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyCalendarPryAndSecondaryCashbackAndNormalSecondaryCashbackWithIncreasedExpiresIn</p></strong>
	 * This method will validate Calendar Primary and Secondary Cash back with normal Secondary Cash back.
	 * Also it will validate Increased Expires In scenario
	 */
	@Test(priority=8,enabled=true)
	public void verifyCalendarPryAndSecondaryCashbackAndNormalSecondaryCashbackWithIncreasedExpiresIn() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreNine("CB_Store_Nine");
		String storeName=std.getStoreName("str_Store_Nine_Name");
		String start="Validation of Increased Expires in x days for primary and Secondary Calender Cashback along with normal Secondary Cashback...... Started";
		String completed="Validation of Increased Expires in x days for primary and Secondary Calender Cashback along with normal Secondary Cashback...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyCurrencyeSymbolSecondaryCashBack().
		verifyCurrencySymbolPrimaryCashBack().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Nine_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Nine_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Nine_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Nine_Secondary_Cashback_Value").
		verifyStorePageSecondSecondaryCashBackDetailsText("str_Store_Nine_Secondary_Cashback_Details").
		verifyStorePageSecondSecondaryCashbackValueText("str_Store_Nine_Secondary_Cashback_Value").
		verifyStorePagePrimaryCalenderIncreasedExpiresIn().
		verifyStorePageSecondaryCalenderIncreasedExpiresIn().
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyAllUserNewUserRadioButtonFunctionality</p></strong>
	 * This test will validate All User and New User Radio Button Functionality.
	 */
	@Test(priority=9,enabled=true)
	public void verifyAllUserNewUserRadioButtonFunctionality() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreEleven("CB_Store_Eleven");
		String storeName=std.getStoreName("str_Store_Eleven_Name");
		String start="Validation of All User Radio Button and New User Radio Button Functionality...... Started";
		String completed="Validation of All User Radio Button and New User Radio Button Functionality...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyAllUserNewUserRadioButtonFucntionality();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * <p><strong>verifyvoucherHeadingIncreasedAndExclusiveLabelInStorePage</p></strong>
	 * This test will validate presence of Voucher Heading, Increased And Exclusive Label 
	 * in Store Page.
	 * Verify voucher heading offer type (Increased Rate)
	 * Verify voucher heading Offer type (Exclusive Rate)

	 */
	@Test(priority=10,enabled=true)
	public void verifyVoucherHeadingIncreasedAndExclusiveLabelInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreEleven("CB_Store_Eleven");
		String storeName=std.getStoreName("str_Store_Eleven_Name");
		String start="Validation of presence of Voucher Heading, Increased And Exclusive Label  in Store Page....... Started";
		String completed="Validation presence of Voucher Heading, Increased And Exclusive Label  in Store Page....... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickCloseIcon().
		verifyExclusiveLabelInStorePage().
		verifyIncreasedLabelInStorePage().
		verifyVoucherHeadingLabelInStorePage();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyLnkUrlContainsOnClickingActivateCashBackInStorePage</p></strong>
	 * This test will validate presence of Link URL contains "Myntra" on
	 * clicking Activate Cash back Link in Store Page.
	 */
	@Test(priority=11,enabled=true)
	public void verifyLnkUrlContainsOnClickingActivateCashBackInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreEleven("CB_Store_Eleven");
		String storeName=std.getStoreName("str_Store_Eleven_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String start="Validation of presence of Link URL on clicking Activate CashBack Link  in Store Page....... Started";
		String completed="Validation of presence of Link URL on clicking Activate CashBack Link  in Store Page....... Completed";
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
		clickActivateCashBackInSP();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains("myntra");
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyNormalCashbackBothPryAndSecondaryInPercentageForRegisteredUser</p></strong>
	 * This method will verify Normal Cashback for both Primary and secondary in percentage For Registered User.
	 * Here Store is created with Normal Cashback data in Pecentage.
	 */
	@Test(priority=12,enabled=false )
	public void verifyNormalCashbackBothPryAndSecondaryInPercentageForRegisteredUser() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage For Registered User...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage For Registered User...... Completed";
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
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_One_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_One_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_One_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_One_Secondary_Cashback_Value").
		clickLinkHideCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("storeOneVoucherOneName").
		verifyStorePageVoucherTwoText("str_Store_One_Voucher_Two_Name").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * <p><strong>verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentageForRegisteredUser</p></strong>
	 * This method will verify scenario where multiple secondary cash back value would
	 * be there and one primary value For Registered User. All the value would be in Percentage
	 */
	@Test(priority=13,enabled=true)
	public void verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentageForRegisteredUser() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreThree("CB_Store_Three");
		String storeName=std.getStoreName("str_Store_Three_Name");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String start="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage For Registered User...... Started";
		String completed="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage For Registered User...... Completed";
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
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Three_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Three_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		verifyStorePageSecondSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	/**
	 * <p><strong>verifyCategoriesFunctionalityForCashBackInStorePage</p></strong>
	 * Below method will require a Store in which all three categories : Rewards, Cashback and Network 18 type boucher should be present.
	 * It will verify all three categories one by one.
	 * Verify Categories dropdown
	 * 
	 */
	@Test(priority=14,enabled=true)
	public void verifyCategoriesFunctionalityForCashBackInStorePage() {
		String started="Validation of Store Page Category Drop Down Functionality ......started";
		String completed="Validation of Store Page Category Drop Down Functionality ......completed";
		Log.info(started);
		reportStep(started, "INFO");
		String storeName=StoreTestData.extractJsonValuesForStoreTen("CB_Store_Ten");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName);
		WPStorePage storePage=new WPStorePage(driver, logger);
		int defaultVoucherCount=storePage.countNumberOfAllUserVoucherCard();
		storePage.clickCategoriesList().
		clickNetworkEighteenCategory();
		int networkEighteenVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
		storePage.clickCategoriesList().
		clickRewardsCategory();
		int rewardsVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
		storePage.clickCategoriesList().
		clickCashbackCategory();
		int cashbackVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
		storePage.clickCategoriesList().
		clickAllCategory();
		int allVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
			if((defaultVoucherCount==allVoucherCardCount)&&(defaultVoucherCount==(networkEighteenVoucherCardCount+rewardsVoucherCardCount+cashbackVoucherCardCount))) {
				Log.info(completed);
				reportStep(completed, "PASS");
			}else {
				Log.info(completed);
				reportStep(completed, "FAIL");
			}
	}
	
	
	
	
	/**
	 * <p><strong>Verify Link URL contains Activate cahback</p></strong>
	 *
	 * 
	 */
	@Test(priority=15,enabled=true)
	public void verifyLinkURLContainsActivateCashback() {
	
		
	}
	
	

	
	/**
	 * <p><strong>signed user navigation on clicking Activate Cashback</p></strong>
	 * Verify Exit click created or not
	 *
	 * 
	 */
	@Test(priority=16,enabled=true)
	public void SignedUsernavigationOnclickingCashback() {
	
		
	}
	
	
	/**
	 * <p><strong>Successful login via Home Page Main CTA
	 * HomePage->ClickOnImage->Store_Page-> Click on Main CTA(Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * PreCondition: Registered User
	 * @throws Exception
	 */
	
	@Test(priority=17	,enabled=true)
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
	
	@Test(priority=18,enabled=true)
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
	 * 
	 * <p><strong>VerifyInActive&ExpiredVoucherShouldnotshowOnStore</p></strong>
	 * @throws Exception 
	 *
	 * 
	 */
	@Test(priority=19,enabled=true)
	public void InActiveExpiredVoucherShouldnotshow() throws Exception {
		
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		verifyHeaderFooterFieldsPresent().
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyStoreName("CB_Store_One_Name").		
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		
		verifyVoucherInactive("Str_Store_One_Voucher_Two_Name");
	
		
	}
}
