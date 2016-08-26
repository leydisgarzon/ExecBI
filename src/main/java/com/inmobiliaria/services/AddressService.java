/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.services;

import com.inmobiliaria.dao.AddressDao;
import com.inmobiliaria.entities.Address;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author ley
 */

@Service
public class AddressService {
    @Resource
    private AddressDao addressDao;
    
    public void insertAddress(Address address){
        addressDao.insertar(address);
    }
    
}
