package frames;

import java.net.SocketException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames {
	
	public static void main(String args[]) throws SocketException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		driver.manage().window().maximize();
		
		WebElement topframe = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		
		driver.switchTo().frame(topframe);
		
		List<WebElement> innerframes = driver.findElements(By.tagName("frame"));
		
		int innerframecount = innerframes.size();
		
		System.out.println("Number of innerframes: "+innerframecount);
		
		if(innerframecount == 3) {
			
			System.out.println("Three inner frames are there in top frame");
		}
		else {
			System.out.println("No inner frames");
		}
		
		WebElement lefttopframe= driver.findElement(By.xpath("//frame[@name='frame-left']"));
		
		driver.switchTo().frame(lefttopframe);
		
		WebElement leftframetext = driver.findElement(By.tagName("body"));
		
		if(leftframetext.getText().equals("LEFT")) {
			
			System.out.println(leftframetext.getText());
		}
		else {
			System.out.println("Not in left top frame");
		}
		
		driver.switchTo().parentFrame();
		
		WebElement middletopframe = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		
		driver.switchTo().frame(middletopframe);
		
		WebElement middleframetext = driver.findElement(By.tagName("body"));
		
		if(middleframetext.getText().equals("MIDDLE")) {
			
			System.out.println(middleframetext.getText());
		}
		else {
			
			System.out.println("Not in middle top frame");
		}
		
		driver.switchTo().parentFrame();
		
		WebElement righttopframe = driver.findElement(By.xpath("//frame[@name='frame-right']"));
		
		driver.switchTo().frame(righttopframe);
		
		WebElement rightframetext = driver.findElement(By.tagName("body"));
		
		if(rightframetext.getText().equals("RIGHT")) {
			
			System.out.println(rightframetext.getText());
		}
		else {
			System.out.println("Not in the right top frame");
		}
		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		
		WebElement bottomframe = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		
		driver.switchTo().frame(bottomframe);
		
		WebElement bottomframetext = driver.findElement(By.tagName("body"));
		
		if(bottomframetext.getText().equals("BOTTOM")) {
			
			System.out.println(bottomframetext.getText());
		}
		else {
			System.out.println("Not in the bottom frame");
		}
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(topframe);
		
		String title = driver.getTitle();
		
		if(title.equals("FRAMES")) {
			
			System.out.println(title);
		}
		else {
			System.out.println("FRAMES is not title");
		}
		
		driver.close();
		
	}

}