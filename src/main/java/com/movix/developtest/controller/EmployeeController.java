package com.movix.developtest.controller;

import com.movix.developtest.controller.base.Controller;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movix.developtest.dto.JSONResponse;
import com.movix.developtest.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController extends Controller {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JSONResponse> getById(@PathVariable("id") Integer id) {
        return this.buildOkStatusResponse(this.employeeService.getById(id));
    }

    @GetMapping(value = "/search/{name}")
    public ResponseEntity<JSONResponse> getByFistNameAndLastName(
            @PathVariable(value = "name", required = true) String name
    ) {
        return this.buildOkStatusResponse(this.employeeService.getFirstNameAndLastName(name));
    }

}