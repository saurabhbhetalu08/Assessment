package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wiki_Page
{
private WebDriver driver;
	
	@FindBy(xpath="//td[text()='India']")
	private WebElement country; 
	
	@FindBy(xpath="(//td//div//ul//li)[12]")
	private WebElement release;
	
	
	
	public Wiki_Page(WebDriver driver)
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
