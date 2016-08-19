/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.dao.util.OracleJdbcTemplate;
import com.inmobiliaria.entities.Address;
import com.inmobiliaria.entities.Manager;
import com.inmobiliaria.entities.Office;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author ley
 */
@Repository
public class OfficeDao {
    
    private static final org.slf4j.Logger loggerOff = LoggerFactory.getLogger(OfficeDao.class);
    
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    @Resource
    private OracleJdbcTemplate oracleJdbcTemplate;
    
    public OracleJdbcTemplate getOracleJdbcTemplate() {
        return oracleJdbcTemplate;
    }
    
    public void setOracleJdbcTemplate(OracleJdbcTemplate oracleJdbcTemplate) {
        this.oracleJdbcTemplate = oracleJdbcTemplate;
    }
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insertar(Office office) {
        
        String myUpdateSQL = "INSERT INTO address(city,street,house_no) values(:city,:street,:numb)";
        SqlParameterSource myParamSource = new MapSqlParameterSource().addValue("city", office.getAddress().getCity())
                .addValue("street", office.getAddress().getStreet()).addValue("numb", office.getAddress().getNumber());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.oracleJdbcTemplate.update(myUpdateSQL, myParamSource, keyHolder, new String[]{"ADDRESS_ID"});
        int id = keyHolder.getKey() != null ? keyHolder.getKey().intValue() : 0;        
        if (id > 0) {
            this.jdbcTemplate.update("INSERT INTO office(office_name,office_telephone,office_fax,office_address) values(?,?,?,?)", office.getName(), office.getTelephone(), office.getFax(), id);
        }
        
    }
    
    public List getAllOffices() {
        return this.jdbcTemplate.query("select office_id, OFFICE_NAME, office_manager, EMPLOYEE_NAME, "
                + "OFFICE_TELEPHONE, OFFICE_FAX, OFFICE_ADDRESS, city, street, house_no  from office "
                + "inner join address on OFFICE_ADDRESS = ADDRESS_ID left join EMPLOYEE\n"
                + "on office.OFFICE_MANAGER = EMPLOYEE.EMPLOYEE_ID", new OfficeMapper());
    }
    
    public Office getOfficeById(int id){
        return this.jdbcTemplate.queryForObject("select office_id, OFFICE_NAME, office_manager, EMPLOYEE_NAME, "
                + "OFFICE_TELEPHONE, OFFICE_FAX, OFFICE_ADDRESS, city, street, house_no  from office "
                + "inner join address on OFFICE_ADDRESS = ADDRESS_ID left join EMPLOYEE\n"
                + "on office.OFFICE_MANAGER = EMPLOYEE.EMPLOYEE_ID where office_id = ?", new OfficeMapper(), id);
    }
    
    private static final class OfficeMapper implements RowMapper<Office> {
        
        @Override
        public Office mapRow(ResultSet rs, int rowNum) throws SQLException {
            Office office = new Office();
            office.setId(rs.getInt("office_id"));
            office.setName(rs.getString("OFFICE_NAME"));
            office.setFax(rs.getInt("OFFICE_FAX"));
            office.setTelephone(rs.getInt("OFFICE_TELEPHONE"));

            //Office's address
            Address address = new Address();
            address.setId(rs.getInt("OFFICE_ADDRESS"));
            address.setCity(rs.getString("city"));
            address.setStreet(rs.getString("street"));
            address.setNumber(rs.getInt("house_no"));
            
            office.setAddress(address);

            //Office's manager
            Manager manager = new Manager();
            if (!Objects.isNull(rs.getObject("office_manager"))) {
                manager.setId(rs.getInt("office_manager"));
                manager.setName(rs.getString("EMPLOYEE_NAME"));
            }
            else{
                manager.setId(-1);
                manager.setName("not asigned");
            }         
                office.setManager(manager);
                
            return office;
        }
    }
}
