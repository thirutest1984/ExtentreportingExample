package extenttestreports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//@Listeners(TestListener.class)
public class ExtentReportTests {
		
	@BeforeTest
	public void beforeTestcases() {
		System.out.println("Running before all the tests");
	}
	
	@AfterTest
	public void afterTestcases() {
		System.out.println("Running after all the tests");
	}
	
	@Test
	public void passingTest() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void failingTest() {
		Assert.assertTrue(false);
	}
	

}
