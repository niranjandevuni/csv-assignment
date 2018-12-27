package com.prokarma.csv.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prokarma.csv.beans.Employee;

@Component
public class ReadCSV {
	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final int EMP_ID = 0;
	private static final int PREFIX = 1;
	private static final int FIRST_NAME = 2;
	private static final int LAST_NAME = 3;
	private static final int MIDDLE_NAME = 4;
	private static final int SALARY = 5;
	private static final int GENDER = 6;
	private static final int STREET = 7;
	private static final int CITY = 8;
	private static final int ACTIVE = 9;

	public List<Employee> readingCSVData(String path) {
		File file = new File(path);
		try {
		if (file.exists()) {
				List<Employee> employees = null;
				BufferedReader fileReader = null;
				employees = new ArrayList<Employee>();

				String line = "";

				fileReader = new BufferedReader(new FileReader(path));

				// Read CSV header
				fileReader.readLine();

				// Read customer data line by line
				while ((line = fileReader.readLine()) != null) {
					String[] tokens = line.split(",");
					if (tokens.length > 0) {
						Employee employee = new Employee(Integer.parseInt(tokens[EMP_ID]), tokens[PREFIX],
								tokens[FIRST_NAME], tokens[LAST_NAME],
								(!tokens[MIDDLE_NAME].isEmpty() && tokens[MIDDLE_NAME] != null) ? tokens[MIDDLE_NAME]
										: "",
								(!tokens[SALARY].isEmpty() && tokens[SALARY] != null)
										? Double.parseDouble(tokens[SALARY])
										: Double.parseDouble(""),
								(!tokens[GENDER].isEmpty() && tokens[GENDER] != null) ? tokens[GENDER] : "",
								(!tokens[STREET].isEmpty() && tokens[STREET] != null) ? tokens[STREET] : "",
								tokens[CITY], Boolean.parseBoolean(tokens[ACTIVE]));

						employees.add(employee);
					}
				}
				fileReader.close();
				return employees;
			}
		}
		catch (Exception e) {
			log.error("Reading CSV Error!"+e.getMessage());
		}
		return null;
	}
}
