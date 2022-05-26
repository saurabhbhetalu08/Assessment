package Test_Classes;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM_Classes.Wiki_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_Wiki 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUpMethod()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions chrome =new ChromeOptions();
		driver = new ChromeDriver(chrome);
		System.out.println("Open Chrome Browser");
		
		driver.manage().window().maximize();
		System.out.println("Maximiza broswer");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		System.out.println("Open URL of Wikipedia");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 700)");
		System.out.println("Scroll Down");
		
	}
	
	@Test
	public void VerifyCountryNameFromWIKI()
	{
		
		Wiki_Page wp = new Wiki_Page(driver);
		
		System.out.println("Print Country Name- "+wp.extractCountry());
		
		String actualName = wp.extractCountry();
		String expectedName = "India";
		
		Assert.assertEquals(expectedName, actualName);

		
	}
	
	@Test
	public void VerifyReleaseDateFromWIKI()
	{
		
		Wiki_Page wp = new Wiki_Page(driver);
		
		System.out.println("Print Release Date- "+wp.extractrelease());
		
		String actualDate = wp.extractrelease();
		String expectedDate = "17 December 2021";
		
		Assert.assertEquals(expectedDate, actualDate);

		
	}
	
	@AfterMethod
	public void tearDownMethod()
	{
		driver.quit();
		System.out.println("Closed Browser");
	}
	

}
