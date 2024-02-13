package selenium.day2.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exercise6 extends Hooks{
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");

		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Alerts")) {
			System.out.println("Page title is correct: Automation Demo Site");
		} else {
			System.out.println("Page title is incorrect: " + pageTitle);
		}
		Thread.sleep(2000);
		
		WebElement alertWithTextBox = driver.findElement(By.linkText("Alert with Textbox"));
		alertWithTextBox.click();
		
		WebElement demoButton = driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button"));
		demoButton.click();
		demoButton.sendKeys("Haithem");	
		
		
		
		tearDown();
		
	}

}
