package testinn.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register {
	@Test(dataProvider = "RegisterationData")
	public void Registeration(String f_name, String l_name, String e_email, String p_pass, String p_cpass) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:5173/signup");

		WebElement fname = driver.findElement(By.id("fname"));
		fname.clear();
		fname.sendKeys(f_name);
		WebElement lname = driver.findElement(By.id("lname"));
		lname.clear();
		lname.sendKeys(l_name);
		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys(e_email);
		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys(p_pass);
		WebElement upass1 = driver.findElement(By.id("cpassword"));
		upass1.clear();
		upass1.sendKeys(p_cpass);
		driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Sign in")).isDisplayed());

	}

	@DataProvider
	public Object[][] RegisterationData() {
		Object[][] data = new Object[5][5];

		data[0][0] = "Mayank";
		data[0][1] = "Aggarwal";
		data[0][2] = "may@gmail.com";
		data[0][3] = "tiet@1234#";
		data[0][4] = "tiet@1234#";

		data[1][0] = "John";
		data[1][1] = "Doe";
		data[1][2] = "john.doe@example.com";
		data[1][3] = "password123";
		data[1][4] = "password123";

		data[2][0] = "Jane";
		data[2][1] = "Smith";
		data[2][2] = "jane.smith@example.com";
		data[2][3] = "securePwd";
		data[2][4] = "securePwd";

		data[3][0] = "Alice";
		data[3][1] = "Johnson";
		data[3][2] = "alice.johnson@example.com";
		data[3][3] = "pass1234";
		data[3][4] = "pass1234";

		data[4][0] = "Bob";
		data[4][1] = "Williams";
		data[4][2] = "bob.williams@example.com";
		data[4][3] = "secretPwd";
		data[4][4] = "secretPwd";

		return data;
	}
}
