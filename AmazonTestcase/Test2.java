package AmazonTestcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v124.webauthn.model.CredentialAdded;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2 {
	WebDriver driver = new FirefoxDriver();

	@Test
	public void testCase2() {
		
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

		// Books Selected
		driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'][normalize-space()='Books'])[1]")).click();

		// Select Product
		driver.findElement(By.xpath("(//div[@class='a-section ProductCardImage-module__wrapper_YgLz4kq6ekChj01qeqOf'])[1]")).click();

		// Add to cart
		driver.findElement(By.name("submit.add-to-cart")).click();

		String text = driver.findElement(By.xpath("(//h1[normalize-space()='Added to Cart'])[1]")).getText();
		System.out.println("Actual text = " + text);
		
		//Assert to check 
		//st.assertEquals(text, "Added to Cart from Movie & TV"); ---//Negative
		st.assertEquals(text, "Added to Cart"); //--Positive Assert
		
		driver.quit();
		st.assertAll();
	}
}
