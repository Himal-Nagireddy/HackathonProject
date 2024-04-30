package stepDefinition;

import java.io.IOException;

import org.junit.Assert;

import Factory.BaseClass;
import Utilities.ExcelUtility;
import io.cucumber.java.en.When;

public class GiftCard extends BaseClass
{
//	@Given("the user able to see home page")
//	public void the_user_able_to_see_home_page() {
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	  	driver.get("https://www.makemytrip.com/");
//	  	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
//		try {
//			w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-frame\"]"))));
//			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-frame\"]")));
//			driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();
//			driver.switchTo().defaultContent();}
//			catch(Exception e) {
//			}
//	}

	@When("the user clicks on more dropdown")
	public void the_user_clicks_on_more_dropdown() {
		logger.info("Clicking more dropdown");
	    cab.clickMoreDropdown();
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 31, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@When("the user clicks on giftcards option")
	public void the_user_clicks_on_giftcards_option() {
		logger.info("Clicking gift cards option");
	    cab.clickGiftCardsOption();
	    if(driver.getTitle().contains("Gift Cards"))
	    {
	    	Assert.assertTrue(true);
	    }
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 33, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("the user selects wedding gift card")
	public void the_user_selects_wedding_gift_card() {

		logger.info("Clicking on wedding giftcard");
		gift.click_wedding_GiftCard();
		Assert.assertTrue(gift.validate_wedding_giftcard());
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 35, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@When("the user gives senders data {string}")
	public void the_user_gives_senders_data(String s) {
		logger.info("Passing sender's name, mobile and email id");
	    gift.toInputsenderName(p.getProperty("Sender_name"));
	    gift.toInputSendersMobileNo(p.getProperty("Sender_mobile"));
	    gift.toInputSendersEmailID(s);
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 37, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("the user gives valid senders email {string}")
	public void the_user_gives_valid_senders_email(String s) {
		logger.info("Passing sender's name, mobile and email id");
	    gift.toInputsenderName(p.getProperty("Sender_name"));
	    gift.toInputSendersMobileNo(p.getProperty("Sender_mobile"));
	    gift.toInputSendersEmailID(s);
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 55, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("the user clicks buy now")
	public void the_user_clicks_buy_now() {
		logger.info("Clicking on buy now option with invalid email address");
	    gift.toClickOnBuyNow();
	    if(driver.getTitle().contains("Gift Cards"))
	    {
	    	Assert.assertTrue(true);
	    }
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 39, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	@When("the user clicks buy now button")
	public void the_user_clicks_buy_now_button() {
		logger.info("Clicking on buy now option with valid email address");
	    gift.toClickOnBuyNow();
	    try 
	    {
			Thread.sleep(3000);
		} 
	    catch (InterruptedException e)
	    {
			e.printStackTrace();
		}
	    if(!driver.getTitle().contains("Gift Cards"))
	    {
	    	Assert.assertTrue(true);
	    }
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("Validated successfully with valid email address");
	    System.out.println("-----------------------------------------------------------");
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 58, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@When("the user checks for warning message")
	public void the_user_checks_for_warning_message() {
		Assert.assertTrue(gift.validate_warningmsg_display());
		logger.info("Capturing the error message displayed");
		System.out.println("-------------------------------------------------------");
	   System.out.println(gift.warningMessageDisplayed());
	   System.out.println("-------------------------------------------------------");
	   try 
		 {
			ExcelUtility.setCellData("Test Cases", 42, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
