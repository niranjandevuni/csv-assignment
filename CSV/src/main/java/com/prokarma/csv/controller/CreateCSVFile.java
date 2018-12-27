package com.prokarma.csv.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.prokarma.csv.beans.Employee;

@Component
public class CreateCSVFile {
	
	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final String CSV_HEADER = "Emp ID,Prefix,First Name,Last Name,Middle Name,Salary,Gender,Street,city,Active";

	public boolean createCSVFile(String path,List<Employee> employees) {
		
		FileWriter fileWriter = null;
		
		try {
			if(employees.size()>0) {
			fileWriter = new FileWriter(path);
 
			fileWriter.append(CSV_HEADER);
			fileWriter.append('\n');
			for (Employee employee : employees) {
				fileWriter.append(String.valueOf(employee.getEmpId()));
				fileWriter.append(',');
				fileWriter.append(employee.getPrefix());
				fileWriter.append(',');
				fileWriter.append(employee.getFirstName());
				fileWriter.append(',');
				fileWriter.append(employee.getLastName());
				fileWriter.append(',');
				fileWriter.append(employee.getMiddleName());
				fileWriter.append(',');
				fileWriter.append(String.valueOf(employee.getSalary()));
				fileWriter.append(',');
				fileWriter.append(employee.getGender());
				fileWriter.append(',');
				fileWriter.append(employee.getStreet());
				fileWriter.append(',');
				fileWriter.append(employee.getCity());
				fileWriter.append(',');
				fileWriter.append(String.valueOf(employee.getActive()));
				fileWriter.append('\n');
			}
 
			log.info("Write CSV successfully!");
			return true;
			}
			return false;
		} catch (Exception e) {
			log.error("Writing CSV error!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				log.error("Flushing/closing error!");
				e.printStackTrace();
			}
		}
		return false;
	}
	/*public static void main(String[] args) {
		List<Employee> Employees = Arrays.asList(
				new Employee(1, "Mr.", "Niranjan3", "Devuni"," ABC",1200.00,"Male","Langer","HYD",true),
				new Employee(2, "Mr.", "Niranjan4", "Devuni"," ",1200.00,"Male","","",true));
		createCSVFile("D:\\sai\\test\\Employee.csv", Employees);
		
	}*/
}
