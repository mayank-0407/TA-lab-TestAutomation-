package testinn.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAuth {
	SoftAssert sassert = new SoftAssert();

	@Test(dataProvider = "RegisterationData", priority = 1, enabled = true)
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

		sassert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Sign in']")).isDisplayed());

		System.out.println("Registered Successfully");
		driver.quit();
		sassert.assertAll();
	}

	@Test(dataProvider = "LoginData", priority = 2, enabled = false)
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

		sassert.assertTrue(driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());

		System.out.println("Logged Successfully");
		driver.quit();
		sassert.assertAll();

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

	@DataProvider
	public Object[][] RegisterationData() {
		Object[][] data = new Object[14][5];

		data[0][0] = "Mayank";
		data[0][1] = "Aggarwal";
		data[0][2] = "may@gmail.com";
		data[0][3] = "Tiet@1234#";
		data[0][4] = "Tiet@1234#";

		data[1][0] = "John";
		data[1][1] = "Doe";
		data[1][2] = "john.doe@example.com";
		data[1][3] = "password123";
		data[1][4] = "password123";

		data[2][0] = "";
		data[2][1] = "Smith";
		data[2][2] = "jane.smith@example.com";
		data[2][3] = "securePwd";
		data[2][4] = "securePwd";

		data[3][0] = "Alice";
		data[3][1] = "";
		data[3][2] = "alice.johnson@example.com";
		data[3][3] = "pass1234";
		data[3][4] = "pass1234";

		data[4][0] = "Bob";
		data[4][1] = "Williams";
		data[4][2] = "bob";
		data[4][3] = "secretPwd";
		data[4][4] = "secretPwd";

		data[5][0] = "Bob";
		data[5][1] = "Williams";
		data[5][2] = "bob.williams@";
		data[5][3] = "secretPwd";
		data[5][4] = "secretPwd";

		data[6][0] = "Bob";
		data[6][1] = "Williams";
		data[6][2] = "bob.williams@example.com";
		data[6][3] = "";
		data[6][4] = "secretPwd";

		data[7][0] = "Alice";
		data[7][1] = "Aggarwal";
		data[7][2] = "alice.johnson@example.com";
		data[7][3] = "pass1234";
		data[7][4] = "";

		// password Validation
		data[8][0] = "John";
		data[8][1] = "Doe";
		data[8][2] = "john.doe@example.com";
		data[8][3] = "Password123";
		data[8][4] = "Password123";

		data[9][0] = "John";
		data[9][1] = "Doe";
		data[9][2] = "john.doe@example.com";
		data[9][3] = "password";
		data[9][4] = "password";

		data[10][0] = "John";
		data[10][1] = "Doe";
		data[10][2] = "john.doe@example.com";
		data[10][3] = "Password";
		data[10][4] = "Password";

		data[11][0] = "John";
		data[11][1] = "Doe";
		data[11][2] = "john.doe@example.com";
		data[11][3] = "Password@";
		data[11][4] = "Password@";

		data[12][0] = "John";
		data[12][1] = "Doe";
		data[12][2] = "john.doe@example.com";
		data[12][3] = "Password@#123";
		data[12][4] = "Password@#123";

		data[13][0] = "John";
		data[13][1] = "Doe";
		data[13][2] = "john.doe@example.com";
		data[13][3] = "P@123";
		data[13][4] = "P@123";

		return data;
	}
}
