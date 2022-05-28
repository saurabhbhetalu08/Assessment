package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDb_Page 
{
	private WebDriver driver;
	
	@FindBy(xpath="(//div//ul//li//a)[83]")
	private WebElement country; 
	
	@FindBy(xpath="(//div//ul//li//a)[81]")
	private WebElement release;
	
	public IMDb_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String extractCountry()
	{
		String str = country.getText();
		return str;
	}
	
	
	public String extractrelease()
	{
		String str = release.getText();
		return str;
	}
	
	
	

}
