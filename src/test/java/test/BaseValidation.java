package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class BaseValidation extends BaseTest{

	@Test
	public void urlValidation() {
		String expectedUrl = "https://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		
		assertTrue(actualUrl.equals(expectedUrl), "Mismatch in the url");
	}
	
	
	@Test
	public void titleValidation() {
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		
		assertTrue(actualTitle.equals(expectedTitle), "Mismatch in the page title");
	}
}
