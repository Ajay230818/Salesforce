package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboards_TC05_Verify_Dashboard_Subscribe {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver",
				"C:\\Users\\Parthiv Ajay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("parthivajay.vt@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ajay@0310");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Dashboards");
		driver.findElement(By.xpath("//mark[text()='Dashboards']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search recent dashboards...\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search recent dashboards...\"]")).sendKeys("parthiv");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//lightning-base-formatted-text[text()='Salesforce Automation']//..//..//..//..//..//td[6]")).click();
		driver.findElement(By.xpath("//span[text()='Subscribe']")).click();
		driver.findElement(By.xpath("//h2[text()='Edit Subscription']")).isDisplayed();
		driver.findElement(By.xpath("//span[text()='Daily']")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		driver.findElement(By.xpath("//span[@class='slds-grid slds-grid_align-spread']/div[@class='slds-truncate']/lightning-primitive-icon")).isDisplayed();
		driver.findElement(By.xpath("//span[text()='Your subscription is all set.']")).isDisplayed();
		driver.close();
	}

}
