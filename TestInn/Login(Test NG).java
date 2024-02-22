package testinn.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	@Test(dataProvider = "LoginData")
	public void TestLogin(String e_email, String p_pass) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:5173");

		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys(e_email);

		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys(p_pass);

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());

	}

	@DataProvider
	public Object[][] LoginData() {
		Object[][] data = new Object[6][2];

		data[0][0] = "";
		data[0][1] = "Tiet@1234#";

		data[1][0] = "may@gmail.com";
		data[1][1] = "";

		data[2][0] = "may";
		data[2][1] = "Tiet@1234#";

		data[3][0] = "may@";
		data[3][1] = "Tiet@1234#";

		data[4][0] = "may@.com";
		data[4][1] = "Tiet@1234#";

		data[5][0] = "may@gmail.com";
		data[5][1] = "Tiet@1234#";

		return data;
	}
}

