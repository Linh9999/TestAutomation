package testCase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNG {
	@Test(priority = 3)
	public void testCaseLogin() {
		System.out.println("Login ");
	}
	
	@Test(priority = 1)
	public void testCaseSignIn() {
		Assert.assertEquals(12, 14);
		Assert.a
		System.out.println("Sign in success");
	}

	@Test(priority = 2)
	public void testCaseHome() {
		System.out.println("Home");
	}
}
