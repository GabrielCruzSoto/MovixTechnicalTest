package com.movix.developtest.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.movix.developtest.entity.Employee;
import com.movix.developtest.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeByID_returnsOk() {
        /* bloque modificable inicio */
        final Optional<Employee> optionalEmployee = Optional.empty();

        /* bloque modificable fin */

        /* bloque no modificable inicio */
        when(this.employeeRepository.findById(any())).thenReturn(optionalEmployee);

        final Employee employee = this.employeeService.getById(1);

        Assert.assertEquals("email@movix.com", employee.getEmail());
        assertTrue("Id validation", 1 == employee.getId());
        /* bloque no modificable fin */
    }
}
