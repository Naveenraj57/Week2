package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select dd1 = new Select(element);
		dd1.selectByIndex(2);
		
		//Select by visible text		
		WebElement element1 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select dd2 = new Select(element1);
		dd2.selectByVisibleText("Loadrunner");
		
		//Select by index
		
		WebElement element2 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select dd3 = new Select(element2);
		dd3.selectByValue("1");
		
		//get options
		WebElement element3 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dd4 = new Select(element3);
		List<WebElement> option =dd4.getOptions();
		System.out.println(option.size());
		
		//sendkeys to select
		
		driver.findElement(By.xpath("//div[@class='example'] [5] /select")).sendKeys("UFT/QTP");
		
		WebElement element4 = driver.findElement(By.xpath("//div[@class='example'] [6]/ select"));
		Select dd5 = new Select(element4);
		dd5.selectByValue("1");
		dd5.selectByValue("2");
		dd5.selectByValue("4");

	}

}
