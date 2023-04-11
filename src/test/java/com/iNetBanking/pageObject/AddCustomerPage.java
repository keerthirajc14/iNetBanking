package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newCust;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
	WebElement custNameTxtfld;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]/input")
	WebElement genderBtn;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	WebElement dob;
	
	@FindBy(xpath="//tbody/tr[7]/td[2]/textarea")
	WebElement addressTxtbx;
	
	@FindBy(xpath="//tbody/tr[8]/td[2]/input")
	WebElement city;
	
	@FindBy(xpath="//tbody/tr[9]/td[2]/input")
	WebElement state;
	
	@FindBy(xpath="//tbody/tr[10]/td[2]/input")
	WebElement pin;
	
	@FindBy(xpath="//tbody/tr[11]/td[2]/input")
	WebElement mNumber;
	
	@FindBy(xpath="//tbody/tr[12]/td[2]/input")
	WebElement custEmail;
	
	@FindBy(xpath="//tbody/tr[13]/td[2]/input")
	WebElement pswrd;
	
	@FindBy(how = How.NAME, using="sub")
	WebElement submitBtn;
	
	
	public AddCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickNewCust() {
		newCust.click();;
	}

	public void custNameTxtfld(String cname) {
		custNameTxtfld.sendKeys(cname);
	}

	public void genderBtn(String cGender) {
		genderBtn.sendKeys("cGender");;
	}

	public void dob(String mm, String dd,String yy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
		
	}

	public void addressTxtbx(String cAddress) {
		addressTxtbx.sendKeys(cAddress);
	}

	public void city(String cCity) {
		city.sendKeys(cCity);
	}
	
	public void state(String cstate) {
		state.sendKeys(cstate);
	}
	
	public void pin(String cPin) {
		pin.sendKeys(cPin);
	}
	
	public void mNumber(String cNumber) {
		mNumber.sendKeys(cNumber);
	}
	
	public void custEmail(String cEmail) {
		custEmail.sendKeys(cEmail);
	}
	
	public void pswrd(String cPassword) {
		pswrd.sendKeys(cPassword);
	}
	
	public void submitBtn() {
		submitBtn.click();
	}
}
