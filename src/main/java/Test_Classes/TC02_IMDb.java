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

import POM_Classes.IMDb_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_IMDb
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
		
		driver.get("https://www.imdb.com/title/tt9389998/");
		System.out.println("Open URL of IMDb");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");
	}
	
	@Test
	public void verifyCountryNameFromIMDb()
	{
		
		IMDb_Page ip = new IMDb_Page(driver);
		
		System.out.println("Print Country Name on IMDb- "+ip.extractCountry());
		
		String actualName = ip.extractCountry();
		String expectedName = "India";
		
		Assert.assertEquals(expectedName, actualName);

		
	}
	
	@Test
	public void verifyReleaseDateFromIMDb()
	{
		
		IMDb_Page ip = new IMDb_Page(driver);
		
		System.out.println("Print Release Date on IMDb- "+ip.extractrelease());
		
		String actualDate = ip.extractrelease();
		String expectedDate = "January 7, 2022 (United States)";
		
		Assert.assertEquals(expectedDate, actualDate);

		
	}
	
	@AfterMethod
	public void tearDownMethod()
	{
		driver.quit();
		System.out.println("Closed Browser");
	}
	
	

}
