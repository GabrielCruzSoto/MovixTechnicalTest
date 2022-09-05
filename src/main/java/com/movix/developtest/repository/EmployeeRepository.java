package com.movix.developtest.repository;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movix.developtest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

    @Query(nativeQuery = true, value = "SELECT * FROM employee e WHERE UPPER(e.first_name) = UPPER(?1) OR UPPER(e.last_name) = UPPER(?2)" )
    Collection<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
