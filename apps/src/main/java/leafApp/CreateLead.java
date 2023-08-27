package leafApp;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
	WebDriver driver;
	
	@BeforeTest
	public void browserinitiate() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Parthiv Ajay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	/*
	 * @Test public void createlead() {
	 * driver.get("http://leaftaps.com/opentaps/control/login");
	 * driver.manage().window().maximize();
	 * driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	 * driver.findElement(By.id("password")).sendKeys("crmsfa");
	 * driver.findElement(By.xpath("//input[@value='Login']")).click();
	 * driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	 * driver.findElement(By.xpath("//a[text()='Leads']")).click();
	 * driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
	 * driver.findElement(By.id("createLeadForm_companyName")).sendKeys("testleaf");
	 * driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Parthiv");
	 * driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ajay");
	 * driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(
	 * "Muthuvel");
	 * driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("pandian")
	 * ; driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
	 * driver.findElement(By.id("createLeadForm_description")).
	 * sendKeys("Just creating an lead");
	 * driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(
	 * "partajay@gmail.com"); Select sel=new
	 * Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")))
	 * ; sel.selectByValue("NY");
	 * driver.findElement(By.xpath("//input[@name='submitButton']")).click(); String
	 * title = driver.getTitle(); System.out.println(title);
	 * driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click(); }
	 */
	
	@Test
	public void salesforce() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		
	}
	
	@AfterTest
	public void teardown() {
		//driver.close();
	}
}
