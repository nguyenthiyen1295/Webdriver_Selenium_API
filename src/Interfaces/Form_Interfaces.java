package Interfaces;

public interface Form_Interfaces {
	String btn_myAccount_Xpath = "//div[@class ='footer']//div[@class ='links']//a[text()='My Account']";
    String btn_register_Xpath = "//a[@title='Create an Account']";
    
    //Login form
    String btn_login_Xpath = "//button[@title ='Login']";
    String label_errorLogin = "//div[text()='This is a required field.']";
    String txt_email_Xpath = "//input[@id='email']";
    String txt_pwd_Xpath = "//input[@id='pass']";
    String label_errorInvalidemail = "//div[@id ='advice-validate-email-email']";
    String label_errorInvalidPwd = "//div[@id ='advice-validate-password-pass']";
}
