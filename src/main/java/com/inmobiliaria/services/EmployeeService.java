/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.services;

import com.inmobiliaria.dao.AddressDao;
import com.inmobiliaria.dao.EmployeeDao;
import com.inmobiliaria.dao.FamiliarDao;
import com.inmobiliaria.entities.Employee;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ley
 */
@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private AddressDao addressDao;

    @Resource
    private FamiliarDao familiarDao;

    @Transactional
    public void insertEmployee(Employee employee) {
        //try{
        int addressFamId = addressDao.insertAndReturnId(employee.getFamiliar().getAddress());
        if (addressFamId > 0) {
            employee.getFamiliar().getAddress().setId(addressFamId);
            int familiarId = familiarDao.insertFamiliar(employee.getFamiliar());

            int addressId = familiarId > 0 ? addressDao.insertAndReturnId(employee.getAddress()) : 0;
            if (addressId > 0) {
                employee.getFamiliar().setId(familiarId);
                employee.getAddress().setId(addressId);
                employeeDao.insertEmployee(employee);
            }

        }
    }
    
    public List<Employee> getSupervisors(int officeId){
        return this.employeeDao.getSupervisors(officeId);
    }
}
