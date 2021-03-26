package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.xpath("//input[@id='firstNameField']")).sendKeys("Naveen");
		driver.findElement(By.xpath("//input[@id='lastNameField']")).sendKeys("Venkat");
		driver.findElement(By.xpath("//input[@id='createContactForm_firstNameLocal']")).sendKeys("Naveen");
		driver.findElement(By.xpath("//input[@id='createContactForm_lastNameLocal']")).sendKeys("Venkat");
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Information Technology");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("This is a description");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("naveenraj57@gmail.com");
		WebElement element = driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']"));
		Select dd1 = new Select(element);
		dd1.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Important note to be followed");
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
		System.out.println(driver.getTitle());
		
	}

}
