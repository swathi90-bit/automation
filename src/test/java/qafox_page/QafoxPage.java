package qafox_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import qafox_base.QafoxBase;

public class QafoxPage 
{
WebDriver driver;

	@FindBy(xpath="//*[@id=\"search\"]/input")
	WebElement searchBox;
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	WebElement search;
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[1]/h4/a")
	WebElement appleCinemaLink;
	@FindBy(xpath="//*[@id=\"input-option218\"]/div/label/input")
	WebElement radioButton;
	@FindBy(xpath="/html/body/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/label")
	WebElement checkBox;
	@FindBy(xpath="//*[@id=\"input-option208\"]")
	WebElement textField;
	@FindBy(xpath="//*[@id=\"input-option217\"]")
	WebElement dropDown;
	@FindBy(xpath="//*[@id=\"input-option209\"]")
	WebElement textField2;
	@FindBy(xpath="//*[@id=\"button-upload222\"]")
	WebElement fileUpload;
	@FindBy(xpath="//*[@id=\"input-option219\"]")
	WebElement datePicker1;
	@FindBy(xpath="//*[@id=\"input-option221\"]")
	WebElement time;
	@FindBy(xpath="//*[@id=\"input-option220\"]")
	WebElement date_Time;
	@FindBy(xpath="//*[@id=\"input-quantity\"]")
	WebElement quantity;
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement addToCart;
	
	
	public QafoxPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//TITLE VERIFICATION
	public void title_verification()
	{
		String actual_title=driver.getTitle();
		System.out.println("WEB PAGE TITLE IS - "+ actual_title);
	}
	//TEXT VERIFICATION
	public void text_verification()
	{
		String src=driver.getPageSource();
		if(src.contains("qafox"))
		{
			System.out.println("PAGE CONTAINS THE TEXT TESTINGNINJA");
		}
		else
		{
		System.out.println("PAGE DOES NOT CONTAIN THE TEXT QA FOX");	
		}
	}
    //NO OF LINKS 
	public void count_link()
	{
	List<WebElement> li=driver.findElements(By.tagName("a"));
	int no_link=li.size();
	System.out.println("no of link= "+no_link);
	for(WebElement ele:li)
	{
		String link=ele.getAttribute("href");
		System.out.println("links in the page are : " + link);
		String link_text=ele.getText();
		System.out.println("link text  "+link_text);
	}
	}
	
	public void search()
	{
		searchBox.sendKeys("Apple Cinema 30",Keys.ENTER);
		
	}
	public void link()
	{
		appleCinemaLink.click();
	}
	public void radioButton()
	{
		radioButton.click();
		if(radioButton.isSelected())
		{
			System.out.println("radio button is selected");
		}
		else
		{
			System.out.println("radio button is not selected");
		}  
	}
	public void checkBox()
	{
		checkBox.click();
		if(checkBox.isSelected())
		{
			System.out.println("check box is selected");
		}
		else
		{
			System.out.println("check box is not selected");
		}
	}
	public void textField()
	{   textField.clear();
		textField.sendKeys("automation testing");
	}
	public void dropDown() throws InterruptedException
	{   
		 dropDown.click();
		 Select s=new Select(dropDown);
		 s.selectByIndex(2);
    }
	public void textArea()
	{
		textField2.sendKeys("automation testing is interesting");
	}
	public void fileUpload(String p) throws AWTException, InterruptedException
	{
		try
		{
		fileUpload.click();
		
		StringSelection strslctn=new StringSelection(p);//copy the content
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strslctn, null);//set the content
		
		Robot robot = new Robot(); 
		// Add a delay to ensure the file dialog is open
		robot.delay(2000); 
		// Press CTRL + V to paste the file path 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V); 
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		// Press ENTER to confirm the file upload
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// Add a delay to ensure the file upload is processed 
		robot.delay(2000);
		
		//Alert alert = driver.switchTo().alert();
		//String alert_text=alert.getText();
		//System.out.println("alert_text");
		//alert.accept(); 
		}
		catch(Exception e)
		{
			System.out.println("error occured during file upload "+e.getMessage());
		}
	
		}
				
	
	public void alertHandle() throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void date()
	{
		datePicker1.clear();
		datePicker1.sendKeys("2024-11-24");
	}
	public void setTime()
	{
		time.clear();
		time.sendKeys("8:20");
	}
	public void date_time()
	{
		date_Time.sendKeys("2024-11-24 8:20");
	}
	public void quantity()
	{
		quantity.clear();
		quantity.sendKeys("3");
	}
	public void addToCart()
	{
		addToCart.click();
	}
	
}

