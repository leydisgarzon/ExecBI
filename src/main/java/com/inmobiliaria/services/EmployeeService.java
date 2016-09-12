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
import com.inmobiliaria.entities.Familiar;
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
        employee.getAddress().setId(addressDao.insertAndReturnId(employee.getAddress()));
        employee.setId(employeeDao.insertEmployeeReturnId(employee));
        familiarDao.insertFamiliar(employee);
    }

    public List<Employee> getSupervisors(int officeId) {
        return this.employeeDao.getSupervisors(officeId);
    }
}
