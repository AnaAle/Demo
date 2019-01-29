package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.AddressDTO;
import com.example.dto.EmployeeCreateDTO;
import com.example.model.Address;
import com.example.repository.AddressRepository;
import com.example.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Employee;
import com.example.service.EmployeeService;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    //http://localhost:8080/employee/id/1
    @GetMapping("/employee/id/{id}")
    public Employee getEmployee(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    private ModelMapper modelMapper = new ModelMapper();

    //Metodos HTTP -> GET, POST, PUT, DELETE ok

    //Guardado
    //Borrado
    // vas a agregar una columna mas al modelo Ok
    //Vas a agregar una busqueda por nombre, el atributo nombre ya existe



    //@GetMapping ("/employee/Nombre")

    //http://localhost:8080/id/"2"
   @DeleteMapping("/employee/id/{id}")
    public void deleteEmploye(@PathVariable("id") long id){employeeService.deleteEmployeeById(id);
   }

    //http://localhost:8080/employee/name/Johon
    //http://localhost:8080/employee/name/TANIA
   @GetMapping("/employee/name/{name}")
    public Employee getEmployeeByName(@PathVariable ("name")String name){return employeeService.getEmployeeByName(name);
    }

    //http://localhost:8080/employee/Save
    @PostMapping("employee/Save/")
    public Employee saveEmployee(@RequestBody EmployeeCreateDTO employee) {
        return employeeService.saveEmployee(employee);
    }
    //http://localhost:8080/employee/addressList/1
    @GetMapping("employee/addressList/{employeeId}")
    public List<AddressDTO> getEmployeeAddressList(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        List<Address> addressList = employee.getAddressList();

        List<AddressDTO> addressDTOS = new ArrayList<>();

        for (Address ad : addressList) {
            AddressDTO addressDTO = modelMapper.map(ad, AddressDTO.class);

            addressDTOS.add(addressDTO);
        }

        return addressDTOS;
    }

   //Eliminar direccion
    /*@DeleteMapping ("employee/Apellido/{eliminarId}")
    public class Employee getEmloyeeByApellidoEliminar(@PathVariable Long ) {
    }*/

    //Busquda por apellido/Ponce/
    //htpp://localhost:8080/employeee/Apellido}")
    @GetMapping ("/employee/Apellido/{Apellido}")
    public Employee getEmplloyeeByApellido(@PathVariable("Apellido") String Apellido) {return employeeService.getEmployeeByApellido(Apellido);
    }
}
