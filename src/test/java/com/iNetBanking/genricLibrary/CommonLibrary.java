package com.iNetBanking.genricLibrary;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonLibrary extends BaseClass {
	
	public boolean isAlertPresent() {
		
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot t=(TakesScreenshot) driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+"./ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, dest);
		System.out.println("ScreenShot Taken");
	}
	
	public String randomWords() {
		String randomwordsGen = RandomStringUtils.randomAlphabetic(8);
		return randomwordsGen;
	}
	
	public String random4Pin() {
		String random4Pin = RandomStringUtils.randomNumeric(6);
		return random4Pin;
	}
	
	public String random10Digits() {
		String random10Digits = RandomStringUtils.randomNumeric(10);
		return random10Digits;
	}
}
