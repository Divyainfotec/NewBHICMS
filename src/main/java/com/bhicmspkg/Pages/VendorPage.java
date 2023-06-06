package com.bhicmspkg.Pages;

import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class VendorPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(VendorPage.class);
	
	public VendorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li//a[text()='Vendors']")public WebElement vendorsmenu;
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")public WebElement vendornames;
	@FindBy(xpath = "//li//a[text()='Vendor list']")public WebElement vendorslst;
	@FindBy(xpath = "//div//button[text()='Add Vendor']")public WebElement addvendor; 
	
	@FindBy(xpath="//*[@id='select2-vendor-results']//li[2]")public WebElement vendornmelst;
	@FindBy(xpath = "//*[@id='vendors-form']/div[1]/div[1]/div[1]/input[@name='Vendors[name]']")public WebElement vendorname;
	@FindBy(xpath="//input[@id='select_alltype']")public WebElement selallexpensetype;
	@FindBy(xpath="//*[@id='Vendors_gst_no']")public WebElement vendorgstno;
	
	@FindBy(xpath="//*[@id='Vendors_description']")public WebElement vendordescr;
	@FindBy(xpath="//*[@id='Vendors_address']")public WebElement vendoraddr;
	@FindBy(xpath="//*[@value='Create']")public WebElement vendorcreatebtn;
	@FindBy(xpath="//table[@id='vendortable']//tbody//tr[1]//td[9]//a")public WebElement vendoredit;
	@FindBy(xpath="//*[@id='vendors-form']/div[2]/input[1]")public WebElement vndrsavebtn;
	@FindBy(xpath = "//table[@id='vendortable']//tbody//tr[1]//td[2]")public WebElement editvndrnme;
	@FindBy(xpath="//li//a[text()='Vendor Payments']")public WebElement vndrpayment;
	@FindBy(xpath="//div[@class='clearfix']//button")public WebElement vndrpayaddentries;
	@FindBy(xpath="//*[@id='Dailyvendors_company_id']")public WebElement selvndrcmpny;
	@FindBy(xpath="//*[@id='Dailyvendors_project_id']")public WebElement selvndrpjt;
	 @FindBy(xpath="//*[@id='Dailyvendors_vendor_id']")public WebElement selvndrname;
	 @FindBy(xpath="//*[@id='Dailyvendors_payment_type']")public WebElement selpaytype;
	 @FindBy(xpath="//*[@id='Dailyvendors_bank']")public WebElement selbnknme;
	 @FindBy(xpath="//*[@id='Dailyvendors_cheque_no']")public WebElement ctypechkno;
	 @FindBy(xpath="//*[@id='Dailyvendors_amount']")public WebElement vndramnt;
	 @FindBy(xpath="//*[@id='Dailyvendors_description']")public WebElement vndrdescr;
	 @FindBy(xpath="//*[@id='buttonsubmit']")public WebElement vndrpaymntaddbtn;
	 @FindBy(xpath="//table[@id='fixTable']//tbody[1]//tr//td[13]")public WebElement vndraction;
	 @FindBy(xpath="//*[@class='popover-content']//li//button[text()='Edit']")public WebElement vndrpaymntedit;
	 @FindBy(xpath="//*[@class='text-right submit-button']//div//button[text()='UPDATE']")public WebElement vndrupdatebtn;
	 @FindBy(xpath="//*[@class='popover-content']//li//button[text()='Delete']")public WebElement vndrdelete;
	/*
	 *  
	 * 
	 @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement 
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 * @FindBy(xpath="")public WebElement
	 */
	public void clickvendorsmenu()
	{
		this.vendorsmenu.click();
	}
	public String Getvendorname()
	{
	String vendrname=vendornmelst.getText();
	return vendrname;
	}
	
	public void clickvendorslist()
	{
		this.vendorslst.click();
	}
	public void clickaddvendor()
	{
		this.addvendor.click();
	}
	public void typevendorname(String vendorname)
	{
		this.vendorname.clear();
		this.vendorname.sendKeys(vendorname);
	}
	public void clickallexpensetype()
	{
		this.selallexpensetype.click();
	}
	public void typevendorgst(String vendorgstno)
	{
		this.vendorgstno.sendKeys(vendorgstno);
	}
	public void typevndrdecsr(String vndrdescr)
	{
		this.vendordescr.sendKeys(vndrdescr);
	}
	public void typevndraddr(String vndraddr)
	{
		this.vendoraddr.sendKeys(vndraddr);
		
	}
	public void Clicklastcompany()//To chk chkbox of last company
	{
		List<WebElement>cmpelm=driver.findElements(By.xpath("//*[@id='Vendors_company_id']//li//input"));
		int cmpelmcnt=cmpelm.size();
		WebElement cmpnme=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+cmpelmcnt+"]//input"));
		if(!cmpnme.isSelected())
		{
			cmpnme.click();
		}
				
	}
	public void clickvndrcreate()
	{
		this.vendorcreatebtn.click();
	}
	//to get last vendorname
	public String Getlastvendorname()
	{
		List<WebElement>vndrlst=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		int vndrlstcnt=vndrlst.size();
		WebElement elem=driver.findElement(By.xpath("//table//tbody//tr["+vndrlstcnt+"]//td[2]"));
		String vendorname=elem.getText();
		return vendorname;
	}
	public void clickvndredit()
	{
		this.vendoredit.click();
	}
	public void clickvndrsavebtn()
	{
		this.vndrsavebtn.click();
	}
	public String Getvndrname()
	{
		String vndrname=this.editvndrnme.getText();
		return vndrname;
	}
	public void clickvndrpayment()
	{
		this.vndrpayment.click();
	}
	public void clickaddentries()
	{
		this.vndrpayaddentries.click();
	}
	public void selvndrcmpny(String cmpny)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvndrcmpny, cmpny);
	}
	public void selvndrpjt(String project)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvndrpjt, project);
	}
	public void selvndrname(String vndrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvndrname, vndrname);
	}
	public void selcompany(String cmpnyname)
	{
		List<WebElement>cmpnames=driver.findElements(By.xpath("//*[@id='Vendors_company_id']//li//input"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String cmpname=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+i+"]//label")).getText();
			if(cmpname.equals(cmpnyname))
			{
				WebElement elem=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+i+"]//input"));
				
				if(elem.getAttribute("checked")==null)
				{
					elem.click();
				}
			}
		}
	}
	public void selpaymnttype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selpaytype, 1);
	}
	public void selbank(String bnknme)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selbnknme, bnknme);
	}
	public void typechkno(String chqno)
	{
		this.ctypechkno.sendKeys("chqno"+RandomStringUtils.randomNumeric(3));
	}
	public void typeamnt()
	{
		this.vndramnt.clear();
		this.vndramnt.sendKeys(RandomStringUtils.randomNumeric(1));
	}
	public void typedescription()
	{
		this.vndrdescr.sendKeys("-----vndr descr-------------");
	}
	public void clickaddbtn()
	{
		this.vndrpaymntaddbtn.click();
	}
	public void clickvndraction()
	{
		this.vndraction.click();
	}
	public void clickvndrpayedit()
	{
		this.vndrpaymntedit.click();
	}
	public void clickupdatebtn()
	{
		this.vndrupdatebtn.click();
	}
	public void clickdvndrpaymntelete()
	{
		this.vndrdelete.click();
	}
	
}














