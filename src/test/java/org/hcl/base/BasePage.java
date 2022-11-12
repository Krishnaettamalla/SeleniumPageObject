package org.hcl.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BasePage {
	public static WebDriver driver;
	public static File configFile;
	public static FileInputStream configFis;
	public static Properties configProp;
	public static File log4jFile;	
	public static FileInputStream log4jFis;
	
	public static Logger logger=Logger.getLogger(BasePage.class);
	
	public static void  readConfigPropFile() {
		configFile=new File("../SeleniumPageObjectFW9am/src/test/java/org/hcl/resources/Config.properties");
		try {
		configFis=new FileInputStream(configFile);
	    configProp=new Properties();
		configProp.load(configFis);
		logger.info("config file loaded");
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void readLog4jProperties() {
		log4jFile=new File("../SeleniumPageObjectFW9am/src/test/java/org/hcl/resources/Log4j.properties");
		try {
			log4jFis=new FileInputStream(log4jFile);
			PropertyConfigurator.configure(log4jFis);
			logger.info("log4j file loaded");	
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
	}
	public static void openBrowser() {
		readConfigPropFile();
		readLog4jProperties();
		
		String browser= configProp.getProperty("Browser");
		logger.info("Browser is ::"+browser);
		
		if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver","../SeleniumPageObjectFW9am/browsers/chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("Chrome Browser invoked");
			driver.manage().window().maximize();
			logger.info("Chrome Browser maximized");
		}
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","../SeleniumPageObjectFW9am/browsers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			logger.info("IE browser invoked");
			driver.manage().window().maximize();
			logger.info("InternetExplorer Browser maximized");
		}
	}
	public static void enterUrl() {
		String browser=configProp.getProperty("BaseUrl");
		driver.get(browser);
	}

}
