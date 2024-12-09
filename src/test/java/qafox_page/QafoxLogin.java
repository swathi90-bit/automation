package qafox_page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import qafox_base.QafoxBase;

public class QafoxLogin extends QafoxBase
{
	

WebDriver driver;
@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
WebElement myacnt;
@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
WebElement login;
@FindBy(xpath="//*[@id=\"input-email\"]")
WebElement email;
@FindBy(xpath="//*[@id=\"input-password\"]")
WebElement password;
@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
WebElement login_click;
public QafoxLogin (WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void mouse_hover() throws InterruptedException
{
	Actions act=new Actions(driver);
	act.moveToElement(myacnt).click().perform();
	Thread.sleep(2000);
	act.moveToElement(login).click().perform();
	
}

public void set_values(String mail,String pass) throws Exception
{
	email.sendKeys(mail);
	password.sendKeys(pass);
	login_click.click();
	Thread.sleep(3000);
	email.sendKeys(Keys.CONTROL+"A");
	email.sendKeys(Keys.DELETE);
	password.sendKeys(Keys.CONTROL+"A");
	password.sendKeys(Keys.DELETE);

	
	//email.clear();
	//password.clear();
	//driver.navigate().refresh();

}

public void login_validation()
{
String act_url=driver.getCurrentUrl();
String exp_url="https://tutorialsninja.com/demo/index.php?route=account/account";
Assert.assertEquals(act_url, exp_url,"login successful");
System.out.println("LOGIN VALIDATION SUCCESSFUL");
System.out.println("current url is----- "+ driver.getCurrentUrl());

}
public void tear_down()
{
	driver.close();
}
}
