package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.firebase.base.BasePage;

public class ForgotPassword extends BasePage {

	WebDriver driver;
	
	@FindBy(id="un")WebElement userName;
	@FindBy(id="continue")WebElement continueButton;
	@FindBy(xpath="//div[@class='message']//p[contains(text(),'you an email')]") WebElement infoMsg;
			
//	@FindBy(xpath="//p[contains(text(),'We’ve sent you an email with a link to')]")WebElement infoMsg;

	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String username) {
		enterText(userName, username, "User Name");
	}
	
	public String clickContinueButton() throws InterruptedException {
		clickElement(continueButton, "Continue Button");
		Thread.sleep(5000);
		waitUntilVisible(infoMsg, "Message");
		Thread.sleep(5000);
		String msg= readText(infoMsg, "Message");
		return msg;
		
	}
}
