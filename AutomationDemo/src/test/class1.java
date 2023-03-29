package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import graphql.org.antlr.v4.runtime.tree.Tree;

public class class1 {

	WebDriver driver;
	ChromeOptions chrome_options;
	JavascriptExecutor jse;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Webdriver\\chromedriver.exe");
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("start-maximized");
			this.driver = new ChromeDriver(ops);
			driver.manage().deleteAllCookies();

//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);

			driver.get("https://cellphones.com.vn/");
			System.out.println(driver.getTitle());

			searchCourse();
//			Thread.sleep(5000);
//			testClick();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testClick() {
		Duration i = driver.manage().timeouts().getImplicitWaitTimeout();
		System.out.println(i);
		driver.findElement(By.cssSelector("#cpsHeader > div > nav > div.header-item.about-5.about-smember.cta-smember"))
				.click();
		WebElement element = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[3]/div[2]/div[2]/div[1]/input")); // you can																					// use
																												// any																									// locator
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='enter the value here';", element);
	}

	public void searchCourse() {
		String txtSearch = "Iphone 14";
		String txtPath = "/html/body/div[1]/div/div/div[1]/header/div/nav/div[3]/form/div/input";
		keySearch(txtPath, txtSearch);
		liveSearch(txtPath, txtSearch);
		
	}

	public void keySearch(String xpath, String value) {
		value = "'" + value + "'";
		WebElement element = driver.findElement(By.xpath(xpath)); // you can use any locator
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=" + value + ";", element);
		element.sendKeys(Keys.RETURN);
		driver.navigate().back();
	}

	public void liveSearch(String xpath, String value) {
		String val = value;
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
		jse.executeScript("scroll(0, 1000)"); // execute a script
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/header/div/nav/div[3]/form/div/div[2]/a[1]"))
				.click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class1 myObj = new class1();
		myObj.invokeBrowser();
	}

}
