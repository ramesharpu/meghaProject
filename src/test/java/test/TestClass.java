package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass {
	@Parameters({"rameshUsername", "rameshPassword"})
	@Test
	public void m1(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

}
