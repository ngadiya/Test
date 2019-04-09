package com.dvla.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetDirectoryInfo {

	
	public int getNumberOfFilesFormDirectory(String dirPath) {
		
		int noOfFiels= 0;
	
		List <String > list = getFilesWithPathFromDirectory(dirPath);
		
		if (list != null ) 
			noOfFiels = list.size();
		
		return noOfFiels;
	}
	
	
	
	public  List<String> getFilesWithPathFromDirectory(String dirPath) {
	     List<String> fileNames = new ArrayList<String>();
	    try {
		      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirPath));
		      for (Path path : directoryStream) 
		      {
		        fileNames.add(path.toString());
		      }
	    } catch (IOException ex) {
	    }
	   
	    return fileNames;
	  }
	
	
}
