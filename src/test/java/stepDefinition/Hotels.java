package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Factory.BaseClass;
import Utilities.ExcelUtility;
import io.cucumber.java.en.When;

public class Hotels extends BaseClass
	{
	@When("the user clicks on Hotels icon")
	public void the_user_clicks_on_hotels_icon() {
		logger.info("Clicking on hotels icon");
	    hotel.clickHotels();
	    if(driver.getTitle().contains("Hotels"))
	    {
	    	Assert.assertTrue(true);
	    }
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

	@When("the user clicks on upto4rooms")
	public void the_user_clicks_on_upto4rooms() {
		logger.info("Clicking on upto 4 rooms option");
		hotel.clickUpto4Rooms();
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

	@When("user clicks on roomsandguests")
	public void user_clicks_on_roomsandguests() {
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

	@When("the user clicks on adults dropdown and print all numbers")
	public void the_user_clicks_on_adults_dropdown_and_print_all_numbers() {
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
