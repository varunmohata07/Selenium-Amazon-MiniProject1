package AmazonTestcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test10 {

	WebDriver driver = new EdgeDriver();

	public void changeLocation() throws InterruptedException {
		// change location to UK as item available only in UK
		WebElement locationButton = driver.findElement(By.id("glow-ingress-block"));
		locationButton.click();

		// select location dropdown
		WebElement locationsDropdown = driver
				.findElement(By.xpath("//div[@class=' a-declarative']/span[@class='a-dropdown-container']"));
		locationsDropdown.click();

		// select UK
		WebElement UKOption = driver
				.findElement(By.xpath("//select[@id='GLUXCountryList']/optgroup[1]/option[@value='GB']"));
		UKOption.click();

		// click done
		driver.findElement(By.xpath("//button[@name='glowDoneButton']")).click();

		// wait for location change
		Thread.sleep(3000);
	}

	@Test
	public void testCase8() throws Throwable {

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
		driver.findElement(By.xpath("//a[@aria-labelledby='see-more-brands-label']")).click();

		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
		driver.findElement(By.xpath("(//div[@class='ProductCard-module__imageWrapper_ytp7KTuzmF4mDTFCQLzr'])[1]"))
				.click();
		driver.findElement(By.xpath("//span[@id='dropdown_selected_size_name']")).click();
		driver.findElement(By.xpath("//div[@class='a-popover-wrapper']/div/ul/li[5]")).click();

		changeLocation();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")).click();
		// Add to Cart
		driver.findElement(By.id("add-to-cart-button")).click();

		String text = driver.findElement(By.xpath("(//h1[normalize-space()='Added to Cart'])[1]")).getText().trim();
		System.out.println("Actual text = " + text);
		// Assert to check
		st.assertEquals(text, "Added to Cart");
		st.assertAll();
		driver.close();

	}
}