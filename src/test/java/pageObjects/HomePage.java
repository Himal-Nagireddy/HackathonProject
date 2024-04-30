package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);

	}
	
	@FindBy(xpath="//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[7]/span")
	WebElement cabButton;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[1]/ul/li[1]")
	WebElement oneWayOutstationButton;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[1]")
	WebElement fromButton;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div/div/input")
	WebElement fromTextbox;
	
	@FindBy(xpath="//*[@id=\"react-autowhatever-1-section-0-item-0\"]")
	WebElement fromDropdownOption;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[2]")
	WebElement toButton;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input")
	WebElement toTextbox;
	
	@FindBy(xpath="//*[@id=\"react-autowhatever-1-section-0-item-0\"]")
	WebElement toDropdownOption;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[3]")
	WebElement dateDropdown;

	@FindBy(xpath="//div[@role='grid'][1]/div[@role='heading']/div")
	WebElement monthYear;
	
	@FindBy(xpath="//div[@class='DayPicker-Month'][1]//div[@class='DayPicker-Week']/div")
	List <WebElement> dateNumber;
	
	@FindBy(xpath="//div[@role='grid'][2]/div[@role='heading']/div")
	WebElement monthYear2;
	
	@FindBy(xpath="//div[@class='DayPicker-Month'][2]//div[@class='DayPicker-Week']/div")
	List <WebElement> dateNumber2;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")
	WebElement nextMonth;

	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[5]")
	WebElement timeDropdown;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[5]/div[1]/div[2]/ul[1]/li")
	List <WebElement> hours;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[5]/div[1]/div[2]/ul[2]/li")
	List <WebElement> minutes;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[5]/div[1]/div[2]/ul[3]/li")
	List <WebElement> ampm;
	
	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div/div[5]/div[1]/div[1]/div[5]")
	WebElement applyButton;

	@FindBy(xpath="//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/p/a")
	WebElement searchButton;

	
	public void clickCabButton() 
	{
		cabButton.click();
	}
	
	
	
	public void clickOneWayOutstationButton() 
	{
		oneWayOutstationButton.click();
	}
	
	public void selectFrom(String fromCity)
	{
		fromButton.click();
		fromTextbox.sendKeys(fromCity);
		
		try 
		{
			Thread.sleep(3000);
		} 
		
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		fromDropdownOption.click();
	}
	
	public void selectTo(String toCity) 
	{
		toButton.click();
		toTextbox.sendKeys(toCity);
		
		try 
		{
			Thread.sleep(3000);
		}
		
		catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		
		toDropdownOption.click();
	}
	
	public void selectDate(String date)
	{
		String[] d=date.split(" ");
		dateDropdown.click();
		List<WebElement> a;
		while(true)
		{
			if(monthYear.getText().equals(d[1]+" "+d[2]))
			{
				a=dateNumber;
				break;
			}
			else if(monthYear2.getText().equals(d[1]+" "+d[2]))
			{
				a=dateNumber2;
				break;
			}
			else
			{
				nextMonth.click();
			}
		}
		
		for(WebElement e:a) 
		{
			if(d[0].equals(e.getText()))
			{
				e.click();
				break;
			}
		}
	}
	
	public void selectTime(String time)
	{
		String[]t=time.split(":");
		for(WebElement e: hours)
		{
			if(e.getText().contains(t[0]))
			{
				e.click();
			}
		}
		
		for(WebElement e:minutes)
		{
			if(e.getText().contains(t[1])) 
			{
				e.click();
			}
		}
		
		for(WebElement e:ampm)
		{
			if(e.getText().equalsIgnoreCase(t[2]))
			{
				e.click();
			}
		}
		applyButton.click();
	}
	
	public void clickSearchButton() 
	{
		searchButton.click();
	}
	
}
