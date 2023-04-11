package com.iNetBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.genricLibrary.BaseClass;
import com.iNetBanking.genricLibrary.CommonLibrary;
import com.iNetBanking.pageObject.AddCustomerPage;
import com.iNetBanking.pageObject.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		AddCustomerPage cp=new AddCustomerPage(driver);
		CommonLibrary cl= new CommonLibrary();
	
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		cp.clickNewCust();
		cp.custNameTxtfld("Jack");
		logger.info("Entered Customer Name");
		cp.genderBtn("male");
		logger.info("Entered Gender");
		cp.dob("04", "10", "2023");
		logger.info("Entered Date of Birth");
		cp.addressTxtbx("Jp Nagar");
		logger.info("Entered Address");
		cp.city("Bangalore");
		logger.info("Entered city");
		cp.state("KA");
		logger.info("Entered state");
		cp.pin(cl.random4Pin());
		logger.info("Entered Pin");
		cp.mNumber(cl.random10Digits());
		logger.info("Entered Mobile number");
		cp.custEmail(cl.randomWords()+"@gmail.com");
		logger.info("Entered email");
		cp.pswrd(cl.randomWords()+"@"+cl.random4Pin());
		logger.info("Entered customer Password");
		cp.submitBtn();
		logger.info("Clicked on submit");
		Thread.sleep(5000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
		}
		else {
			cl.captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
