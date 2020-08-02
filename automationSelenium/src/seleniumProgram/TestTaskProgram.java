package seleniumProgram;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTaskProgram {
	
	 Pages page;

	@BeforeClass
	public void testBeforeClass() throws Exception 
	{
		
		page = new Pages(); //lounch browser
		
		page.navigateUrl();//navigate to URL
	}
	@Test
	public void productTest() throws Exception 
	{

		page.login("admin@example.com", "password");//login with credential

		page.createProduct();//add new product 
		page.updateProduct();//update or edit Product
		page.deleteProduct();//delete product

		page.logout();  //logout Application

	}
	@AfterClass
	public void testAfterClass() throws Exception 
	{

		page.closeBrowser();  //close the browser

	}
}
