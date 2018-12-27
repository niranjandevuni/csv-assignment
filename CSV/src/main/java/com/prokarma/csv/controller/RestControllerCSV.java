package com.prokarma.csv.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.csv.beans.Employee;
import com.prokarma.csv.service.EmployeeService;

@RestController
public class RestControllerCSV {

	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Inject
	private CreateCSVFile createCSVFile;

	@Inject
	private ReadCSV readCSV;

	@Value("${file.path}")
	private String filePath;

	@Inject
	private EmployeeService employeeService;

	@GetMapping("/all")
	public List<Employee> allEmployees() {
		return employeeService.getAllEmpoyees();
	}

	@PostMapping("/create")
	public String createCSVFile(@RequestBody List<Employee> employees) {
		if (createCSVFile.createCSVFile(filePath, employees)) {
			return "Success in Creating CSV file";
		} else {
			return "Failed in Creating CSV file ";
		}

	}

	@Scheduled(fixedRate = 10000)
	@GetMapping("/readCsv")
	public List<Employee> readCsvData() {
		List<Employee> employees = readCSV.readingCSVData(filePath);
		employeeService.saveCsvEmployeeData(employees, filePath);
		return employees;
	}

}
