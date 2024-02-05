import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	public static void Shop(FirefoxDriver driver) {
		WebElement clickShop = driver.findElement(By.linkText("Shop"));
		clickShop.click();
		
		WebElement clickJs = driver.findElement(By.linkText("JavaScript"));
		clickJs.click();
		
		WebElement clickPic = driver.findElement(By.xpath("//img[@title='Functional Programming in JS']"));
		clickPic.click();
		
		WebElement changeQuantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		changeQuantity.clear();
		changeQuantity.sendKeys("2");
		
		WebElement addToBasket = driver.findElement(By.xpath("//button[normalize-space()='Add to basket']"));
		addToBasket.click();
		
		WebElement viewBasket = driver.findElement(By.xpath("//i[@class='wpmenucart-icon-shopping-cart-0']"));
		viewBasket.click();
	}
	
	public static void Login(FirefoxDriver driver)
	{
		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys("tiet@gmail.com");
		WebElement upass = driver.findElement(By.id("password"));
		upass.sendKeys("tiet@1234#");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		WebElement Link = driver.findElement(By.linkText("Dashboard"));
		if(Link.getText().equals("Dashboard"))
			System.out.println("Log In SuccessFull");
		else
			System.out.println("Log In Failed");	
		Link.click();
		
	}

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://practice.automationtesting.in/my-account/");
		Login(driver);
		Shop(driver);
	}
}
