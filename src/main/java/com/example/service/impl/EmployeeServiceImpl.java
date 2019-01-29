package com.example.service.impl;


import java.util.List;
import java.util.Optional;

import com.example.dto.AddressDTO;
import com.example.dto.EmployeeCreateDTO;
import com.example.model.Address;
import com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.modelmapper.ModelMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

import javax.naming.Name;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empleadoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> opt = empleadoRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empleadoRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        empleadoRepository.deleteById(id);
    }

    //Generado busqueda apellido
    @Override
    public Employee getEmployeeByApellido(String Apellido){
        return empleadoRepository.findByApellido(Apellido);
    }

    @Override
    public List<AddressDTO> getArrayList() {
        return null;
    }

    @Override
    public Address getEmployyeByAddres(String calle, String colonia, int numeroExt, int numeroInt, String ciudad, String estado, String pais, int cp) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return empleadoRepository.findByName(name);
    }

    @Override
    public Employee saveEmployee(EmployeeCreateDTO employeee) {
    Employee employeeEntity = modelMapper.map(employeee, Employee.class);
    Employee save = empleadoRepository.save(employeeEntity);
    return save;
    }
}
