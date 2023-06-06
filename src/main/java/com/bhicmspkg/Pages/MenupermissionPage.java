package com.bhicmspkg.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Config.Config;
import com.bhicmspkg.Helper.AlertHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class MenupermissionPage {
	WebDriver driver;
	Properties pr=new Properties();
	//Config con=new Config(pr);
	private final Logger logger=LoggerHelper.getLogger(MenupermissionPage.class);
	public MenupermissionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
		@FindBy(xpath = "//li//a[text()='Settings']") public WebElement settingsmenu;
		@FindBy(xpath = "//li//a[text()='Menu Permissions']") public WebElement menupermission;
		@FindBy(xpath = "//*[@id='savebtn']") public WebElement savebutton;
		@FindBy(xpath ="//*[@class='icon-arrow-up']")public WebElement scrolltotop;
		
		public void clicksettings()
		{
			this.settingsmenu.click();
	
		}
		public void clickmenupermission()
		{
			this.menupermission.click();
		}
		public void clickuser(String uname)
		{
			String beforepath="//*[@id='userslist']//ul//li//a[contains(text(),'";
			String afterpath="')]";
			WebElement elm=driver.findElement(By.xpath(beforepath+uname+afterpath));
			JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollToElemet(elm);
			driver.findElement(By.xpath(beforepath+uname+afterpath)).click();
		}
		public void checkallpermission() throws InterruptedException
		{
			List<WebElement>permissionlist=driver.findElements(By.xpath("//*[@class='grid']//table//th//input"));
			for(int i=0;i<=permissionlist.size();i++)
			{
				Iterator<WebElement>we=permissionlist.iterator();
				while(we.hasNext())
				{
					WebElement webel=we.next();
					if(!webel.isSelected())
					{
						try {
						JavascriptHelper js=new JavascriptHelper(driver);
						js.scrollUpByPixel();
						if(!webel.isSelected())
						{
							js.scrollUpByPixel();
						}
						//js.scrollToElemet(webel);
						webel.click();
						}
						catch(Exception weException)
						{
							JavascriptHelper js=new JavascriptHelper(driver);
							js.executeScript("window.scrollBy(0, 43)", webel);
							webel.click();
						}
					}
					
				}
				
			}
       }
		public void clickscroltotop()
		{
			//this.scrolltotop.click();
			JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollUpByPixel();
		}
		public void clicksavebutton()
		{
			this.savebutton.click();
			logger.info("----------------click save button---------------------");
		}
		public void clickAlert()
		{
			AlertHelper alertpermission=new AlertHelper(driver);
			alertpermission.getAlert();
			alertpermission.AcceptAlertIfPresent();
			logger.info("-------Accept alert----------");
			JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollUpByPixel();
		}
}
