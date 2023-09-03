package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Opportunity_TC005_VerifyOpportunitiessortorderbyClosedate {

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
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(15));
		String ctasc ="Sorted Ascending";
		String ctdesc = "Sorted Descending";
		WebElement visibility = driver.findElement(By.xpath("//span[text()='Close Date']"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;        
		js1.executeScript("arguments[0].click();",visibility);
		String desc = driver.findElement(By.xpath("//span[text()='Sorted Descending']")).getText();
		if(desc.equals(ctdesc)) {
			
			js1.executeScript("arguments[0].click();",visibility);

		}
		String asc = driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).getText();
		Thread.sleep(3000);
		if(ctasc.equals(asc)) {
			System.out.println("Test case Passed");
		}

	}

}
