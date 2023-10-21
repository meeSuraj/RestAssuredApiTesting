package SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;  
import io.github.bonigarcia.wdm.WebDriverManager;
public class Assingment1 {

	public static void main(String[] args) throws InterruptedException {
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
		driver.navigate().to("https://money.rediff.com/gainers");
		//Maximize the browser  
		driver.manage().window().maximize();  

		//Scroll down the webpage by 5000 pixels  
		//        JavascriptExecutor js = (JavascriptExecutor)driver;  
		//        js.executeScript("scrollBy(0, 5000)");  

		// Click on the Search button by absolute xpath
		//        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/table[1]/tbody[1]/tr[1]/td[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")).sendKeys("T-Shirts");
		//        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/table[1]/tbody[1]/tr[1]/td[3]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]")).click();
		//        
		//by relative xpath
		//        driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("T-Shirts for men");
		//        driver.findElement(By.xpath("//input[@value='Search']")).click();
		//gh-ac' or @name='_nkw'

		//And operator
		//  driver.findElement(By.xpath("//input[@id='gh-ac' and @name='_nkw']")).sendKeys("T-shirts for men");

		//contains method
		//driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("T shirts for Kids");

		//starts-with method
		//driver.findElement(By.xpath("//input[starts-with(@id,'gh-ac')]")).sendKeys("T shirts for women");

		//self node
		String strself=driver.findElement(By.xpath("//input[starts-with(@id,'gh-ac')]/self::input")).getText();
		driver.findElement(By.xpath("//input[starts-with(@id,'gh-ac')]/self::input")).getText();
		//        Alert alert = driver.switchTo().alert();
		//        alert.accept();
		Thread.sleep(3000);
		//        System.out.println(driver.switchTo().alert().getText());
		//        driver.switchTo().alert().accept();

		//driver.switchTo().alert().dismiss();
		System.out.println(strself);
		//parent node
		String strParent=driver.findElement(By.xpath("//input[starts-with(@id,'gh-ac')]/parent::div")).getText();
		System.out.println(strParent);
		driver.close();
	}  

}




