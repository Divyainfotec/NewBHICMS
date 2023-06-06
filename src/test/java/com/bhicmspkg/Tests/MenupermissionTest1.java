package com.bhicmspkg.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;
import com.bhicmspkg.Config.Config;

import com.bhicmspkg.Pages.LoginPage;
import com.bhicmspkg.TestBase.TestBase;

import com.bhicmspkg.Pages.LogoutPage;
import com.bhicmspkg.Pages.MenupermissionPage1;
import com.bhicmspkg.TestBase.TestBase;

public class MenupermissionTest1 extends TestBase {
	private static Logger loger=LoggerHelper.getLogger(MenupermissionTest1.class);
	LoginPage  bhilogin;
	 Config  con;
	 //AMSPage amspg;
	
	 @BeforeMethod
		public void GetAMS_Login() 
		{
			con=new Config(pr); 
			bhilogin=new LoginPage(driver);
		  //  bhilogin.Login(con.Getusername(),con.Getpassword());
		    loger.info("--------Login is doing------------");
		   
		    loger.info("==============login is sucessful=========================");
	  	}
  @Test
  public void Setpermission() throws InterruptedException
  {
	  JavascriptHelper js=new JavascriptHelper(driver);
	  
	  MenupermissionPage1 menupg=new MenupermissionPage1(driver);
	  menupg.clickSettingsmenu();
	  Thread.sleep(2000);
	  menupg.clickmenupermission();
	  Thread.sleep(2000);
	 String userbeforepath= "//*[@id='userslist']//li//a[text()='";
	 String userafterpath=" ']";
	// String user_permission=con.Getsiteusername();
	// String uname="JUVAN";
	// menupg.typeusername(user_permission);
	 Thread.sleep(2000);
	 //System.out.println(user_permission);//*[@id='userslist']//ul//li//a[text()='Bezy ']
	 //Thread.sleep(2000);
	// WebElement user_elm= driver.findElement(By.xpath(userbeforepath+user_permission+userafterpath));
	
	 try {
		 //user_elm.click();
	     //if(!user_elm.isSelected())
		      {				
				
				// js.scrollDownByPixel();
				// Thread.sleep(2000);
		 	     //js.executeScript("window.scrollBy(0, 40)", user_elm);
		 	     Thread.sleep(2000);
		 	     //user_elm.click();
		 	     Thread.sleep(2000);
			 }
		}
	 catch (Exception e)
	 {

		 js.scrollUpByPixel();
		 Thread.sleep(2000);
		// user_elm.click();
		 Thread.sleep(2000);
	 }
	 Thread.sleep(3000);
	 loger.info("==============selected user=========================");
	 menupg.checkallpermission();
	 Thread.sleep(3000);
	 loger.info("==============user give all permission=========================");
	 Thread.sleep(3000);
	 WebElement scrolltop=driver.findElement(By.xpath("//*[@class='icon-arrow-up']"));
	 waitForElementWithPollingInterval(driver, 3000, scrolltop);
	 menupg.clickscroltotop();
	 Thread.sleep(2000);
	 menupg.clicksavebutton();
	 loger.info("==============user clicked save button=========================");
	 Thread.sleep(2000);
	 menupg.clickAlert();
	 Thread.sleep(2000);
	 loger.info("==============user accepted alert=========================");
	 menupg.clickAlert();
	 Thread.sleep(4000);
	 loger.info("==============menu permission set successfully for a specified user =========================");
	//JavascriptHelper jsscroll=new JavascriptHelper(driver);
	//jsscroll.scrollDownByPixel();
	//jsscroll.executeScript("arguments[0].scrollIntoView(true);", user_elm);
	
//	jsscroll.scrollToElemetAndClick(user_elm);
	//jsscroll.scrollIntoView(user_elm);
	
	//
	//////WebDriverWait wait = new WebDriverWait(driver, 5);
	//wait.until(ExpectedConditions.visibilityOf(user_elm));
	//jsscroll.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", user_elm);
//	jsscroll.executeScript("arguments[0]. scrollIntoView(true);", user_elm);
	//jsscroll.executeScript("window.scrollBy(0, 20)", "");
	//jsscroll.scrollToElemet(user_elm);
	//Thread.sleep(2000);
	
	
	// jsscroll.scrollUpByPixel();
	 
	// jsscroll.scrollDownByPixel();
	// jsscroll.scrollToElemet(user_elm);
	//jsscroll.scrollIntoView(user_elm);
	
    //jsscroll.scrollUpByPixel();
	//menupg.clickscroltotop();
	
	
	// jsscroll.scrollToElemetAndClick(user_elm);
	 
	// driver.findElement(By.xpath(userbeforepath+user_permission+userafterpath)).click();
	
	
  }
  @AfterMethod
  public void Logout()
  {
	  LogoutPage logout=new LogoutPage(driver);
	//  logout.clickusericon();
	  logout.clickLogout();
  }
}
