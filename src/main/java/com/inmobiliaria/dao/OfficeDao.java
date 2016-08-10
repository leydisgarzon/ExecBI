/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.entities.Office;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


/**
 *
 * @author ley
 */

@Repository
public class OfficeDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger logger = LoggerFactory.getLogger(OfficeDao.class);
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insertar(Office office) {
        final KeyHolder holder = new GeneratedKeyHolder();
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            //@Override
            public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                final PreparedStatement ps = connection.prepareStatement("INSERT INTO address(city,street,house_no) values(?,?,?)",
                       // new String[] {"ADDRESS_ID"});
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, office.getAddress().getCity());
                ps.setString(2, office.getAddress().getStreet());
                ps.setInt(3, office.getAddress().getNumber());
                return ps;
            }
        };
        
        this.jdbcTemplate.update(psc,holder);
        final int id = (int) holder.getKeys().get("ADDRESS_ID");
        
        logger.debug("Address Inserción Satisfactoria " + String.valueOf(id) );
        
        this.jdbcTemplate.update("INSERT INTO office(office_name,office_telephone,office_fax,office_address) values(?,?,?,?)", office.getName(),office.getTelephone(),office.getFax(),id);
    }
}
