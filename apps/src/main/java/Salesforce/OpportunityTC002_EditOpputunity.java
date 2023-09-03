package Salesforce;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpportunityTC002_EditOpputunity {

	public static void main(String[] args) throws InterruptedException {
		//login script
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");
				ChromeDriver driver = new ChromeDriver(option);
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
				driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("KARTHIK D");
				driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
				//driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer'])[5]")).click();
				for(int i=0; i<=2;i++){
					try{
						driver.findElement(By.xpath("(//td[@class='slds-cell-edit cellContainer'])[5]")).click();
						break;
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
				driver.findElement(By.xpath("(//li[@class='uiMenuItem'])[1]")).click();
				driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
				WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(15));
				WebElement visibility = driver.findElement(By.xpath("//td[@class='slds-is-today slds-is-selected']/following::td[1]"));
				//td[@class='slds-is-today slds-is-selected']/following::td[1]
				wb.until(ExpectedConditions.visibilityOf(visibility)).click();
				driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
			   
				JavascriptExecutor stage = (JavascriptExecutor)driver;        
			    WebElement account = driver.findElement(By.xpath("//span[text()='Perception Analysis']"));
			    stage.executeScript("arguments[0].click();",account);
			    Thread.sleep(3000);
				WebElement visib = driver.findElement(By.xpath("(//div[@role='none'])[6]"));
				js.executeScript("arguments[0].click();",visib);
			    WebElement statustext = driver.findElement(By.xpath("//span[text()='In progress']"));
			    js.executeScript("arguments[0].click();",statustext);
			    driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[8]")).click();
			    driver.findElement(By.xpath("//button[text()='Save']")).click();
			    System.out.println("test case passed");
			    driver.close();

	}

}
