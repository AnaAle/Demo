package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository("empleadoRepository")
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

    Employee findByName(String name);
    Employee findByNameAndActive(String name, boolean active);
    Employee findByNameAndActiveTrue(String name);

    Employee findByApellido(String Apellido);
}

