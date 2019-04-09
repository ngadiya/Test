package com.dvla.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Writer {

	public void WriteInTextFile(String fileNameWithPath,  String fileName,String fileMimeType,double fileSize,String extension ) 
	{
		PrintWriter writer;
		try {
			
			writer = new PrintWriter(fileNameWithPath, "UTF-8");
			writer.println(fileName);
			writer.println(fileMimeType);
			writer.println(fileSize);
			writer.println(extension);
	
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
