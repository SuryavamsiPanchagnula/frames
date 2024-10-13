package frames;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class window {
	
	public static void main(String args[]) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		String originalWindow=driver.getWindowHandle();
		
		try{
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.manage().window().maximize();
		
		WebElement clickhere= driver.findElement(By.xpath("//div[@id='content']//a[text()='Click Here']"));
		
		clickhere.click();
		
		Thread.sleep(2000);
		
		Set<String> AllWindows =driver.getWindowHandles();
		
		for(String windowHandle : AllWindows) {
			if(!windowHandle.equals(originalWindow)) {
				
				driver.switchTo().window(windowHandle);
				break;
			}
				
		}
		
		if(driver.findElement(By.tagName("h3")).getText().equals("New Window")) {
		    System.out.println("Element verification successful");
		}
		else {
			System.out.println("not in new window");
		}
		driver.close();
		
		driver.switchTo().window(originalWindow);
		if(driver.findElement(By.tagName("h3")).getText().equals("Opening a new window")) {
			System.out.println("Switched back to original window");
		}
		else {
			
			System.out.println("not in original window");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
		driver.quit();
		}
		
	}

}