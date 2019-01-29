package com.example.service;

import java.util.List;

import com.example.dto.AddressDTO;
import com.example.dto.EmployeeCreateDTO;
import com.example.model.Address;
import com.example.model.Employee;

public interface EmployeeService {
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();
    void deleteEmployeeById(Long id);
    Employee getEmployeeByName(String name);
    Employee saveEmployee(EmployeeCreateDTO employeee);

    Employee getEmployeeByApellido(String Apellido);

    List<AddressDTO> getArrayList();
    Address getEmployyeByAddres(String calle, String colonia, int numeroExt, int numeroInt, String ciudad, String estado, String pais, int cp);
}

