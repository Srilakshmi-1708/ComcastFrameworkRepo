package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductImgBtn;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getCreateProductImgBtn() {
		return createProductImgBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	
}
