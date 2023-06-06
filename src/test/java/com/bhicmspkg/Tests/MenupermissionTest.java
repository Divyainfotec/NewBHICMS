package com.bhicmspkg.Tests;

import java.awt.Robot;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;

import com.bhicmspkg.Pages.CompanyPage;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.Masterpage;
import com.bhicmspkg.Pages.MenupermissionPage;
import com.bhicmspkg.Pages.ProjectcreationPage;
import com.bhicmspkg.TestBase.TestBase;

public class MenupermissionTest extends TestBase{
	Masterpage mstr;
	 CompanyPage cmppge;
	 Robot robo;
	 LogoutPage logout;
	 Config con;
	 ProjectcreationPage pjtpge;
	private static Logger logger=LoggerHelper.getLogger(MenupermissionTest.class);
	
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
			Assert.assertTrue(false, "==============login is not sucessful=========================");
		}
		  
	 }
	 @Test
	 public void MenuPermission() throws InterruptedException
	 {
		 con=new Config(pr);
		 MenupermissionPage mpge=new MenupermissionPage(driver);
		 mpge.clicksettings();
		 logger.info("---------user click settings menu--------------");
		 mpge.clickmenupermission();
		 Thread.sleep(4000);
		 logger.info("--------user click menu permission --------------------------");
		 mpge.clickuser(con.Getcompanyusername());
		 Thread.sleep(2000);
		 logger.info("---------user click the selected user--------------------");
		 mpge.checkallpermission();
		 logger.info("---------user click all the permissions--------------------");
		 Thread.sleep(5000);
		//mpge.clickscroltotop();
		 JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollUpByPixel();
		Thread.sleep(2000);
		 mpge.clicksavebutton();
		 Thread.sleep(2000);
		  mpge.clickAlert();
		  Thread.sleep(2000);
	 }
}
