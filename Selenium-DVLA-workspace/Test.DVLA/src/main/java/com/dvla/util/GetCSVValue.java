package com.dvla.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetCSVValue {

	public List<String> getvehicleNumber(String filePath) {

		List<String> list = new ArrayList<String>();
		try {

			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File(filePath));
			
			scanner.useDelimiter(",");

			while (scanner.hasNext()) {
				list.add(scanner.next());
			}

		} catch (IOException ex) {

		}

		return list;

	}
}
