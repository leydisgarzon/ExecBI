/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.entities.Address;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ley
 */
@Repository
public class AddressDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insertar(Address address) {
        this.jdbcTemplate.update("INSERT INTO address(city,street,house_no) values(?,?,?)", address.getCity(),address.getStreet(),address.getNumber());
    }
    
    public void update(Address address){
        this.jdbcTemplate.update("UPDATE ADDRESS SET CITY = ?, STREET = ?, HOUSE_NO = ?  WHERE ADDRESS_ID  = ?", address.getCity(),address.getStreet(),address.getNumber(),address.getId());
    }
    
    public void deleteAddressById(int id){
        this.jdbcTemplate.update("DELETE FROM ADDRESS WHERE ADDRESS_ID  = ?", id);
    }
    
    /*public int getLastId() {
        return this.jdbcTemplate.queryForObject("SELECT address_id from address where rownum=1 order by address_id desc",Integer.class);
    }*/
    
    /*public Address get(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT udn.id, udn.name, udn.server, udn.dragon, udn.udngroup, udngroup.name as groupname FROM udn INNER JOIN udngroup ON udn.udngroup =  udngroup.id WHERE udn.id = ?", new UdnMapper(), id);
    }*/
}
