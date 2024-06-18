package practice.test;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;

 
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest() { 
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		String expectedTitle="login";
		Assert.assertEquals(actTitle,expectedTitle);
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4"); 
	}
	
@Test
public void createInvoicewithOrganizationTest() {
	System.out.println("execute createInvoicewithOrganizationTest");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}

}
