package com.example.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String calle;
    private String colonia;
    private int numeroExt;
    private int numeroInt;
    private String ciudad;
    private String estado;
    private String pais;
    private String cp;
}
