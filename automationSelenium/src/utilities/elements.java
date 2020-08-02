package utilities;

import org.openqa.selenium.By;

public class elements
{

	 public By loginIdTextBox= By.xpath("//input[@id='admin_user_email']");
	 public By passTextBox= By.xpath("//input[@id='admin_user_password']");
	 public By loginbtn= By.xpath("//li[@id='admin_user_submit_action']");
	 public By signedSuccessText= By.xpath("//div[contains(text(),'Signed in successfully.')]");

	 public By clickOnProduct= By.linkText("Products");
	 public By clickNewProduct= By.linkText("New Product");
	 public By productTitle= By.xpath("//input[@id='product_title']");
	 
	 public By productSku= By.xpath("//input[@id='product_sku']");
	 public By productDescription= By.xpath("//input[@id='product_description']");
     public By clickCreateProductBtn=By.xpath("//li[@id='product_submit_action']");
     public By productStatusText=By.xpath("//div[@class='flash flash_notice']");
     public By productErrorText=By.xpath("//p[@class='inline-errors']");
     public By productTable=By.xpath("//table[@id='index_table_products']//tr");
     public By view=By.xpath("//tr[1]//td[8]//a[contains(text(),'Edit')]");
     public By clickUpdateProductBtn=By.xpath("//li[@id='product_submit_action']");

      
   
     
     public By clickOnEditProduct=By.linkText("Edit Product");

     public By logoutLink=By.linkText("Logout");
    

     
     
   
}
