package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Find Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("naveenraj57@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		String text =driver.findElement(By.xpath("//span[@id='viewContact_firstName_sp']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement element = driver.findElement(By.xpath("//select[@id='addMarketingCampaignForm_marketingCampaignId']"));
		Select dd1 = new Select(element);
		dd1.selectByValue("9000");
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Add']")).click();
		driver.findElement(By.xpath("//input[@id='updateContactForm_departmentName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateContactForm_departmentName']")).sendKeys("Selenium Automation Testing");
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
		String text1 = driver.findElement(By.xpath("//span[@id='viewContact_marketingCampaigns_sp']")).getText();
		if(text1.equals("eCommerce Site Internal Campaign"))
		{
			System.out.println("Market campaign are same ");
		}
		else
		{
			System.out.println("Market campaign are not same");
		}
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("View Contact | opentaps CRM"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test fail");
		}
	}

}
