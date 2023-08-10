package com.guiportifolio.springboot.cruddemo.rest;

import com.guiportifolio.springboot.cruddemo.entity.Employee;
import com.guiportifolio.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // buscar(GET) "/employess" e retornar uma lista de todos os empregados
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // buscar(GET) "/employees/{employeeId}" e retornar um empregado específico por id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        return theEmployee;
    }

    // enviar(POST) "/employees" - adicionar um novo empregado
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // caso passem um valor no id via JSON - atribuir id == 0
        // isso garante que o método "merge" irá salvar um novo empregado ao invés de atualizar

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // atualizar(PUT) "/employees" - atualizar os dados de algum empregado
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // deletar(DELETE) "/employees/{employeeId}"
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw  new RuntimeException("Employee id not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id: " + employeeId;

    }
}
