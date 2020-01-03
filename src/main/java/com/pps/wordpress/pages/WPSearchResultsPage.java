package com.pps.wordpress.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

public class WPSearchResultsPage extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPSearchResultsPage.class);

	//Constructor
	public WPSearchResultsPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.debug("Waiting for the Home page");
		reportStep("Waiting for the Home page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lblSearchResults));
			Log.debug("Successfully landed on the Search Results page");
			reportStep("Successfully landed on the Search Results Page ", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Not able to land on the Search Results page", "FAIL");
			Log.error("Not able to land on the Search Results page");
		} 
	}

	@FindBy(xpath="//h2[contains(text(),'SEARCH RESULTS')]")
	private static WebElement lblSearchResults;

	@FindBy(xpath="(//a[contains(text(),'ACTIVATE CASHBACK')])[1]")
	private static WebElement lnkActivateCashbackInStoreCard;

	//Click on Store card Activate Cashback Link
	public WPSignUpSignInPopUp clickOnStoreCardActivateCashBackLink() {
		try {
			Log.info("Locating Store Card Activate Cashback Link the Search Results page");
			reportStep("Locating Store Card Activate Cashback Link the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkActivateCashbackInStoreCard);
			Log.info("Successfully clicked Store Card Activate Cashback Link the Search Results page");
			reportStep("Successfully clicked Store Card Activate Cashback Link the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Store Card Activate Cashback Link the Search Results page");
			reportStep("Unable to click Store Card Activate Cashback Link the Search Results page", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	@FindBy(xpath="//div[@class='voucher_card']/a[contains(text(),' ACTIVATE CASHBACK')]")
	private static WebElement lnkVoucherCardActivateCashback;

	//Click on Voucher Card Activate Cashback Link
	public WPSignUpSignInPopUp clickOnVoucherCardActivateCashBackLink() {
		try {
			Log.info("Locating Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Locating Voucher Card Activate Cashback Link the Search Results page", "INFO");
			Utils.explicitWaitForClick(lnkActivateCashbackInStoreCard);
			Log.info("Successfully clicked Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Successfully clicked Voucher Card Activate Cashback Link the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Unable to click Voucher Card Activate Cashback Link the Search Results page", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	//Click on Voucher Card Activate Cashback Link
	public WPSearchResultsPage clickOnVoucherCardActivateCashBack() {
		try {
			Log.info("Locating Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Locating Voucher Card Activate Cashback Link the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkActivateCashbackInStoreCard);
			Log.info("Successfully clicked Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Successfully clicked Voucher Card Activate Cashback Link the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Unable to click Voucher Card Activate Cashback Link the Search Results page", "FAIL");
		}
		return this;
	}
	@FindBy(xpath="//*[contains(text(),'My Account')]")
	private static WebElement lblMyAccount;
	
	public WPSearchResultsPage clickMyAccountLabel() {
		try {
			reportStep("Verifying My Account Label is present on Home Page or not", "INFO");
			Log.info("Verifying My Account Label is present on Home Page or not");
			Utils.explicitWaitForClick(lblMyAccount);
			reportStep("Clicked Successfully on My Account Label on Home Page", "PASS");
			Log.info("Clicked Successfully on My Account Label on Home Page");
		}catch(Exception e) {
			reportStep("Unable to Click on My Account Label on Home Page", "FAIL");
			Log.error("Unable to Click on My Account Label on Home Page");
		}
		return this;
	}

	@FindBy(xpath="(//a[contains(text(),'VIEW ALL')])[1]")
	private static WebElement lnkViewAllRetailers;

	//Click View All Link in retailers section 
	public WPStoreListingPage clickViewAllLinkRetailer() {
		try {
			Log.info("Locating View All Link the Search Results page");
			reportStep("Locating View All Link in the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkViewAllRetailers);
			Log.info("Successfully clicked View All Link in the Search Results page");
			reportStep("Successfully clicked View All Link in the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click  View All Link in the Search Results page");
			reportStep("Unable to click View All Link in the Search Results page", "FAIL");
		}
		return new WPStoreListingPage(driver, logger);
	}

	@FindBy(xpath="(//a[contains(text(),'VIEW ALL')])[2]")
	private static WebElement lnkViewAllVoucher;

	//Click view all link in Voucher Section
	public WPStoreListingPage clickViewAllLinkVoucher() {
		try {
			Log.info("Locating View All Link For Voucher the Search Results page");
			reportStep("Locating View All Link for Voucher in the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkViewAllVoucher);
			Log.info("Successfully clicked View All Link For Voucherin the Search Results page");
			reportStep("Successfully clicked View All Link For Voucher in the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click  View All Link Voucher in the Search Results page");
			reportStep("Unable to click View All Link  Voucher in the Search Results page", "FAIL");
		}
		return new WPStoreListingPage(driver, logger);
	}
	
	@FindBy(id="idMenuEarnings")
	private static WebElement lnkMyEarning;
	//Click My Earning Link
	public WPMyEarningsPage clickMyEarningLink() {
		try {
			Log.info("Locating My Earnings link on Search Result Page");
			reportStep("Locating My Earnings link on Search Result Page", "INFO");
			Utils.explicitWaitForClick(lnkMyEarning);
			Log.info("Successfully clicked My Earnings link on Search Result Page");
			reportStep("Successfully clicked My Earnings link on  Search Result Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click My Earnings link on  Search Result Page");
			reportStep("Unable to click My Earnings link on  Search Result Page", "FAIL");
		}
		return new WPMyEarningsPage(driver, logger);
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
	@FindBy(name="search_store")
	private static WebElement txtBxSearchStoreOrCoupons;
	
	
	public WPSearchResultsPage verifyplaceholdervalue() {
		try {
			reportStep("Locating Search Bar in Header Section", "INFO");
			Log.info("Locating Search Bar in Header Section");
			if(txtBxSearchStoreOrCoupons.getAttribute("value").equals("Search Retailers or Coupons"))
			{
			reportStep("place holder value verified successfully", "PASS");
			Log.info("place holder value verified successfully");
			}
		}catch(Exception e) {
			Log.fatal("failed to verify placeholder value");
			reportStep("failed to verify placeholder value", "FAIL");
		}
		return this;
	}
	
	public WPSearchResultsPage searchForVoucherOrStore(String search) {
		try {
			reportStep("Locating Search Bar in Header Section", "INFO");
			Log.info("Locating Search Bar in Header Section");
			Utils.explicitWaitForClick(txtBxSearchStoreOrCoupons);
			Utils.sendKeysAndPressEnter(txtBxSearchStoreOrCoupons, search);
			reportStep("Successfully entered "+search+"  to be searched: " +search, "PASS");
			Log.info("Successfully entered "+search+" to be searched");
		}catch(Exception e) {
			Log.fatal("Unable to enter "+search+" to be searched in Home Page Search Bar");
			reportStep("Unable to enter "+search+" to be searched in Home Page Search Bar", "FAIL");
		}
		return this;
	}
	
	// To make this dynamic below approach has been used instead of page factory
	public WebElement firstStoreImageInStoreCardOnSearchResult(String storeName) {
		WebElement element = null;
		try {
			String locator="Successfully located First Store Image in Search Result Page";
			System.out.println("(//a[@title='"+storeName +"'])[1]");
			element=driver.findElement(By.xpath("(//a[@title='"+storeName +"'])[1]"));
			Log.info(locator);
			reportStep(locator, "PASS");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	
	// To make this dynamic below approach has been used instead of page factory
	public WebElement VerifySearchResultsAfterStoreInactive(String storeName) {
		WebElement element = null;
		try {
			String locator="Successfully located First Store Image in Search Result Page";
			System.out.println("(//a[@title='"+storeName +"'])[1]");
			List<WebElement> elementslist =driver.findElement(By.xpath("(//a[@title='"+storeName +"'])[1]"));
			if(elementslist.size()==0){
				Log.info("Store InActive Verification completed");
				reportStep("Store InActive Verification completed", "PASS");
			}else {
				Log.info("Store InActive Verification failed");
				reportStep("Store InActive Verification failed", "FAIL");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	
	// To make this dynamic below approach has been used instead of page factory
	public WebElement VerifySearchResultssuggestione(String storeName) {
		WebElement element = null;
		try {
			String locator="Successfully located First Store Image in Search Result Page";
			System.out.println("(//a[@title='"+storeName +"'])[1]");
			List<WebElement> elementslist =driver.findElement(By.xpath("(//a[@title='"+storeName +"'])[1]"));
			if(elementslist.size()>0){
				Log.info("Seacrh result suggestion Verification completed");
				reportStep("Seacrh result suggestion Verification completed", "PASS");
			}else {
				Log.info("Seacrh result suggestion Verification failed");
				reportStep("Seacrh result suggestion Verification failed", "FAIL");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public WPStorePage clickOnStoreImage(String storeName) {
		String pass="Successfully clicked on first Store Card Image in Search Result Page to Navigate to Store Page";
		String fail="Unable to click at first Store Card Image in Search Result Page";
		if(Utils.click(firstStoreImageInStoreCardOnSearchResult(storeName))){
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPStorePage(driver, logger);
	}
	
	
	
	@FindBy(xpath="//strong[contains(text(),'No results']")
	private static WebElement txtNoResults;
	
	
	public WPSearchResultsPage verifyNoresultsFound(String storeName) {
		String locator="Locating no results found";
		String pass="No results found is verified successfully";
		String fail="Failure to verify No Results found";
		Log.info(locator);
		reportStep(locator, "INFO");
		
		if(txtNoResults.isDisplayed()) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}else {
			Log.info(pass);
			reportStep(pass, "PASS");
		}
		return this;
	}
	
	
	
	@FindBy(xpath="//div[@class='no_voucher']")
	private static WebElement txtNoCoupons;
	
	
	public WPSearchResultsPage verifyNoCouponsFound(String storeName) {
		String locator="Locating no voucher found";
		String pass="No voucher found is verified successfully";
		String fail="Failure to verify No voucher found";
		Log.info(locator);
		reportStep(locator, "INFO");
		
		if(txtNoCoupons.isDisplayed()) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}else {
			Log.info(pass);
			reportStep(pass, "PASS");
		}
		return this;
	}
	
	
	public WPSearchResultsPage verifyInactiveStoreNotDisplayingInSearchResultPage(String storeName) {
		String locator="Locating Inactive Store in Search Result Page";
		String pass="Inactive Store is displaying in Search Result Page is verified successfully";
		String fail="Inactive Store is displaying in Search Result Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		int size=Utils.getNumberOfElements(driver.findElements(By.xpath("(//a[@title='"+storeName +"'])[1]")));
		if(size>0) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}else {
			Log.info(pass);
			reportStep(pass, "PASS");
		}
		return this;
	}
	
	
	public WPSearchResultsPage refreshStorePage(WebDriver driver) {
		try {
			reportStep("Refreshing Store Page ------","INFO");
			Log.info("Refreshing Store Page ------");
			this.driver=driver;
			Utils.refresh(driver);
	        Utils.sleep10sec();
			//Utils.explicitWaitForClick(lblMyAccount);
			reportStep("Store page refreshed","PASS");
			Log.info("Store page refreshed");
		}catch(Exception e) {
			Log.fatal("Error in Refreshing store page");
			reportStep("Error in Refreshing store page","FAIL");
		}
		return this;
	}
	
	public WPSearchResultsPage verifypartner1loggedin()
	{
		
		reportStep("Locating Store Card First Activate Cashback Link", "INFO");
		Log.info("Locating Store Card First Activate Cashback Link");
		
		try {
			
       String str = lnkVoucherCardActivateCashback.getAttribute("href");		
		String id = str.substring(str.indexOf("id="));		
		System.out.println("User ID ="+id);
	
		
		
			
			if (str.contains("id="))
			{			

				reportStep("Successfully logged in - "+id, "INFO");
				Log.info("Successfully logged in - "+id);
				
				Utils.scrollToBottomOfPage(driver);
				lnkVoucherCardActivateCashback.click();
				
				
			}
				
				else
					
				{
					
			
				reportStep("Failed to loggedin as a new user", "FAIL");
				Log.info("Failed to loggedin as a new user");
			}
		}catch(Exception e) {
			Log.fatal("Failed to loggedin as a new user");
			reportStep("Failed to loggedin as a new user", "FAIL");
		}
	return this;
		
	}
	
	
	@FindBy(xpath = "//span[text()='Manage Cashback']")
	private static WebElement btnManageCashback;
	
	public WPSearchResultsPage clickManageCashback(){
		Log.info("Trying to click ManageCashback Link");
		reportStep("Trying to click ManageCashback Link","INFO");
		if(Utils.click(btnManageCashback)) {
			Log.info("Clicked Successfully ManageCashback Link");
			reportStep("Clicked Successfully ManageCashback Link","PASS");
		}else {
			Log.info("Unable to click Join Free Link");
			reportStep("Unable to click Join Free Link","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//div[@class='container search_main']/div/h2")
	private static WebElement SearchResultShortDesc;
	
	public WPSearchResultsPage VerifySearchResultShortdesc(String desc){
		Log.info("Trying verify searchresult short desc");
		reportStep("Trying verify searchresult short des","INFO");
		
		String s = "Results for your search "+desc;
		if(SearchResultShortDesc.equals(s)) {
			Log.info("verify searchresult short des pass");
			reportStep("verify searchresult short desc pass","PASS");
		}else {
			Log.info("Unable verify searchresult short des");
			reportStep("Unableverify searchresult short des","FAIL");
		}
		return this;
	}
	
	
	
	
}
