package com.actitime.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(id="logoutLink")
	private WebElement logbtn;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void setLogout() {
		logbtn.click();
	}

}
