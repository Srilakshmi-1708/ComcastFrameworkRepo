package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateEdt;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateEdt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actOrgNameEdt;
	
	
	
	public WebElement getActOrgNameEdt() {
		return actOrgNameEdt;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	
	
	
}










