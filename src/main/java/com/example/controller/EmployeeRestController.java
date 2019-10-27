package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DataTableResultInfo;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DataTableResultInfo dataTableResultInfo;
	
	@RequestMapping(path="/employees", method=RequestMethod.POST)
	public 
	DataTableResultInfo getAllEmployees(HttpServletRequest request){
		request.getParameterNames();
		request.getParameterMap();
		int start = Integer.valueOf(request.getParameter("start"));
		int length = Integer.valueOf(request.getParameter("length"));
		request.getParameter("order[0][column]");


		Page<Employee> bookPage = employeeService.findPaginated(new PageRequest(start/length, length));
		dataTableResultInfo.setData((List<Employee>)bookPage.getContent());
		dataTableResultInfo.setRecordsTotal(100);
		dataTableResultInfo.setLength(length);
		dataTableResultInfo.setRecordsFiltered(100);
		return dataTableResultInfo;
	}
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") long id){
		return employeeService.getEmployeeById(id);
	}

}
