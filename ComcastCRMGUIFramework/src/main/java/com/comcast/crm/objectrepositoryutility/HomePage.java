package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(linkText="Organizations")
   private WebElement orglnk;
   
   @FindBy(linkText="Contacts")
   private WebElement contlnk;
   
   @FindBy(linkText="Products")
   private WebElement productlnk;
   
   public WebElement getProductlnk() {
	return productlnk;
}

@FindBy(linkText="Campaigns")
   private WebElement camplnk;
   
   @FindBy(linkText="More")
   private WebElement morelnk;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminImg;
   
   @FindBy(linkText="Sign Out")
   private WebElement SignOutlnk;
       
    public WebElement getOrglnk() {
	return orglnk;
}

    public WebElement getContlnk() {
	return contlnk;
}
   
  
	public WebElement getCamplnk() {
		return camplnk;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

public void navigateToCampaignPage() {
	   Actions act=new Actions(driver);
		act.moveToElement(morelnk).perform();	   
	   camplnk.click();
   }
   
   public void logout() {
	   Actions act=new Actions(driver);
	   act.moveToElement(adminImg).perform();
	   SignOutlnk.click();
   }
   
   
}



