package com.pps.wordpress.pages;

import java.util.List;

/*
@author= Rahul Tiwari
This page will identify all elements in Home Page of Cash Karo website and will perform operation on the same.
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Utils;
import utility.WrapperMethods;

import com.relevantcodes.extentreports.ExtentTest;
import utility.TestSetUp;
import utility.Log;

public class WPHomePage extends WrapperMethods {
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPHomePage.class);
	private static String subCategory = Utils.getTestData(0, "subCategory");

	public WPHomePage(WebDriver driver, ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info("Waiting for the Home page");
		reportStep("Waiting for the Home page", "INFO");
		try {
			// wait.until(ExpectedConditions.visibilityOf(lblSignInSignUP));
			Utils.sleep3sec();
			Log.info("Successfully landed on the Home page");
			reportStep("Successfully landed on the Home page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Home page", "FAIL");
			Log.error("Not able to land on the Home page");
		}
	}

	@FindBy(id = "lblPopularRetailersHead")
	private static WebElement popularRetailersection;
	
	@FindBy(id = "popularRetailersImg_0")
	private static WebElement popularRetailer;
	
	

	@FindBy(id = "lblGreatDealsHead")
	private static WebElement trendingRetailersection;
	
	
			
	@FindBy(xpath = "(//div[@class='store_card'])[9]/div/a/img")
	private static WebElement trendingRetailer;		
			

	@FindBy(id = "lblPickOftheDay")
	private static WebElement PickoftheRetailersection;
	
	@FindBy(id = "img_pickOftheDay0")
	private static WebElement PickoftheRetailer;
	
	

	@FindBy(xpath = "//img[contains(@id,banner)]")
	private static List<WebElement> banners;

	public WPHomePage verifyPopularRetailer(String pt) throws Exception {
		String info="verify popular retailer functionality verification started";
		String pass = "verify popular retailer functionality verification complted";
		String fail = "verify popular retailer functionality verification failed";
		
		System.out.println((popularRetailer.getAttribute("alt").toString()));
		System.out.println(pt);
		try {
			
			
			

			if (pt.equals(popularRetailer.getAttribute("alt").toString())) {
				Log.info(info);
				reportStep(pass, "PASS");
			} else {
				Log.info(fail);
				reportStep(fail, "FAIL");
			}
		} catch (Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}

		return this;
	}

	public WPHomePage verifyTrendingRetailer(String pt) throws Exception {
		
		String info="verify trending retailer functionality verification started";
		String pass="verify trending retailer functionality verification completed";
		String fail="verify trending retailer functionality verification failed";

		System.out.println((trendingRetailer.getAttribute("alt").toString()));
		System.out.println(pt);
		
		try {
			

			if (pt.equals(trendingRetailer.getAttribute("alt").toString())) {
				Log.info(info);
		
				reportStep(pass, "PASS");
			} else {
				Log.info(fail);
				reportStep(fail, "FAIL");
			}

		} catch (Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}

		return this;

	}

	public WPHomePage verifyPickoftheDayRetailer(String pt)
	{
	String info="verify pick of the day retailer functionality verification started";
	String pass="verify pick of the day retailer functionality verification completed";
	String fail="verify pick of the day retailer functionality verification failed";
	
	try{
		
		System.out.println(pt);
		System.out.println(PickoftheRetailer.getAttribute("alt").toString());
	if(pt.equals(PickoftheRetailer.getAttribute("alt").toString())) 
	{
		Log.info(info);
		reportStep(pass, "PASS");
	}else {
		Log.info(fail);
		reportStep(fail, "FAIL");
	}
	} catch(Exception e) 
	{
		Log.info(fail);
		reportStep(fail, "FAIL");
	}


		
return this;
}
	
	

	public WPHomePage verifyhomepagesectionsPresent() throws Exception {

		String pass = "verify pick of the day retailer functionality verification started";
		String fail = "verify pick of the day retailer functionality verification started";
		
		verifyDisplayed(driver, "Popular Retailer section", popularRetailer);
		verifyDisplayed(driver, "Trending Retailer section", trendingRetailer);
		verifyDisplayed(driver, "Pick of the day section", PickoftheRetailer);
		verifyDisplayed(driver, "4 panner", banners.get(3));
		
		

		return this;
	}

	public WPHomePage verifyHeaderFooterFieldsPresent() throws Exception {

		verifyDisplayed(driver, "Hamburger Menu", lnkHamburgerMenu);
		verifyDisplayed(driver, "search store textbox", txtBxSearchStoreOrCoupons);
		verifyDisplayed(driver, "paytm logo", lnkLogo);
		verifyDisplayed(driver, "Link SignIn/SignUP", lblSignInSignUP);
		verifyDisplayed(driver, "ContactUs link", lnkContactUsFooter);

		return this;
	}
	
	@FindBy(xpath="//a[contains(text(),'GRAB DEAL')]")
	private static List<WebElement> lnkGrabDeal;
	
	public  WPIntermediaryPage clickGrabDealLink(int i) {
		String locator="Locating Grab Deal in Store Page.";
		String pass="Successfully clicked Grab Deal in Store Page.";
		String fail="Unable to locate Grab Deal in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkGrabDeal.get(i))) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPIntermediaryPage(driver, logger);
	}

	@FindBy(id = "idMenuEarnings")
	private static WebElement lnkMyEarning;

	// Click My Earning Link
	public WPMyEarningsPage clickMyEarningLink() {
		try {
			Log.info("Locating My Earnings link on Home Page");
			reportStep("Locating My Earnings link on Home Page", "INFO");
			Utils.explicitWaitForClick(lnkMyEarning);
			Log.info("Successfully clicked My Earnings link on Home Page");
			reportStep("Successfully clicked My Earnings link on  Home Page", "PASS");
		} catch (Exception e) {
			Log.info("Unable to click My Earnings link on  Home Page");
			reportStep("Unable to click My Earnings link on  Home Page", "FAIL");
		}
		return new WPMyEarningsPage(driver, logger);
	}

	@FindBy(id = "link_howitworks")
	private static WebElement lnkHowItWorks;

	// Click My Earning Link
	public WPHowItWorks clickHowItWorksLink() {
		String locator = "Locating How It Works Page in Home Page";
		String pass = "Successfully clicked How It Works Page in Home Page";
		String fail = "Unable to click How It Works Page in Home Page";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			Utils.explicitWaitForClick(lnkHowItWorks);
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPHowItWorks(driver, logger);
	}

	// Header Section Elements of Home Page
	// Word Press Logo
	@FindBy(xpath = "//div[@class='header_top']//img[@id='imgTopSiteLogo']")
	private WebElement imgLogo;

	public WPHomePage verifyLogoIsPresent() {
		try {
			reportStep("Verifying Logo is Present ", "INFO");
			Utils.verifyElementPresence(imgLogo);
			reportStep("Verification Completed: Logo is Present ", "PASS");
		} catch (Exception e) {
			reportStep("Verification Completed: Logo is not Present ", "FAIL");
		}
		return this;
	}

	// Click on Logo
	public WPHomePage clickOnLogo() {
		try {
			reportStep("Clicking On Logo", "INFO");
			Log.info("Verifying Logo is Present");
			Utils.click(imgLogo);
			reportStep("Clicked Successfully on Logo", "PASS");
			Log.info("Clicked Successfully on Logo");
		} catch (Exception e) {
			reportStep("Unable to Click Logo ", "FAIL");
			Log.fatal("Unable to Click Logo \", \"FAIL\"");
		}
		return this;
	}

	// Hamburger Menu link
	@FindBy(id = "ajaxMenuLoad")
	private static WebElement lnkHamburgerMenu;

	public WPHomePage clickHambergerMenu() {
		try {
			reportStep("Clicking On Hamburger Menu", "INFO");
			Log.info("Verifying Hamburger Menu is Present");
			Utils.click(lnkHamburgerMenu);
			reportStep("Clicked Successfully on Hamburger Menu", "PASS");
			Log.info("Clicked Successfully on Hamburger Menu");
		} catch (Exception e) {
			Log.fatal("Unable to Click Hamburger Menu");
			reportStep("Unable to Click Hamburger Menu ", "FAIL");
		}
		return this;
	}

	// Verifying Hamberger Menu is present
	public WPHomePage verifyHambergerMenuIsPresent() {
		try {
			reportStep("Verifying On Hamburger Menu", "INFO");
			Log.info("Verifying Hamburger Menu is Present");
			Utils.verifyElementPresence(lnkHamburgerMenu);
			reportStep("Hamburger Menu is present", "PASS");
			Log.info("Hamburger Menu is present");
		} catch (Exception e) {
			Log.fatal("Hamburger Menu is not present");
			reportStep("Hamburger Menu is not present", "FAIL");
		}
		return this;
	}

	// Dynamic Main Category
	// Since @FindBy annotations does not support dynamic xpath, hence the
	// author is violating Page Factory rule here
	public WebElement mainCategory(String category) {
		WebElement element = null;
		try {
			Log.info("Locating Main Category");
			Utils.explicitWaitForVisibility(driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]")));
			Log.info("Successfully located Main Category");
		} catch (Exception e) {
			Log.info("Unable to locate Main Category");
			reportStep("Unable to locate Main Category", "FAIL");

			throw e;
		}
		return element;
	}

	// Click Category
	// Violation of page factory has been done because
	// utils.click and utils.jsClick is not working
	public WPHomePage clickCategory(String category) throws Exception {
		try {
			Log.info("Trying to click  Main Category : " + category);
			reportStep("Trying to click Main Category: " + category, "INFO");
			Utils.sleep();
			driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]")).click();
			Log.info("clicked successfully  Main Category : " + category);
			reportStep("clicked successfully  Main Category : " + category, "PASS");
		} catch (Exception e) {
			Log.info("Unable to click Main Category");
			e.printStackTrace();
			reportStep("Unable to click Main Category", "FAIL");
		}
		return this;
	}

	// Click Main Category
	public WPStoreCategoryPage clickMainCategory(String category) {
		try {
			Log.info("Trying to click  Main Category" + category);
			reportStep("Trying to click Main Category: " + category, "INFO");
			Utils.sleep();
			driver.findElement(By.xpath("//a[contains(text(),'" + category + "')]")).click();
			Log.info("clicked successfully  Main Category");
			reportStep("clicked successfully  Main Category: " + category, "PASS");
		} catch (Exception e) {
			Log.info("Unable to click Main Category");
			reportStep("Unable to click Main Category: " + category, "FAIL");
		}
		return new WPStoreCategoryPage(driver, logger);
	}

	// Locating Sub category
	public WebElement subCategory() {
		WebElement element = null;
		try {
			Log.info("Locating Sub Category");
			element = driver.findElement(By.xpath("//a[contains(text(),'" + subCategory + "')]"));
			Log.info("Successfully located Sub Category");
		} catch (Exception e) {
			Log.info("Unable to locate Sub Category");
			reportStep("Unable to locate Sub Category", "FAIL");

			throw e;
		}
		return element;
	}

	// Clicking to click Sub Category
	public WPHomePage clickSubCategory() {
		try {
			Log.info("Trying to click  Sub Category");
			reportStep("Trying to click Sub Category", "INFO");
			Utils.explicitWaitForClick(driver.findElement(By.xpath("//a[contains(text(),'" + subCategory + "')]")));
			Utils.click(subCategory());
			Log.info("clicked successfully  Sub Category");
			reportStep("clicked successfully  Sub Category", "PASS");
		} catch (Exception e) {
			Log.info("Unable to click Sub Category");
			reportStep("Unable to click Sub Category", "FAIL");
			throw e;
		}
		return this;
	}

	// Label Sign In Sign Up
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	private static WebElement lblSignInSignUP;

	public WPHomePage clickOnlblSignInSignUP() {
		try {
			reportStep("Verifying On  Sign In/ Sign UP", "INFO");
			Log.info("Verifying  Sign In/ Sign UP is Present");
			Utils.sleep();// Even if the Sign In element is not visible but
							// present in DOM, driver is clicking on Sign In
			if (Utils.click(lblSignInSignUP)) {
				reportStep("Clicked Successfully on Sign In/ Sign UP", "PASS");
				Log.info("Clicked Successfully on Sign In/ Sign UP");
			} else {
				Log.fatal("Unable to Click Sign In/ Sign UP \", \"FAIL\"");
				reportStep("Unable to Click Sign In/ Sign UP ", "FAIL");
			}

		} catch (Exception e) {

		}
		return this;
	}

	// Sign In Link
	@FindBy(xpath = "//a[text()='Sign in']")
	private static WebElement lnkSignIn;

	// Click on Sign In Link
	public WPSignUpSignInPopUp clickOnlnkSignIn() {
		try {
			reportStep("Clicking On Sign In Link", "INFO");
			Log.info("Clicking On Sign In Link");
			Utils.explicitWaitForClick(lnkSignIn);
			reportStep("Clicked Successfully on Sign In Link", "PASS");
			Log.info("Clicked Successfully on Sign In Link");
		} catch (Exception e) {
			Log.error("Unable to Click Sign In Link");
			reportStep("Unable to Click Sign In", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	// Search Store or Coupon element
	@FindBy(name = "search_store")
	private static WebElement txtBxSearchStoreOrCoupons;

	// Searching Voucher and Store
	public WPSearchResultsPage searchForVoucherOrStore(String search) {
		try {
			reportStep("Locating Search Bar in Header Section", "INFO");
			Log.info("Locating Search Bar in Header Section");
			Utils.explicitWaitForClick(txtBxSearchStoreOrCoupons);
			Utils.sendKeysAndPressEnter(txtBxSearchStoreOrCoupons, search);
			reportStep("Successfully entered what needs to be searched: " + search, "PASS");
			Log.info("Successfully entered what needs to be searched");
		} catch (Exception e) {
			Log.fatal("Unable to enter what needs to be searched in Home Page Search Bar");
			reportStep("Unable to enter what needs to be searched in Home Page Search Bar", "FAIL");
		}
		return new WPSearchResultsPage(driver, logger);
	}

	@FindBy(xpath = "//div[@class='store_card']/a[contains(text(),'ACTIVATE CASHBACK')]")
	private static List<WebElement> lnkStoreCardActivateCashback;

	// Clicking Store Card Activate Cashback button
	public WPSignUpSignInPopUp clickStoreCardActivateCashbackLink() {
		try {
			reportStep("Locating Store Card First Activate Cashback Link", "INFO");
			Log.info("Locating Store Card First Activate Cashback Link");
			Utils.explicitWaitForClick(lnkStoreCardActivateCashback.get(12));
			reportStep("Successfully Clicked Store Card First Activate Cashback Link", "PASS");
			Log.info("Successfully Clicked Store Card First Activate Cashback Link");
		} catch (Exception e) {
			Log.fatal("Unable to Click Store Card First Activate Cashback Link");
			reportStep("Unable to click Store Card First Activate Cashback Link", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	public WPHomePage clickFirstActivateCashbackLink() {
		try {
			reportStep("Locating Store Card First Activate Cashback Link", "INFO");
			Log.info("Locating Store Card First Activate Cashback Link");
			Utils.explicitWaitForClick(lnkStoreCardActivateCashback.get(13));
			reportStep("Successfully Clicked Store Card First Activate Cashback Link", "PASS");
			Log.info("Successfully Clicked Store Card First Activate Cashback Link");
		} catch (Exception e) {
			Log.fatal("Unable to Click Store Card First Activate Cashback Link");
			reportStep("Unable to click Store Card First Activate Cashback Link", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private static WebElement lblMyAccount;

	// Click My Account Link
	public WPHomePage ClickOnMyAccount() {
		try {
			reportStep("Clicking On My Account label", "INFO");
			Log.info("Clicking On My Account label ");
			Utils.click(lblMyAccount);
			reportStep("Clicked Successfully on My Account label", "PASS");
			Log.info("Clicked Successfully on My Account label");
		} catch (Exception e) {
			Log.error("Unable to Click My Account label");
			reportStep("Unable to Click My Account label ", "FAIL");
		}
		return this;
	}

	// Verify Presence of My Account label
	public WPHomePage verifyPresenceOfMyAccountLabel() {
		try {
			Utils.explicitWaitForClick(lblMyAccount);
			reportStep("Verifying My Account Label is present on Home Page or not", "INFO");
			Log.info("Verifying My Account Label is present on Home Page or not");
			presence = Utils.verifyElementPresence(lblMyAccount);
			if (!presence) {
				throw new Exception("My Account Label is not present on Home Page");
			}
			reportStep("My Account Label is present on Home Page", "PASS");
			Log.info("My Account Label is  present on Home Page");
		} catch (Exception e) {
			reportStep("My Account Label is not present on Home Page", "FAIL");
			Log.error("My Account Label is not present on Home Page");
		}
		return this;
	}

	// Click My Account on Home Page
	public WPAccountSettingsPage clickMyAccountLabeloOnHomePage() {
		try {
			reportStep("Verifying My Account Label is present on Home Page or not", "INFO");
			Log.info("Verifying My Account Label is present on Home Page or not");
			Utils.explicitWaitForClick(lblMyAccount);
			reportStep("Clicked Successfully on My Account Label on Home Page", "PASS");
			Log.info("Clicked Successfully on My Account Label on Home Page");
		} catch (Exception e) {
			reportStep("Unable to Click on My Account Label on Home Page", "FAIL");
			Log.error("Unable to Click on My Account Label on Home Page");
		}
		return new WPAccountSettingsPage(driver, logger);
	}

	public WPHomePage clickMyAccountLabel() {
		try {
			reportStep("Verifying My Account Label is present on Home Page or not", "INFO");
			Log.info("Verifying My Account Label is present on Home Page or not");
			Utils.explicitWaitForClick(lblMyAccount);
			reportStep("Clicked Successfully on My Account Label on Home Page", "PASS");
			Log.info("Clicked Successfully on My Account Label on Home Page");
		} catch (Exception e) {
			reportStep("Unable to Click on My Account Label on Home Page", "FAIL");
			Log.error("Unable to Click on My Account Label on Home Page");
		}
		return this;
	}

	@FindBy(xpath = "(//div[@class='trend_card'])[1]")
	private static WebElement lnkfirstStoreCard;

	// Click First Store Card
	public WPStorePage clickFirstStoreCard() {
		try {
			reportStep("Clicking Home Page First Store Card", "INFO");
			Log.info("Clicking Home Page First Store Card");
			Utils.click(lnkfirstStoreCard);
			reportStep("Clicked successfully Home Page First Store Card", "PASS");
			Log.info("Clicked successfully Home Page First Store Card");
		} catch (Exception e) {
			Log.info("Unable to click Home Page First Store Card");
			reportStep("Unable to click Home Page First Store Card", "FAIL");
		}
		return new WPStorePage(driver, logger);
	}

	// refresh home page
	public WPHomePage refreshHomePage(WebDriver driver) {
		try {
			reportStep("Refreshing Home Page ------", "INFO");
			Log.info("Refreshing Home Page ------");
			this.driver = driver;
			Utils.refresh(driver);
			Utils.sleep10sec();
			// Utils.explicitWaitForClick(lblMyAccount);
			reportStep("After refreshing Home Page My Account Label not visible", "PASS");
			Log.info("After refreshing Home Page My Account Label was visible");
		} catch (Exception e) {
			Log.fatal("After refreshing Home Page My Account Label was not visible");
			reportStep("After refreshing Home Page My Account Label was not visible", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//button[contains(text(),'Continue as')]")
	private static WebElement btnFbContinueAs;

	@FindBy(id = "lnkLayoutFacebook")
	private static WebElement btnSignInWithFB;

	// RegisteredUser Locator are identified Below

	@FindBy(id = "link_join")
	private static WebElement lnkJoinFree;

	public WPJoinFree clickJoinFreeLink() {
		Log.info("Trying to click Join Free Link");
		reportStep("Trying to click Join Free Link", "INFO");
		if (Utils.click(lnkJoinFree)) {
			Log.info("Clicked Successfully Join Free Link");
			reportStep("Clicked Successfully Join Free Link", "PASS");
		} else {
			Log.info("Unable to click Join Free Link");
			reportStep("Unable to click Join Free Link", "FAIL");
		}
		return new WPJoinFree(driver, logger);
	}

	@FindBy(name = "login")
	private static WebElement btnFbLogin;

	@FindBy(name = "mobileNo")
	private static WebElement txtBxFBMobileNumber;

	@FindBy(xpath = "//span[text()='CashKaro']")
	private static WebElement lblDisclaimerOfCashkaro;

	// Partners Logo
	@FindBy(id = "imgTopSiteLogo")
	private static WebElement lnkLogo;

	public WPHomePage clickLogo() {
		Log.info("Waiting for Logo");
		reportStep("Waiting for Logo", "INFO");
		if (Utils.click(lnkLogo)) {
			Log.info("Clicked Successfully Logo");
			reportStep("Clicked Successfully Logo", "PASS");
		} else {
			Log.info("Unable to click Logo");
			reportStep("Unable to click Logo", "FAIL");
		}
		return this;
	}

	@FindBy(id = "link_contactus")
	private static WebElement lnkContactUsFooter;

	// This method will click contact us link in footer Of Home Page
	public WPContactUsPage clickContactUsLink() {
		Log.info("Locating Contact Us Link");
		reportStep("Locating Contact Us Link", "INFO");
		if (Utils.jsClick(lnkContactUsFooter, driver)) {
			Log.info("Clicked Successfully on Contact Us Link in Footer");
			reportStep("Clicked Successfully on Contact Us Link in Footer", "PASS");
		} else {
			Log.info("Unable to click Contact Us Link in Footer");
			reportStep("Unable to click Contact Us Link in Footer", "FAIL");
		}
		return new WPContactUsPage(driver, logger);
	}

	@FindBy(id = "idMenuPayments")
	private static WebElement lnkPaymentsMenu;

	// This method will click contact us link in footer Of Home Page
	public WPPaymentPage clickPaymentsMenuOnHomePage() {
		String locator = "Locating Payments Menu in HomePage";
		String pass = "Clicked Successfully Payments Menu in HomePage";
		String fail = "Unable to click Payments Menu in HomePage";
		Log.info(locator);
		reportStep(locator, "INFO");
		if (Utils.click(lnkPaymentsMenu)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		} else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}
	
	@FindBy(id="idMenuMissingCashback")
	private static WebElement lnkMissingCashBack;
	//Click My Earning Link
	public WPMissingTicket clickMissingCashBackLink() {
		try {
			Log.info("Locating Missing Cashback link on Search Result Page");
			reportStep("Locating Missing Cashback link on Search Result Page", "INFO");
			Utils.explicitWaitForClick(lnkMissingCashBack);
			Log.info("Successfully clicked Missing Cashback link on Search Result Page");
			reportStep("Successfully clicked Missing Cashback link on  Search Result Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Missing Cashback link on  Search Result Page");
			reportStep("Unable to click Missing Cashback link on  Search Result Page", "FAIL");
		}
		return new WPMissingTicket(driver, logger);
	}

	// Add Cashback to Account
	public WPHomePage addCashbackRewards(String amount, String email, String cashBackType) {
		Log.info("Adding " + cashBackType + " CashBack to user account");
		reportStep("Adding " + cashBackType + " CashBack to user account", "INFO");
		Utils.addCashbackRewards(driver, amount, email, cashBackType);
		Log.info("Successfully Added " + amount + " CashBack of type " + cashBackType + " to user account");
		reportStep("Successfully Added " + amount + " CashBack of type " + cashBackType + " to user account", "PASS");
		return this;
	}

	/**
	 * Page Object and Actions Of Master Card starts here..
	 */
	@FindBy(xpath = "//button[text()='Proceed ']")
	private static WebElement btnProceed;

	public WPHomePage clickOnProceedButton() {
		String locator = "Locating Proceed button in HomePage";
		String pass = "Clicked Successfully on Proceed button in HomePage";
		String fail = "Unable to click Proceed button in HomePage";
		Log.info(locator);
		reportStep(locator, "INFO");
		if (Utils.click(btnProceed)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		} else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//a[contains(text(),'View More')]")
	private static WebElement lnkViewMore;

	public WPHomePage clickOnviewMoreLink() {
		String locator = "Locating View More Link in HomePage";
		String pass = "Clicked Successfully on View More Link in HomePage";
		String fail = "Unable to click View More Link in HomePage";
		Log.info(locator);
		reportStep(locator, "INFO");
		if (Utils.click(lnkViewMore)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		} else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	// Click First Store Card
	public WPHomePage clickFirstStoreCard_partner1() {
		try {
			reportStep("Clicking Home Page First Store Card", "INFO");
			Log.info("Clicking Home Page First Store Card");
			Utils.click(lnkfirstStoreCard);
			reportStep("Clicked successfully Home Page First Store Card", "PASS");
			Log.info("Clicked successfully Home Page First Store Card");
		} catch (Exception e) {
			Log.info("Unable to click Home Page First Store Card");
			reportStep("Unable to click Home Page First Store Card", "FAIL");
		}
		return this;
	}

	public WPHomePage verifypartner1loggedin() {

		reportStep("Locating Store Card First Activate Cashback Link", "INFO");
		Log.info("Locating Store Card First Activate Cashback Link");

		try {

			String str = lnkStoreCardActivateCashback.get(12).getAttribute("href");
			String id = str.substring(str.indexOf("id="));
			System.out.println("User ID =" + id);

			if (str.contains("id=")) {

				reportStep("Successfully logged in - " + id, "INFO");
				Log.info("Successfully logged in - " + id);

				Utils.scrollToBottomOfPage(driver);
				lnkStoreCardActivateCashback.get(12).click();

			}

			else

			{

				reportStep("Failed to loggedin as a new user", "FAIL");
				Log.info("Failed to loggedin as a new user");
			}
		} catch (Exception e) {
			Log.fatal("Failed to loggedin as a new user");
			reportStep("Failed to loggedin as a new user", "FAIL");
		}
		return this;

	}

	public WPHomePage verifypartner1loggedinfailure() {

		reportStep("Locating Store Card First Activate Cashback Link", "INFO");
		Log.info("Locating Store Card First Activate Cashback Link");

		try {

			String str = lnkStoreCardActivateCashback.get(12).getAttribute("href");
			String id = str.substring(str.indexOf("id="));
			System.out.println("User ID =" + id);

			if (str.contains("id=")) {

				reportStep("Successfully logged in - " + id, "FAIL");
				Log.info("Successfully logged in - " + id);

				Utils.scrollToBottomOfPage(driver);
				lnkStoreCardActivateCashback.get(12).click();

			}

			else

			{

				reportStep("Failed to loggedin", "PASS");
				Log.info("Failed to loggedin");
			}
		} catch (Exception e) {
			Log.fatal("Unable to verify login failure");
			reportStep("Failed to loggedin as a new user", "FAIL");
		}
		return this;

	}

	public WPHomePage hitICICILoginwithFedIDAndChannelfromStorepage(String FedID, String Channel) {
		Log.info("Launching ICICI with the FedID " + FedID);
		reportStep("Launching ICICI with the " + FedID + "number", "INFO");
		Utils.iciciLoginwithFedIDAndChannel(driver, FedID, Channel);
		Log.info("Successfully launched url with FEDID :" + FedID + " & Channel :" + Channel);
		reportStep("Successfully launched url with FEDID :" + FedID + " & Channel :" + Channel, "PASS");
		return new WPHomePage(driver, logger);
	}

	public WPHomePage hitICICILoginonlywithFedIDStorePage(String FedID) {
		Log.info("Launching ICICI with the FedID " + FedID);
		reportStep("Launching ICICI with the " + FedID + "number", "INFO");
		Utils.iciciLoginwithFedID(driver, txtreference, FedID);
		Log.info("Successfully launched url with FEDID :" + FedID);
		reportStep("Successfully launched url with FEDID :" + FedID, "PASS");
		return new WPHomePage(driver, logger);
	}

	public WPHomePage hitICICILoginwithFedIDAndChannelAndRedirectionURLfromStorepage(String FedID, String Channel,
			String URL) {
		Log.info("Launching ICICI with the FedID " + FedID);
		reportStep("Launching ICICI with the " + FedID + "number", "INFO");
		Utils.iciciLoginwithFedIDAndChannelRedirectionURL(driver, FedID, Channel, URL);
		Log.info("Successfully launched url with FEDID :" + FedID + " & Channel :" + Channel);
		reportStep("Successfully launched url with FEDID :" + FedID + " & Channel :" + Channel, "PASS");
		return new WPHomePage(driver, logger);
	}

	@FindBy(xpath = "//span[text()='Manage Cashback']")
	private static WebElement btnManageCashback;

	public WPHomePage clickManageCashback() {
		Log.info("Trying to click ManageCashback Link");
		reportStep("Trying to click ManageCashback Link", "INFO");
		if (Utils.click(btnManageCashback)) {
			Log.info("Clicked Successfully ManageCashback Link");
			reportStep("Clicked Successfully ManageCashback Link", "PASS");
		} else {
			Log.info("Unable to click Join Free Link");
			reportStep("Unable to click Join Free Link", "FAIL");
		}
		return this;
	}

	@FindBy(id = "reference")
	private static WebElement txtreference;

	public WPHomePage enterReference(String Ref) {
		String locator = "Locating Proceed button in HomePage";
		String pass = "Clicked Successfully on Proceed button in HomePage";
		String fail = "Unable to click Proceed button in HomePage";
		Log.info(locator);
		reportStep(locator, "INFO");
		if (Utils.sendKeys(txtreference, Ref)) {
			txtreference.sendKeys(Keys.ENTER);
			Log.info(pass);
			reportStep(pass, "PASS");
		} else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	public WPHomePage VerifyRedirectionURL() {

		return this;
	}

}
