package testin.com;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterationValidation {	
	public static boolean Login(FirefoxDriver driver)
	{
		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys("test@gmail.com");
		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys("Tiet@1234");
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();

		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		WebElement isLogged = driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold text-left']"));
		try {
			if(isLogged.getText().contains("Dashboard!"))
				System.out.println("Login SuccessFull");
			else {				
				System.out.println("Login Failed");
				return false;
			}
		}
		catch(Exception e){			
			System.out.println("Something went wrong");	
			return false;
		}
		return true;	
	}	
	public static boolean Register(FirefoxDriver driver)
	{
		WebElement fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys("Test");
		WebElement lname = driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys("Phase");
		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys("test@gmail.com");
		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys("Tiet@1234");
		WebElement upass1 = driver.findElement(By.id("cpassword"));
		upass1.clear();
		upass1.sendKeys("Tiet@1234");
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
		
		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		WebElement isSignedUp = driver.findElement(By.xpath("//h1[normalize-space()='Sign in']"));
		try {
			if(isSignedUp.getText().equals("Sign in"))
				System.out.println("Account Created SuccessFull");
			else {				
				System.out.println("Signup Failed");
				return false;
			}
		}
		catch(Exception e){			
			System.out.println("Something went wrong");	
			return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:5173/");
		boolean isRegistered = Register(driver);
		if(!isRegistered) return;
		boolean isLogged = Login(driver);
		if(!isLogged) return;
	}
}
