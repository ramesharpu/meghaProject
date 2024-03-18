package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(id = "email")
	WebElement email;
	
	@CacheLookup
	@FindBy(id = "pass")
	WebElement passwd;
	
	@CacheLookup
	@FindBy(xpath = "")//add the location of the upload button
	WebElement uploadProfilePhotoButton;
	
	public Login(WebDriver driverObj) {
		driver = driverObj;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		email.clear();
		email.sendKeys(username);
		
		passwd.clear();
		passwd.sendKeys(password);
	}
	
	public void uploadFile() throws AWTException, InterruptedException {
	
		Robot robot = new Robot();
		
		//copy the file location
		String fileName = "D:\\selenium\\wallpaper.jpg";
		StringSelection stringSelection = new StringSelection(fileName);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		
		//pasting ==> using "control + v" operation
		
		//Thread.sleep is used only for demonstration purpose
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}
}
