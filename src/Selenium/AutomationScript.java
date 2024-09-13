package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutomationScript {
	
	ChromeDriver driver;
	Actions actions;
	WebDriverWait wait;
	
	String url = "https://bssoln-001-site3.atempurl.com";
	
	@Test(priority = 1)
	public void invokeWebsite() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 5);
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@Test (priority = 2)
	public void navigateToRegistrationPage() {
		WebElement logInIcon = driver.findElement(By.xpath("//div[@class='header-links']//ul/li[2]"));
		logInIcon.click();
		
		WebElement registrationLink = driver.findElement(By.linkText("Create Now"));
		registrationLink.click();
	}
	
	@Test (priority = 3)
	public void userRegistration() {
		WebElement firstName = driver.findElement(By.id("FirstName"));
		WebElement lastName = driver.findElement(By.id("LastName"));
		WebElement email = driver.findElement(By.id("Email"));
		WebElement phone = driver.findElement(By.id("Phone"));
		WebElement password = driver.findElement(By.name("Password"));
		WebElement confirmPass = driver.findElement(By.name("ConfirmPassword"));
		WebElement regButton = driver.findElement(By.id("register-button"));
		
		
		firstName.sendKeys("SaqibSizan");
		lastName.sendKeys("Khan");
		email.sendKeys("sizan59@gmail.com");
		phone.sendKeys("01520103756");
		password.sendKeys("sizan123");
		confirmPass.sendKeys("sizan123");
		
		actions.moveToElement(regButton).click().build().perform();
		
		WebElement logInIcon = driver.findElement(By.xpath("//div[@class='header-links']//ul/li[2]"));
		logInIcon.click();
	}
	
	@Test (priority = 4)
	public void userLogin() {
		WebElement userName = driver.findElement(By.id("Username"));
		WebElement password = driver.findElement(By.name("Password"));
		WebElement loginButton = driver.findElement(By.className("auth__details__form__submit"));
		
		userName.sendKeys("sizan@gmail.com");
		password.sendKeys("sizan_cit");
		
		actions.moveToElement(loginButton).click().build().perform();
	}
	
	private void cartScript(String category, int productNum) {
		WebElement eyeProductNav = driver.findElement(By.linkText(category));
		eyeProductNav.click();
		
		String productXpath = "(//div[@class='product-item'])[" + productNum + "]";
		WebElement product = driver.findElement(By.xpath(productXpath));
		product.click();
		
		WebElement addCartButton = driver.findElement(By.xpath("//div[@class='add-to-cart']/div/div/button"));
		actions.moveToElement(addCartButton).click().build().perform();
		
		WebElement continueShoppingButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continueshopping")));
		continueShoppingButton.click();
		
		WebElement goToHome = driver.findElement(By.xpath("(//div[@class='header-logo'])[1]"));
		goToHome.click();
	}
	
	@Test (priority = 5)
	public void addProductsToCart() {
		cartScript("Foundation", 1);
		cartScript("Eyeshadow Palettes", 2);
		cartScript("Mascara", 3);
	}
	
	@Test (priority = 6)
	public void navigateToCartPage() {
		WebElement cartIcon = driver.findElement(By.xpath("//div[@class='header-links']//ul/li[4]"));
		cartIcon.click();
	}
	
	@Test (priority = 7)
	public void removeItemFromCart() {
		List<WebElement> removeButtons = driver.findElements(By.xpath("//td/button[@name='updatecart']"));
		
		int totalElements = removeButtons.size();
		
		removeButtons.get(totalElements-1).click();
	}
	
	@Test (priority = 8)
	public void checkoutProducts() {
		WebElement checkoutButton = driver.findElement(By.id("checkout"));
		checkoutButton.click();
		
		WebElement cashPayment = driver.findElement(By.xpath("//ul[@id='payment-method-block']/li[2]"));
		cashPayment.click();
		
		WebElement confirmOrder = driver.findElement(By.xpath("//div[@class='order-summary__container']/button"));
		actions.moveToElement(confirmOrder).click().build().perform();
		
		WebElement goToHome = driver.findElement(By.xpath("//div[@class='buttons']/button"));
		goToHome.click();
	}
	
	@Test (priority = 9)
	public void exitBrowser() {
		driver.quit();
	}

}
