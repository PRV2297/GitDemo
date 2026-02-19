import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		String Username = "Admin";
		String Password = "admin123";
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Username);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(6000);
		
		
		// Dynamic Dropdown Selection
		
		// (1) Find the Dropdown Locator and Send Text
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("in");
		Thread.sleep(6000);
		
		// Find all elements from the keyword
		
		List<WebElement> options = driver.findElements(By.xpath("//span[contains(@class,'oxd-text oxd-text--span oxd-main-menu-item--name')]"));
		Thread.sleep(4000);
		
		
		// Giving Conditions for finding the element
		
		for(WebElement option: options)
		{
			if(option.getText().equals("Admin"))
				
			{
				
				option.click();
				
				break;
			}
		}
		
	
		driver.findElement(By.xpath("//button[@role='none']")).click();
		Thread.sleep(4000);
		
		// User Search
		
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("Jobinsam@6742");
		Thread.sleep(4000);
		
		// Static Dropdown 1
		
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		
		Select Dropdown = new Select(dropdown);
		
		Dropdown.selectByContainsVisibleText("ESS");
		
		String Userrole = Dropdown.getFirstSelectedOption().getText();
		
		System.out.println("The Selected Userrole is" + Userrole);
		
		
		// Dynamic Dropdown Element
		
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Jobin Sam");
		Thread.sleep(4000);
		
		
		
		// Static Dropdown 2
		
		WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		
		Select Dropdown2 = new Select(dropdown1);
		
		Dropdown2.selectByContainsVisibleText("Enabled");
		
		
		
		
				
				
		
		
		

	}

}
