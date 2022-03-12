package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService empService;

    @PostMapping(value = "/employee")
    public Employee create(@Valid @RequestBody Employee emp) {
        logger.info(emp.toString());
        return empService.create(emp);
    }

    @Operation(summary = "Get all employees")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "all employees",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Employee.class)) }),
         })
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return empService.getAll();
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable(value = "empId") Long id) {
        return empService.getById(id);
    }
}
