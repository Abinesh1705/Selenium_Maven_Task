package pages;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Login_Page {

	WebDriver driver;
	By username = By.id("username");
	By email = By.id("email");
	By phone = By.id("tel");
	By file = By.xpath("//input[@type='file']");
	By upload = By.name("datafile");
	By submit = By.id("submit");


	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public String name(String input) {
		driver.findElement(username).sendKeys(input);
		return driver.findElement(username).getAttribute("value");


	}

	public String email(String input) {
		driver.findElement(email).sendKeys(input);
		return driver.findElement(email).getAttribute("value");


	}

	public String tel(String input) {
		driver.findElement(phone).sendKeys(input);
		return driver.findElement(phone).getAttribute("value");


	}
	public String upload(String input) {
		driver.findElement(upload).sendKeys(input);
		return driver.findElement(upload).getAttribute("value");

	}


	public String gender(String input) {
		Select gender = new Select(driver.findElement(By.name("sgender")));
		gender.selectByVisibleText(input);
		return driver.findElement(By.name("sgender")).getAttribute("value");

	}

	public boolean experience() {
		driver.findElement(By.xpath("//input[@value='one']")).click();
		return driver.findElement(By.xpath("//input[@value='one']")).isSelected();
	}

	public boolean skills() {
		driver.findElement(By.xpath("//input[@value='automationtesting']")).click();
		return driver.findElement(By.xpath("//input[@value='automationtesting']")).isSelected();
	}

	public String tools(String input) {
		Select tools = new Select(driver.findElement(By.id("tools")));
		tools.selectByVisibleText(input);
		return driver.findElement(By.id("tools")).getAttribute("value");
	}

	public void submit() {
		driver.findElement(submit).click();
	}



}









