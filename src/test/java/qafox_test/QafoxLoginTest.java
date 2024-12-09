package qafox_test;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import qafox_base.QafoxBase;
import qafox_page.QafoxLogin;
import qafox_utilities.ExcelUtils_Qa;

public class QafoxLoginTest extends QafoxBase
{ 


	@Test
	public void test_methd() throws Exception
	{
	QafoxLogin ob2=new QafoxLogin(driver);
	ob2.mouse_hover();
//READING DATA FROM EXCEL FILE 
	String xl="C:\\Users\\kkswa\\Downloads\\Qafoxlogin.xlsx";
	String Sheet="Sheet1";
	int rowCount=ExcelUtils_Qa.getRowCount(xl,Sheet);
	for(int i=1;i<=rowCount;i++)
	{
		try 
		{
		String mail=ExcelUtils_Qa.getCellValue(xl,Sheet,i,0);
		System.out.println("email--"+mail);
		String pass=ExcelUtils_Qa.getCellValue(xl,Sheet,i,1);
		System.out.println("password--"+pass);
		ob2.set_values(mail, pass);
		
        //Thread.sleep(2000);
       
        //driver.navigate().refresh();
        
	   }
		catch(Exception e )
		{
			System.out.println("ERROR OCCURED..."+e.getMessage());
		}
     }
	 
    ob2.login_validation();
    ob2.tear_down();
   
    
}
}	

