package Booking;

import java.util.Scanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingSomethingInShopee {
	@BeforeTest
	public void Login() {
		System.out.println("Login");
	}
	
	@BeforeMethod
	public void beforeTestcase() {
		System.out.println("Start /n");
	}
	
	@AfterMethod
	public void afterTestcase() {
		System.out.println("End /n");
	}
	
	@Test
	public void buyALight() {
		System.out.println("buy a light");
	}
	@Test
	public void buyABook() {
		System.out.println("buy a book");
	}
	
	@AfterTest
	public void Notifiacation() {
		System.out.println("Done");
	}
}
