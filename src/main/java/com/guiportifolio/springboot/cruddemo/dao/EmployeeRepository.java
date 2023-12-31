package com.guiportifolio.springboot.cruddemo.dao;

import com.guiportifolio.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Aqui já existem vários códigos prontos para uso:
    // findAll()
    // findById()
    // save()
    // deleteById()
    // ...

    public List<Employee> findAllByOrderByFirstNameAsc();
}
