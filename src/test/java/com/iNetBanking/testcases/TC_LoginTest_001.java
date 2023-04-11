package com.iNetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.genricLibrary.BaseClass;
import com.iNetBanking.genricLibrary.CommonLibrary;
import com.iNetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		CommonLibrary cl=new CommonLibrary();
	
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			cl.captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("Login test failed"); 
		}
	}
}
