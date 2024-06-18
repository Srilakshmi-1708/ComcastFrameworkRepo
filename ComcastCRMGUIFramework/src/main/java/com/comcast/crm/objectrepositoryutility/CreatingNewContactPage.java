package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdt;
	
	@FindBy(name="support_end_date")
	private WebElement endDateEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement createContactWithOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchtxtfld;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchtxtfld() {
		return searchtxtfld;
	}

	public void setSearchtxtfld(WebElement searchtxtfld) {
		this.searchtxtfld = searchtxtfld;
	}

	public WebElement getCreateContactWithOrgBtn() {
		return createContactWithOrgBtn;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebDriver getDriver() {
		return driver;
		}
	
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContact(String lastname) {
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void createContactWithOrg(String lastname) {
		lastnameEdt.sendKeys(lastname);
		}
	
	public void searchOrg(String orgName) {
		searchtxtfld.sendKeys(orgName);
	}
	
	//public void searchBtn() {
		//searchBtn.click();
	//}
	
	public void createContactWithSupportDate(String lastname,String startDate,String endDate) throws InterruptedException {
		lastnameEdt.sendKeys(lastname);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		System.out.println(startDate);
		
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		System.out.println(endDate);
		
		saveBtn.click();
	}
	
	
	
}


