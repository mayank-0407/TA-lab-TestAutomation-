package testinn.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestTestIn {
	SoftAssert sassert = new SoftAssert();

	public void Login(String e_email, String p_pass, FirefoxDriver driver) {
		WebElement uemail = driver.findElement(By.id("email"));
		uemail.clear();
		uemail.sendKeys(e_email);

		WebElement upass = driver.findElement(By.id("password"));
		upass.clear();
		upass.sendKeys(p_pass);

		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());
	}


	@Test(dataProvider = "CreateQuizData",priority=1,enabled=false)
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

		sassert.assertTrue(driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());
		System.out.println("Quiz Added Successfully");
		driver.quit();
		sassert.assertAll();
	}

	@Test(dataProvider = "AddMCQQuestionData",priority=2,enabled=false)
	public void TestAddQuestion(String QText_, String QAns_,String QOptions_) {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://localhost:5173");

		Login("may@gmail.com", "Tiet@1234#", driver);
		
		try {
		    TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		driver.findElement(By.id("0")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Add MCQ']")).click();

		WebElement QText = driver.findElement(By.id("questionText"));
		QText.clear();
		QText.sendKeys(QText_);

		WebElement QAns = driver.findElement(By.id("answer"));
		QAns.clear();
		QAns.sendKeys(QAns_);
		
		WebElement QOptions = driver.findElement(By.id("options"));
		QOptions.clear();
		QOptions.sendKeys(QOptions_);
		
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
		try {
		    TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		sassert.assertTrue(
				driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());
		System.out.println("Question Added Successfully");
		driver.quit();
		sassert.assertAll();
	}

	
	@Test(dataProvider = "AddQuestionData",priority=3,enabled=true)
	public void TestAddFillUp(String QText_, String QAns_) {

		SoftAssert sassert = new SoftAssert();
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

		sassert.assertTrue(driver.findElement(By.xpath("//div[@class='p-4 text-2xl font-semibold']")).isDisplayed());
		
		System.out.println("FillUp Added Successfully");
		driver.quit();
		sassert.assertAll();
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

	@DataProvider
	public Object[][] AddMCQQuestionData() {
		Object[][] data = new Object[6][3];
		
		data[0][0] = "";
		data[0][1] = "name";
		data[0][2] = "name,input,form,h1";
		
		data[1][0] = "Name any one attribute with which you can fetch the data of input";
		data[1][1] = "";
		data[1][2] = "name,input,form,h1";

		data[2][0] = "Name any one attribute with which you can fetch the data of input";
		data[2][1] = "name";
		data[2][2] = "";

		data[3][0] = "Name any one attribute with which you can fetch the data of input";
		data[3][1] = "name";
		data[3][2] = "input,form,h1";
		
		data[4][0] = "Name any one attribute with which you can fetch the data of input";
		data[4][1] = "name";
		data[4][2] = "form1,input,form,h1";

		data[5][0] = "Name any one attribute with which you can fetch the data of input";
		data[5][1] = "name";
		data[5][2] = "name,input,form,h1";


		return data;
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
