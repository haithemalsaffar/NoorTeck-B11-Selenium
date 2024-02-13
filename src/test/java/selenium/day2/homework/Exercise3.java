package selenium.day2.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exercise3 extends Hooks {
	public static void main(String[] args) throws InterruptedException {
		setUp();
		driver.get(" https://demo.nopcommerce.com/ ");

		WebElement register = driver.findElement(By.partialLinkText("Register"));
		register.click();
		Thread.sleep(3000);

		WebElement pageTitle = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		if (pageTitle.getText().equals("nopCommerce demo store. Register")) {
			System.out.println("PageTitle Verfied");
		} else
			System.out.println("PageTitle Not Verfied");

		WebElement male = driver.findElement(By.id("gender-male"));

		male.click();
		WebElement firstName = driver.findElement(By.id("FirstName"));
		WebElement lastName = driver.findElement(By.id("LastName"));

		firstName.sendKeys("John");
		lastName.sendKeys("Cena");

		WebElement dayDropdown = driver.findElement(By.name("DateOfBirthDay"));
		Select selectObjD = new Select(dayDropdown);
		selectObjD.selectByVisibleText("11");
		Thread.sleep(2000);

		WebElement monDropdown = driver.findElement(By.name("DateOfBirthMonth"));
		Select selectObjM = new Select(monDropdown);
		selectObjM.selectByVisibleText("April");
		Thread.sleep(2000);

		WebElement yearDropdown = driver.findElement(By.name("DateOfBirthYear"));
		Select selectObjY = new Select(yearDropdown);
		selectObjY.selectByVisibleText("1970");
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("John.Cena5@noorteck.com");
		Thread.sleep(2000);

		WebElement company = driver.findElement(By.id("Company"));
		company.sendKeys("Noorteck");
		Thread.sleep(2000);

		WebElement newsLetter = driver.findElement(By.id("Newsletter"));
		newsLetter.click();
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("admin@Noor99");
		Thread.sleep(2000);

		WebElement confirmpass = driver.findElement(By.id("ConfirmPassword"));
		confirmpass.sendKeys("admin@Noor99");
		Thread.sleep(5000);

		WebElement register1 = driver.findElement(By.id("register-button"));
		register1.click();

		Thread.sleep(5000);

		WebElement regver = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > div.result"));

		
		if (regver.getText().equals("Your registration completed")) {
			System.out.println("TESTCASE PASSED ");
		} else {
			System.out.println("TESTCASE FAILED");
		}
		Thread.sleep(2000);
				
		
		tearDown();

	}

}
