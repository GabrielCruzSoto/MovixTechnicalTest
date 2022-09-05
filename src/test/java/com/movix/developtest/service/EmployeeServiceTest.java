package com.movix.developtest.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.movix.developtest.entity.Employee;
import com.movix.developtest.repository.EmployeeRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class EmployeeServiceTest {

    private EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

    private final EmployeeService employeeService = new EmployeeService(employeeRepository);



    @Test
    public void getEmployeeByID_returnsOk() {
        /* bloque modificable inicio */
        Employee employeeMock = new Employee();
        employeeMock.setId(1);
        employeeMock.setEmail("email@movix.com");
        final Optional<Employee> optionalEmployee = Optional.of(employeeMock);

        /* bloque modificable fin */


        /* bloque no modificable inicio */
        when(this.employeeRepository.findById(any())).thenReturn(optionalEmployee);

        final Employee employee = this.employeeService.getById(1);

        Assert.assertEquals("email@movix.com", employee.getEmail());
        assertTrue("Id validation", 1 == employee.getId());
        /* bloque no modificable fin */
    }
    @Test
    public void getFirstNameAndLastName_returnsOk() {
        Employee employeeMock = new Employee();
        employeeMock.setId(1);
        employeeMock.setEmail("email@movix.com");
        final List<Employee> listEmployeeMock = new ArrayList<Employee>();
        listEmployeeMock.add(employeeMock);
        when(this.employeeRepository.findByFirstNameAndLastName(any(),any())).thenReturn(listEmployeeMock);

        final  List<Employee>  listEmployee = this.employeeService.getFirstNameAndLastName("name");

        Assert.assertEquals("email@movix.com", listEmployeeMock.get(0).getEmail());
        assertTrue("Id validation", 1 == listEmployeeMock.get(0).getId());
    }
}
