package com.actitime.generic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdiver.chrome.driver","./driver/chromedriver.exe"); 
	}
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		Reporter.log("openbrowser",true);
		driver=new ChromeDriver();
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("closebrowser",true);
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		FileLib ob=new FileLib();
		String url=ob.getPropertyData("url");
		String un=ob.getPropertyData("username");
		String pwd=ob.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage();
		l.setLogin(un, pwd);
	
		
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("logout",true);
		Thread.sleep(5000);
		HomePage h=new HomePage();
		h.setLogout();
	}

}
