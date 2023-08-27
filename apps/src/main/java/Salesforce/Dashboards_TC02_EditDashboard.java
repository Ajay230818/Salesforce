package Salesforce;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dashboards_TC02_EditDashboard {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Parthiv Ajay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
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
		WebElement createddashabord = driver.findElement(By.xpath("(//a[text()='Dashboard parthiv'])[1]"));
		createddashabord.isDisplayed();
		driver.findElement(By.xpath("(//a[text()='Dashboard parthiv'])[1]/../../../../../..//td[6]")).click();
		driver.findElement(By.xpath("//a//span[text()='Edit']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Properties']")));
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("SalesForce");
		driver.findElement(By.id("submitBtn")).click();	
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.id("modalBtn2")).click();
		WebElement descriptiontext = driver.findElement(By.xpath("//p[@class='slds-page-header__info']"));
		descriptiontext.isDisplayed();
		driver.close();
	}

}
