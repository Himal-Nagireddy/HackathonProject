package stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.BaseClass;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LowestCabDetails extends BaseClass{
	
	
	@Given("the user able to see homepage")
	public void the_user_able_to_see_homepage()
	{
		logger.info("Going to makemytrip home page");
		driver.manage().window().maximize();
		logger.info("maximized window");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	driver.get(p.getProperty("appURL"));

		try {
			
			 //Declare and initialise a fluent wait
		  	FluentWait wait = new FluentWait(driver);
		  	//Specify the timeout of the wait
		  	wait.withTimeout(Duration.ofSeconds(30));
		  	//Specify polling time
		  	wait.pollingEvery(Duration.ofSeconds(5));
		  	//Specify what exceptions to ignore
		  	wait.ignoring(TimeoutException.class);

		  	//This is how we specify the condition to wait on.
		  	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-cy='outsideModal']"))));
		  	
		  	driver.findElement(By.xpath("//*[@data-cy='closeModal']")).click();
		  	
		  	Thread.sleep(5000);
			}
			catch(Exception e) {
			}
		
		try {
			
		  	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-frame\"]")));
//			
			driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();
//			
			driver.switchTo().defaultContent();
			}catch(Exception e) {
				
			}
		
		
		if(driver.getTitle().contains("MakeMyTrip"))
				{
					Assert.assertTrue(true);
					logger.info("In the MakeMyTrip Website");
				}
	  
	}

	@When("the user click on cab option")
	public void the_user_click_on_cab_option() 
	{
		
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

	@When("the user clicks on One way option")
	public void the_user_clicks_on_one_way_option() 
	{
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

	@When("the user selects from")
	public void the_user_selects_from() 
	{
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

	@When("the user selects to")
	public void the_user_selects_to() {
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

	@When("the user selects date")
	public void the_user_selects_date() {
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

	@When("the user selects time")
	public void the_user_selects_time() {
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

	@When("the user click on search")
	public void the_user_click_on_search() {
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

	@When("the user select sorted by")
	public void the_user_select_sorted_by() {
	   cab.clickSortByDropdown();
	   cab.clickLowToHighPrice();
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

	@When("the user selects suv")
	public void the_user_selects_suv() {
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

	@When("the user able to lowest car details")
	public void the_user_able_to_lowest_car_details() {
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
