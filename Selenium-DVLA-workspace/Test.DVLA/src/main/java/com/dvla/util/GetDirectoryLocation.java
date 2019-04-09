package com.dvla.util;

import java.io.IOException;
import java.util.ResourceBundle;

public class GetDirectoryLocation {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");

	public String getValueFormConfig(String key) throws IOException {
 
		String dictoryName  = null;
		try {
			
			 dictoryName = rb.getString(key);
			
		} catch (Exception e) {
			
			System.out.println("Exception: " + e);
		
		} finally {
			
		}
		return dictoryName;
	}
	
}
