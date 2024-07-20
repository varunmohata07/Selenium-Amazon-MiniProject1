package AmazonTestcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test4 {
	WebDriver driver = new FirefoxDriver();

	@Test
//		WebDriver driver = new ChromeDriver();	
	public void testCase4() {

		// soft assert
		SoftAssert st = new SoftAssert();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.navigate().refresh();
		// Handling Pop ups
		try {
			WebElement toastremove1 = driver.findElement(By.xpath(
					"//div[@class='a-section glow-toaster glow-toaster-theme-default glow-toaster-slot-default nav-coreFlyout nav-flyout']//input[@data-action-type='DISMISS']"));
			toastremove1.click();
		} catch (Exception e) {
			System.out.println("Exception Occurred....");
		}

		// Click Today's Deal
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[1]")).click();

		// See More
		driver.findElement(By.xpath("//a[@aria-labelledby='see-more-departments-label']")).click();

		List<WebElement> labels = driver.findElements(
				By.xpath("(//div[@class='SingleSelectInput-module__options_BX566mbDVnYGXyVzej99'])[1]/span"));

		for (WebElement a : labels) {
			System.out.println(a.getText());
			Assert.assertTrue(a.isEnabled());
		}
		driver.close();

	}
}