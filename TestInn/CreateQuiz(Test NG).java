package testinn.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateQuiz {
	public void Login(String e_email, String p_pass, FirefoxDriver driver) {
		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys(e_email);

		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys(p_pass);

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();

	}

	@Test(dataProvider = "CreateQuizData")
	public void TestCreateQuiz(String qname, String qdes) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:5173");

		Login("may@gmail.com", "Tiet@1234#", driver);
		
		driver.findElement(By.xpath("//a[@id='hiddenCreateQuiz']")).click();

		WebElement Qname = driver.findElement(By.xpath("//input[@id='quizname']"));
		Qname.clear();
		Qname.sendKeys(qname);

		WebElement Qdes = driver.findElement(By.xpath("//input[@id='quizdescription']"));
		Qdes.clear();
		Qdes.sendKeys(qdes);
		
		driver.findElement(By.xpath("//button[normalize-space()='Create Quiz']")).click();
		
		try {
		    TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());
	}

	@DataProvider
	public Object[][] CreateQuizData() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "";
		data[0][1] = "This is Description of Lab Quiz";
		
		data[1][0] = "Lab Quiz 1";
		data[1][1] = "";
		
		data[2][0] = "Lab Quiz 1";
		data[2][1] = "This is Description of Lab Quiz";
		
		return data;
	}
}
