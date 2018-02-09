package Page;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	private WebDriver driver;
	
	public GooglePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME, using="q")
	public static WebElement searchBox;
	
	@FindBy(how=How.CLASS_NAME, using="rc")
	public static List<WebElement> result;
	
	public void getGoogle() {
		driver.get("https://www.google.com/");
	}
	
	public void searchText(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
	}
	
	public void clickOnResult(WebDriver driver, String link) {
		for(WebElement r:result) {
			if(r.findElement(By.className("_Rm")).getText().contains(link)) {
				r.findElement(By.tagName("a")).click();
				break;
			}
		}
	}
	
	public WebDriver initChrome() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    return driver;
	}
}
