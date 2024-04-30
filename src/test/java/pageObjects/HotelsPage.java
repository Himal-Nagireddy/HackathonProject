package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsPage extends BasePage{

	public HotelsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[text()='Hotels']") 
	WebElement Hotels;
	
	@FindBy(xpath="//span[@class='grpBkngOpt__item--text']") 
	WebElement upto4Rooms;
	
	@FindBy(xpath="//input[@id='guest']") 
	WebElement roomsAndGuestsDropdown;	
	
	@FindBy(xpath="//div[@class='rmsGst__body']") 
	WebElement validate_RoomsAndGuestsDropdown;
	
	@FindBy(xpath="//*[@class='rmsGst__row'][2]/div[2]") 
	WebElement adultsDropdown;
	
	@FindBy(xpath="//ul[@class='gstSlct__list']/li") 
	List<WebElement> totalAdults;
	
	
	public void clickHotels()
	{
		Hotels.click();
	}
	public void clickUpto4Rooms()
	{
		upto4Rooms.click();
	}
	
	public boolean validate_upto4RoomsSelection()
	{
		if(upto4Rooms.isSelected())
		{
			return true;
		}
		return false;
	}
	
	public void clickRoomsAndGuestsDropdown()
	{
		roomsAndGuestsDropdown.click();
	}
	
	public boolean validate_RoomsAndGuestsDropdown()
	{
		if(validate_RoomsAndGuestsDropdown.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public void clickAdultsDropdown()
	{
		adultsDropdown.click();
	}
	public boolean validate_adultsdropdown()
	{
		if(!totalAdults.isEmpty())
		{
			return true;
		}
		return false;
	}
	public List<WebElement> getTotalAdults()
	{
		
		return totalAdults;
	}
}
