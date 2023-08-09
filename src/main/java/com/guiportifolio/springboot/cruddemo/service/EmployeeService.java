package com.guiportifolio.springboot.cruddemo.service;

import com.guiportifolio.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
