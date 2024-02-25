package testinn.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddFillUp {
	public void Login(String e_email, String p_pass, FirefoxDriver driver) {
		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys(e_email);

		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys(p_pass);

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();

	}

	@Test(dataProvider = "AddQuestionData")
	public void TestAddFillUp(String QText_, String QAns_) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:5173");

		Login("may@gmail.com", "Tiet@1234#", driver);

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}

		driver.findElement(By.id("0")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Add FillUp']")).click();

		WebElement QText = driver.findElement(By.id("questionText"));
		QText.clear();
		QText.sendKeys(QText_);

		WebElement QAns = driver.findElement(By.id("answer"));
		QAns.clear();
		QAns.sendKeys(QAns_);

		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());
	}

	@DataProvider
	public Object[][] AddQuestionData() {
		Object[][] data = new Object[4][2];

		data[0][0] = "";
		data[0][1] = "sensitive";
		
		data[1][0] = "C++ Language is case _";
		data[1][1] = "";
		
		data[2][0] = "C++ Language is case ";
		data[2][1] = "sensitive";
		
		data[3][0] = "C++ Language is case _";
		data[3][1] = "sensitive";

		return data;
	}
}
