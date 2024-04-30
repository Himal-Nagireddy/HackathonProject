package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException, InterruptedException
	
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
		
		//loading log4j 
		logger=LogManager.getLogger(this.getClass());//Log4j
				
				
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		 	{	
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		    }
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println("No matching browser..");
						return;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
//		Thread.sleep(3000);
//		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
//		try {
//			w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-frame\"]"))));
//			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-frame\"]")));
//			driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();
//			driver.switchTo().defaultContent();}
//			catch(Exception e) {
//			}
		

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
	
			driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();
			
			driver.switchTo().defaultContent();
			}catch(Exception e) {
				
			}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		FileUtils.copyFile(sourceFile, targetFile);
	
			
		return targetFilePath;

	}
}
