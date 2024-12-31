package learning.config.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

	//how to read data from .properties file 
	public static void main(String[] args) {
		
		//create Properties class object
		Properties properties = new Properties();
		
		try {
			//location of .properties file, Opening this in reading mode
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");// throws FileNotFoundException 
			
			//reading set of key-value pair from (.properties) file and store in Properties obj
			properties.load(fileInputStream);//throws IOException
			
			//reading data from properties object 
			System.out.println(properties.getProperty("browser"));
			System.out.println(properties.getProperty("baseUrl"));
			System.out.println(properties.getProperty("username"));
			System.out.println(properties.getProperty("password"));
			System.out.println(properties.getProperty("invalid_username"));
			System.out.println(properties.getProperty("invalid_password"));
			
			// fetch all keys from properties object
			System.out.println(properties.stringPropertyNames());
			
			//fetch all the keys from properties object
			System.out.println(properties.keySet());
			
			//fetching all the values from properties object
			System.out.println(properties.values());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
