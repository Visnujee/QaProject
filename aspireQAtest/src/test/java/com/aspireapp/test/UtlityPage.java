package com.aspireapp.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtlityPage {
	
	public static Properties userInput() throws IOException {
		Properties obj = new Properties(); 
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\aspireapp\\test\\objects.properties");
		obj.load(objfile);
		return obj;
	}
 

}
