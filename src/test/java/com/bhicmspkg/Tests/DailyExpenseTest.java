package com.bhicmspkg.Tests;

import java.awt.Robot;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.AlertHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.DailyExpensePage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.PurchaseItemMasterPage;
import com.bhicmspkg.Pages.PurchasePage;
import com.bhicmspkg.Pages.WarehousePage;
import com.bhicmspkg.TestBase.TestBase;

public class DailyExpenseTest extends TestBase{
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
	 DailyExpensePage dexppge;
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
	 ///*-------------------------------- 
	 @Test
	 public void DailyexpenseEntries_ByCheque() throws InterruptedException
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
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 dexppge.clickaddentriesdailyexp();
		 Thread.sleep(2000);
		 dexppge.seldlyexpcmpny(cmpnyname);
		 Thread.sleep(2000);
		 String dlyexpbillno="dlyexpbillno"+RandomStringUtils.randomNumeric(3);
		 dexppge.typedlyexpbillno(dlyexpbillno);
		 dexppge.seldlyexptrhead();
		 Thread.sleep(2000);
		 dexppge.seldlyexptrtype1(2);
		 Thread.sleep(2000);
		 dexppge.seldlyexpbank();
		 dexppge.typechkno();
		 dexppge.selpettycashuser();
		 dexppge.typeamount("1000");
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 dexppge.seldlyexppurtype();
		 dexppge.typedlyexpdescr();
		 dexppge.clickadddlyexpbtn();
		 Thread.sleep(2000);
		 String newbillno=dexppge.getdlyexpbillno();
		 if(newbillno.equals(dlyexpbillno))
		 {
			 logger.info("------Dailyexpense entries by cheque successfully done!!!-----------");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.info("------Dailyexpense entries by cheque failed!!!-----------");
			 Assert.assertTrue(false, "Dailyexpense entries by cheque failed!!!");
		 }
	 }
	
	 @Test
	 public void DailyexpenseEntries_ByCredit() throws InterruptedException
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
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 dexppge.clickaddentriesdailyexp();
		 Thread.sleep(2000);
		 dexppge.seldlyexpcmpny(cmpnyname);
		 Thread.sleep(2000);
		 String dlyexpbillno="dlyexpbillno"+RandomStringUtils.randomNumeric(3);
		 dexppge.typedlyexpbillno(dlyexpbillno);
		 dexppge.seldlyexptrhead();
		 Thread.sleep(2000);
		 dexppge.seldlyexptrtype("Credit");
		 Thread.sleep(2000);
		 dexppge.selpettycashuser();
		 dexppge.typeamount("1000");
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 dexppge.seldlyexppurtype();
		 Thread.sleep(2000);
		 dexppge.typedlyexpdescr();
		 dexppge.clickadddlyexpbtn();
		 Thread.sleep(2000);
		 String newbillno=dexppge.getdlyexpbillno();
		 if(newbillno.equals(dlyexpbillno))
		 {
			 logger.info("------Dailyexpense entries by credit successfully done!!!-----------");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.info("------Dailyexpense entries by credit failed!!!-----------");
			 Assert.assertTrue(false, "Dailyexpense entries by credit failed!!!");
		 }
	 }
	
	 @Test
	 public void DailyexpenseEntries_ByCash() throws InterruptedException
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
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 dexppge.clickaddentriesdailyexp();
		 Thread.sleep(2000);
		 dexppge.seldlyexpcmpny(cmpnyname);
		 Thread.sleep(2000);
		 String dlyexpbillno="dlyexpbillno"+RandomStringUtils.randomNumeric(3);
		 dexppge.typedlyexpbillno(dlyexpbillno);
		 dexppge.seldlyexptrhead();
		 Thread.sleep(2000);
		 dexppge.seldlyexptrtype("Cash");
		 Thread.sleep(2000);
		 dexppge.selpettycashuser();
		 Thread.sleep(2000);
		 dexppge.typeamount("1000");
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 dexppge.seldlyexppurtype();
		 Thread.sleep(2000);
		 dexppge.typedlyexpdescr();
		 dexppge.clickadddlyexpbtn();
		 Thread.sleep(2000);
		 String newbillno=dexppge.getdlyexpbillno();
		 if(newbillno.equals(dlyexpbillno))
		 {
			 logger.info("------Dailyexpense entries by cash successfully done!!!-----------");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.info("------Dailyexpense entries by cash failed!!!-----------");
			 Assert.assertTrue(false, "Dailyexpense entries by cash failed!!!");
		 }
	 }
	 
	 @Test
	 public void DailyexpenseEntries_ByPettyCash() throws InterruptedException
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
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 dexppge.clickaddentriesdailyexp();
		 Thread.sleep(2000);
		 dexppge.seldlyexpcmpny(cmpnyname);
		 Thread.sleep(2000);
		 String dlyexpbillno="dlyexpbillno"+RandomStringUtils.randomNumeric(3);
		 dexppge.typedlyexpbillno(dlyexpbillno);
		 dexppge.seldlyexptrhead();
		 Thread.sleep(2000);
		 dexppge.seldlyexptrtype("Petty Cash");
		 Thread.sleep(2000);
		 dexppge.selpettycashuser();
		 Thread.sleep(2000);
		 dexppge.typeamount("1000");
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 dexppge.seldlyexppurtype();
		 Thread.sleep(2000);
		 dexppge.typedlyexpdescr();
		 dexppge.clickadddlyexpbtn();
		 Thread.sleep(2000);
		 String newbillno=dexppge.getdlyexpbillno();
		 if(newbillno.equals(dlyexpbillno))
		 {
			 logger.info("------Dailyexpense entries by petty cash successfully done!!!-----------");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 logger.info("------Dailyexpense entries by petty cash failed!!!-----------");
			 Assert.assertTrue(false, "Dailyexpense entries by cash failed!!!");
		 }
	 }
	 @Test
	 public void DailyexpenseEntriesdelete() throws InterruptedException
	 {
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 Thread.sleep(2000);
		 int rowno=dexppge.getrowno();
		 Thread.sleep(2000);
		 if(rowno>1)
		 {
			 dexppge.clickdlyexpaction();
			 Thread.sleep(2000);
			 dexppge.clickdeletebtn();
			 AlertHelper alert=new AlertHelper(driver);
			 alert.AcceptAlertIfPresent();
		 }
	 }
	
	 @Test
	 public void DailyexpenseEntriesEdit() throws InterruptedException
	 {
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 Thread.sleep(2000);
		 int rowno=dexppge.getrowno();
		 Thread.sleep(2000);
		 if(rowno>1)
		 {
			 dexppge.clickdlyexpaction();
			 Thread.sleep(2000);
			 dexppge.clickdlyexpeditbtn();
			 Thread.sleep(2000);
			 dexppge.typeamount("3000");
			 Thread.sleep(2000);
			 js=new JavascriptHelper(driver);
			 js.scrollDownByPixel();
			 Thread.sleep(2000);
		
			 dexppge.typedlyexpdescr();
			 Thread.sleep(2000);
			dexppge.clickupdatebtn();
			 Thread.sleep(2000);
		 }
	 }
	// --------------------------------*/
	 @Test
	 public void DailyexpenseFundTransferByBank() throws InterruptedException
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
		 dexppge=new DailyExpensePage(driver);
		 dexppge.clickdailyexpensemenu();
		 Thread.sleep(2000);
		 dexppge.clickfundtransfer();
		 Thread.sleep(2000);
		 dexppge.selfndtrcmpny(cmpnyname);
		 Thread.sleep(2000);
		 dexppge.selfndtrpaymnttype("Bank");
		 dexppge.selfndtrbnknme();
		 Thread.sleep(2000);
		 dexppge.typechqno("chq0"+RandomStringUtils.randomNumeric(3));
		 dexppge.selbcmpny(cmpnyname);
		 dexppge.selbpaytype("Bank");
		 Thread.sleep(2000);
		 dexppge.selfndtrBbnknme();
		 dexppge.typeBchqno("chq1"+RandomStringUtils.randomNumeric(3));
		 dexppge.typeBamnt();
		 dexppge.typedescr();
		 Thread.sleep(2000);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 dexppge.clickaddbtn();
		
	 }
	 @AfterMethod
	 public void Logout() throws InterruptedException
	 {
	 	 
	 	   logout=new LogoutPage(driver);
	 	  logout.clickusericon();
	 	  logout.clickLogout();
	 	  Thread.sleep(2000);
	 }
}
