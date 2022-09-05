package com.movix.developtest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movix.developtest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

}
