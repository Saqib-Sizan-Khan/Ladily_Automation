package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.testng.annotations.Test;

public class AutomationScript {
	
	ChromeDriver driver;
	Actions actions;
	
	String url = "https://bssoln-001-site3.atempurl.com";
	
	@Test(priority = 1)
	public void invokeWebsite() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@Test (priority = 2)
	public void navigateToRegistrationPage() {
		WebElement logInIcon = driver.findElement(By.xpath("//div[@class='header-links']//ul/li[2]"));
		logInIcon.click();
		
//		WebElement registrationLink = driver.findElement(By.linkText("Create Now"));
//		registrationLink.click();
	}
	
//	@Test (priority = 3)
//	public void userRegistration() {
//		WebElement firstName = driver.findElement(By.id("FirstName"));
//		WebElement lastName = driver.findElement(By.id("LastName"));
//		WebElement email = driver.findElement(By.id("Email"));
//		WebElement phone = driver.findElement(By.id("Phone"));
//		WebElement password = driver.findElement(By.name("Password"));
//		WebElement confirmPass = driver.findElement(By.name("ConfirmPassword"));
//		WebElement regButton = driver.findElement(By.id("register-button"));
//		
//		
//		firstName.sendKeys("SaqibSizan");
//		lastName.sendKeys("Khan");
//		email.sendKeys("sizan59@gmail.com");
//		phone.sendKeys("01520108612");
//		password.sendKeys("sizan123");
//		confirmPass.sendKeys("sizan123");
//		
//		regButton.click();
//	}
	
	@Test (priority = 4)
	public void userLogin() {
		WebElement userName = driver.findElement(By.id("Username"));
		WebElement password = driver.findElement(By.name("Password"));
		WebElement loginButton = driver.findElement(By.className("auth__details__form__submit"));
		
		userName.sendKeys("sizan@gmail.com");
		password.sendKeys("sizan_cit");
		
		loginButton.click();
	}
	
	@Test (priority = 5)
	public void addProductToCart() {
		WebElement eyeProductNav = driver.findElement(By.linkText("Eyeshadow Palettes"));
		eyeProductNav.click();
		
		WebElement product = driver.findElement(By.xpath("(//div[@class='product-item'])[2]"));
		product.click();
		
		WebElement addCartButton = driver.findElement(By.id("add-to-cart-button-9"));
		actions.moveToElement(addCartButton).click().build().perform();
		
		WebElement continueShopping = driver.findElement(By.id("continueshopping"));
		continueShopping.click();
	}

}
