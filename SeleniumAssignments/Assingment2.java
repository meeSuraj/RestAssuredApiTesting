package SeleniumAssignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;  
public class Assingment2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// System Property for Chrome Driver  
		WebDriver driver;
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssureshrao\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");  

		// Instantiate a ChromeDriver class.    
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setCapability("marionette", true);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options1);

		// Launch Website  
		//driver.navigate().to("http://www.ebay.com/");  
	//	driver.navigate().to("https://money.rediff.com/gainers");
		driver.get("https://money.rediff.com/gainers");
		//Maximize the browser  
		driver.manage().window().maximize();  

		// driver.findElement(By.xpath("//a[contains(.,'SoftTech Engineers')]/self::a")).getText();
		// System.out.println(strself);
		//String str=driver.findElement(By.xpath("//a[contains(.,'SoftTech Engineers')]/parent::td")).getText();

		List<WebElement> childcount=driver.findElements(By.xpath("//a[contains(.,'SoftTech Engineers')]/ancestor::tr/child::*"));
		System.out.println("No of child nodes are "+childcount.size());
		List <WebElement> ancestorcound=driver.findElements(By.xpath("//a[contains(.,'SoftTech Engineers')]/ancestor::tr/following::td"));
		System.out.println(ancestorcound.size());
		List<WebElement> precedingcoung=driver.findElements(By.xpath("//a[contains(.,'SoftTech Engineers')]/preceding::*"));
		System.out.println(precedingcoung.size());
		List<WebElement> precedingSibling=driver.findElements(By.xpath("//a[contains(.,'SoftTech Engineers')]/ancestor::td/following-sibling::*"));
		System.out.println(precedingSibling.size());
		driver.close();
	}  

}
