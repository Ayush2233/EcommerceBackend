package com.example.demo.servicesImpl;


/*This class implements the methods of the Address service interface*/

import com.example.demo.entities.AddressEntity;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    AddressRepository addressRepo;

    @Override
    public void addAddress(AddressEntity address)
    {
        addressRepo.save(address);
    }
}
