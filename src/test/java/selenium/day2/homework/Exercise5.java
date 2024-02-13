package selenium.day2.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exercise5 extends Hooks {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		driver.get(" https://blazedemo.com/index.php ");
		WebElement cityDropdown = driver.findElement(By.xpath("/html/body/div[3]/form/select[1]"));

		Select selectDep = new Select(cityDropdown);
		selectDep.selectByVisibleText("Boston");

		cityDropdown.click();
		Thread.sleep(3000);

		WebElement destDropdown = driver.findElement(By.xpath("/html/body/div[3]/form/select[2]"));
		Select selectDest = new Select(destDropdown);
		selectDest.selectByVisibleText("Rome");
		Thread.sleep(1000);

		WebElement pageTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div/a[2]"));
		String pageTitle1 = driver.getTitle();
		if (pageTitle1.equals("BlazeDemo - reserve")) {
			System.out.println("Page title is correct: BlazeDemo - reserve");
		} else {
			System.out.println("Page title is incorrect: " + pageTitle1);
		}
		Thread.sleep(2000);

		WebElement findFlight = driver.findElement(By.xpath("/html/body/div[3]/form/div/input"));
		findFlight.click();

		
		List<WebElement> flightRows = driver.findElements(By.cssSelector("table.table tbody tr"));

	
		int cheapestFlightIndex = 0;
		double minPrice = Double.MAX_VALUE;
		for (int i = 0; i < flightRows.size(); i++) {
			WebElement priceElement = flightRows.get(i).findElement(By.xpath("./td[6]"));
			double price = Double.parseDouble(priceElement.getText().replace("$", ""));
			if (price < minPrice) {
				minPrice = price;
				cheapestFlightIndex = i;
			}
		}
		flightRows.get(cheapestFlightIndex).findElement(By.tagName("input")).click();

		WebElement name = driver.findElement(By.id("inputName"));
		name.sendKeys("John Cena");

		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("123 Mainst.");

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("New York");

		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("New York");

		WebElement zipcode = driver.findElement(By.id("zipCode"));
		zipcode.sendKeys("12345");

		Select cardTypeDropdown = new Select(driver.findElement(By.id("cardType")));
		cardTypeDropdown.selectByVisibleText("Visa");

		WebElement cardNumber = driver.findElement(By.id("creditCardNumber"));
		cardNumber.sendKeys("1234567890123456");

		WebElement month = driver.findElement(By.id("creditCardMonth"));
		month.sendKeys("11");

		WebElement year = driver.findElement(By.id("creditCardYear"));
		year.sendKeys("2017");

		WebElement purchaseFlight = driver
				.findElement(By.cssSelector("body > div.container > form > div:nth-child(12) > div > input"));
		purchaseFlight.click();
		Thread.sleep(2000);

		String confirmationMessage = driver.findElement(By.tagName("h1")).getText();
		if (confirmationMessage.equals("Thank you for your purchase today!")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");

		
		}
		tearDown();
	}
}
