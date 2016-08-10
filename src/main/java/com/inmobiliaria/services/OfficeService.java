/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.services;

//import com.inmobiliaria.dao.AddressDao;
import com.inmobiliaria.dao.OfficeDao;
import com.inmobiliaria.entities.Office;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ley
 */
@Service
//@Transactional(readOnly = true)
public class OfficeService {
    @Resource
    private OfficeDao officeDao;
    /*@Resource
    private AddressDao addressDao;*/
    
    private static final Logger logger = LoggerFactory.getLogger(OfficeService.class);
    //@Transactional
    public void insertar(Office office) {
        try{
            //this.addressDao.insertar(office.getAddress());
            //office.getAddress().setId(this.addressDao.getLastId());
            this.officeDao.insertar(office);
        }
         catch (Exception e) {
            logger.debug(e.getMessage());
        }
        
    }

}
