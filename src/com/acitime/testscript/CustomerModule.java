package com.acitime.testscript;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	//pullback
	@Test
	public void testcreateCustomer() {
		Reporter.log("create",true);
		
	}

}
