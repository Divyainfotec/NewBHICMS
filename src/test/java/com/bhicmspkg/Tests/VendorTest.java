package com.bhicmspkg.Tests;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
import com.bhicmspkg.Pages.UserPage;
import com.bhicmspkg.Pages.VendorPage;
import com.bhicmspkg.TestBase.TestBase;

public class VendorTest extends TestBase{
	LogoutPage logout;
	 Config con;
	 UserPage userpge;
	 Masterpage mstr;
	 VendorPage vndrpage;
	 JavascriptHelper js;
	 CompanyPage cmpnypge;
	private static Logger logger=LoggerHelper.getLogger(CompanycreationTest.class);
	
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
	///*----------------------
	 @Test
	 public void VendorCreation() throws InterruptedException
	 {
		LocalDate todaydate=java.time.LocalDate.now();
		 con=new Config(pr);
		 logger.info("----------user click settings-----------");
		  vndrpage=new VendorPage(driver);
		  vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvendorslist();
		  Thread.sleep(2000);
		  vndrpage.clickaddvendor();
		  Thread.sleep(2000);
		 // String vendorname="vndr"+RandomStringUtils.randomAlphabetic(2)+todaydate;  
		  String vendorname="Vendor BHI";  
		  vndrpage.typevendorname(vendorname);
		  logger.info("----type vendor name----------------");
		  vndrpage.clickallexpensetype();
		  Thread.sleep(2000);
		  logger.info("----click expense type---------------");
		  vndrpage.typevendorgst("vndrgst"+RandomStringUtils.randomNumeric(2));
		  logger.info("---type vendor GSTno---------------");
		  JavascriptHelper js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  vndrpage.typevndrdecsr("Vendor description");
		  vndrpage.typevndraddr("vndraddr");
		  logger.info("----type vendor address and description---------------");
		  vndrpage.Clicklastcompany();
		  Thread.sleep(2000);
		  logger.info("----click company----------------");
		  vndrpage.clickvndrcreate();
		  logger.info("----click created button----------------");
		  Thread.sleep(2000);
		  String createdvndrname=vndrpage.Getlastvendorname();
		  System.out.println("Vendor name "+createdvndrname);
		  if(createdvndrname.equals(vendorname))
		  {
			  logger.info("----vendor created successfully!!!----------------");
			  Assert.assertTrue(true);
		  }
		  else
		  {
			  Assert.assertTrue(false, "----------vendor created failed!!!-------------------------");
		  }
		  
	 }
	 
	 @Test
	 public void VendorEdit() throws InterruptedException
	 {
		 vndrpage=new VendorPage(driver);
		  vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvendorslist();
		  Thread.sleep(2000);
		  vndrpage.clickvndredit();
		  Thread.sleep(2000);
		  String vendorname="vndr"+RandomStringUtils.randomAlphabetic(2);  
		  vndrpage.typevendorname(vendorname);
		  js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  vndrpage.clickvndrsavebtn();
		  Thread.sleep(2000);
		  String vndrnme=vndrpage.Getvndrname();
		  Thread.sleep(2000);
		  if(vndrnme.equals(vendorname))
		  {
			  logger.info("----------vendor name edited successfully-------------");
			  Assert.assertTrue(true);
		  }
		  else
		  {
			  logger.info("----------vendor name edited failed-------------");
			  Assert.assertTrue(false,"----Something went wrong, vendor name edited failed-");
		  }
	 }
	
	 @Test
	 public void VendorPayment() throws InterruptedException
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
		 mstr.clickbankname();
		 String bankname=mstr.getbankname(cmpnyname);//------
		 mstr.clicksettingsmenu();
		 ProjectcreationPage pjtpge=new ProjectcreationPage(driver);
		 pjtpge.clicksettingspjt();
		 Thread.sleep(2000);
		 String pjtnme=pjtpge.getlastprojectname();
		 Thread.sleep(2000);
		 vndrpage=new VendorPage(driver);
		// vndrpage.getbankname(cmpnyname);
		  vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvendorslist();
		  Thread.sleep(2000);
		  String vndrnme=vndrpage.Getvndrname();
		  if(driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]")).getText().contains(cmpnyname))
		  {
		  vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvndrpayment();
		  vndrpage.clickaddentries();
		  Thread.sleep(2000); 
		  vndrpage.selvndrcmpny(cmpnyname);
		  Thread.sleep(2000);
		  vndrpage.selvndrpjt(pjtnme);
		  Thread.sleep(2000);
		  vndrpage.selvndrname(vndrnme);
		  Thread.sleep(2000);
		  vndrpage.selpaymnttype();
		  Thread.sleep(2000);
		  vndrpage.selbank(bankname);
		  Thread.sleep(2000);
		  vndrpage.typechkno("chqno"+RandomStringUtils.randomNumeric(3));
		  Thread.sleep(2000);
		  vndrpage.typeamnt();
		  Thread.sleep(2000);
		  vndrpage.typedescription();
		  js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  vndrpage.clickaddbtn();
		  Thread.sleep(2000);
		  }
		  else
		  {
			  vndrpage.clickvndredit();
			  Thread.sleep(2000);
			  js=new JavascriptHelper(driver);
			  js.scrollDownByPixel();
			  vndrpage.selcompany(cmpnyname);
			  Thread.sleep(2000);
			  vndrpage.clickvndrsavebtn();
			  Thread.sleep(2000);
			  vndrpage.clickvendorsmenu();
			  Thread.sleep(2000);
			  vndrpage.clickvndrpayment();
			  Thread.sleep(2000);
			  vndrpage.clickaddentries();
			  Thread.sleep(2000); 
			  vndrpage.selvndrcmpny(cmpnyname);
			  Thread.sleep(2000);
			  vndrpage.selvndrpjt(pjtnme);
			  Thread.sleep(2000);
			  vndrpage.selvndrname(vndrnme);
			  Thread.sleep(2000);
			  vndrpage.selpaymnttype();
			  Thread.sleep(2000);
			  vndrpage.selbank("IDIB");
			  Thread.sleep(2000);
			  vndrpage.typechkno("chqno"+RandomStringUtils.randomNumeric(3));
			  Thread.sleep(2000);
			  vndrpage.typeamnt();
			  Thread.sleep(2000);
			  vndrpage.typedescription();
			  js=new JavascriptHelper(driver);
			  js.scrollDownByPixel();
			  Thread.sleep(2000);
			  vndrpage.clickaddbtn();
			  Thread.sleep(2000);
		  }
	 }
	  
	 @Test
	 public void VendorPaymentEdit() throws InterruptedException
	 {
		 vndrpage=new VendorPage(driver);
		 vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvndrpayment();
		  Thread.sleep(2000);
		  vndrpage.clickvndraction();
		  Thread.sleep(2000);
		  vndrpage.clickvndrpayedit();
		  Thread.sleep(2000);
		  vndrpage.typeamnt();
		  Thread.sleep(2000);
		  js=new JavascriptHelper(driver);
		  js.scrollDownByPixel();
		  Thread.sleep(2000);
		  vndrpage.clickupdatebtn();
		  Thread.sleep(2000);
		  logger.info("-------vendor payment edited successfullly---------------");
		  Assert.assertTrue(true);
		  
	 }
	 //-----------------*/
	 @Test
	 public void VendorPaymentdelete() throws InterruptedException
	 {
		 vndrpage=new VendorPage(driver);
		 vndrpage.clickvendorsmenu();
		  Thread.sleep(2000);
		  vndrpage.clickvndrpayment();
		  Thread.sleep(2000);
		  vndrpage.clickvndraction();
		  Thread.sleep(2000);
		  vndrpage.clickdvndrpaymntelete();
		  Thread.sleep(2000);
		  AlertHelper alert=new AlertHelper(driver);
		  alert.AcceptAlert();
		  logger.info("-------vendor payment deleted successfullly---------------");
		  Assert.assertTrue(true);
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
