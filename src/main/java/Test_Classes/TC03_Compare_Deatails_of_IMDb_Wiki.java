package Test_Classes;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.IMDb_Page;
import POM_Classes.Wiki_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_Compare_Deatails_of_IMDb_Wiki 
{
	WebDriver driver;
	SoftAssert soft = new SoftAssert();

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
	}
	
	@Test
	public void CompareCountryonWiki_IMDb()
	{		
		driver.get("https://www.imdb.com/title/tt9389998/");
		System.out.println("Open Pushpa The Rise on IMDb");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");
		
		IMDb_Page ip= new IMDb_Page(driver);
		String CountryOnIMDb = ip.extractCountry();
		
		System.out.println("Print Country Name on IMDb- "+ip.extractCountry());
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		System.out.println("Open Pushpa The Rise on Wikipidia");
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");

		Wiki_Page wp = new Wiki_Page(driver);
		String CountryOnWiki = wp.extractCountry();
		
		System.out.println("Print Country Name on Wiki- "+wp.extractCountry());

		soft.assertEquals(CountryOnIMDb,CountryOnWiki);
		System.out.println("Compare Deatails");
		soft.assertAll();
	}
	
	
	@Test
	public void CompareReleaseDateonWiki_IMBD()
	{
		driver.get("https://www.imdb.com/title/tt9389998/");
		System.out.println("Open Pushpa The Rise on IMBD");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");
		IMDb_Page ip= new IMDb_Page(driver);
		String DateOnIMDb = ip.extractrelease();
		
		System.out.println("Print Release Date on IMDb- "+ip.extractrelease());
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		System.out.println("Open Pushpa The Rise on Wikipidia");
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");

		Wiki_Page wp = new Wiki_Page(driver);
		String DateOnWiki = wp.extractrelease();
		
		System.out.println("Print Release Date on Wiki- "+wp.extractrelease());
		
		soft.assertEquals(DateOnIMDb, DateOnWiki);
		System.out.println("Compare Deatails");
		soft.assertAll();
				
	}
	

	@AfterMethod
	public void tearDownMethod()
	{
		driver.quit();
		System.out.println("Closed Browser");
	}
	

}
