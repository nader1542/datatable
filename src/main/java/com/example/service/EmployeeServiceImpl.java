package com.example.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findOne(id);
	}
	@Override
	public Page<Employee> findPaginated(Pageable pageable) {
        List<Employee> books =employeeRepository.findAll();
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Employee> list;
 
        if (books.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, books.size());
            list = books.subList(startItem, toIndex);
        }
 
        Page<Employee> bookPage
          = new PageImpl<>(list, pageable, list.size());
        return bookPage;
    }

}
