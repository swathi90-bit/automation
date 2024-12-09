package qafox_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class QafoxRegistration
{
	WebDriver driver;
	@FindBy(xpath="/html/body/nav/div/div[2]/ul/li[2]/a/i")
	WebElement my_account;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement reg;
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement f_name;
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement l_name;
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement telephone;
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement confirmpassword;
	@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
	WebElement radioButton;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement continue_click;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement privacy_policy;
	


public QafoxRegistration(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	System.out.println(driver);
}

public void mouse_hover() throws InterruptedException
{
Actions act=new Actions(driver);
act.moveToElement(my_account).click().perform();
Thread.sleep(2000);
act.moveToElement(reg).click().perform();
}

public void set_values()
{
	f_name.sendKeys("swathi");
	l_name.sendKeys("kk");
	email.sendKeys("kkswathi6@gmail.com");
	telephone.sendKeys("12345678");
	password.sendKeys("Asdf@1234");
	confirmpassword.sendKeys("Asdf@1234");
}
public void agree_News_Letter()
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
public void privacy_policy()
{
	privacy_policy.click();
}
public void continuemtd()
{
	
		
	
	continue_click.click();

    }
}



