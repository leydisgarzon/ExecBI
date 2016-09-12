/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.services;

import com.inmobiliaria.dao.AddressDao;
import com.inmobiliaria.dao.FamiliarDao;
import com.inmobiliaria.entities.Familiar;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ley
 */
@Service
@Transactional(readOnly = true)
public class FamiliarService {

    @Resource
    private FamiliarDao familiarDao;

    @Resource
    private AddressDao addressDao;
    
    @Transactional
    public int insertFamiliar(Familiar familiar, Long idEmployee) {
        //try{
        int addressId = addressDao.insertAndReturnId(familiar.getAddress());
        if (addressId > 0) {
            familiar.getAddress().setId(addressId);
            return familiarDao.insertFamiliar(familiar, idEmployee);
        } else {
            return 0;
        }
       /* }catch(Exception e){
            
        }*/
                
    }
}
