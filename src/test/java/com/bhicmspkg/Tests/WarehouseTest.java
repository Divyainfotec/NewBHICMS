package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.LocalDate;
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
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.Pages.PurchaseItemMasterPage;
import com.bhicmspkg.Pages.PurchasePage;
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.Pages.VendorPage;
import com.bhicmspkg.Pages.WarehousePage;
import com.bhicmspkg.TestBase.TestBase;

public class WarehouseTest extends TestBase{
	PurchaseItemMasterPage purchasemstr;
	 CompanyPage cmpnypge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 JavascriptHelper js;
	 GenericHelper gh;
	 WarehousePage whse;
	 PurchasePage puchpge;
	 
	 Masterpage mstr;
	private static Logger logger=LoggerHelper.getLogger(WarehouseTest.class);
	
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
 /*--------------------------------------------------------
	 @Test
	 public void Addwarehouse() throws InterruptedException, AWTException
	 {
		 LocalDate Today_date=java.time.LocalDate.now();	
		 WarehousePage wh=new WarehousePage(driver);
		 wh.clickwarehousemenu();
		 Thread.sleep(2000);
		 wh.clickwarehouseoption();
		 Thread.sleep(2000);
		 wh.clickaddwarehouse();
		 Thread.sleep(2000);
		 String whnme="BHI warehouse"+RandomStringUtils.randomAlphabetic(2)+Today_date;
		 wh.typewarehousename(whnme);
		 String whplace="whplace"+RandomStringUtils.randomAlphabetic(2);
		 wh.typewarehouseplace(whplace);
		 con=new Config(pr);
		 wh.selwarehouseinchrge(con.Getcompanyusername());
		 selassgnto();
		 Thread.sleep(2000);
		 wh.typewhaddr();
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 wh.clickcrestebtn();
		 Thread.sleep(2000);
		 String newwh=Getnewwarehouse();
		 if(newwh.equals(whnme))
		 {
			 logger.info("-------new warehouse created successfully!!!------");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.info("---------warehouse could not created---------------");
			 Assert.assertTrue(false, "something went wrong, warehouse created failed");
		 }
		 
	 }
	 -------------*/
	 /*------------------ 
	 public void AddwarehouseReceipt() throws InterruptedException, AWTException
	 {
		 puchpge=new PurchasePage(driver);
			puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
			 logger.info("------click purchase Menu-----------");
			 puchpge.clickpurchasebill();
			 logger.info("------click purchase Bill--------------------------");
		String pubillno=puchpge.Getpubillno();
		 WarehousePage wh=new WarehousePage(driver);
		 wh.clickwarehousemenu();
		 Thread.sleep(2000);
		 wh.clickwarehouseoption();
		 LocalDate Today_date=java.time.LocalDate.now();	
		// WarehousePage wh=new WarehousePage(driver);
		 wh.clickwarehousemenu();
		 Thread.sleep(2000);
		 String newwh=Getnewwarehouse();
		 wh.clickwhreceipt();
		 Thread.sleep(2000);
		 wh.clickaddreceipt();
		 Thread.sleep(2000);
		 wh.clickselwh();
		 
		 wh.typwhname(newwh);
		 Thread.sleep(2000);
		 wh.clickreceiptclrk();
		 con=new Config(pr);
		 wh.typclrkname(con.Getcompanyusername());
		 String receiptno="R_"+RandomStringUtils.randomNumeric(3);
		 wh.typereceiptno(receiptno);
		 Thread.sleep(2000);
		 wh.clicktransfertype();
		 Thread.sleep(2000);
		 wh.typetransfertype("Purchase Bill");
		 Thread.sleep(2000);
		 wh.clickpubill();
		 //String pubillno="pubill"+RandomStringUtils.randomNumeric(3);
		 wh.typepubill(pubillno);
		 wh.typermks("Wharehouse receipt created!!!");
		 Thread.sleep(2000);
		 wh.typewhquantity("1");
	 }
	/*
	 @Test
	 public void PurchaseOrderCreation() throws InterruptedException, AWTException
	 {
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmpnypge.getlastcmpnyname();
		 Thread.sleep(2000);
		 System.out.println("company name "+cmpnyname);
		 Thread.sleep(2000);
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 pjtpge.clickeditpjtname();
		 Thread.sleep(2000);
		 pjtpge.clickcompany(cmpnyname);
		 Thread.sleep(2000);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 pjtpge.clicksavepjtbtn();
		 Thread.sleep(2000);
		 VendorPage vendpge=new VendorPage(driver);
			vendpge.clickvendorsmenu();
			vendpge.clickvendorslist();
			Thread.sleep(2000);
			 String vendorname=Getlastvendorname();
			 Thread.sleep(2000);
		 puchpge=new PurchasePage(driver);
		 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		 logger.info("------click purchase Menu-----------");
		 puchpge.clickpurchaseorders();
		 logger.info("------click purchase Orders--------------------------");
		 puchpge.clickaddPoByQuantity();
		 logger.info("------user click addPO By Quantity-------------------------");
		 puchpge.selpurcompany();
		 Thread.sleep(2000);
		 logger.info("------user select the company--------------------------");
		 puchpge.typevalue(cmpnyname);
		 Thread.sleep(2000);
		 puchpge.selpurproject();
		 Thread.sleep(2000);
		 puchpge.typevalue(pjtnme);
		 Thread.sleep(2000);
		 logger.info("------user select the project--------------------------");
		 puchpge.selpurchexpehead();
		 Thread.sleep(2000);
		 String expensehead=driver.findElement(By.xpath("//*[@id='select2-expense_head-results']//li[2]")).getText();
		  puchpge.typevalue(expensehead);
		 Thread.sleep(2000);
		 logger.info("------user select the expense head--------------------------");
		 puchpge.selpurvendor();
		 Thread.sleep(2000);
		 puchpge.typevalue(vendorname);
		 Thread.sleep(2000);
		 logger.info("------user select the vendor--------------------------");
		 String puno="pno"+RandomStringUtils.randomNumeric(4);
		 puchpge.typepurchaseno(puno);
		 logger.info("------user type the purchase number--------------------------");
		 puchpge.typecontno("98"+RandomStringUtils.randomNumeric(8));
		 puchpge.typeaddr(" Hospital junction 0987");
		 Thread.sleep(2000);
		 logger.info("-----user type the address--------------------------");
		 Thread.sleep(2000);
		    js=new JavascriptHelper(driver);
			js.scrollDownByPixel();
			Thread.sleep(2000);
			puchpge.selectpoitm();
			Thread.sleep(2000);
			puchpge.typepuitmquantity("1");
			Thread.sleep(2000);
			puchpge.typerate("100");
			puchpge.typediscount("2");
			puchpge.typediscount("1");
			puchpge.clickpuitmsavebtn();
			Thread.sleep(2000);
		 
	 }
	---------------------------*/
	 @Test
	 public void addwarehousedespatch() throws InterruptedException, AWTException
	 {
		/* puchpge=new PurchasePage(driver);
		 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		 logger.info("------click purchase Menu-----------");
		 puchpge.clickpurchaseorders();
		 logger.info("------click purchase Orders--------------------------");
		 puchpge.clickpoactionmenu();
			Thread.sleep(2000);
		puchpge.clickpobilledit();
		Thread.sleep(2000);
		String despatchitm=puchpge.Getspecitm();
		Thread.sleep(2000);*/
		 WarehousePage wh=new WarehousePage(driver);
		  wh.clickwarehousemenu();
		 Thread.sleep(2000);
		 wh.clickwarehouseoption();
		 String newwh=Getnewwarehouse();
		 String whto=Getnewwarehouseto();
		 wh.clickwarehousemenu();
		 wh.clickaddespatch();
		 Thread.sleep(2000);
		  wh.clickaddespatchbtn();
		  wh.clickchoosewh();
		 wh.searchwh(newwh);
		 Thread.sleep(2000); 
		 wh.clickchoosewhto();
		 wh.searchwhto(whto);
		 Thread.sleep(2000);
		 wh.clickclrkreceipt();
		 con=new Config(pr);
		 wh.searchclerk(con.Getcompanyusername());
		 Thread.sleep(2000); 
		 wh.typedespatchno("desp2345"+RandomStringUtils.randomNumeric(2));
		 wh.typedespatchrmks("Despatchrmks");
		 logger.info("-----------");
		 wh.seldespatchitm();
		 //wh.clickdespatchitm();
		 Thread.sleep(2000);
		// wh.searchdespatchitm(despatchitm);
		 //System.out.println("Despatch item "+despatchitm);
		 Thread.sleep(2000); 
		 wh.typedesquantity("1");
		 Thread.sleep(2000);
		 wh.typedesrmks("wh despatch remarks");
		 Thread.sleep(2000);
		 wh.clickwhdespatchsavebtn();
		 Thread.sleep(2000);
	 }
	 
	 @AfterMethod
	 public void Logout() throws InterruptedException
	 {
	 	 
	 	   logout=new LogoutPage(driver);
	 	  logout.clickusericon();
	 	  logout.clickLogout();
	 	  Thread.sleep(2000);
	 }
	 public void selassgnto()
		{
			List<WebElement> userlist=driver.findElements(By.xpath("//*[@id='Warehouse_assigned_to']//li"));
			int userlistcnt=userlist.size();
			String expuser=con.Getcompanyusername();
			for(int i=1;i<=userlistcnt;i++)
			{
			String lstdusernme=driver.findElement(By.xpath("//*[@id='Warehouse_assigned_to']//li["+i+"]//label")).getText();
			if(expuser.equals(lstdusernme))
			{
				driver.findElement(By.xpath("//*[@id='Warehouse_assigned_to']//li["+i+"]//label")).click();
			}
			}
		}
	 public String Getnewwarehouse()
	 {
		 String whname=driver.findElement(By.xpath("//*[@id='myTable']//tbody//tr[1]//td[2]")).getText();
		 return whname;
	 }
	 public String Getnewwarehouseto()
	 {
		 String whname=driver.findElement(By.xpath("//*[@id='myTable']//tbody//tr[2]//td[2]")).getText();
		 return whname;
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
		
	 
}
