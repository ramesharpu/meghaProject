package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class RobotExample  extends BaseTest{
	@Test
	public void robotExample() throws AWTException, InterruptedException {
		driver.get("https://tinypng.com/");
		
		driver.findElement(By.xpath("//section[@class='target']")).click();
		
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
