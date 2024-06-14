package flipkartAutomate.utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.naming.ConfigurationException;



public class Config {
	
	private Properties properties;
	 
    public Config() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/TestConfig.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
	

}
