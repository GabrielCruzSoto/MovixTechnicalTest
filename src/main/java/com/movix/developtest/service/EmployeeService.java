package com.movix.developtest.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.movix.developtest.entity.Employee;
import com.movix.developtest.exceptions.EmployeeNotFoundException;
import com.movix.developtest.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getById(Integer id) {
        logger.info("getById|id={}", id);
        Optional<Employee> optional = this.employeeRepository.findById(id);

        logger.info("getById|id={}, result={}", id, optional.isPresent());
        if (!optional.isPresent()) {
            throw new EmployeeNotFoundException("Not found..");
        }
        return optional.get();
    }
}
