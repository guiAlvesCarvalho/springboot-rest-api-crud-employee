package com.guiportifolio.springboot.cruddemo.rest;

import com.guiportifolio.springboot.cruddemo.dao.EmployeeDAO;
import com.guiportifolio.springboot.cruddemo.entity.Employee;
import com.guiportifolio.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // buscar "/employess" e retornar uma lista de empregados
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


}
