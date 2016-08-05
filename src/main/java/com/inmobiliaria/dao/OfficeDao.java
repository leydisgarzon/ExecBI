/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.entities.Office;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author ley
 */

@Repository
public class OfficeDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insertar(Office office) {
        this.jdbcTemplate.update("INSERT INTO office(office_name,office_telephone,office_fax) values(?,?,?)", office.getName(),office.getTelephone(),office.getFax());
    }
}
