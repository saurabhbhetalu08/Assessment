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

import POM_Classes.IMDB_Page;
import POM_Classes.Wiki_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_Compare_Deatails_of_IMBD_Wiki 
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
	public void test1()
	{		
		driver.get("https://www.imdb.com/title/tt9389998/");
		System.out.println("Open Pushpa The Rise on IMBD");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");
		
		IMDB_Page ip= new IMDB_Page(driver);
		String CountryOnIMBD = ip.extractCountry();
		
		System.out.println("Print Country Name on IMBD- "+ip.extractCountry());
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		System.out.println("Open Pushpa The Rise on Wikipidia");
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");

		Wiki_Page wp = new Wiki_Page(driver);
		String CountryOnWiki = wp.extractCountry();
		
		System.out.println("Print Country Name on Wiki- "+wp.extractCountry());

		soft.assertEquals(CountryOnIMBD,CountryOnWiki);
		System.out.println("Compare Deatails");
		soft.assertAll();
	}
	
	
	@Test
	public void test2()
	{
		driver.get("https://www.imdb.com/title/tt9389998/");
		System.out.println("Open Pushpa The Rise on IMBD");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");
		IMDB_Page ip= new IMDB_Page(driver);
		String DateOnIMBD = ip.extractrelease();
		
		System.out.println("Print Release Date on IMBD- "+ip.extractrelease());
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		System.out.println("Open Pushpa The Rise on Wikipidia");
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0, 5560)");
		System.out.println("Scroll Down");

		Wiki_Page wp = new Wiki_Page(driver);
		String DateOnWiki = wp.extractrelease();
		
		System.out.println("Print Release Date on Wiki- "+wp.extractrelease());
		
		soft.assertEquals(DateOnIMBD, DateOnWiki);
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
