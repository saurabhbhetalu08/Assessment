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

import POM_Classes.IMDB_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_IMDB
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
		System.out.println("Open URL of IDBD");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");
	}
	
	@Test
	public void verifyCountryNameFromIMBD()
	{
		
		IMDB_Page ip = new IMDB_Page(driver);
		
		System.out.println("Print Country Name- "+ip.extractCountry());
		
		String actualName = ip.extractCountry();
		String expectedName = "India";
		
		Assert.assertEquals(expectedName, actualName);

		
	}
	
	@Test
	public void verifyReleaseDateFromIMBD()
	{
		
		IMDB_Page ip = new IMDB_Page(driver);
		
		System.out.println("Print Release Date- "+ip.extractrelease());
		
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
