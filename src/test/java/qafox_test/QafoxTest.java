package qafox_test;

import org.testng.annotations.Test;

import qafox_base.QafoxBase;
import qafox_page.QafoxLogin;
import qafox_page.QafoxRegistration;
import qafox_utilities.ExcelUtils_Qa;


public class QafoxTest  extends QafoxBase
{
@Test
public void test_method() throws InterruptedException
{
	//registration page 
	QafoxRegistration ob=new QafoxRegistration(driver);
	ob.mouse_hover();
	ob.set_values();
	ob.agree_News_Letter();
    ob.privacy_policy();
    ob.continuemtd();
   
}
}
