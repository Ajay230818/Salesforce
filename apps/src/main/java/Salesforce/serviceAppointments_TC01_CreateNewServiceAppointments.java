package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class serviceAppointments_TC01_CreateNewServiceAppointments {
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
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Service Appointments");
		driver.findElement(By.xpath("//mark[text()='Service Appointments']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[text()='Description']//..//..//textarea")).sendKeys("Creating Service Appointments");
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[text()='Account Name']//..//..//input")).sendKeys("Parthiv Ajay V T");
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='Earliest Start Permitted']//..//..//div[@class='dateTime-inputDate form-element form-element__control']//a[@class='datePicker-openIcon display']")).click();
		driver.findElement(By.xpath("//span[text()='29']")).click();
		driver.findElement(By.xpath("//span[text()='Due Date']//..//..//div[@class='dateTime-inputDate form-element form-element__control']//a[@class='datePicker-openIcon display']")).click();
		driver.findElement(By.xpath("//span[@class='slds-day weekday DESKTOP uiDayInMonthCell--default' and text()='31']")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String Successmessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String AppointmentNumber = Successmessage.substring(21, 28);
		System.out.println(AppointmentNumber);
		driver.findElement(By.xpath("//button[@class='slds-button slds-show']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Service Appointments");
		driver.findElement(By.xpath("//mark[text()='Service Appointments']")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(AppointmentNumber);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		String confirmAppnum="//a[text()='"+AppointmentNumber+"']";
		driver.findElement(By.xpath(confirmAppnum)).isDisplayed();
	}

}
