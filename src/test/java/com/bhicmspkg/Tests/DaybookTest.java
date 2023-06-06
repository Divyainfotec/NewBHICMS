package com.bhicmspkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.DayBookPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.Pages.PurchasePage;
import com.bhicmspkg.TestBase.TestBase;

public class DaybookTest extends TestBase{
	 Masterpage mstr;
	 DayBookPage daybookpge;
	 CompanyPage cmpnypge;
	 PurchasePage puchpge;
		private static Logger logger=LoggerHelper.getLogger(DaybookTest.class);
		
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
		 public void Daybook_AddEntries() throws InterruptedException, IOException
		 {
			 puchpge=new PurchasePage(driver);
			 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
			 logger.info("------click purchase Menu-----------");
			 Thread.sleep(2000);
			 logger.info("------click purchase Orders--------------------------");
			 puchpge.clickpurchasebill();
			 logger.info("------click purchase Bill--------------------------");
			 String lastbillno=puchpge.Getlastpubillno();
			Thread.sleep(2000);
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
			 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
			 mstr.clicksettingsmenu();
			 pjtpge.clicksettingspjt();
			 Thread.sleep(2000);
			 String pjtnme=pjtpge.getlastprojectname();
			 Thread.sleep(2000);
			 daybookpge=new DayBookPage(driver);
		 	 daybookpge.clickdaybook();
		 	Thread.sleep(2000);
		 	daybookpge.clickdaybookadd();
		 	Thread.sleep(2000);
		 	daybookpge.clickdaybookselcmpny();
		 	daybookpge.typevalue(cmpnyname);
		 	 Thread.sleep(2000);
		 	 daybookpge.seldayproject(pjtnme);
		 	 Thread.sleep(2000);
		 	 daybookpge.seldbbillno(lastbillno);
		 	 daybookpge.seldbtranshead("Cheque/Online Payment");
		 	 daybookpge.typedaybookdescr();
		 	 daybookpge.seldbpurtype("Full Paid");
		 	 daybookpge.seldbbank();
		 	 daybookpge.typechkno();
		 	Thread.sleep(2000);
		 	daybookpge.clickdbaddbtn();
		 	Thread.sleep(2000);
		 	if(daybookpge.resultbillno().equals(lastbillno))
		 	{
		 		logger.info("-------Daybook entries added successfully!!-----------");
		 		Assert.assertTrue(true);
		 	}
		 	else
		 	{
		 		logger.info("--------Daybook entries added failed!!----------");
		 		captureScreen(driver, "------Daybook entries added failed!!----------");
		 		Assert.assertTrue(false, "------Daybook entries added failed!!----------");
		 	}
		 }
public String Getlastcreatedpuno()
		 {
		 	return driver.findElement(By.xpath("//*[@id='fixtable']/tbody[1]/tr/td[2]/div")).getText();
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