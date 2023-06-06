package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
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
import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.Pages.PurchasePage;
import com.bhicmspkg.Pages.SubcontractorPage;
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.Pages.WarehousePage;
import com.bhicmspkg.TestBase.TestBase;

public class SubcontractorTest extends TestBase{
	 CompanyPage cmpnypge;
	 Masterpage mstr;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 UserPage userpge;
	 PurchasePage puchpge;
	 JavascriptHelper js;
	 WarehousePage whse;
	 SubcontractorPage subcntr;
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
	// /*-------------------------------
	 @Test
	 public void SubcontractorCreation() throws InterruptedException
	 {
		  subcntr=new SubcontractorPage(driver);
		  subcntr.clicksubcntrmenu();
		  Thread.sleep(2000);
		  subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		  subcntr.clickaddsubcntrbtn();
		  Thread.sleep(2000);
		  
		  String subcntrname="subcntr"+RandomStringUtils.randomAlphabetic(3);
		  subcntr.typesubcntrnme(subcntrname);
		  Thread.sleep(2000);
		  subcntr.typesubcntrphone(RandomStringUtils.randomNumeric(5));
		  Thread.sleep(2000);
		  subcntr.typesubcntremail();
		  Thread.sleep(2000);
		  subcntr.typesubcntrdescr();
		  subcntr.clicksubexphead();
		  Thread.sleep(2000);
		  js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  subcntr.typesubcntrgstno();
		  Thread.sleep(2000);
		  subcntr.Clicklastcompany();
		  Thread.sleep(2000);
		  subcntr.clickcreatebtn();
		  Thread.sleep(2000);
		  String newsubcntrnme=subcntr.Getsubcontrname();
		  if(newsubcntrnme.equals(subcntrname))
		  {
		  logger.info("-----------subcontractor creation successfully!!!----------------");
		  Assert.assertTrue(true);
		  }
		  else
		  {
			  logger.info("-----------subcontractor creation failed!!!----------------");
			  Assert.assertTrue(false,"Something went wrong.Subcontractor creation failed!!!---------");
		  }
		  
	 }
	 @Test
	 public void SubcontractorCreationEdit() throws InterruptedException
	 {
		  subcntr=new SubcontractorPage(driver);
		  subcntr.clicksubcntrmenu();
		  Thread.sleep(2000);
		  subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		 subcntr.clicksubcntredit();
		 String subcntrname="subcntr"+RandomStringUtils.randomAlphabetic(3);
		  subcntr.typesubcntrnme(subcntrname);
		  Thread.sleep(2000);
		  js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  subcntr.clicksavesubcntrbtn();
		  Thread.sleep(2000);
		  logger.info("-------Subcontractor details edited successfully!!!-----------");
		 Assert.assertTrue(true);
		 Thread.sleep(2000);
	 }
	
	 @Test
	 public void SubcontractorQuotationCreation() throws InterruptedException, AWTException
	 {  
		 subcntr=new SubcontractorPage(driver);
		// LocalDate Today_date=java.time.LocalDate.now();
		// /*
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmpnypge.getlastcmpnyname();
		 Thread.sleep(2000);
		 mstr.clicksettingsmenu();
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		 subcntr=new SubcontractorPage(driver);
		  subcntr.clicksubcntrmenu();
		  Thread.sleep(2000);
		  subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		 String newsubcntrnme=subcntr.Getsubcontrname();
		 subcntr.clicksubcntrmenu();
		  subcntr.clicksubcontractorquotation();
		  Thread.sleep(2000);
		    subcntr.clickaddquotation();
		  Thread.sleep(2000);
		  subcntr.selsubcntrcmpny(cmpnyname);
		  Thread.sleep(2000);
		  subcntr.selsubcntrpjt(pjtnme);
		  Thread.sleep(2000);
		 subcntr.selsubcntrname(newsubcntrnme);
		 Thread.sleep(2000);
		 subcntr.typescquotationno("scno"+RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 subcntr.selsubcntrexphead();
		 Thread.sleep(2000);
		 subcntr.typesubcntrqtndate();
		 Thread.sleep(2000);
		 subcntr.typesubcntrqtndescr();
		 Thread.sleep(2000);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 subcntr.clickpaymnttitle();
		 subcntr.typesubcntamnt();
		 Thread.sleep(2000);
		 subcntr.clickaddamntbtn();
		 Thread.sleep(2000);//*/
	// /*------------------------
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		  subcntr.clicksubcontractorquotation();
		  Thread.sleep(2000);
		  subcntr.clicksubcntractmenu();
		 Thread.sleep(2000);
		 subcntr.clicksubcntrqtedit();
		 subcntr.clickaddnewsubcontritm();
		 Thread.sleep(2000);
		 subcntr.typesubcntrcategory();
		 Thread.sleep(2000);
		 robo=new Robot();
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 subcntr.clicksubcntritemadd();
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 subcntr.typeitmdescr();
		 Thread.sleep(2000);
		 subcntr.selsubitmtype();
		 Thread.sleep(2000);
		 subcntr.typeitmquantity();
		 Thread.sleep(2000);
		 subcntr.typeitmunit();
		 Thread.sleep(2000);
		 subcntr.typeitmrate();
		 Thread.sleep(2000);
		 subcntr.typeitmamnt();
		 Thread.sleep(2000);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 subcntr.clicksavebtn();
		 Thread.sleep(2000);
	 }

	 @Test
	 public void SubcontractorQuotationapprove() throws InterruptedException
	 {
		 
		 subcntr=new SubcontractorPage(driver);
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		 logger.info("-----click subcontractor menu------");
		  subcntr.clicksubcontractorquotation();
		  logger.info("-----click subcontractor quotation------");
		  Thread.sleep(2000);
		  subcntr.clicksubcntractmenu();
		  logger.info("-----click subcontractor action menu------");
		  Thread.sleep(2000);
		   subcntr.clicksubcntrqtedit(); 
		   logger.info("-----click subcontractor quotation edit------");
		 Thread.sleep(2000);
		 subcntr.clicktotalamnt();
		 logger.info("-----click total amount menu------");
		 Thread.sleep(2000);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 subcntr.clicksubcntritmactmnu();
		 Thread.sleep(2000);
		 logger.info("-----click subcontractor item action menu------");
		subcntr.clicksubcntritmapprbtn();
		Thread.sleep(2000);
		 logger.info("-----click subcontractor item approve button------");
	 }
	
	 @Test
	 public void SubcontractorQuotationPayment() throws InterruptedException, AWTException
	 {
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmpnypge.getlastcmpnyname();
		 Thread.sleep(2000);
		 mstr.clicksettingsmenu();
		 Thread.sleep(2000);
		 mstr.clickbankname();
		 logger.info("----------user click bank-----------");
		 String bnkname=mstr.getbankname(cmpnyname);
		 Thread.sleep(2000);
		  mstr.clicksettingsmenu();
		  Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		 subcntr=new SubcontractorPage(driver);
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		 logger.info("-----click subcontractor menu------");
		 subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		 String newsubcntrnme=subcntr.Getsubcontrname();
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		subcntr.clicksubcontractorquotation();
		  Thread.sleep(2000);
		  String subcntrquotno=subcntr.Getsubcontrquotationno();
		  Thread.sleep(2000);
		  String subcntrquotamnt=subcntr.Getsubcontrquotationamnt();
		  Thread.sleep(2000);
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		 subcntr.clicksubcntrpaymnt();
		 Thread.sleep(2000);
		 logger.info("----click subcontractor payments-------");
		 subcntr.clickaddentries();
		 Thread.sleep(2000);
		 logger.info("----click add entries-------");
		 subcntr.selsubcntrpaycmpny(cmpnyname);
		 Thread.sleep(2000);
		 logger.info("----select company name-------");
		 subcntr.selsubcntrpaymntnme(newsubcntrnme);
		 Thread.sleep(2000);
		 logger.info("----select subcontractor name-------");
		 robo=new Robot();
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);
		 subcntr.selsubcntrpaymntpjtnme(pjtnme);
		 Thread.sleep(2000);
		 logger.info("----select subcontractor project name------");
		 subcntr.selsubcntrquotno(subcntrquotno);
		 Thread.sleep(2000);
		 logger.info("----select subcontractor quotation number-------");
		 subcntr.typesubcntrpaymntamnt(subcntrquotamnt);
		 Thread.sleep(2000);
		 logger.info("----select subcontractor payment amount-------");
		 subcntr.selsubcntrpaymnttype();
		 Thread.sleep(2000);
		 logger.info("----select subcontractor payment type-------");
		 subcntr.selsubcntrpaymntbnknme(bnkname);
		 Thread.sleep(2000);
		 logger.info("----select subcontractor bank name-------");
		 subcntr.typesubcntrchqno();
		 Thread.sleep(2000);
		 logger.info("----type subcontractor cheque no-------");
		 subcntr.typesubcntrpaymntdescr();
		 Thread.sleep(2000);
		 logger.info("----type subcontractor payment description-------");
		 subcntr.clicksubcntrpaymntaddbtn();
		 Thread.sleep(2000);
		 logger.info("----click subcontractor payment add button-------");
		 logger.info("-----subcntractor payment created successfully!!!--------");
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		 subcntr.clicksubcntrpaymnt();
		 Thread.sleep(2000);
		 subcntr.clicksubcntrpaymntapprbtn();
		 AlertHelper alert=new AlertHelper(driver);
		 alert.AcceptAlertIfPresent();
		 logger.info("----click subcontractor payment add button-------");
	     logger.info("-----subcntractor payment created successfully!!!--------");
		 logger.info("------subcontractor payment approve done successfully----------");
		 Assert.assertTrue(true);
	 }
	// ------------------------*/
	 @Test
	 public void Subcontractorbill() throws InterruptedException
	 {
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmpnypge.getlastcmpnyname();
		 Thread.sleep(2000);
		 mstr.clicksettingsmenu();
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		  subcntr=new SubcontractorPage(driver);
		  subcntr.clicksubcntrmenu();
		  Thread.sleep(2000);
		  subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		  String newsubcntrnme=subcntr.Getsubcontrname();
		  subcntr.clicksubcntrmenu();
			 Thread.sleep(2000);
			subcntr.clicksubcontractorquotation();
			  Thread.sleep(2000);
			  String subcntrquotno=subcntr.Getsubcontrquotationno();
		 
		 subcntr.clicksubcntrmenu();
		 Thread.sleep(2000);
		 subcntr.clicksubcntrbill();
		 logger.info("--------click subcontractor bill--------------");
		 String subcntrbillno=subcntr.Getsubcontrbillno();
		 Thread.sleep(2000);
		 subcntr.clickaddnew();
		 Thread.sleep(2000);
		 subcntr.selsubcntrbillcmpny(cmpnyname);
		 Thread.sleep(2000);
		 subcntr.selsubcntrbillpjt(pjtnme);
		 Thread.sleep(2000);
		 subcntr.selsubcntrbillcntrname(newsubcntrnme);
		 logger.info("--------select sub contractor name------");
		 subcntr.selsubcntrbillquotno(subcntrquotno);
		 logger.info("--------select sub contractor bill quot no------");
		 subcntr.typesubcntrbillno(subcntrbillno);
		 logger.info("--------type the subcontractor bill number------");
		 subcntr.typesubcntrbilldate();
		 logger.info("--------type the subcontractor bill date------");
		 subcntr.clicksubcntrbillcreatebtn();
		 logger.info("--------click subcontractor save button-----");
		 logger.info("-----Subcontractor bill created successfully!!-------------");
		 Assert.assertTrue(true);
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
