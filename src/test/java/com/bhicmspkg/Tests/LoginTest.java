package com.bhicmspkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.TestBase.TestBase;


public class LoginTest extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(LoginTest.class);
	
  @Test
  public void Login() throws InterruptedException, IOException {
	  LoginPage bhilogin=new LoginPage(driver);
	  Config con=new Config(pr);
	  bhilogin.Login(con.Getusername(), con.Getpassword());
	  bhilogin.clickloginbtn();
	  Thread.sleep(4000);
	  loger.info("--------Login is doing------------");
	  boolean status=bhilogin.verifysuccessfull();
	  	  if(status==true){
	  		loger.info("==============login is sucessful=========================");
			Assert.assertTrue(true);
			Thread.sleep(2000);
			
			
			
		}
		else{
			captureScreen(driver,"loginTest");
			 // Assert.assertTrue(false);
			Assert.assertTrue(false, "==============login is not sucessful=========================");
		}
	  	//con.Geturl();
	 }
  @Test
  public void Verifytitle()
  {
	  String expectedtitle="Google";
	  Assert.assertTrue(driver.getTitle().equals(expectedtitle), "Expected and actual title is different.");
  }
  @AfterMethod
  public void Logout() throws InterruptedException
  {
	//  if(driver.findElement(By.xpath("//*[@id='myNavbar']//div//ul//li[2]")).isDisplayed())
	  //{
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
	  Thread.sleep(2000);
	  //}
	  /*else
	  {
		  driver.quit();
	  }*/
  }
}
