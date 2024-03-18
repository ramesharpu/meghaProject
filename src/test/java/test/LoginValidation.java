package test;

import java.util.HashMap;

import org.testng.annotations.Test;

import pom.Login;

public class LoginValidation extends BaseTest{

	String validUsername = "dan";
	String validPassword = "test1234";

	
	@Test
	public void validUsernameValidPasswordTest() {
		HashMap<String, String> user1 = readCsvFile(2);
		Login loginObj = new Login(driver);
		
		loginObj.login(user1.get("username"), user1.get("city"));
	}

}
