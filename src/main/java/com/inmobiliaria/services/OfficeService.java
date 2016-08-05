/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.services;

import com.inmobiliaria.dao.OfficeDao;
import com.inmobiliaria.entities.Office;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author ley
 */
@Service
public class OfficeService {
    @Resource
    private OfficeDao officeDao;

    public void insertar(Office office) {
        this.officeDao.insertar(office);
    }
}
