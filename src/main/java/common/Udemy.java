package common;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Udemy {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");

		WebElement coloumndriver=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int numberOfLinks = coloumndriver.findElements(By.tagName("a")).size();
		for(int i=0;i<numberOfLinks;i++)
		{		
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(2000L);
			
		}
		
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())
		{
			
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		
		}
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
