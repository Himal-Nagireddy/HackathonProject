package TestCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import Utilities.ExcelUtility;
import pageObjects.CabsPage;
import pageObjects.HomePage;

public class TC_01_LowestCabDetails extends BaseClass
	{
	
	HomePage home;
	CabsPage cab;
	@Test(priority=1,groups= {"smoke"})
	public void click_on_caboption()
	{
		
		logger.info("Clicking on the cab option");
		 home = new HomePage(driver);
		 cab = new CabsPage(driver);
		 home.clickCabButton();
		 logger.info("Clicked on Cabs option");
		 try 
		 {
			ExcelUtility.setCellData("Test Cases", 18, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,groups= {"smoke"})
	public void click_on_oneway_outstation()
	{	
		
		logger.info("Clicking on the cab option");
		home.clickOneWayOutstationButton();
	    logger.info("Clicked one way outstation cab");
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 2, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=3,groups= {"smoke"})
	public void user_selecting_from()
	{
		
		logger.info("Selecting From");
		home.selectFrom(p.getProperty("From"));
		logger.info("Selected Delhi");
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 5, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=4,groups= {"smoke"})
	public void user_selecting_to()
	{
		
		logger.info("Selecting To");
		home.selectTo(p.getProperty("To"));
		logger.info("Selected Manali");
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 8, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=5,groups= {"smoke"})
	public void user_selecting_date()
	{
		
		logger.info("Selecting Date");
		home.selectDate(p.getProperty("Date"));
	    logger.info("Selected date");
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 10, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=6,groups= {"smoke"})
	public void user_selecting_time()
	{
		
		logger.info("Selecting Time");
		home.selectTime(p.getProperty("Time"));
		logger.info("Selected Time");
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 13, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=7,groups= {"smoke"})
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
			ExcelUtility.setCellData("Test Cases", 16, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=8,groups= {"smoke"})
	public void user_selecting_lowtohighprice()
	{
		
		logger.info("Selecting low to highest price in the sort by dropdown");
		cab.clickSortByDropdown();
		try
		{
			Thread.sleep(2000);
		} 
		catch(InterruptedException e)
		{
			
			e.printStackTrace();
		}
		cab.clickLowToHighPrice();
		try 
		{
			Thread.sleep(2000);
		} 
		catch(InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		Assert.assertTrue(cab.validate_lowtohighprice());
		logger.info("Selected low to highest price in the sort by dropdown");
		try 
		 {
			ExcelUtility.setCellData("Test Cases", 21, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=9,groups= {"smoke"})
	public void user_selecting_suv()
	{
		
		logger.info("Selecting SUV Checkbox");
		cab.clickSuvCab();
	    logger.info("Selected SUV Checkbox");
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 22, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test(priority=10,groups= {"smoke"})
	public void lowest_cab_details()
	{
		
		logger.info("Printing lowest cab details : ");
		System.out.println("----------------------------------------------");
	    System.out.println("Cab Name: "+cab.getCabName());
	    System.out.println("Cab Price: "+cab.getCabPrice());
	    System.out.println("----------------------------------------------");
	    try 
		 {
			ExcelUtility.setCellData("Test Cases", 24, 8,"Pass");
		} 
		 catch (IOException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
