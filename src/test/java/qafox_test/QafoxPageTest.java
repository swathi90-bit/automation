package qafox_test;

import org.testng.annotations.Test;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import qafox_base.QafoxBase;
import qafox_page.QafoxPage;

public class QafoxPageTest extends QafoxBase
{
@Test
public void test_method() throws InterruptedException, AWTException
{
	QafoxPage ob3=new QafoxPage(driver);
	ob3.title_verification();
	ob3.text_verification();
	ob3.count_link();
    ob3.search();
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("window.scrollBy(0,50)");
	ob3.link();
	ob3.radioButton();
	ob3.checkBox();
	ob3.textField();
	ob3.dropDown();
	ob3.textArea();
    ob3.fileUpload("C:\\Users\\kkswa\\Downloads\\Alan Varghese - Full Stack Resume.pdf");
	
	ob3.date();
	ob3.setTime();

	ob3.date_time();
    Thread.sleep(3000);
	ob3.quantity();
	ob3.addToCart();
	
}
}
