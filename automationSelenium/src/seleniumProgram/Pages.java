package seleniumProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BasePath;
import utilities.elements;

public class Pages {

	WebDriver driver;
	elements ele = new elements();
	WebDriverWait wait;
	String productTitle="";
	String productSku="";
	String productDes="";
	String remark="";
	String existingTitle="";

	/**
	 * open chrome browser
	 * */ 
	public Pages() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", BasePath.browserDriver);
			driver = new ChromeDriver();
		} catch (Exception e) {
			throw new Exception("Unable to open Chrome :" + e.getMessage());

		}
	}

	/**
	 * navigate to URL application
	 * */ 
	public void navigateUrl() throws Exception {
		try {

			driver.get(BasePath.url);
			driver.manage().window().maximize();

			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(ele.loginIdTextBox));

		} catch (Exception e) {
			throw new Exception("Unable to open URL :" + e.getMessage());

		}

	}

	/**
	 * login application with credential
	 * */ 
	public void login(String loginId, String pass) throws Exception {
		try {
			driver.findElement(ele.loginIdTextBox).clear();
			driver.findElement(ele.loginIdTextBox).sendKeys(loginId);

			driver.findElement(ele.passTextBox).clear();
			driver.findElement(ele.passTextBox).sendKeys(pass);

			driver.findElement(ele.loginbtn).click();

			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(ele.signedSuccessText));
		} catch (Exception e) {
			throw new Exception("Unable to Login :" + e.getMessage());

		}

	}

	/**
	 * get data from  productcreate sheet and add new product with validation in application
	 * */ 	
	public void createProduct() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			File file = new File("D:\\share\\ProductDetails.xlsx");
			FileInputStream fis = new FileInputStream(file);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet("CreateProduct");

			int totalRow = sheet.getLastRowNum();
			System.out.println("Total Number of Rows : "+totalRow);
			sheet.getRow(0).createCell(3).setCellValue("Remark");


			for (int i = 1; i <= totalRow; i++) 
			{
				driver.findElement(ele.clickOnProduct).click();

				Row row =sheet.getRow(i);
				DataFormatter formatter = new DataFormatter();  
				productTitle = formatter.formatCellValue(row.getCell(0));
				productSku = formatter.formatCellValue(row.getCell(1));
				productDes = formatter.formatCellValue(row.getCell(2));
				System.out.println(productTitle+"----"+productSku+"----"+productDes);


				int len = productTitle.length();
				ArrayList<String> list = new ArrayList<String>();
				if (productTitle.isEmpty()) {
					list.add("Title");
				}
				if (productSku.isEmpty()) {
					list.add("Sku");
				}
				if (productDes.isEmpty()) {
					list.add("Description");
				}
				if (!list.isEmpty()) {
					remark = list.toString() + " - is Empty";
					System.out.println("Remark :" + remark);
					sheet.getRow(i).createCell(3).setCellValue(remark);
					continue;
				}
				if (productTitle.length() > 40) 
				{
					System.out.println("Title lenght is greather than 40");
					remark = "Title length is Greater than 40";
					sheet.getRow(i).createCell(3).setCellValue(remark);
					continue;
				}
				if (productSku.length() > 10) 
				{
					System.out.println("Sku lenght is greather than 10");
					remark = "Sku length is Greater than 10";
					sheet.getRow(i).createCell(3).setCellValue(remark);
					continue;
				}

				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(ele.clickNewProduct));

				driver.findElement(ele.clickNewProduct).click();

				driver.findElement(ele.productTitle).clear();
				driver.findElement(ele.productTitle).sendKeys(productTitle);

				driver.findElement(ele.productSku).clear();
				driver.findElement(ele.productSku).sendKeys(productSku);

				driver.findElement(ele.productDescription).clear();
				driver.findElement(ele.productDescription).sendKeys(productDes);

				driver.findElement(ele.clickCreateProductBtn).click();
				// check unique product name and Sku
				try {

					String productText = driver.findElement(ele.productErrorText).getText();
					System.out.println(productText);
					// click Cancel
					driver.findElement(By.linkText("Cancel")).click();
					sheet.getRow(i).createCell(3).setCellValue(productText);
					continue;
				} catch (Exception e) {
					System.out.println("No Error...");

				}
				String productText = driver.findElement(ele.productStatusText).getText();
				System.out.println(productText);
				sheet.getRow(i).createCell(3).setCellValue(productText);

			}			
			fis.close();
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();

		} catch (Exception e) {
			this.takeScreenShot("Create_product");
			throw new Exception("Unable to Create Product:" + e.getMessage());

		}

	}
	/**
	 * get data from  productupdate sheet and update data with validation in application
	 * */ 	public void updateProduct() throws Exception {
		 try 
		 {


			 File file = new File("D:\\share\\ProductDetails.xlsx");
			 FileInputStream fis = new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 XSSFSheet sheet = workbook.getSheet("UpdateProduct");
			 int totalRow = sheet.getLastRowNum();
			 System.out.println("Total Number of Rows : "+totalRow);
			 sheet.getRow(0).createCell(6).setCellValue("Remark");


			 for (int i = 1; i <= totalRow; i++) 
			 {
				 driver.findElement(ele.clickOnProduct).click();

				 Row row =sheet.getRow(i);
				 DataFormatter formatter = new DataFormatter();
				 existingTitle = formatter.formatCellValue(row.getCell(0));

				 productTitle = formatter.formatCellValue(row.getCell(3));
				 productSku = formatter.formatCellValue(row.getCell(4));
				 productDes = formatter.formatCellValue(row.getCell(5));


				 int len = productTitle.length();
				 ArrayList<String> list = new ArrayList<String>();
				 if (productTitle.isEmpty()) {
					 list.add("Title");
				 }
				 if (productSku.isEmpty()) {
					 list.add("Sku");
				 }
				 if (productDes.isEmpty()) {
					 list.add("Description");
				 }
				 if (!list.isEmpty()) {
					 remark = list.toString() + " - is Empty";
					 System.out.println("Remark :" + remark);
					 sheet.getRow(i).createCell(6).setCellValue(remark);
					 continue;
				 }
				 if (productTitle.length() > 40) 
				 {
					 System.out.println("Title lenght is greather than 40");
					 remark = "Title length is Greater than 40";
					 sheet.getRow(i).createCell(6).setCellValue(remark);
					 continue;
				 }
				 if (productSku.length() > 10) 
				 {
					 System.out.println("Sku lenght is greather than 10");
					 remark = "Sku length is Greater than 10";
					 sheet.getRow(i).createCell(6).setCellValue(remark);
					 continue;
				 }
				 try {
					 driver.findElement(By.xpath("//td[contains(text(),'"+existingTitle+"')]/following::td/div/a[contains(text(),'Edit')]")).click();
				 }catch(Exception e) {
					 sheet.getRow(i).createCell(6).setCellValue("Product not exists");
					 continue;
				 }

				 driver.findElement(ele.productTitle).clear();
				 driver.findElement(ele.productTitle).sendKeys(productTitle);

				 driver.findElement(ele.productSku).clear();
				 driver.findElement(ele.productSku).sendKeys(productSku);

				 driver.findElement(ele.productDescription).clear();
				 driver.findElement(ele.productDescription).sendKeys(productDes);

				 driver.findElement(ele.clickUpdateProductBtn).click();
				 // check unique product name and Sku
				 try {

					 String productText = driver.findElement(ele.productErrorText).getText();
					 System.out.println(productText);
					 // click Cancel
					 driver.findElement(By.linkText("Cancel")).click();
					 sheet.getRow(i).createCell(6).setCellValue(productText);
					 continue;
				 } catch (Exception e) {
					 System.out.println("No Error...");

				 }
				 String productText = driver.findElement(ele.productStatusText).getText();
				 System.out.println(productText);
				 sheet.getRow(i).createCell(6).setCellValue(productText);

			 }			
			 fis.close();
			 FileOutputStream outputStream = new FileOutputStream(file);
			 workbook.write(outputStream);
			 outputStream.close();
			 workbook.close();


		 } catch (Exception e) {
			 this.takeScreenShot("Update_product");
			 throw new Exception("Unable to Update Product:" + e.getMessage());

		 }

	 }
	 /**
	  *  get data from  productdelete sheet and delete this data from application
	  * */ 	
	 public void deleteProduct() throws Exception {
		 try {


			 File file = new File("D:\\share\\ProductDetails.xlsx");
			 FileInputStream fis = new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 XSSFSheet sheet = workbook.getSheet("DeleteProduct");
			 int totalRow = sheet.getLastRowNum();
			 System.out.println("Total Number of Rows : "+totalRow);
			 sheet.getRow(0).createCell(1).setCellValue("Remark");


			 for (int i = 1; i <= totalRow; i++) 
			 {
				 driver.findElement(ele.clickOnProduct).click();
				 Row row =sheet.getRow(i);


				 DataFormatter formatter = new DataFormatter();
				 productTitle = formatter.formatCellValue(row.getCell(0));
				 // productTitle=row.getCell(0).toString();
				 System.out.println(productTitle);



				 try {
					 driver.findElement(By.xpath("//td[contains(text(),'"+productTitle+"')]/following::td/div/a[contains(text(),'Delete')]")).click();

					 driver.switchTo().alert().accept();

					 String productText = driver.findElement(ele.productStatusText).getText();
					 System.out.println(productText);
					 sheet.getRow(i).createCell(1).setCellValue(productText);


				 } catch (Exception e) {
					 sheet.getRow(i).createCell(1).setCellValue("Product not exists");
					 System.out.println("No alert");
				 }
			 }
			 fis.close();
			 FileOutputStream outputStream = new FileOutputStream(file);
			 workbook.write(outputStream);
			 outputStream.close();
			 workbook.close();
		 } catch (Exception e) {
			 this.takeScreenShot("Delete_Product");

			 throw new Exception("Unable to Update Product:" + e.getMessage());

		 }

	 }
	 /**
	  * logout the application with current user
	  * */ 
	 public void logout() throws Exception {
		 try {
			 driver.findElement(ele.logoutLink).click();
		 } catch (Exception e) {
			 this.takeScreenShot("Logout");
			 throw new Exception("Unable to Logout:" + e.getMessage());

		 }
	 }
	 /**
	  * takeScreenShot pass screenshot name which is used to take screen shot
	  * */ 
	 public void takeScreenShot(String screenShotName) throws Exception {
		 try {

			 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			 File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(srcFile, new File(BasePath.screenshotPath + screenShotName + ".png"));
			 System.out.println("the Screenshot is taken");

		 } catch (Exception e) {
			 System.out.println("Unable to take screenshot:" + e.getMessage());
		 }
	 }
	 /**
	  * close the current Browser session
	  * */ 
	 public void closeBrowser() throws Exception {
		 try {
			 driver.close();
		 } catch (Exception e) {
			 throw new Exception("Unable to Close Browser:" + e.getMessage());

		 }
	 }
}
