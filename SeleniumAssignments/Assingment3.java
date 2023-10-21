package SeleniumAssignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assingment3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver;
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setCapability("marionette", true);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options1); 
		driver.get("https://developer.salesforce.com/signup");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input']/self::input")).sendKeys("Suraj");

	}

}
