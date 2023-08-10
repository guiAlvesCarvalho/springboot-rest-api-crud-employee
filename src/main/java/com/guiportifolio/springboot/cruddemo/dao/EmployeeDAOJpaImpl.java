package com.guiportifolio.springboot.cruddemo.dao;

import com.guiportifolio.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // definir campo para entitymanager
    private EntityManager entityManager;

    // Injeção de dependencias - contructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        // criar query (JPQL)
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // executar query e pegar lista de resultados
        List<Employee> employees = theQuery.getResultList();

        // retornar resultados
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // merge -> if id == 0 Then insert/save Else update
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);
    }
}
