package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Seleniumbase extends TestSetUp {
	

	public static final Logger log = LogManager.getLogger(Seleniumbase.class);
	
	
	public  void verifyDisplayed(WebDriver driver, String label,WebElement ele) 
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			if (ele.isDisplayed()) 
			{
				
				log.info(label +" is displayed in login page");
				reportStep(label + " is displayed in the login page", "PASS");
			}

			else
			{
				reportStep(label +" is not displayed in the login page", "FAIL");
				log.error(label+" is not displayed in the login page");
				Assert.fail(label+" is not displayed in the login page");
			}
		} 
		catch (Exception e) 
		{
			int position = e.toString().indexOf("Exception:");
			String error = e.toString().substring(0, position + 10);
			//reportStep("Unable to find Element --> " + error, "fail");
			log.error("Unable to find Element ");
			//Assert.fail("Unable to find Element");
		}
	}
	
	public void VerifyChar_allowance(String label,WebElement ele, String data)
	{

		try{
			ele.clear();
			ele.sendKeys(data);
			if (ele.getAttribute("value").equals(data))
			{
				reportStep(data +"allowed in the "+label+ " field","pass");	
			}
			else
			{
				reportStep(data+"not allowed in the "+label+ "field","fail");	
			}
		}
		catch(Exception e){
			
			reportStep(data+"not allowed in the "+label+ "field since cannot able to locate field","fail");
		}


	}


	public void VerifyChar_NotAllowance(String Label , WebElement ele, String data)
	{

		try{
			ele.clear();
			ele.sendKeys(data);
			if (ele.getAttribute("value").length()==0)
			{
				reportStep(data+"not allowed in the field","pass");	
			}
			else
			{
				reportStep(data+"allowed in the field","fail");	
			}
		}
		catch(Exception e){
			reportStep(data+"not allowed in the field since cannot able to locate field","fail");
		}


	}
	
	
	public void verifyFieldLength(WebElement ele,int size) 	{

		int actualsize=0;

		try 
		{
			
			 actualsize = Integer.parseInt(ele.getAttribute("maxlength"));
			
			if(actualsize == size)
			{
				reportStep("The actual size matches the expected size " + actualsize, "pass");
				log.info("The actual size matches the expected size" + actualsize );
			}

			else
			{
				reportStep("The actual size does not matches the expected size, the Actual size is: " + actualsize, "fail");
				log.info("The actual size matches the expected size " + actualsize);
				Assert.fail();

			}
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("The actual size does not matches the expected size, the Actual size is: " + actualsize, "fail");
			log.info("The actual size matches the expected size " + actualsize);
			Assert.fail();
		}

	}
	
	public void copypaste(WebElement ele, String text, int size) throws AWTException
	{
		int actualsize=0;
		try 
		{
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

			clipboard.setContents(new StringSelection(text), null);
			ele.clear();
			Utils.sleep3sec();
			ele.click();

		
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);



			String typedvalue = ele.getAttribute("value");

			if(text.equals(typedvalue)){
				reportStep("pasted text  matches the expected copied text " + actualsize, "pass");
				log.info("pasted text  matches the expected copied text" + actualsize );
			}

			else{
				reportStep("pasted text  does not matches the expected copied text, the Actual size is: " + actualsize, "fail");
				log.info("pasted text  matches the expected copied text " + actualsize);

			}
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			reportStep("pasted text size does not matches the expected size, the Actual size is: " + actualsize, "fail");
			log.info("pasted text size matches the expected size " + actualsize);
		}
	}

	
	
}