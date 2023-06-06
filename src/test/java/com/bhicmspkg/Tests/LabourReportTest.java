package com.bhicmspkg.Tests;

import java.awt.Robot;
import java.io.IOException;

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
import com.bhicmspkg.Pages.LabourReportPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.Pages.PurchasePage;
import com.bhicmspkg.Pages.SubcontractorPage;
import com.bhicmspkg.Pages.VendorPage;
import com.bhicmspkg.Pages.WarehousePage;
import com.bhicmspkg.TestBase.TestBase;

public class LabourReportTest extends TestBase{
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
	 AlertHelper alert;
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
	 ///*-----------------
	 @Test
	 public void Labourreport() throws InterruptedException
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
		 mstr.clicksettingsmenu();
		 Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		SubcontractorPage subcntr=new SubcontractorPage(driver);
		subcntr.clicksubcntrmenu();
		subcntr.clicksubcntrlst();
		String subcntrname=subcntr.Getsubcontrname();
		 LabourReportPage lbrrpt=new LabourReportPage(driver);
		 lbrrpt.clicklabourreportmenu();
		 Thread.sleep(2000);
		 lbrrpt.clickaddentriesbtn();
		 Thread.sleep(2000);
		 lbrrpt.sellbrcompany(cmpnyname);
		 Thread.sleep(2000);
		 lbrrpt.sellbrproject(pjtnme);
		 Thread.sleep(2000);
		 lbrrpt.selsubcntr(subcntrname);
		 Thread.sleep(2000);
		 lbrrpt.selexphead();
		 lbrrpt.typelbrdescription();
		 lbrrpt.typemason();
		 lbrrpt.typewagespersqfeet();
		 lbrrpt.typewagerate();
		 lbrrpt.clickaddbtn();
		 	 
	 }
	 
	 @Test
	 public void LabourreportEdit() throws InterruptedException
	 {
		 LabourReportPage lbrrpt=new LabourReportPage(driver);
		 lbrrpt.clicklabourreportmenu();
		 Thread.sleep(2000);
		 lbrrpt.clickactionmenu();
		 Thread.sleep(2000);
		 lbrrpt.clickEdit();
		 lbrrpt.typelbrdescription();
		 lbrrpt.clickupdatebtn();
		 Thread.sleep(2000);
		 AlertHelper alert=new AlertHelper(driver);
		 alert.AcceptAlertIfPresent();
		Thread.sleep(3000);
		driver.navigate().refresh();
	 }
	

	
	
	 @Test
	 public void Labourreportdelete() throws InterruptedException
	 {
		 LabourReportPage lbrrpt=new LabourReportPage(driver);
		 lbrrpt.clicklabourreportmenu();
		 Thread.sleep(2000);
		 lbrrpt.clickactionmenu();
		 Thread.sleep(2000);
		 lbrrpt.clickDelete();
		 alert=new AlertHelper(driver);
		 alert.AcceptAlertIfPresent();
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
}
