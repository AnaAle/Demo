package com.example.service.impl;

import com.example.model.Address;
import com.example.repository.AddressRepository;
import com.example.service.AddressService;
import org.hibernate.cache.cfg.internal.AbstractDomainDataCachingConfig;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    //@Override
    //public Address eliminarAddress(Address Eliminar)
    //{
        //return addressRepository.delete();
    //}
}

