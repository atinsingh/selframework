package co.pragra.selboot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	
	private static final String CONFIG_FILE_NAME = "test-config.properties";
	private static Properties properties; // Map<K,V>
	
	private AppConfig(){
		// Here we are initializing map
		properties = new Properties();
		
		// We are reading file name as test-config.properties as binary stram.
		// getClass gives us current class , getClassLoader gives us parth.
		// getResourceAsStream reads file and and covert into binary stream.
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String get(String key){
		if(properties==null){
			new AppConfig();
		}
		return properties.getProperty(key);
	}
	
	
}
