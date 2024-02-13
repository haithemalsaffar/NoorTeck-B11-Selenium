package selenium.day2.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Hooks;

public class Exercise2 extends Hooks{
    public static void main(String[] args) throws InterruptedException {
//        // Step 1: Set Chrome Driver path
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
//
//        // Step 2: Initialize ChromeDriver
//        WebDriver driver = new ChromeDriver();
    	
    	setUp();

        // Step 3: Navigate to URL
        driver.get("https://ntkhr.noortecktraining.com/web/index.php/auth/login");

//        // Step 4: Maximize browser window
//        driver.manage().window().maximize();

        // Step 5: Enter Username
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("ntk-admin");
        Thread.sleep(3000);

        // Step 6: Enter Password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Ntk-orange!admin.123");
        Thread.sleep(3000);
        
        // Step 7: Click Login Button
        WebElement loginButton = driver.findElement(By.xpath("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button"));
        loginButton.click();

        // Adding an implicit wait to ensure elements load properly
        Thread.sleep(3000);

        // Step 8: Retrieve Header Text and Verify
        WebElement headerText = driver.findElement(By.id("menu_dashboard_index"));
        String header = headerText.getText();
        if (header.equals("Dashboard")) {
            System.out.println("Header text is 'Dashboard'. Verification successful.");
        } else {
            System.out.println("Header text verification failed.");
        }

        // Step 9: Close the Browser
        driver.quit();
    }
}

