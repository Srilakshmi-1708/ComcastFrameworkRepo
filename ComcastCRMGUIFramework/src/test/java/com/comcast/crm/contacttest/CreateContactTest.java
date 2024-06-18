package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable{

		//github
		//read testScript from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String lastname=eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		//Step 2:navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact Page");
		HomePage hp=new HomePage(driver);
		hp.getContlnk().click(); 

		//clicking on + button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Contact Page");
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewCntctbtn().click();

		//Enter all details & create a new contact
		UtilityClassObject.getTest().log(Status.INFO, "create a new Contact");
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);

		cncp.createContact(lastname);
		UtilityClassObject.getTest().log(Status.INFO,lastname+ "===>Create a new Contact");

		//verify Header contact info Expected Result
		UtilityClassObject.getTest().log(Status.INFO, "verify header");
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actHeader=cip.getHeaderMsg().getText();
		Assert.assertEquals(true, actHeader.contains(lastname));
		UtilityClassObject.getTest().log(Status.PASS, "verified header");

		UtilityClassObject.getTest().log(Status.INFO, "verify the lastname");  
		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName,lastname);
		UtilityClassObject.getTest().log(Status.PASS, "verified the lastname");
	}

	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws Throwable{

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String lastname=eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		//Step 2:navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact Page");
		HomePage hp=new HomePage(driver);
		hp.getContlnk().click();

		//clicking on + button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Contact Page");
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewCntctbtn().click();

		String startDate=jLib.getSystemDateYYYYDDMM();
		String endDate=jLib.getRequiredDateYYYYDDMM(30);

		UtilityClassObject.getTest().log(Status.INFO, "create a new Contact");
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createContactWithSupportDate(lastname, startDate, endDate);

		//verify header info expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify header");
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actHeader=cip.getHeaderMsg().getText();
		Assert.assertEquals(true, actHeader.contains(lastname));
		UtilityClassObject.getTest().log(Status.PASS, "verified header");

		UtilityClassObject.getTest().log(Status.INFO, "verify startDate");
		String actStartDate=cip.getStartDateEdt().getText();
		Assert.assertEquals(true, actStartDate.contains(startDate));
		UtilityClassObject.getTest().log(Status.PASS, "verified startDate");

		UtilityClassObject.getTest().log(Status.INFO, "verify endDate");
		String actEndDate=cip.getEndDateEdt().getText();
		Assert.assertEquals(true, actEndDate.contains(endDate));
		UtilityClassObject.getTest().log(Status.PASS, "verified endDate");

	}

	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		//test script from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName=eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNumber();
		String contactLastName=eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber() ;

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact Page");
		HomePage hp=new HomePage(driver);
		hp.getOrglnk().click();

		//clicking on + button	
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgbtn().click();

		//create organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		//verify Header message Expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify the orgName");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		UtilityClassObject.getTest().log(Status.PASS, "verified the orgName");

		//navigate to Contact Module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact module");
		hp.getContlnk().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewCntctbtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create contact with Org");
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createContactWithOrg(contactLastName);
		System.out.println(contactLastName);

		cncp.getCreateContactWithOrgBtn().click();

		//switch to child window
		UtilityClassObject.getTest().log(Status.INFO,"switch to child window");
		wLib.switchToTabOnUrl(driver, "module=Accounts");       

		cncp.searchOrg(orgName);
		cncp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();

		//switch to parent window
		UtilityClassObject.getTest().log(Status.INFO,"switch back to parent window");
		wLib.switchToTabOnUrl(driver, "contacts&action");   

		UtilityClassObject.getTest().log(Status.INFO,"click on save button");
		cncp.getSaveBtn().click();

		//verify Header contactLastName info ExpectedResult
		UtilityClassObject.getTest().log(Status.INFO, "verify header message with contactLastName");
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerInfo=cip.getHeaderInfo().getText();
		Assert.assertEquals(true, headerInfo.contains(contactLastName));
		UtilityClassObject.getTest().log(Status.PASS, "verified header message with contactLastName");

		//verify Header orgName info Expected Result
		UtilityClassObject.getTest().log(Status.INFO, "verify last header message");
		String lastheaderInfo=cip.getActOrgNameEdt().getText();
		Assert.assertEquals(true,lastheaderInfo.contains(orgName));
		UtilityClassObject.getTest().log(Status.PASS, "verified last header message");

	}
}


