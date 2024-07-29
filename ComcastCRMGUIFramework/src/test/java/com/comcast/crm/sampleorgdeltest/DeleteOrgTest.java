package com.comcast.crm.sampleorgdeltest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {
		 
		FileUtility fLib=new FileUtility(); 
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
		
	      //test script from Excel file
		String orgName=eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
	
	     WebDriver driver=null;
	        
	     if(BROWSER.equals("chrome")) { 
	    	 driver=new ChromeDriver();
	     }
	     else if(BROWSER.equals("firefox")) {
	    	 driver=new FirefoxDriver();
	     }
	     else if(BROWSER.equals("edge")) {
	    	 driver=new EdgeDriver();
	     }
	     else {
	    	 driver=new ChromeDriver();
	     }
	     //step 1: login to app
	     wLib.waitForPageToLoad(driver);
	     driver.get(URL);
	    
	    
	    LoginPage lp=new LoginPage(driver);
	     
	     lp.loginToApp(URL,USERNAME,PASSWORD);
	    	
	    //Step 2:navigate to organization module 
	    HomePage hp=new HomePage(driver);
	    hp.getOrglnk().click();
			 
		OrganizationsPage op=new OrganizationsPage(driver);
	    op.getCreateNewOrgbtn().click();
	
	       CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName);
			
			
		
			//verify Header msg Expected result
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String actOrgName=oip.getHeaderMsg().getText();
			if(actOrgName.contains(orgName)) {
				System.out.println(orgName + ":name is verified ====> PASS");
			}
			else{
				System.out.println(orgName + ":name is not verified ====> FAIL");
			}
			
			//go back to organizations page
			
		    hp.getOrglnk().click();
		  //search for organization
		    op.getSearchEdt().sendKeys(orgName);
		    wLib.select(op.getSearchDD(), "Organization_Name");
		    op.getSearchBtn().click();
		    
		   // in dynamic webtable select & delete org
		    driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		
		    hp.logout();
			
			driver.quit();
			
			}
	
}




