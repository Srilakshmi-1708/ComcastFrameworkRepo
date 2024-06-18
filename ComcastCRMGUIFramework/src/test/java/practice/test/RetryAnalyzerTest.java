package practice.test;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import junit.framework.Assert;

 
public class RetryAnalyzerTest {
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() { 
		System.out.println("execute createInvoiceTest");
		String expectedTitle="login";
		Assert.assertEquals("",expectedTitle);
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4"); 
	}
	


}
