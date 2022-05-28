package com.training.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.salesforce.pages.homepages.HomePage;
import com.salesforce.pages.loginpages.ForgotPassword;
import com.salesforce.pages.loginpages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	ForgotPassword forgotpassword;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
	
	@Given("user go to url {string}")
	public void user_go_to_url(String url) {
	  driver.get(url);
	}

	@When("user on {string}")
	public void user_on(String page) {
		if(page.equalsIgnoreCase("loginpage"))
			login= new LoginPage(driver);
		else if(page.equalsIgnoreCase("homepage"))
			home=new HomePage(driver);
		else if(page.equalsIgnoreCase("forgotpassword"))
			forgotpassword=new ForgotPassword(driver);
	}

	@When("user enters {string} in username field")
	public void user_enters_in_username_field(String username) {
	   login.enterUserName(username);
	}

	@When("user clears password in password field")
	public void user_clears_password_in_password_field() {
		login.enterPassword("");
	 
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		login.clickLogin();
	 
	}

	@Then("validate error msg is displayed as {string}")
	public void validate_error_msg_is_displayed_as(String errorMsg) {
	   String actualMsg=login.getErrorMsg();
	   Assert.assertEquals(actualMsg, errorMsg);
	}
	
	@When("user enters {string}  in password field")
	public void user_enters_in_password_field(String password) {
		login.enterPassword(password);
	}

	@Then("validate page title should be {string}")
	public void validate_page_title_should_be(String expectedTitle) throws InterruptedException {
			Thread.sleep(5000);
			String actualTitle=home.getactualTitleHomePage();
			Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@When("user clicks on Remember me checkbox")
	public void user_clicks_on_remember_me_checkbox() {
		login.selectChkBox();
	}

	@Then("click on user menu drop down")
	public void click_on_user_menu_drop_down() {
		home.clickUserMenu();
	}

	
	@Then("user selects Logout link")
	public void user_selects_logout_link() {
		home.selectLogoutLink();
	}
	
	@Then("validate username should be {string}")
	public void validate_username_should_be(String expectedUserName) {
		 String actualUserName= login.getUserName();
		 Assert.assertEquals(actualUserName, expectedUserName);
	}
	
	
	@When("user clicks on Forgot Password")
	public void user_clicks_on_forgot_password() {
		login.clickForgotPassword();
	}

	@Then("verify page title as {string}")
	public void verify_page_title_as(String expectedTitle) throws InterruptedException {
		Thread.sleep(5000);
	   String actual= driver.getTitle();
	   Assert.assertEquals(actual, expectedTitle);
	}
	@Then("user click on continue button and message displayed is {string}")
	public void user_click_on_continue_button_and_message_displayed_is(String expectedMsg) {
		String actualMsg=forgotpassword.clickContinueButton();
		Assert.assertEquals(actualMsg, expectedMsg);
	}


	@Then("user enters {string} in username")
	public void user_enters_in_username(String username) {
	    forgotpassword.enterUsername(username);
	}

	@Then("validate error msg displayed as {string};")
	public void validate_error_msg_displayed_as(String expectedMsg) {
	   String actual= login.getErrorMsg();
	   Assert.assertEquals(actual, expectedMsg);
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
