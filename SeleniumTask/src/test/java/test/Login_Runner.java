package test;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import pages.Login_Page;;

public class Login_Runner {

	Properties p = new Properties();
	WebDriver driver = new ChromeDriver();

	@Test
	public void f() throws IOException, InterruptedException {

		Login_Page obj = new Login_Page(driver);
		String uname = obj.name(p.getProperty("name"));
		String uemail = obj.email(p.getProperty("email"));
		String utel = obj.tel(p.getProperty("telephone"));
		Thread.sleep(5000);
		String ugender = obj.gender(p.getProperty("Gender"));
		String uupload = obj.upload(p.getProperty("image"));
		boolean uexp = obj.experience();
		boolean uskills = obj.skills();
		String utools =obj.tools(p.getProperty("tools"));

		System.out.println("UserName : "+uname);
		System.out.println("Email : "+uemail);
		System.out.println("Phone Numeber : "+utel);
		System.out.println("Gender : "+ugender);
		System.out.println("File Path : "+uupload);
		System.out.println("Experience : "+uexp);
		System.out.println("Skills : "+uskills);
		System.out.println("Tools : "+utools);


	}


	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException {
		FileReader fr = new FileReader("C:\\Users\\abinesh.ashokan\\Documents\\Selenium_Task\\SeleniumTask\\Utility\\Login.properties");
		p.load(fr);

		String first = driver.getWindowHandle();
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.switchTo().newWindow(WindowType.TAB);
		String second = driver.getWindowHandle();
		driver.get(p.getProperty("url1"));
		Thread.sleep(2000);
		driver.switchTo().window(first);
		Thread.sleep(2000);	

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
