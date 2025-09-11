package Automation;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MyTestCases extends myData {

	WebDriver driver = new EdgeDriver();

	String myWebsite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	@BeforeTest
	public void mySetup() {
		driver.get(myWebsite);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void SignupTest() throws InterruptedException {

		driver.navigate().to(SignupPage);

		// WebElements
		WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));

		WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));

		WebElement Email = driver.findElement(By.id("AccountFrm_email"));

		WebElement Telephone = driver.findElement(By.id("AccountFrm_telephone"));

		WebElement Fax = driver.findElement(By.id("AccountFrm_fax"));

		WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));

		WebElement TheCountry = driver.findElement(By.id("AccountFrm_country_id"));

		WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));

		Select mySelectElementForCountry = new Select(TheCountry);
		Select mySelectElementForState = new Select(TheState);

		mySelectElementForCountry.selectByIndex(108);

		Thread.sleep(2000);

		// To Select State

		// Option1 (Select by index)
		mySelectElementForState.selectByIndex(theSelectStateIndex);

		// Option 2 (Select by value)
		// mySelectElementForState.selectByValue("1709");

		// Option 3 (Select by visible text)
		// mySelectElementForState.selectByVisibleText("Al Balqa'");

		// Write Address
		List<WebElement> AlltheStates = TheState.findElements(By.tagName("option"));

		String theCity = AlltheStates.get(theSelectStateIndex).getText();

		WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));

		WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));

		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));

		WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));

		WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));

		WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));

		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));

		// Actions
		FirstName.sendKeys(TheFirstName);
		LastName.sendKeys(TheLastName);
		Email.sendKeys(TheEmail);

		Telephone.sendKeys("Telephone");
		Fax.sendKeys(TheFaxNumber);
		AddressOne.sendKeys(TheAddressOne);

		TheCityInput.sendKeys(theCity);

		ThePostalCode.sendKeys(PostalCode);

		LoginName.sendKeys(LOGINAME);

		ThePassword.sendKeys(Password);

		TheConfirmPassword.sendKeys(Password);

		AgreeCheckBox.click();

		ContinueButton.click();
		
		
		Thread.sleep(5000);
		
		String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();
		
		
		// This is a test case that compares the actual result with the expected result and works like the if 
		Assert.assertEquals(ActualSignUpMessage, ExpectedTextforTheSignUp);
		
		
		
//		//Static
//		
//		String [] FirstNames = {"Sam", "Tom", "Dan", "Lily", "Dev", "Mel"}; 
//		
//		//Dynamic
//		List<String> mycolors = new ArrayList<String>();
//
//		mycolors.add("green");
//		mycolors.add("blue");
//		
//		System.out.println(FirstNames[0]);
//		System.out.println(mycolors.get(0));
//		

	}
	
	@Test(priority = 2,enabled = false)
	public void LogoutTest () throws InterruptedException {
		
	Thread.sleep(3000);
		
	// Link text Method
    driver.findElement(By.linkText("Logoff")).click();
    
    
    // Partial link text method
    // driver.findElement(By.partialLinkText("Logo")).click();
	
    
    // System.out.println(driver.getPageSource());
    
    boolean ActualValueForLogout = driver.getPageSource().contains(TheLogoutMessage);
    
    Assert.assertEquals(ActualValueForLogout, true);

	}
	

	@Test(priority = 3,enabled = false)
	
	public void Login() throws InterruptedException {
		
	// Search and count how many tags of type <a this pages has 
	//System.out.println(driver.findElements(By.tagName("a")).size());
	
	//Click Login or Register button
		
	// ----LinkText method----	
	//driver.findElement(By.linkText("Login or register")).click();
	
	//----Xpath method----
	//driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=account/login']")).click();
	
	//Using selector Hub:
		//1) Xpath
	//driver.findElement(By.xpath("//a[normalize-space()='Login or register']")).click();
	 	//2) CSS Selector
	driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
	
	WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname"));
	
	WebElement LoginPassword = driver.findElement(By.id("loginFrm_password"));

	WebElement LoginButton = driver.findElement(By.cssSelector("button[title='Login']"));
	

	LoginNameInput.sendKeys(LOGINAME);
	
	LoginPassword.sendKeys(Password);
	
	Thread.sleep(3000);
	
	LoginButton.click();
	
	// Now we are logged in
	
	boolean ActualValue = driver.getPageSource().contains(WelcomeMessage);
	boolean ExpectedValue = true;
	
	assertEquals(ActualValue, ExpectedValue);
	
	
	}
	
	@Test(priority = 4)
	public void AddItemToTheCart() {
		
	driver.navigate().to(myWebsite);	
	
	List<WebElement> AllItems = driver.findElements(By.className("prdocutname"));
	
	int RandomIndexForTheItem = rand.nextInt(AllItems.size());
	
	// Selecting a random item
	AllItems.get(RandomIndexForTheItem).click();
	
	System.out.println(driver.getCurrentUrl()); 
	
	}
	
	@AfterTest
	public void AfterMyTest() {

		// driver.close();

		// driver.quit();

	}
}
