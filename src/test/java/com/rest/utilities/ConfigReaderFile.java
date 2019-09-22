package com.rest.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderFile {

	public static Properties prop = null;
	public static String currPrjLoc = System.getProperty("user.dir");
	public static String configFile = currPrjLoc
			+ "\\config\\config.properties";

	private ConfigReaderFile() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(configFile);
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			System.out.println("File Not Found Exception : "
					+ fnfe.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static class SingletonHolder {
		public static final ConfigReaderFile instance = new ConfigReaderFile();
	}

	public static ConfigReaderFile getInstance() {
		return SingletonHolder.instance;
	}

	public String getBaseURL() {

		return prop.getProperty("baseURL");
	}

}
