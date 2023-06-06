package com.bhicmspkg.Tests;

import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.AlertHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.PurchaseItemMasterPage;
import com.bhicmspkg.Pages.PurchasePage;
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.Pages.WarehousePage;
import com.bhicmspkg.TestBase.TestBase;

public class TestClass extends TestBase{
	PurchaseItemMasterPage purchasemstr;
	 CompanyPage cmpnypge;
	 Masterpage mstr;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 UserPage userpge;
	 PurchasePage puchpge;
	 JavascriptHelper js;
	 WarehousePage whse;
	private static Logger logger=LoggerHelper.getLogger(PurchaseTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  bhilogin.clickloginbtn();
		  Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  
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
	 @Test
	 public void PurchaseOrder_Bill() throws InterruptedException
	 {
	 	mstr=new Masterpage(driver);
	 	 mstr.clicksettingsmenu();
	 	 Thread.sleep(2000);
	 	 logger.info("----------user click settings-----------");
	 	 cmpnypge=new CompanyPage(driver);
	 	 cmpnypge.clickcompany();
	 	 Thread.sleep(2000);
	 	 
	 	 logger.info("----------user click company-----------");
	 		 
	 	 String cmpnyname=cmpnypge.getlastcmpnyname();
	 	 Thread.sleep(2000);
	 	 whse=new WarehousePage(driver);
	 	 whse.clickwarehousemenu();
	 	 Thread.sleep(2000);
	 	 whse.clickwarehouseoption();
	 	 Thread.sleep(2000);
	 	 
	 	String whsename=whse.getwarehousename();
	 	Thread.sleep(2000);
	 	con=new Config(pr);
	 	whse.whassignee(con.Getcompanyusername());
	 	
	 	
	 	puchpge=new PurchasePage(driver);
	 	 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
	 	 logger.info("------click purchase Menu-----------");
	 	 puchpge.clickpurchaseorders();
	 	 Thread.sleep(2000);
	 	 logger.info("------click purchase Orders--------------------------");
	 	String editpno=Getlastcreatedpuno();
	 	Thread.sleep(2000);
	 	try
	 	{
	 	if(puchpge.Getposavedstatus().equals("Saved"))
	 	{
	 		puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
	 		 logger.info("------click purchase Menu-----------");
	 		 puchpge.clickpurchasebill();
	 		 logger.info("------click purchase Bill--------------------------");
	 		 puchpge.clickaddbill();
	 		 Thread.sleep(2000);
	 		 logger.info("-----click add bill-----------------");
	 		 puchpge.clickselcmpnybill();
	 		 logger.info("-------select company-----------");
	 		 puchpge.typevalue(cmpnyname);
	 		// puchpge.typeselcmpny(cmpnyname);
	 		 Thread.sleep(2000);
	 		 puchpge.clickpubill();
	 		 puchpge.typevalue(editpno);
	 		 Thread.sleep(2000);
	 		 String bilno="billno"+RandomStringUtils.randomNumeric(2);
	 		 puchpge.typebillno(bilno);
	 		 Thread.sleep(2000);
	 		 puchpge.clickselwarehouse();
	 		 puchpge.typevalue(whsename);
	 		 Thread.sleep(2000);
	 		 js=new JavascriptHelper(driver);
	 		 js.scrollDownByPixel();
	 		 Thread.sleep(2000);
	 		 puchpge.typequantity("1");
	 		 Thread.sleep(2000);
	 		 puchpge.clickpubillcreatebutton();
	 		 Thread.sleep(2000);
	 	}
	 	}
	 catch (Exception e) {
	 	logger.info("--------Status is not saved, so you cannot bill--------");
	 }


	 }

	 	 public String Getlastcreatedpuno()
	 		{
	 			return driver.findElement(By.xpath("//*[@id='fixtable']/tbody[1]/tr/td[2]/div")).getText();
	 		}
	 public String Getlastvendorname() throws InterruptedException
		{
			List<WebElement>vndrlst=driver.findElements(By.xpath("//table[@id='vendortable']//tbody//tr//td[2]"));
			
			Thread.sleep(2000);
			int vndrlstcnt=vndrlst.size();
			WebElement elem=driver.findElement(By.xpath("//table[@id='vendortable']/tbody//tr["+vndrlstcnt+"]//td[2]"));
			String vendorname=elem.getText();
			return vendorname;
		}
	 @AfterMethod
	 public void Logout() throws InterruptedException
	 {
	 	  LogoutPage logout=new LogoutPage(driver);
	 	  logout.clickusericon();
	 	  logout.clickLogout();
	 	  Thread.sleep(2000);
	 }
	 }
