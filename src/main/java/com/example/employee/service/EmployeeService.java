package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(Employee emp) {
        logger.info(emp.toString());
        return employeeRepository.save(emp);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateById(Long employeeId, Employee employee) {
        Employee emp = employeeRepository.findById(employeeId).get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        return employeeRepository.save(emp);
    }
}
