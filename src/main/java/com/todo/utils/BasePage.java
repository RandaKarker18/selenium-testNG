package com.todo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	public static WebDriver driver;

	public static Properties prop;
	private String propertyFilePath = "src/main/resources/config/env-config.properties";

	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream input = new FileInputStream(propertyFilePath);
		prop.load(input);
	}

	public static void initialization(String browser) {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("browser does not exist");
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
