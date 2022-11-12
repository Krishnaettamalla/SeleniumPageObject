package org.hcl.pages;

import org.hcl.base.ReusableMathods;
import org.openqa.selenium.By;

public class Login_Page extends ReusableMathods{
	
	
	public static By username_input=By.id("user_name");
	public static By password_input=By.id("user_pass");
	public static By login_button=By.id("login_button");
	
	public static void enterUserName(String data) {
		setText(username_input,data);
		}
	public static void enterPassWord(String data) {
		setText(password_input,data);
		}
	public static void clickLoginBtn() {
		click(login_button);
		}
}
