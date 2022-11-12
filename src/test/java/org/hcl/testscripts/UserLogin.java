package org.hcl.testscripts;


import org.hcl.base.BasePage;
import org.hcl.pages.Login_Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserLogin {

@BeforeTest
public void initialize() {
	BasePage.openBrowser();
	BasePage.enterUrl();
}
@Test
public void verifyUserLogin() {
	Login_Page.enterUserName("krishna1234");
	Login_Page.enterPassWord("pass123");
	Login_Page.clickLoginBtn();
	}
@AfterTest
public void tearDown() {
	BasePage.driver.close();
}

}
