package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CabsPage extends BasePage{
	
	public CabsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='checkmarkOuter ']/label[text()='SUV']")
	public WebElement suvCab;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[3]/span/label")
	public WebElement validate_suvCab_selection;
	
	@FindBy(xpath="//span[@class='latoRegular']") 
	public WebElement sortByDropdown;
	
	@FindBy(xpath="//p[text()='Price']") 
	WebElement lowToHighPrice;
	
	@FindBy(xpath="//*[contains(text(),'(Lowest to Highest)')]") 
	WebElement validate_LowToHighPrice;
	
	@FindBy(xpath="//span[@class='latoBlack font20 appendRight5']") 
	WebElement cabName;
	
	@FindBy(xpath="//p[@class='font28 latoBlack blackText ']") 
	WebElement cabPrice;
	
	@FindBy(xpath="//span[text()='More']") 
	WebElement moreDropdown;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div/nav/ul/li[10]/div/a[2]") 
	WebElement giftCardsOption;
	
	@FindBy(xpath="//h1[text()='Gift Cards']") 
	WebElement validateGiftCardsSelection;
	
	
	public void clickSuvCab()
	{
		suvCab.click();
	}
	
	public boolean validate_suvcab_selection()
	{
		if(validate_suvCab_selection.isSelected())
		{
			return true;
		}
		return false;
	}
	
	public void clickSortByDropdown()
	{
		sortByDropdown.click();
	}
	
	public void clickLowToHighPrice()
	{
		lowToHighPrice.click();
	}
	
	public boolean validate_lowtohighprice()
	{
		if(validate_LowToHighPrice.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public String getCabName()
	{
		return cabName.getText();
	}
	
	public String getCabPrice()
	{
		return cabPrice.getText();
	}
	
	public void clickMoreDropdown()
	{
	    moreDropdown.click();
	}
	
	public void clickGiftCardsOption()
	{
		giftCardsOption.click();
	}
	
	public boolean validate_GiftCardsSelection()
	{
		if(validateGiftCardsSelection.isDisplayed())
		{
			return true;
		}
		return false;
	}

}
