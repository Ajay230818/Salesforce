package Salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Opportunity_TC003_DeleteOppurtunity {

	public static void main(String[] args) throws InterruptedException {
		//login script

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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;        
		WebElement opputunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();",opputunity);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("KARTHIK SDET");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		for(int i=0; i<=2;i++){
			try{
				driver.findElement(By.xpath("(//div[contains(@class,'slds-grid slds-grid--align-spread')])[2]")).click();
				break;
			}
			catch(Exception e){
				//System.out.println(e.getMessage());
			}
		}
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
		WebElement clickdelete = driver.findElement(By.xpath("//a[@title='Delete']"));
		js.executeScript("arguments[0].click();",clickdelete);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("KARTHIK SDET");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		String norecordtext = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		String norecordcompanre="No items to display.";
		if(norecordtext.equals(norecordcompanre)) {
			System.out.println("Record passed");
		}
		else {
			System.out.println("TC failed");
		}
		//driver.findElement(By.xpath("//div[text()='Delete']")).click();
	}

}
