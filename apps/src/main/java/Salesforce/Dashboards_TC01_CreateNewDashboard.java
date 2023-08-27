package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dashboards_TC01_CreateNewDashboard {
	WebDriver driver;
	
	@BeforeTest
	public void browserinitiateandlogin() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Parthiv Ajay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		
	}
	
	@Test
	public void createNewDashboard() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("parthivajay.vt@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Ajay@0310");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Dashboards");
		driver.findElement(By.xpath("//mark[text()='Dashboards']")).click();
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		//Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Dashboard parthiv");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.switchTo().defaultContent();
		WebElement Dashboardsavedmessage = driver.findElement(By.xpath("//span[text()='Dashboard saved']"));
		Dashboardsavedmessage.isDisplayed();
		driver.close();
	}
	
}
