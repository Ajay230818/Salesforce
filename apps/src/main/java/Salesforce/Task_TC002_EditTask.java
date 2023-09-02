package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task_TC002_EditTask {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("sahanabaasha@tcs.com");
		driver.findElement(By.id("password")).sendKeys("Sahana@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		WebElement createTask= driver.findElement(By.xpath("//p[text()='Tasks']"));
		js.executeScript("arguments[0].click();",createTask);
		driver.findElement(By.xpath("//span[text()='Select a List View: Tasks']/preceding-sibling::lightning-primitive-icon")).click();
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Bootcamp",Keys.ENTER);
		driver.findElement(By.xpath("(//span[text()='Bootcamp'])[1]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'slds-grid slds-grid--vertical-align-center')]")).click();
		//Thread.sleep(2000);
		WebElement edit= driver.findElement(By.xpath("//div[text()='Edit']/parent::a"));
		js.executeScript("arguments[0].click();",edit);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Low']")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		String taskEdit = driver.findElement(By.xpath("//span[text()='Task']")).getText();
		if(taskEdit.contains(taskEdit)) {
			System.out.println("Task saved");
		}
			else 
			{
				System.out.println("not saved");
			
			}
		

	}

}
