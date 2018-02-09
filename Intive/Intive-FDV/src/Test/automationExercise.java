package Test;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Page.GooglePage;

public class automationExercise {
	public WebDriver driver;
	private  GooglePage page=new GooglePage(driver);
	
	@BeforeClass
	public void Init() throws MalformedURLException
	{
		driver=page.initChrome();
	}
	
	@BeforeMethod
	public void irABing() {
		page.getGoogle();
	}
	
	@AfterClass
	public void cerraDriver() {
		driver.quit();
	}
	
	@Test
	public void i_am_on_SeleniumHQ_Page() {
		GooglePage page=new GooglePage(driver);
		page.searchText("SeleniumHQ");
		page.clickOnResult(driver, "www.seleniumhq.org");
	
	assertEquals(driver.getCurrentUrl(),"http://www.seleniumhq.org/");
	}

}
