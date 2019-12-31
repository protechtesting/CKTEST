package com.pps.wordpress.icici.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPIntermediaryPage;
import com.pps.wordpress.pages.WPStorePage;

import testData.StoreTestData;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 * This class will validate store page functionalities for N18 store
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-18">Raise JIRA Issue Here</a>
 */
public class WP_VerifyStorePageFunctionalityForNetworkEighteen extends TestSetUp{
	@Test(priority=1,enabled=true)
	public void verifyAllUserNewUserRadioButtonFunctionality() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
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
	
	@Test(priority=2,enabled=true)
	public void verifyLnkUrlContainsOnClickingGrabDealInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String start="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Started";
		String completed="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Completed";
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
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	@Test(priority=3,enabled=true)
	public void verifyNormalCashbackBothPryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Network 18 for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Network 18 for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("str_Store_One_Voucher_One_Name").
		verifyStorePageVoucherTwoText("str_Store_One_Voucher_Two_Name").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	@Test(priority=4,enabled=true)
	public void verifyIntermediaryPageAfterClickingGrabDeal() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String start="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Started";
		String completed="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Completed";
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
		new WPIntermediaryPage(driver, logger).
		stopIntermediaryPageFromNavigation().
		verifyArrowNavigationIsPresent().
		verifyIntermediaryCurrencySymbolIsPresent().
		verifyIntermediaryRetailerNameIsPresent().
		verifyIntermediaryWordPressLogoIsPresent().
		clickHereLink();
		Utils.explicitWaitForUrlContains("myntra");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyCategoriesFunctionalityForCashBackInStorePage
	 * Below method will verify the copy code functionality
	 * 
	 */
	
	@Test(priority=16,enabled=true)
	public void verifyCopyCodefunctionality() {
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
	
}




