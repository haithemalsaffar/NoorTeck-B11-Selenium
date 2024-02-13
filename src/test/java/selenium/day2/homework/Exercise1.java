package selenium.day2.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Hooks;

public class Exercise1 extends Hooks {
	public static void main(String[] args) throws InterruptedException {
		setUp();

		driver.get("https://ntkhr.noortecktraining.com/web/index.php/auth/login");

		Thread.sleep(2000);

		
		WebElement usernameBox = driver.findElement(By.name("username"));
		usernameBox.sendKeys("ntk-admin");

		Thread.sleep(1000);

		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("Ntk-orange!admin.123");

		Thread.sleep(1000);

	
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		loginButton.click();

		WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));

		String header = dashboard.getText();
		if (header.equals("Dashboard")) {
			System.out.println("Header text is 'Dashboard'. Verification successful.");
		} else {
			System.out.println("Header text verification failed.");
		}

		tearDown();
		
	}

}
