package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static WebDriver driver;
	String browser = "chrome";
	String url = "https://www.facebook.com";

	@BeforeSuite
	public void setupBrowser() {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();//instantiating a chrome browser
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();//instantiating a chrome browser
		}
		else {
			System.out.println("valid browser is not provided, hence quitting the automation run");
			System.exit(0);
		}

		driver.get(url);
	}

	@AfterSuite
	public void quitBrowser() {
//		driver.quit();//close the browser
	}

	public HashMap<String, String> readCsvFile(int lineNumber) {
		String line = "";  
		String splitBy = ",";
		int i = 0;
		HashMap<String, String> user = null;
		try   
		{  
			BufferedReader br = new BufferedReader(new FileReader("user.csv"));  
			while ((line = br.readLine()) != null)
			{  
				if(i==lineNumber) {
					String[] userData = line.split(splitBy);
					user = new HashMap<String, String>();
					user.put("username",userData[0]);
					user.put("phoneNumber",userData[1]);
					user.put("city", userData[2]);
					user.put("postalCode", userData[3]);
					break;
				}
				else {
					i++;
				}
			}  
		}   
		catch (IOException e)   
		{  
			e.printStackTrace();  
		} 
		return user;
	}  
}
