package com.bhicmspkg.Pages;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhicmspkg.Helper.DropdownHelper;
import com.bhicmspkg.Helper.GenericHelper;
import com.bhicmspkg.Helper.JavascriptHelper;
import com.bhicmspkg.Helper.LoggerHelper;

public class SubcontractorPage {

	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(SubcontractorPage.class);
	public SubcontractorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*   @FindBy(xpath="")public WebElement 
	 * @FindBy(xpath="")public WebElement 
	 * 
	 *   @FindBy(xpath="")public WebElement 
	 * @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 * @FindBy(xpath="")public WebElement 
	 *  @FindBy(xpath="")public WebElement 
	 * 
	 * @FindBy(xpath="")public WebElement 
	
	 */
	
	@FindBy(xpath="//li//a[text()='Sub Contractors']")public WebElement subcntrmenu;
	@FindBy(xpath="//li//a[text()='Sub Contractor list']")public WebElement subcntrlst;
	@FindBy(xpath="//div//button[text()='Add Sub Contractor']")public WebElement addsubcntrbtn;
	@FindBy(xpath="//form[@id='subcontractor-form']//input[@id='Subcontractor_subcontractor_name']")public WebElement subcntrnme;
	@FindBy(xpath="//input[@id='Subcontractor_subcontractor_phone']")public WebElement subcntrphone;
	@FindBy(xpath="//input[@id='Subcontractor_subcontractor_email']")public WebElement subcntremail;
	@FindBy(xpath="//*[@id='Subcontractor_subcontractor_description']")public WebElement subcntrdescr;
	@FindBy(xpath="//*[@id='select_alltype']")public WebElement subcntrexphead;
	@FindBy(xpath="//*[@id='Subcontractor_gst_no']")public WebElement subcntrgstno;
	@FindBy(xpath="//*[@value='Create']")public WebElement subcntrcreatebtn;
	 @FindBy(xpath="//table[@id='subcontable']//tbody//tr//td[7]//a")public WebElement subcntredit;
	 @FindBy(xpath="//*[@value='Save']")public WebElement subcntrsavebtn;
	  @FindBy(xpath="//li//a[text()='Sub Contractor Quotations']")public WebElement subcntrquotation;
	  @FindBy(xpath="//div//a[text()='Add Quotation']")public WebElement addquotationbtn;
	  @FindBy(xpath="//*[@id='Scquotation_company_id']")public WebElement selsubcntrcmpny;
	  @FindBy(xpath="//*[@id='Scquotation_project_id']")public WebElement selsubcntrpjt;
	  @FindBy(xpath="//*[@id='Scquotation_subcontractor_id']")public WebElement subcntrname;
	  @FindBy(xpath="//*[@id='Scquotation_scquotation_no']")public WebElement scquotationno;
	  @FindBy(xpath="//*[@id='Scquotation_expensehead_id']")public WebElement selexpensehead;
	  @FindBy(xpath="//*[@id='Scquotation_completion_date']")public WebElement subcntrcompletiondate;
	  @FindBy(xpath="//*[@id='Scquotation_scquotation_decription']")public WebElement subscrqtndescr;
	  @FindBy(xpath="//*[@id='ScquotationPaymentEntries_amount']")public WebElement  subcntramnt; 
	  @FindBy(xpath="//button[text()='Add New']")public WebElement addnewsubcontritm;
	  @FindBy(xpath="//input[@id='ScquotationPaymentEntries_payment_title']")public WebElement subcntrpaytitle;
	  @FindBy(xpath="//input[@value='Add']")public WebElement amntadd;
	  @FindBy(xpath="//*[@id='subqtntbl']//tbody//tr[1]//td[12]//span")public WebElement  subcntractionmenu;
	  @FindBy(xpath="//table[@id='subqtntbl']//tbody[1]//tr[1]//td[12]//div[1]//ul[1]//li[1]//a")public WebElement subcntrquotedit;
	  @FindBy(xpath="//*[@id='ScQuotationItemCategory_main_title']")public WebElement subcntrctgry;
	  @FindBy(xpath="//*[@id='items_list']/div/div[3]/div[1]/div/div[2]/i")public WebElement subcntritmadd;
	  @FindBy(xpath="//div[@id='cke_3_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")public WebElement itmdescr;
	  @FindBy(xpath="//*[@id='ScquotationItems_item_type']")public WebElement selsubcntritm;
	  @FindBy(xpath="//input[@id='ScquotationItems_item_quantity']")public WebElement itmquantity;
	  @FindBy(xpath="//input[@id='ScquotationItems_item_unit']")public WebElement itmunit;
	  @FindBy(xpath="//input[@id='ScquotationItems_item_rate']")public WebElement itmrate;
	  @FindBy(xpath="//input[@id='ScquotationItems_item_amount']")public WebElement itmamnt;
	  @FindBy(xpath="//div[@class='text-center mt']//button[@id='0']")public WebElement savebtn;
	  @FindBy(xpath="//*[@id='item_table']//tbody//tr[1]//td[8]//span")public WebElement subcntritmactionmenu;
	  //Approve
	  @FindBy(xpath="//*[@id='total_sum']")public WebElement totalamnt;
	  @FindBy(xpath="//*[@id='item_table']//tbody//tr[1]//td[8]//div[@class='popover-content']//ul//li[3]") public WebElement subcntrapprovebtn;
	  //Payment
	  @FindBy(xpath="//li//a[text()='Sub Contractor Payments']")public WebElement subcntrpaymnts; 
	  @FindBy(xpath="//*[@id='dailyformbutton']")public WebElement addentries;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_company_id']")public WebElement selsubcntrpaymntcmpny;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_subcontractor_id']")public WebElement subcntrpaymntname;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_project_id1']")public WebElement selsubcntrpaymntpjt;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_quotation_number1']")public WebElement subcntrquotno;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_amount1']")public WebElement subcntrpamntamnt;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_payment_type']")public WebElement subcntrpaymnttype;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_bank']")public WebElement subcntrpamntbanknme;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_cheque_no']")public WebElement subcntrpaymntchqno;
	  @FindBy(xpath="//*[@id='SubcontractorPayment_description']")public WebElement subcntrpaymntdescr;
	  @FindBy(xpath="//*[@id='buttonsubmit']")public WebElement subcntrpaymntaddbutton;
	  @FindBy(xpath="//button[text()='Approve']")public WebElement subcntrpaymntapprovebtn;
	  @FindBy(xpath="//li//a[text()='Sub Contractor Bill']")public WebElement subcntrbill;
	//subcntrbill
	  @FindBy(xpath="//div//a[text()='Add New']")public WebElement AddNewbtn;
	  @FindBy(xpath="//*[@id='Subcontractorbill_company_id']")public WebElement subcntrbillcompany;
	  @FindBy(xpath="//*[@id='project_id']")public WebElement selsubcntrbillpjt;
	  @FindBy(xpath="//*[@id='subcontractor_id']")public WebElement  selsubcntrbillcntrname;
	  @FindBy(xpath="//*[@id='Subcontractorbill_scquotation_id']")public WebElement  selsubcntrbillquotno;
	  @FindBy(xpath="//*[@id='Subcontractorbill_bill_number']")public WebElement subcntrbillno;
	  @FindBy(xpath="//*[@id='Subcontractorbill_date']")public WebElement subcntrbilldate;
	  @FindBy(xpath="//*[@id='submitButton']")public WebElement  subcntrbillcreatebtn;
	public void clicksubcntrmenu()
	{
		this.subcntrmenu.click();
	}
	public void clicksubcntrlst()
	{
		this.subcntrlst.click();
	}
	public void clickaddsubcntrbtn()
	{
		this.addsubcntrbtn.click();
	}
	public String Getsubcontrname()
	{
		List<WebElement>subcntrlst=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		int subcntrlstcnt=subcntrlst.size();
		WebElement elem=driver.findElement(By.xpath("//table//tbody//tr["+subcntrlstcnt+"]//td[2]"));
		String subcntrname=elem.getText();
		return subcntrname;
	}
	public void typesubcntrnme(String Subcntrname)
	{
		this.subcntrnme.clear();
		this.subcntrnme.sendKeys(Subcntrname);
	}
	public void typesubcntrphone( String subcntrphone)
	{
		this.subcntrphone.sendKeys(subcntrphone);
	}
	public void typesubcntremail()
	{
		this.subcntremail.sendKeys(RandomStringUtils.randomAlphabetic(4)+"@bhi.com");
	}
	public void typesubcntrdescr()
	{
		this.subcntrdescr.sendKeys("----subcntr description------------");
	}
 public void clicksubexphead()
 {
	 this.subcntrexphead.click();
 }
 public void typesubcntrgstno()
 {
	 this.subcntrgstno.sendKeys(RandomStringUtils.randomAlphanumeric(5));
 }
 public void Clicklastcompany()//To chk chkbox of last company
	{
		List<WebElement>cmpelm=driver.findElements(By.xpath("//*[@id='Subcontractor_company_id']//li//input"));
		int cmpelmcnt=cmpelm.size();
		WebElement cmpnme=driver.findElement(By.xpath("//*[@id='Subcontractor_company_id']//li["+cmpelmcnt+"]//input"));
		if(!cmpnme.isSelected())
		{
			cmpnme.click();
		}
				
	}
 public void clickcreatebtn()
 {
	 this.subcntrcreatebtn.click();
 }
 public void clicksubcntredit() throws InterruptedException
 {
	 List<WebElement>subcntrlst=driver.findElements(By.xpath("//table[@id='subcontable']//tbody//tr//td[7]//a"));
		int subcntrlstcnt=subcntrlst.size();
		WebElement editelem=driver.findElement(By.xpath("//table[@id='subcontable']//tbody//tr["+subcntrlstcnt+"]//td[7]//a"));
		js=new JavascriptHelper(driver);
		js.scrollToElemet(editelem);
	    editelem.click();	
	 Thread.sleep(2000);
 }
 public void clicksavesubcntrbtn()
 {
	 this.subcntrsavebtn.click();
	 logger.info("-----save button is clicked-----------");
 }
 public void clicksubcontractorquotation()
 {
	 this.subcntrquotation.click();
 }
 public void clickaddquotation()
 {
	 this.addquotationbtn.click();
 }
 public void selsubcntrcmpny(String cmpny)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntrcmpny, cmpny);
 }
 public void selsubcntrpjt(String pjt)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntrpjt, pjt);
 }
 public void selsubcntrname(String subcntrnme)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.subcntrname, subcntrnme);
 }
 public void typescquotationno(String scqno)
 {
	 this.scquotationno.sendKeys(scqno);
 }
 public void selsubcntrexphead()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingIndex(this.selexpensehead, 2);
 }
 public void typesubcntrqtndate()
 {
	 LocalDate Today_date=java.time.LocalDate.now();
	 this.subcntrcompletiondate.sendKeys(Today_date.toString());
 }
 public void typesubcntrqtndescr()
 {
	 this.subscrqtndescr.sendKeys("---subcontractor quotation----");
	 this.subscrqtndescr.sendKeys(Keys.TAB);
 }
 public void typesubcntamnt()
 {
	 this.subcntramnt.sendKeys("2000");
 }
 public void clickaddnewsubcontritm()
 {
	 this.addnewsubcontritm.click();
 }
 public void clickaddamntbtn()
 {
	 this.amntadd.click();
 }
 public void clickpaymnttitle()
 {
	 this.subcntrpaytitle.sendKeys("subcntrpaymnttitle"+RandomStringUtils.randomAlphabetic(2));
 }
 public void clicksubcntractmenu()
 {
	 this.subcntractionmenu.click();
 }
 public void clicksubcntrqtedit()
 {
	 this.subcntrquotedit.click();
 }
 public void typesubcntrcategory()
 {
	 this.subcntrctgry.sendKeys("ctgry"+RandomStringUtils.randomAlphabetic(2));
	 this.subcntrctgry.sendKeys(Keys.TAB);
	
 }
 public void clicksubcntritemadd()
 {
	// this.subcntrctgry.sendKeys(Keys.TAB);
	 this.subcntritmadd.click();
 }
 public void typeitmdescr()
 {
	 driver.switchTo().frame(2);
	 logger.info("------------switching to meeting frame----------------------");
	 WebElement el  =  driver.switchTo().activeElement();
	 new Actions(driver).moveToElement(el).perform();
	 driver.findElement(By.xpath("/html/body")).sendKeys("SS Stand");
	 driver.switchTo().defaultContent();
	 
	// driver.switchTo().frame(3);
	 //this.itmdescr.sendKeys("SS stand");
 }
 public void selsubitmtype()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntritm, "Qty*rate");
 }
 public void typeitmquantity()
 {
	 this.itmquantity.sendKeys("1");
 }
 public void typeitmunit()
 {
	 this.itmunit.sendKeys("nos");
 }
 public void typeitmrate()
 {
	 this.itmrate.sendKeys("200");
 }
 public void typeitmamnt()
 {
	 this.itmamnt.clear();
	 this.itmamnt.sendKeys("300");
 }
 public void clicksavebtn()
 {
	 this.savebtn.click();
 }
 public void clicktotalamnt()
 {
	 this.totalamnt.click();
 }
 public void clicksubcntritmactmnu()
 {
	 this.subcntritmactionmenu.click();
 }
 public void clicksubcntritmapprbtn()
 {
	 this.subcntrapprovebtn.click();
 }
 public void clicksubcntrpaymnt()
 {
	 this.subcntrpaymnts.click();
 }
 public void clickaddentries()
 {
	 this.addentries.click();
 }
 public void selsubcntrpaycmpny(String company)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(selsubcntrpaymntcmpny, company);
 }
 public void selsubcntrpaymntnme(String subcntrname)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.subcntrpaymntname, subcntrname);
 }
 public void selsubcntrpaymntpjtnme(String pjtnme)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntrpaymntpjt, pjtnme);
 }
 public String Getsubcontrquotationno()
	{
		WebElement elem=driver.findElement(By.xpath("//table//tbody//tr[1]//td[7]"));
		String subcntrquotno=elem.getText();
		return subcntrquotno;
	}
 public String Getsubcontrquotationamnt()
	{
		WebElement elem=driver.findElement(By.xpath("//table//tbody//tr[1]//td[10]"));
		String subcntrquotno=elem.getText();
		return subcntrquotno;
	}
 public void selsubcntrquotno(String subcntrquotno)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.subcntrquotno, subcntrquotno);
 }
 public void typesubcntrpaymntamnt(String amnt)
 {
	 this.subcntrpamntamnt.sendKeys(amnt);
 }
 public void selsubcntrpaymnttype()
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingIndex(this.subcntrpaymnttype, 1);
 }
 public void selsubcntrpaymntbnknme(String bnknme)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.subcntrpamntbanknme, bnknme);
 }
 public void typesubcntrchqno()
 {
	 this.subcntrpaymntchqno.sendKeys("chqno"+RandomStringUtils.randomNumeric(3));
 }
 public void typesubcntrpaymntdescr()
 {
	 this.subcntrpaymntdescr.sendKeys("-------payment description------------");
 }
 public void clicksubcntrpaymntaddbtn()
 {
	 this.subcntrpaymntaddbutton.click();
 }
 public void clicksubcntrpaymntapprbtn()
 {
	 this.subcntrpaymntapprovebtn.click();
 }
 public void clicksubcntrbill()
 {
	 this.subcntrbill.click();
 }
 public void clickaddnew()
 {
	 this.AddNewbtn.click();
 }
 public void selsubcntrbillcmpny(String cmpny)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.subcntrbillcompany, cmpny);
 }
 public void selsubcntrbillpjt(String pjtname)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntrbillpjt, pjtname);
 }
 public void selsubcntrbillcntrname(String subcntrname)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntrbillcntrname, subcntrname);
 }
 public void selsubcntrbillquotno(String scquotno)
 {
	 DropdownHelper dpsel=new DropdownHelper(driver);
	 dpsel.SelectUsingVisibleText(this.selsubcntrbillquotno, scquotno);
 }
 public void typesubcntrbillno(String subcntrbillno)
 {
	 this.subcntrbillno.sendKeys(subcntrbillno);
 }
 public String Getsubcontrbillno()
	{
		WebElement elem=driver.findElement(By.xpath("//table//tbody//tr[1]//td[6]"));
		String subcntrbillno=elem.getText();
		return subcntrbillno;
	}
 public void typesubcntrbilldate()
 {
	 LocalDate Today_date=java.time.LocalDate.now();
	 this.subcntrbilldate.sendKeys(""+Today_date);
 }
 public void clicksubcntrbillcreatebtn()
 {
	 this.subcntrbillcreatebtn.click();
 }
 //
}
