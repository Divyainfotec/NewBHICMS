package com.bhicmspkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.TestBase.TestBase;

public class CompanycreationTest extends TestBase {
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	private static Logger loger=LoggerHelper.getLogger(CompanycreationTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  bhilogin.clickloginbtn();
		  Thread.sleep(4000);
		  loger.info("--------Login is doing------------");
		  loger.info("==============login is sucessful=========================");
		 boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				
				loger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		  	
		}
	 @Test
	 public void CreateCompany() throws InterruptedException, AWTException
	 {
		 con=new Config(pr);
		  mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 loger.info("----------user click settings-----------");
		 cmppge=new CompanyPage(driver);
		 cmppge.clickcompany();
		 loger.info("----------user click company-----------");
		 Thread.sleep(2000);
		 Robot robo=new Robot();
		  robo.keyPress(KeyEvent.VK_CONTROL);
		  robo.keyPress(KeyEvent.VK_MINUS);
		  robo.keyRelease(KeyEvent.VK_CONTROL);
		  robo.keyRelease(KeyEvent.VK_MINUS);
		  robo.keyPress(KeyEvent.VK_CONTROL);
		  robo.keyPress(KeyEvent.VK_MINUS);
		  robo.keyRelease(KeyEvent.VK_CONTROL);
		  robo.keyRelease(KeyEvent.VK_MINUS);
		  Thread.sleep(3000);
		 cmppge.clickaddcompany();
		 Thread.sleep(2000);
		 loger.info("----------user click add company-----------");
			LocalDate Today_date=java.time.LocalDate.now();	
		// String companyname="BHI Test Company"+RandomStringUtils.randomAlphabetic(2)+"_"+ Today_date;
			//BHI Test Company
		 String companyname="BHI Test Company";
		 cmppge.typecompanynme(companyname);
		 loger.info("----------user type company name-----------");
		 Thread.sleep(2000);
		 cmppge.typecmpnypincode(67+RandomStringUtils.randomNumeric(4));
		 loger.info("----------user type company pincode-----------");
		 cmppge.typecmpnyphone(98698+RandomStringUtils.randomNumeric(4));
		 loger.info("----------user type company phone number-----------");
		 JavascriptHelper js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 cmppge.typecmpnyemail("bhiinfotech"+RandomStringUtils.randomAlphabetic(2)+"@email.com");
		 Thread.sleep(2000);
		 loger.info("----------user type company company email-----------");
		 cmppge.typecmpnyGSTno("BC"+RandomStringUtils.randomAlphabetic(3));
		 loger.info("----------user type company GST no-----------");
		 cmppge.typecmpnytolerance(RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 loger.info("----------user type company tolerance-----------");
		 cmppge.typesubcntrpaylmt(RandomStringUtils.randomNumeric(4));
		 Thread.sleep(2000);
		 loger.info("----------user type company subcntr payment limit-----------");
		 cmppge.clickcmpnypopermission();
		 loger.info("----------user click company PO permission-----------");
		// cmppge.typecmppurchseamnt(RandomStringUtils.randomNumeric(4));
		 //loger.info("----------user type company purchase amount-----------");
		       
	/*	 WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()="+subcntremailnot+"]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		       //Checking whether first attempt to check the check box worked
		        
		        if (!chkbox.isSelected()) {
		        	chkbox.click();
		        }
		    }*/
		 clicksubcontremailnot();
		 Thread.sleep(2000);
		loger.info("-----------click subcontractor email notification user----------------");
		 		// cmppge.clicksubcntremailnotification();
		// loger.info("----------user click subcntractor email notification-----------");
		clickPOemailnot();
		Thread.sleep(2000);
		 loger.info("----------user click PO email notification-----------");
		 cmppge.typedescription("company description");
		 Thread.sleep(2000);
		 loger.info("----------user type company description-----------");
		 cmppge.typecmpnyaddress("Orient Square, 2nd floor, Sahodaran Ayyappan Rd, Kadavanthra Junction, Kochi, Kerala 682020");
		 loger.info("----------user type company address-----------");
		 clickinvoiceemailnot();
		 Thread.sleep(2000);
		 loger.info("----------user click invoice email notification----------");
		 cmppge.clickcmpnycreatebtn();
		 loger.info("----------user click cmpny create button---------");
		 Thread.sleep(2000);
		 getcompanyname(companyname);
		 Thread.sleep(2000);
	 }
	 public void clicksubcontremailnot() throws InterruptedException
	 {

		 String subcntremailnot=con.Getcompanyusername();
		 int subcntrcnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li")).size();
		 
		 for(int i=1;i<=subcntrcnt;i++)
		 {
 		 String cmpnyuname=driver.findElement(By.xpath("//*[@id='Company_subco_email_userid']//li["+i+"]//label")).getText();
		// driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(cmpnyuname.equalsIgnoreCase(subcntremailnot))
		{
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Company_subco_email_userid']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	        chkbox.click();
	        Thread.sleep(2000);
		}
		 }
	 }
	 public void clickPOemailnot()
	 {

		 String subcntremailnot=con.Getcompanyusername();
		 int subcntrcnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_po_email_userid']//li")).size();
		 
		 for(int i=1;i<=subcntrcnt;i++)
		 {
 		 String cmpnyuname=driver.findElement(By.xpath("//*[@id='Company_po_email_userid']//li["+i+"]//label")).getText();
		// driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(cmpnyuname.equalsIgnoreCase(subcntremailnot))
		{
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Company_po_email_userid']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	        chkbox.click();
			
		}
		 }
	 }
	 public void clickinvoiceemailnot()
	 {

		 String subcntremailnot=con.Getcompanyusername();
		 int subcntrcnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_invoice_email_userid']//li")).size();
		 
		 for(int i=1;i<=subcntrcnt;i++)
		 {
 		 String cmpnyuname=driver.findElement(By.xpath("//*[@id='Company_invoice_email_userid']//li["+i+"]//label")).getText();
 		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(cmpnyuname.equalsIgnoreCase(subcntremailnot))
		{
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Company_invoice_email_userid']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	        chkbox.click();
			
		}
		 }
	 }
	 public void getcompanyname(String cmpname)
	 {
		 
		 List<WebElement> cmpnynames=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 for(WebElement we:cmpnynames)
		 {
			 try {
			if(cmpname.equals(we.getText()))
			{
			 System.out.println(we.getText());
			Assert.assertTrue(true);
			loger.info("------------company creation successfully!!!--------------------------");
			}}
			 catch(Exception ex)
			 {
				 Assert.assertTrue(false,"----------something went wrong, company cannot create-----------------------");
			 }
			
				
			 
		 }
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
