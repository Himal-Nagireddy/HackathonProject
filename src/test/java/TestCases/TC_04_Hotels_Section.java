package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import Utilities.ExcelUtility;
import pageObjects.HotelsPage;

public class TC_04_Hotels_Section extends BaseClass
	{
	HotelsPage hotel; 
	
	
	@Test(priority=1,groups= {"regression"})
	public void click_on_hotels_icon()
	{
		hotel = new HotelsPage(driver);
		logger.info("Clicking on hotels icon");
	    hotel.clickHotels();
	    if(driver.getTitle().contains("Hotels"))
	    {
	    	Assert.assertTrue(true);
	    }
	    logger.info("Navigated to hotels page successfully");
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 61, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,groups= {"regression"})
	public void click_on_upto4rooms()
	{
		logger.info("Clicking on upto 4 rooms option");
		hotel.clickUpto4Rooms();
		logger.info("Clicked on upto 4 rooms option");
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 63, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3,groups= {"regression"})
	public void click_on_roomsandguests()
	{
		logger.info("Clicking on rooms and guests dropdown");
		hotel.clickRoomsAndGuestsDropdown();
		Assert.assertTrue(hotel.validate_RoomsAndGuestsDropdown());
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 65, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=4,groups= {"regression"})
	public void click_on_adultsdropdown_printallnumbers()
	{
		logger.info("Clicking on adults dropdown and printing all the numbers");
	    hotel.clickAdultsDropdown();
	    Assert.assertTrue(hotel.validate_adultsdropdown());
	    try 
	    {
			Thread.sleep(3000);
		}
	    catch (InterruptedException e)
	    {

			e.printStackTrace();
		}
	    System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Maximum number of adults can be accommodated is : " + hotel.getTotalAdults().size());
		System.out.println("-----------------------------------------------------------------------------");
	    for(WebElement w : hotel.getTotalAdults())
	    {
	    	System.out.println(w.getText());
	    }
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 68, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
