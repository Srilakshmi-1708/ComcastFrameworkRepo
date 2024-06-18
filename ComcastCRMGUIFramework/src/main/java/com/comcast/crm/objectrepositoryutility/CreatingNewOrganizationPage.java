package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreatingNewOrganizationPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
 
    //with industry type
    @FindBy(name="industry")
	private WebElement industryDD;
    
    //with type DD
    @FindBy(name="accounttype")
    private WebElement typeDD;

	//with phone number
    @FindBy(name="phone")
    private WebElement phoneNumEdt;
    
    public WebDriver getDriver() {
		return driver;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}
	
	public WebElement getPhoneNumEdt() {
		return phoneNumEdt;
	}

	public WebElement getOrgNameEdt() {
	return orgNameEdt;
}

    public WebElement getSaveBtn() {
	return saveBtn;
    }
    
public void createOrg(String orgName) {
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();
}

public void createOrg(String orgName,String industry,String type) {    //creating org by selecting industry & type
	orgNameEdt.sendKeys(orgName);
	Select sel=new Select(industryDD);
	sel.selectByValue(industry);
	Select sel1=new Select(typeDD);
	sel1.selectByValue(type);
	saveBtn.click();
}
 
public void createorg(String orgName,String PhoneNumber) {  //creating org by entering phone number
	orgNameEdt.sendKeys(orgName);
	phoneNumEdt.sendKeys(PhoneNumber);
	saveBtn.click();
}
}
