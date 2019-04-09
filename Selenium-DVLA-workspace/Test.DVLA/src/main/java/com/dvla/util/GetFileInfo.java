package com.dvla.util;

import java.io.File;
import java.nio.file.Files;

import org.apache.commons.io.FilenameUtils;

public class GetFileInfo {

	
	// Get MimeType of file
		public String getMimeType(String filePath) throws Exception {
			
			String mimeType = null;
			
			try {
				
				mimeType = Files.probeContentType(new File(filePath).toPath());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return mimeType;
		}

		// Get File Size
		public double getFileSize(String filePath) throws Exception {

			double fileSizeInKB = 0;
			
			try {
			
				File myFile = new File(filePath);
				fileSizeInKB = (double) myFile.length() / 1024;
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fileSizeInKB;

		}

		// Get File Name
		public String getFileName(String filePath) throws Exception {

			String fileName = null;
			
			try {
			
				File myFile = new File(filePath);
				fileName = myFile.getName();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return fileName;
		}

		//Get File Extension
		public String getFileExtension(String FilePath) throws Exception{
			
			String fileExtension = null;
			
			try {
				
				fileExtension = FilenameUtils.getExtension(FilePath);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return fileExtension;
		}
	
}
