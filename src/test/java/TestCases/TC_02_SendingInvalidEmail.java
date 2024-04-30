package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import Utilities.ExcelUtility;
import pageObjects.CabsPage;
import pageObjects.GiftCardsPage;
import pageObjects.HomePage;

public class TC_02_SendingInvalidEmail extends BaseClass
{
	HomePage home;
	CabsPage cab;
	GiftCardsPage gift;
	@Test(priority=1,groups= {"smoke","regression"})
	public void click_on_caboption()
	{
		logger.info("Clicking on the cab option");
		 home = new HomePage(driver);
		 cab = new CabsPage(driver);
		 gift = new GiftCardsPage(driver);
		 home.clickCabButton();
		 logger.info("Clicked on Cabs option");
		 try 
		 {
			ExcelUtility.setCellData("Test Cases", 27, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,groups= {"smoke","regression"})
	public void user_clicking_search()
	{
		logger.info("Clicking Search Button");
		home.clickSearchButton();
	    logger.info("Clicked on search button");
	    try
	    {
			Thread.sleep(3000);
		} 
	    catch (InterruptedException e) 
	    {
			e.printStackTrace();
		}
	    if(driver.getTitle().contains("Cabs"))
		{
			Assert.assertTrue(true);
			logger.info("In cabs page");
		}
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 30, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3,groups= {"smoke","regression"})
	public void user_clicking_moredropdown()
	{
		logger.info("Clicking more dropdown");
	    cab.clickMoreDropdown();
	    logger.info("Clicked on more dropdown");
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
	
	@Test(priority=4,groups= {"smoke","regression"})
	public void user_clicking_giftcardsoption()
	{
		logger.info("Clicking gift cards option");
	    cab.clickGiftCardsOption();
	    if(driver.getTitle().contains("Gift Cards"))
	    {
	    	Assert.assertTrue(true);
	    }
	    logger.info("Clicked gift cards option");
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
	
	@Test(priority=5,groups= {"smoke","regression"})
	public void user_clicking_wedding_giftcard()
	{
		logger.info("Clicking on wedding giftcard");
		gift.click_wedding_GiftCard();
		Assert.assertTrue(gift.validate_wedding_giftcard());
		logger.info("In wedding giftcard page");
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
	
	@Test(priority=6,groups= {"smoke","regression"})
	public void user_gives_senders_data_with_invalid_email()
	{
		logger.info("Passing sender's name, mobile and email id");
		gift.toInputsenderName(p.getProperty("Sender_name"));
	    gift.toInputSendersMobileNo(p.getProperty("Sender_mobile"));
	    gift.toInputSendersEmailID("junmungmail.com");
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
	
	@Test(priority=7,groups= {"smoke","regression"})
	public void user_clicks_on_buynow()
	{
		logger.info("Clicking on buy now option with invalid email address");
	    gift.toClickOnBuyNow();
	    if(driver.getTitle().contains("Gift Cards"))
	    {
	    	Assert.assertTrue(true);
	    }
	    logger.info("Clicked on buy now option with invalid email address");
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
	
	@Test(priority=8,groups= {"smoke","regression"})
	public void capture_warning_msg()
	{
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
