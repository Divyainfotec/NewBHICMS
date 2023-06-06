package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.Pages.PurchaseItemMasterPage;
import com.bhicmspkg.Pages.ReportDownloadPage;
import com.bhicmspkg.Pages.Sales_QuotationGeneratorPage;
import com.bhicmspkg.Pages.SubcontractorPage;
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.Pages.VendorPage;
import com.bhicmspkg.TestBase.TestBase;

public class ReportDownloadTest extends TestBase{
	PurchaseItemMasterPage purchasemstr;
	CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 UserPage userpge;
	 Masterpage mstr;
	 ReportDownloadPage rptdwnld;
	 SubcontractorPage subcntr;
	 VendorPage vndrpage;
	private static Logger logger=LoggerHelper.getLogger(ReportDownloadTest.class);
	
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
	 //logger.info("-----------------------");
	 /*--------------------------
	 @Test
	 public void FinanciareportDownload() throws InterruptedException
	 {
		 rptdwnld=new ReportDownloadPage(driver);
		 rptdwnld.Clickreportmenu();
		 Thread.sleep(2000);
		 logger.info("--------User click Report menu---------------");
		 rptdwnld.Clickfinancialrpt();
		 Thread.sleep(2000);
		 logger.info("--------User click financial Report---------------");
		 rptdwnld.clicksaveaspdf();
		 Thread.sleep(2000);
		 logger.info("-------User click Save as PDF----------------");
		 logger.info("--------Financial Report save As Pdf button is clicked------------");
		 rptdwnld.clicksaveasexcel();
		 Thread.sleep(2000);
		 logger.info("---------User click Save As Excel--------------");
		 logger.info("--------Financial Report save As Excel button is clicked------------");
		 logger.info("--------Financial Report Download successfully!!!---------");
	 }
	
	
	 @Test
	 	 public void WorkstatusreportDownload() throws InterruptedException
	 {
		 rptdwnld=new ReportDownloadPage(driver);
		 rptdwnld.Clickreportmenu();
		 Thread.sleep(2000);
		 logger.info("--------User click Report menu---------------");
		 rptdwnld.clickworkstatus();
		 logger.info("---------User click work status report--------------------");
		 rptdwnld.clicksaveaspdf();
		 logger.info("-------User click Save as PDF----------------");
		 logger.info("--------Work status Report save As Pdf button is clicked------------");
		 rptdwnld.clicksaveasexcel();
		 logger.info("---------User click Save As Excel--------------");
		 logger.info("--------Work status Report save As Excel button is clicked------------");
		 logger.info("-------Work status Report Downloaded successfully!!!----------");
	 }
	 
		 @Test
 	 public void ProjectreportDownload() throws InterruptedException
	 {
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		 mstr.clicksettingsmenu();
		  Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
	 rptdwnld=new ReportDownloadPage(driver);
	 rptdwnld.Clickreportmenu();
	 Thread.sleep(2000);
	 logger.info("--------User click Report menu---------------");
	 rptdwnld.Clickprojectreport();
	 Thread.sleep(2000);
	 logger.info("--------User click Project Report ---------------");
	 rptdwnld.selpjtrptpjt(pjtnme);
	 Thread.sleep(2000);
	 logger.info("--------User select project---------------");
	 rptdwnld.selpjtstatus("Ongoing");
	 Thread.sleep(2000);
	 rptdwnld.selpjtrptcmpny(cmpnyname);
	 Thread.sleep(2000);
	 logger.info("--------User select company---------------");
	 rptdwnld.clickpjtrptgo();
	 Thread.sleep(2000);
	 rptdwnld.Clickunreconciledrpt();
	 logger.info("-----unreconcilation report------------");
	 rptdwnld.clicksaveaspdf();
	 logger.info("-------User click Save as PDF----------------");
	 logger.info("--------Project Report save As Pdf button is clicked------------");
	 rptdwnld.clicksaveasexcel();
	 logger.info("---------User click Save As Excel--------------");
	 logger.info("--------Project Report save As Excel button is clicked------------");
	 logger.info("-------Project Report Downloaded successfully!!!----------");
	 }
	  
	 @Test
	 public void ReceiptreportDownload() throws InterruptedException, AWTException
	 {
	     mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		 rptdwnld=new ReportDownloadPage(driver);
		 rptdwnld.Clickreportmenu();
		 Thread.sleep(2000);
		 logger.info("--------User click Report menu---------------");
		 rptdwnld.clickreceiptrpt();
		 logger.info("--------User click Receipt Report ---------------");
		 rptdwnld.selreceiptcmpny(cmpnyname);
		 Thread.sleep(2000);
		// rptdwnld.selexpfromdate();
		// Thread.sleep(2000);
		// rptdwnld.selexptodate();
		// Thread.sleep(2000);
		 /* robo=new Robot();
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);
		 robo.keyPress(KeyEvent.VK_TAB);
		 robo.keyRelease(KeyEvent.VK_TAB);*/
	 /*----
		 rptdwnld.clickreportgobtn();
		 rptdwnld.clicksaveaspdf();
		 logger.info("-------User click Save as PDF----------------");
		 logger.info("--------Receipt Report save As Pdf button is clicked------------");
		 rptdwnld.clicksaveasexcel();
		 logger.info("---------User click Save As Excel--------------");
		 logger.info("--------Receipt Report save As Excel button is clicked------------");
		 logger.info("-------Receipt Report Downloaded successfully!!!----------");
	 }

	 @Test
 	 public void WeeklypaymentreportDownload() throws InterruptedException, AWTException
 {
		 mstr=new Masterpage(driver);
		 subcntr=new SubcontractorPage(driver);
		  subcntr.clicksubcntrmenu();
		  Thread.sleep(2000);
		  subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		 String newsubcntrnme=subcntr.Getsubcontrname();
		 mstr.clicksettingsmenu();
		  Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		  rptdwnld=new ReportDownloadPage(driver);
	 rptdwnld.Clickreportmenu();
	 Thread.sleep(2000);
	 logger.info("--------User click Report menu---------------");
	 rptdwnld.Clickweeklypaymntrpt();
	 logger.info("----------user click weekly payment report-----------------------");
	 rptdwnld.selsubcontractor(newsubcntrnme );
	 Thread.sleep(2000);
	 rptdwnld.selweeklyrptpjt(pjtnme);
	 Thread.sleep(2000);
	 robo=new Robot();
	 robo.keyPress(KeyEvent.VK_TAB);
	 robo.keyRelease(KeyEvent.VK_TAB);
	 robo.keyPress(KeyEvent.VK_TAB);
	 robo.keyRelease(KeyEvent.VK_TAB);
	 rptdwnld.Clickweeklypaymntgobtn();
	 rptdwnld.clicksaveaspdf();
	 Thread.sleep(2000);
	 logger.info("-------User click Save as PDF----------------");
	 logger.info("--------Weeklyclickreportgobtnpayment Report save As Pdf button is clicked------------");
	 rptdwnld.clicksaveasexcel();
	 Thread.sleep(2000);
	 logger.info("---------User click Save As Excel--------------");
	 logger.info("--------Weeklypayment Report save As Excel button is clicked------------");
	 logger.info("-------Weeklypayment Report Downloaded successfully!!!----------");
 }
 

	 @Test
 	 public void DaybooktransactionreportDownload() throws InterruptedException, AWTException
 {
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		  vndrpage=new VendorPage(driver);
			// vndrpage.getbankname(cmpnyname);
			  vndrpage.clickvendorsmenu();
			  Thread.sleep(2000);
			  vndrpage.clickvendorslist();
			  Thread.sleep(2000);
			  String vndrnme=vndrpage.Getvndrname();
			  subcntr=new SubcontractorPage(driver);
		  subcntr.clicksubcntrmenu();
		  Thread.sleep(2000);
		  subcntr.clicksubcntrlst();
		  Thread.sleep(2000);
		 String newsubcntrnme=subcntr.Getsubcontrname();
		  mstr.clicksettingsmenu();
		  Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		  rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  rptdwnld.clickdaybooktransaction();
		  logger.info("----------user click day book transaction-----------");
		  rptdwnld.selpjtrptpjt(pjtnme);
		  Thread.sleep(2000);
		  logger.info("----------user select the project-----------");
				  rptdwnld.seldaybooktranstype_credit();
				  logger.info("----------user select the daybooktransaction type-----------");
				  rptdwnld.selpjtrptcmpny(cmpnyname);
		  Thread.sleep(2000);
		  logger.info("----------user select the company-----------");
		  rptdwnld.seldaybookvndrname(vndrnme);
		  Thread.sleep(2000);
		  logger.info("----------user select the vendor name-----------");
		  rptdwnld.seldaybookpurchasetype();
		  Thread.sleep(2000);
		  logger.info("----------user select the purchase type-----------");
		  rptdwnld.seldaybookpexptype();
		  Thread.sleep(2000);
		  rptdwnld.seldaybooksubcntrname(newsubcntrnme);
		  Thread.sleep(2000);
		  logger.info("----------user select subcntr name----------");
			 robo=new Robot();
			 robo.keyPress(KeyEvent.VK_TAB);
			 robo.keyRelease(KeyEvent.VK_TAB);
			 robo.keyPress(KeyEvent.VK_TAB);
			 robo.keyRelease(KeyEvent.VK_TAB);
		  rptdwnld.clickdaybookgobtn();
		  logger.info("----------user click go button-----------");
		  Thread.sleep(2000);
		  rptdwnld.clicksaveaspdf();
			 Thread.sleep(2000);
			 logger.info("-------User click Save as PDF----------------");
			 logger.info("--------Daybook transaction Report save As Pdf button is clicked------------");
			 rptdwnld.clicksaveasexcel();
			 Thread.sleep(2000);
			 logger.info("---------User click Save As Excel--------------");
			 logger.info("--------Daybook transaction Report save As Excel button is clicked------------");
			 logger.info("-------Daybook transaction Report Downloaded successfully!!!----------");
 }
 
	 @Test
 	 public void DailyexpreportDownload() throws InterruptedException, AWTException
 {
		 
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		 rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  rptdwnld.clickdlyexprpt();
		  logger.info("-----user click daily expense report-------------");
		  rptdwnld.selpjtrptcmpny(cmpnyname);
		  Thread.sleep(2000);
		  robo=new Robot();
			 robo.keyPress(KeyEvent.VK_TAB);
			 robo.keyRelease(KeyEvent.VK_TAB);
			 robo.keyPress(KeyEvent.VK_TAB);
			 robo.keyRelease(KeyEvent.VK_TAB);
			 robo.keyPress(KeyEvent.VK_TAB);
			 robo.keyRelease(KeyEvent.VK_TAB);
		  rptdwnld.seldailyexptype();
		  logger.info("----------user select the daily expense type-----------");
		  rptdwnld.seldailyexppurchasetype();
		  Thread.sleep(2000);
		  logger.info("----------user select the daily expense purchase type-----------");
		  rptdwnld.seldailyexptranstype();
		  logger.info("----------user select the daily expense transaction type-----------");
		  rptdwnld.clickdlyexpgobtn();
		  logger.info("-------user click go button-----------");
		  rptdwnld.clicksaveaspdf();
			 Thread.sleep(2000);
			 logger.info("-------User click Save as PDF----------------");
			 logger.info("--------Daily expense transaction Report save As Pdf button is clicked------------");
			 rptdwnld.clicksaveasexcel();
			 Thread.sleep(2000);
			 logger.info("---------User click Save As Excel--------------");
			 logger.info("--------Daily expense   Report save As Excel button is clicked------------");
			 logger.info("-------Daily expense   Report Downloaded successfully!!!----------");
 }
	 @Test
 	 public void VendorPaymentreportDownload() throws InterruptedException, AWTException
 {
 		// vndrpage.getbankname(cmpnyname);
		  vndrpage=new VendorPage(driver);
		  vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvendorslist();
		  Thread.sleep(2000);
		  String vndrnme=vndrpage.Getvndrname();
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		 rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  rptdwnld.clickvendrpaymntreport();
		  Thread.sleep(2000);
		 rptdwnld.selvendornamername(vndrnme);
		 Thread.sleep(2000);
		 rptdwnld.selpjtrptcmpny(cmpnyname);
		 Thread.sleep(2000);
		 rptdwnld.clickvndrgobtn();
		 logger.info("-------user click go button-----------");
		  rptdwnld.clicksaveaspdf();
			 Thread.sleep(2000);
			 logger.info("-------User click Save as PDF----------------");
			 logger.info("--------Vendor payment Report save As Pdf button is clicked------------");
			 rptdwnld.clicksaveasexcel();
			 Thread.sleep(2000);
			 logger.info("---------User click Save As Excel--------------");
			 logger.info("------Vendor payment Report save As Excel button is clicked------------");
			 logger.info("-------Vendor payment Report Downloaded successfully!!!----------");
 }
 
	 @Test
 public void SubcntractorPAymntreportDownload() throws InterruptedException, AWTException
 {
	 subcntr=new SubcontractorPage(driver);
	  subcntr.clicksubcntrmenu();
	  Thread.sleep(2000);
	  subcntr.clicksubcntrlst();
	  Thread.sleep(2000);
	 String newsubcntrnme=subcntr.Getsubcontrname();
	 Thread.sleep(2000);
		 mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 logger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 logger.info("----------user click company-----------");
		 String cmpnyname=cmppge.getlastcmpnyname();
		 Thread.sleep(2000);
		 mstr.clicksettingsmenu();
		  Thread.sleep(2000);
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		  rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  rptdwnld.clicksubcntrpaymntreport();
		  Thread.sleep(2000);
		  rptdwnld.selsubcntrname(newsubcntrnme);
		  logger.info("----------user select subcontractor name-----------");
		  Thread.sleep(2000);
		  rptdwnld.selpjtrptcmpny(cmpnyname);
			 Thread.sleep(2000);
			 logger.info("----------user select  company name-----------");
			 rptdwnld.selsubcntrpjtname(pjtnme);
			 Thread.sleep(2000);
			 logger.info("----------user select project name----------");
			 rptdwnld.clickvndrgobtn();
			 Thread.sleep(2000);
			 logger.info("----------user click go button-----------");
			 logger.info("-------user click go button-----------");
			  rptdwnld.clicksaveaspdf();
				 Thread.sleep(2000);
				 logger.info("-------User click Save as PDF----------------");
				 logger.info("--------Subcontractor payment Report save As Pdf button is clicked------------");
				 rptdwnld.clicksaveasexcel();
				 Thread.sleep(2000);
				 logger.info("---------User click Save As Excel--------------");
				 logger.info("------Subcontractor payment Report save As Excel button is clicked------------");
				 logger.info("-------Subcontractor payment Report Downloaded successfully!!!----------");
 }
 
	 @Test
	 public void CashbalancereportDownload() throws InterruptedException, AWTException
	 {
			 
			  LocalDate todaydate=java.time.LocalDate.now();
			  rptdwnld=new ReportDownloadPage(driver);
			  JavascriptHelper js=new JavascriptHelper(driver);
			  rptdwnld.Clickreportmenu();
			  rptdwnld.clickcashbalancereport();
			  rptdwnld.rptfromdate();
			  Thread.sleep(2000);
			  rptdwnld.rpttodate();
			  Thread.sleep(2000);
			  rptdwnld.clickvndrgobtn();
			  Thread.sleep(2000);
			  rptdwnld.clicksaveaspdf();
			  Thread.sleep(2000);
			  logger.info("-------User click Save as PDF----------------");
			  logger.info("--------Cashbalance Report save As Pdf button is clicked------------");
			  rptdwnld.clicksaveasexcel();
			  Thread.sleep(2000);
			  logger.info("---------User click Save As Excel--------------");
			  logger.info("------Cashbalance Report save As Excel button is clicked------------");
			  logger.info("------Cashbalance Report Downloaded successfully!!!----------");
	 }
	 
	 @Test
	 public void TaxreportDownload() throws InterruptedException, AWTException
	 {
			  
			 mstr=new Masterpage(driver);
			 mstr.clicksettingsmenu();
			 logger.info("----------user click settings-----------");
			 cmppge=new CompanyPage(driver);
			 cmppge.clickcompany();
			 logger.info("----------user click company-----------");
			 String cmpnyname=cmppge.getlastcmpnyname();
			 Thread.sleep(2000);
			 
		 	  LocalDate todaydate=java.time.LocalDate.now();
			  rptdwnld=new ReportDownloadPage(driver);
			  JavascriptHelper js=new JavascriptHelper(driver);
			  rptdwnld.Clickreportmenu();
			  logger.info("--------user click report menu------------");
			  rptdwnld.clicktaxreport();
			  logger.info("----------user click tax report------------");
			  rptdwnld.rptfromdate();
			  logger.info("----------user select from date------------");
			  rptdwnld.rpttodate();
			  logger.info("----------user select to date------------");
			  rptdwnld.selpjtrptcmpny(cmpnyname);
			  Thread.sleep(2000);
			  logger.info("----------user select  company name-----------");
			  rptdwnld.clickvndrgobtn();
			  Thread.sleep(2000);
			  rptdwnld.clicksaveaspdf();
			  Thread.sleep(2000);
			  logger.info("-------User click Save as PDF----------------");
			  logger.info("--------Tax Report save As Pdf button is clicked------------");
			  rptdwnld.clicksaveasexcel();
			  Thread.sleep(2000);
			  logger.info("---------User click Save As Excel--------------");
			  logger.info("------Tax Report save As Excel button is clicked------------");
			  logger.info("------Tax Report Downloaded successfully!!!----------");
			  
	 }
	 
	 
	 @Test
	 public void BankreconciliationreportDownload() throws InterruptedException, AWTException
	 {
			  
			 mstr=new Masterpage(driver);
			 mstr.clicksettingsmenu();
			 logger.info("----------user click settings-----------");
			 cmppge=new CompanyPage(driver);
			 cmppge.clickcompany();
			 logger.info("----------user click company-----------");
			 String cmpnyname=cmppge.getlastcmpnyname();
			 Thread.sleep(2000);
			 mstr.clicksettingsmenu();
			 logger.info("----------user click settings-----------");
			 mstr.clickbankname();
			 Thread.sleep(2000);
			String bankname= mstr.getbankname(cmpnyname);
			Thread.sleep(2000);
			 LocalDate todaydate=java.time.LocalDate.now();
			  rptdwnld=new ReportDownloadPage(driver);
			  JavascriptHelper js=new JavascriptHelper(driver);
			  rptdwnld.Clickreportmenu();
			  logger.info("--------user click report menu------------");
			  rptdwnld.clickreconciliation();
			  Thread.sleep(2000);
			  logger.info("----------user click reconciliation report------------");
			  rptdwnld.Reconciliationrptfromdate();
			  Thread.sleep(2000);
			  logger.info("----------user select from date------------");
			  rptdwnld.Reconconciliationrpttodate();
			  logger.info("----------user select to date------------");
			  robo=new Robot();
			  robo.keyPress(KeyEvent.VK_TAB);
			  robo.keyRelease(KeyEvent.VK_TAB);
			  rptdwnld.selbankreconciliation(bankname);
			  Thread.sleep(2000);
			  rptdwnld.selreconcilcmp(cmpnyname);
			  Thread.sleep(2000);
			  logger.info("----------user select  company name-----------");
			  rptdwnld.clickreconcilgobtn();
			  Thread.sleep(2000);
			  rptdwnld.clicksaveaspdf();
			  Thread.sleep(2000);
			  logger.info("-------User click Save as PDF----------------");
			  logger.info("--------Bank reconciliation Report save As Pdf button is clicked------------");
			  rptdwnld.clicksaveasexcel();
			  Thread.sleep(2000);
			  logger.info("---------User click Save As Excel--------------");
			  logger.info("------Bank reconciliation Report save As Excel button is clicked------------");
			  logger.info("------Bank reconciliation Report Downloaded successfully!!!----------");
	 }
	
	 @Test
	 public void PurchasereportDownload() throws InterruptedException, AWTException
	 { 	
		    vndrpage=new VendorPage(driver);
		    vndrpage.clickvendorsmenu();
		    Thread.sleep(2000);
		    vndrpage.clickvendorslist();
		    Thread.sleep(2000);
		     String vndrnme=vndrpage.Getvndrname();
			 mstr=new Masterpage(driver);
			 mstr.clicksettingsmenu();
			 logger.info("----------user click settings-----------");
			 cmppge=new CompanyPage(driver);
			 cmppge.clickcompany();
			 logger.info("----------user click company-----------");
			 String cmpnyname=cmppge.getlastcmpnyname();
			 Thread.sleep(2000);
			 mstr.clicksettingsmenu();
			  Thread.sleep(2000);
			 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
			 pjtpge.clicksettingspjt();
			 Thread.sleep(2000);
			 String pjtnme=pjtpge.getlastprojectname();
			 Thread.sleep(2000);
			 ReportDownloadPage rptdwnld=new ReportDownloadPage(driver);
			 rptdwnld.Clickreportmenu();
			  logger.info("--------user click report menu------------");
			  rptdwnld.clickpurchasebillreport();
			  logger.info("--------user click purchase bill report -----------");
			 rptdwnld.selpurchasepjt(pjtnme);
			 Thread.sleep(2000);
			 logger.info("--------user select purchase project------------");
			 rptdwnld.selpurchasevndr(vndrnme);
			 Thread.sleep(2000);
			 logger.info("--------user select purchase vendor------------");
			 rptdwnld.selpjtrptcmpny(cmpnyname);
			 Thread.sleep(2000);
			 logger.info("--------user select purchase company------------");
			 rptdwnld.rptfromdate();
			 Thread.sleep(2000);
			 logger.info("--------user select from date------------");
			 rptdwnld.rpttodate();
			 Thread.sleep(2000);
			 logger.info("--------user select todate-----------");
			 rptdwnld.clickreconcilgobtn();
			 Thread.sleep(2000);
			 logger.info("--------user click go button------------");
			  rptdwnld.clicksaveaspdf();
			  Thread.sleep(2000);
			  logger.info("-------User click Save as PDF----------------");
			  logger.info("--------Purchase Bill Report save As Pdf button is clicked------------");
			  rptdwnld.clicksaveasexcel();
			  Thread.sleep(2000);
			  logger.info("---------User click Save As Excel--------------");
			  logger.info("------Purchase Bill Report save As Excel button is clicked------------");
			  logger.info("------Purchase Bill Report Downloaded successfully!!!----------");
	 
	 }
	 ----------------------------------------*/
	 @Test
	 public void SalesquotationreportDownload() throws InterruptedException, AWTException
	 { 	
		 Sales_QuotationGeneratorPage sqpge=new Sales_QuotationGeneratorPage(driver);
		 sqpge.clicksalesmenu();
		 Thread.sleep(2000);
		 logger.info("-------User click Sales menu----------------");
		 sqpge.clickquotationgenerator();
		 Thread.sleep(2000);
		 logger.info("-------User click Quotation generator----------------");
		 sqpge.clicksqgaction();
		 Thread.sleep(2000);
		 logger.info("-------User click quotation action menu---------------");
		 sqpge.clickviewoption();
		 Thread.sleep(2000);
		 logger.info("-------User click View in action menu----------------");
		 sqpge.clicksqgpdf();
		 Thread.sleep(2000);
		 logger.info("-------User click Save as PDF----------------");
		 Thread.sleep(2000);
		 
	 }
	 @AfterMethod
	 public void Logout() throws InterruptedException
	 {
		/* File listOfFiles[] = folder.listFiles();
		  logger.info("==============make sure the file is not empty=========================");
	      Assert.assertTrue(listOfFiles.length>0);
	      Thread.sleep(2000);
	      logger.info("==============make sure that downloaded file is not empty=========================");
	      for(File file: listOfFiles){
	          Assert.assertTrue(file.length()>0);
	           }
	   for(File file:folder.listFiles())
	      {
	    	  file.delete();
	      }
	      folder.delete();*/
	 	  LogoutPage logout=new LogoutPage(driver);
	 	  logout.clickusericon();
	 	  logout.clickLogout();
	 	  Thread.sleep(2000);
	 }
}
