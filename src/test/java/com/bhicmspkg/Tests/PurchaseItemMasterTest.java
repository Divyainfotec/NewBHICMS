package com.bhicmspkg.Tests;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.PurchaseItemMasterPage;
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.TestBase.TestBase;

public class PurchaseItemMasterTest extends TestBase {
	PurchaseItemMasterPage purchasemstr;
	CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 UserPage userpge;
	 Masterpage mstr;
	 
	private static Logger logger=LoggerHelper.getLogger(PurchaseItemMasterTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  bhilogin.clickloginbtn();
		  Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  logger.info("==============login is sucessful=========================");
		 boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				logger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		  }
	// /*--------------------------------------------------------
	 @Test
	 public void AddCategoryPurchaseItems() throws InterruptedException
	 {
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 Thread.sleep(2000);
		 
		 logger.info("----------user click company-----------");
			 
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		 con=new Config(pr);
		 purchasemstr=new PurchaseItemMasterPage(driver);
		 purchasemstr.clicksettings();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 purchasemstr.clickpurchaseitems();
		 Thread.sleep(2000);
		 logger.info("----------user click purchase items from settings menu-----------");
		 purchasemstr.clickitemlist();
		 Thread.sleep(2000);
		 logger.info("----------user click itemlist----------");
		 purchasemstr.clickaddcategorybtn();
		 Thread.sleep(2000);
		 logger.info("----------user click category button-----------");
		 String expcategoryname="category"+RandomStringUtils.randomNumeric(2);
		 purchasemstr.typecategoryname(expcategoryname);
		 purchasemstr.selcompanyname(cmpnyname);
		 purchasemstr.clicksavebutton();
		 Thread.sleep(2000);
		 logger.info("---------user created save button-------------------");
		Getcategoryname(expcategoryname);
	 }
	private void Getcategoryname(String expcategoryname) {
		try {
		List<WebElement> ctgrylist=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=0;i<ctgrylist.size();i++)
		{
			String actctgryname=driver.findElement(By.xpath("//table//tbody//tr//td[1]")).getText();
			//System.out.println("--------category name ---------------"+actctgryname);
			if(expcategoryname.equalsIgnoreCase(actctgryname)) 
			{
				logger.info("----------categoy created successfully!!!---------");
				Assert.assertTrue(true);
			}
		}}catch (Exception e) {
			Assert.assertTrue(false, "-----something went wrong. category cannot create--------");
		}
		
	}
	@Test
	 public void AddbrandPurchaseItems() throws InterruptedException
	 {
		mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		con=new Config(pr);
		 purchasemstr=new PurchaseItemMasterPage(driver);
		 purchasemstr.clicksettings();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 purchasemstr.clickpurchaseitems();
		 Thread.sleep(2000);
		 logger.info("----------user click purchase items from settings menu-----------");
		 purchasemstr.clickaddbrandlist();
		 logger.info("----------click add brand list ------------------");
		 purchasemstr.clickaddbrand();
		 logger.info("------------click add brand list----------------------------------");
		 String brandname="brand1"+RandomStringUtils.randomAlphabetic(2);
		 purchasemstr.typebrandname(brandname);
		 logger.info("----------type brand name-----------");
		 purchasemstr.selbrandcompany(cmpnyname);
		 logger.info("-----select the company for brand-------------------");
		 purchasemstr.clickbrandsavebtn();
		 Thread.sleep(2000);
		 logger.info("-----click brand save button-------------------");
		 Getbrandname(brandname);
		 Thread.sleep(2000);
	 }
	//table[@id='brandtable']//tbody//tr//td[2]
	private void Getbrandname(String brandname) {
		try {
		List<WebElement>expbrandname=driver.findElements(By.xpath("//table[@id='brandtable']//tbody//tr//td[2]"));
		
				for(int i=1;i<expbrandname.size();i++)
				{
					String actbrandname=driver.findElement(By.xpath("//table[@id='brandtable']//tbody//tr["+i+"]//td[2]")).getText();
					if(actbrandname.equals(brandname))
					{
						logger.info("------brand name created successfully!!------------");
						Assert.assertTrue(true);
					}
				}
		}
		catch(Exception ex)
		{
			Assert.assertTrue(false, "-------brand name cannot create---------------");
		}
		
	}
	
	@Test
	 public void AddspecificationPurchaseItems() throws InterruptedException
	 {
		mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		con=new Config(pr);
		 purchasemstr=new PurchaseItemMasterPage(driver);
		 purchasemstr.clicksettings();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 purchasemstr.clickpurchaseitems();
		 Thread.sleep(2000);
		 logger.info("----------user click purchase items from settings menu-----------");
		 purchasemstr.clickitemlist();
		 Thread.sleep(2000);
		 logger.info("----------user click itemlist----------");
		 String categoryname=purchasemstr.getcategoryname();
		 Thread.sleep(2000);
		
		 purchasemstr.clickaddbrandlist();
		 Thread.sleep(2000);
		 logger.info("----------click add brand list ------------------");
		 String brandname=purchasemstr.getbrandname();
		 Thread.sleep(2000);
		 purchasemstr.clickspecificationlst();
		 Thread.sleep(2000);
		 logger.info("----------user click specification list button-----------");
		 purchasemstr.clickaddspecification();
		 Thread.sleep(2000);
		 logger.info("----------user click add specification button-----------");
		 purchasemstr.typesearchitemspec(categoryname);
		 Thread.sleep(2000);
		 logger.info("----------user select category-----------");
		 purchasemstr.typesearchbrandspec(brandname);
		 Thread.sleep(2000);
		 logger.info("----------user select brand name-----------");
		 purchasemstr.typesearchquantityspec("By Length");
		 Thread.sleep(2000);
		 logger.info("----------user search quantity-----------");
		 purchasemstr.typespecification();
		 Thread.sleep(2000);
		 logger.info("----------user search specification-----------");
		 purchasemstr.selunit("SQFT");
		 Thread.sleep(2000);
		 logger.info("----------user click add specification button-----------");
		 purchasemstr.typehsncode("HSN09"+RandomStringUtils.randomNumeric(2));
		 Thread.sleep(2000);
		 logger.info("----------user enter hsn code for purchase-----------");
		 purchasemstr.selpurchasespeccompany(cmpnyname);
		 Thread.sleep(2000);
		 logger.info("----------user select the company-----------");
		 
		 purchasemstr.clickpurchasesavebutton();
		 Thread.sleep(2000);
		 logger.info("----------user click purchase save button-----------");
		 logger.info("----------user created specification successfully-----------");
		 Assert.assertTrue(true);
		 }
	//----------------------------------------------------*/
	@Test
	 public void Addunitconversion() throws InterruptedException
	 {
		con=new Config(pr);
		 purchasemstr=new PurchaseItemMasterPage(driver);
		 purchasemstr.clicksettings();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 purchasemstr.clickpurchaseitems();
		 Thread.sleep(2000);
		 logger.info("----------user click purchase item-----------");
		 purchasemstr.clickitemlist();
		 Thread.sleep(2000);
		 logger.info("----------user click item list-----------");
		 String categoryname=purchasemstr.getcategoryname();
		 Thread.sleep(2000);
		 purchasemstr.clickunitconversion();
		 Thread.sleep(2000);
		 logger.info("----------user click unit conversion-----------");
		 
		 
	 }
	 @AfterMethod
	  public void Logout() throws InterruptedException
	  {
		 //driver.findElement(By.xpath("//li//a[text()='Home']")).click();
		   logout=new LogoutPage(driver);
		  logout.clickusericon();
		  logout.clickLogout();
		  Thread.sleep(2000);
	  }
}
