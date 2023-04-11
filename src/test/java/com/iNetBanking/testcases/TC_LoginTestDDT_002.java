package com.iNetBanking.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.genricLibrary.BaseClass;
import com.iNetBanking.genricLibrary.CommonLibrary;
import com.iNetBanking.pageObject.LoginPage;
import com.iNetBanking.utilities.ExcelUtils;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		CommonLibrary cl=new CommonLibrary();
		lp.setUsername(user);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(cl.isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			logger.warn("Login Failed");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(3000);
			lp.clickLogout();
			logger.info("Clicked on logout");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+ "./src/test/java/com/iNetBanking/testData/LoginData.xlsx";
		
		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colcount=ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				loginData[i-1][j]=ExcelUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
