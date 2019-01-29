package com.example.controller;

import com.example.dto.AddressDTO;
import com.example.model.Address;
import com.example.model.Employee;
import com.example.service.AddressService;
import com.example.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;

    private ModelMapper modelMapper = new ModelMapper();

    //Funcion a trabajar guardar direccion.
    //http://localhost:8080/addressList/1
    @PostMapping("address/addressList/{employeeId}")
    public AddressDTO addAddress(@PathVariable Long employeeId, @RequestBody Address address)  {
        Employee employeeById = employeeService.getEmployeeById(employeeId);
        address.setEmployee(employeeById);


        //Terminar de validar
        Address addressEntity = addressService.saveAddress(address);

        AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);

        return addressDTO;
    }

}
