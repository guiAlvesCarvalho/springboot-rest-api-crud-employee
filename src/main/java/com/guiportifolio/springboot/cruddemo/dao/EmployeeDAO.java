package com.guiportifolio.springboot.cruddemo.dao;

import com.guiportifolio.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
