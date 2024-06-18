 package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{ //Rule 1: create a seperate java class
	
	WebDriver driver;                     //Rule 2:Object Creation
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
      @FindBy(name="user_name")
      private WebElement usernameEdt;
      
      @FindBy(name="user_password")
      private WebElement passwordEdt;
      
      @FindBy(id="SubmitButton")
      private WebElement loginBtn;
      //Rule3:Object Initialization
      //Rule 4:Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
    //Rule5:we can provide Action
	public void loginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
      
}
