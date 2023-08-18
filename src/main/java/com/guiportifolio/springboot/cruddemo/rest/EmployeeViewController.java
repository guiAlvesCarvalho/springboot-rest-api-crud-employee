package com.guiportifolio.springboot.cruddemo.rest;

import com.guiportifolio.springboot.cruddemo.entity.Employee;
import com.guiportifolio.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeViewController {

    EmployeeService employeeService;

    public EmployeeViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the spring model
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
