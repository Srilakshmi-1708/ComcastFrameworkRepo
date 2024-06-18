package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable {

		//read test script data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();

		//Step 2:navigate to organization module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hp=new HomePage(driver);
		hp.getOrglnk().click();

		//clicking on + button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgbtn().click();

		//Enter all details & create a new organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO,orgName+ "===>Create a new Org");

		//verify Header msg Expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify header message");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		UtilityClassObject.getTest().log(Status.PASS, "verified the orgName");
	}

	@Test(groups="regressionTest")
	public void createOrgWithIndTest() throws Throwable{

		//test script from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName=eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
		String industry=eLib.getDataFromExcel("org", 4, 3);
		String type=eLib.getDataFromExcel("org", 4, 4) ;

		//Step 2:navigate to organization module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hp=new HomePage(driver);
		hp.getOrglnk().click();

		//clicking on + button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgbtn().click();

		//create organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry,type);

		//verify Header msg Expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify header message");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		UtilityClassObject.getTest().log(Status.PASS, "verified the orgName");

		UtilityClassObject.getTest().log(Status.INFO,"verify industry");
		String actIndustry=oip.getIndustryInfo().getText();
		Assert.assertEquals(true, actIndustry.contains(industry));
		UtilityClassObject.getTest().log(Status.PASS, "====>verified the industry");

		UtilityClassObject.getTest().log(Status.INFO,"verify type");
		String actType=oip.getTypeInfo().getText();
		Assert.assertEquals(true, actType.contains(type));
		UtilityClassObject.getTest().log(Status.PASS, "====>verified the type");
	}

	@Test(groups="regressionTest")
	public void createOrgWithPhoneNumberTest() throws Throwable{

		//test script from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName=eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
		String PhoneNumber=eLib.getDataFromExcel("org", 7, 3);

		//Step 2:navigate to organization module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hp=new HomePage(driver);
		hp.getOrglnk().click();

		//clicking on + button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgbtn().click();

		//create organization
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createorg(orgName, PhoneNumber);

		//verify Header phone number info Expected Result
		UtilityClassObject.getTest().log(Status.INFO, "verify header message");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		UtilityClassObject.getTest().log(Status.PASS, "verified the orgName");

		UtilityClassObject.getTest().log(Status.INFO, "verify the phonenumber");
		String actPhoneNumber=oip.getPhoneNumberInfo().getText();
		Assert.assertEquals(actPhoneNumber, PhoneNumber);
		UtilityClassObject.getTest().log(Status.PASS, "====>verified the phonenumber");
      }

}






















