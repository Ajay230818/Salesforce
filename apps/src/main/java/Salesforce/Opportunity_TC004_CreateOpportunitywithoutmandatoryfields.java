package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Opportunity_TC004_CreateOpportunitywithoutmandatoryfields {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
	///	WebDriverWait wait = new WebDriverWait(driver,30);

		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("karthikdamotharan99@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Karthik@664721");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;        
		WebElement opputunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();",opputunity);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(10));
	    String opp = driver.findElement(By.xpath("//a[text()='Opportunity Name']")).getText();
	    String stg = driver.findElement(By.xpath("//a[text()='Stage']")).getText();
	    WebElement visibility = driver.findElement(By.xpath("//strong[text()='Review the following fields']"));
	    wb.until(ExpectedConditions.visibilityOf(visibility));
	    System.out.println("Kindly Enter the Following details:"+" "+opp+" "+stg);

	}

}
