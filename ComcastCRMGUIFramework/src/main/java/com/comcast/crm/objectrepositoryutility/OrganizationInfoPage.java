package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(className="dvHeaderText")
    private WebElement headerMsg;
    
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
    
    @FindBy(id="dtlview_Phone")
    private WebElement phoneNumberInfo;
    
	public WebElement getPhoneNumberInfo() {
		return phoneNumberInfo;
	}
    
    @FindBy(id="dtlview_Industry")
    private WebElement industryInfo;
    
    @FindBy(id="dtlview_Type")
    private WebElement typeInfo;
    
	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}
    
    
    
    
}
     
