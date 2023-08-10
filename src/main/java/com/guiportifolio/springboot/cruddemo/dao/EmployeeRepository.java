package com.guiportifolio.springboot.cruddemo.dao;

import com.guiportifolio.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Aqui já existem vários códigod prontos para uso:
    // findAll()
    // findById()
    // save()
    // deleteById()
    // ...
}
