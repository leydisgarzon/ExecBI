/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.dao.util.OracleJdbcTemplate;
import com.inmobiliaria.entities.Employee;
import com.inmobiliaria.entities.Familiar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ley
 */
@Repository
public class FamiliarDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private OracleJdbcTemplate oracleJdbcTemplate;
    
    @Resource
    private AddressDao addressDao;
    
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

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public int insertFamiliarReturnId(Familiar familiar, Long idEmployee) {
        /*int familiarId = 0;
        String myUpdateSQLAddress = "INSERT INTO address(city,street,house_no) values(:city,:street,:numb)";
        SqlParameterSource myParamSource = new MapSqlParameterSource().addValue("city", familiar.getAddress().getCity())
                .addValue("street", familiar.getAddress().getStreet()).addValue("numb", familiar.getAddress().getNumber());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.oracleJdbcTemplate.update(myUpdateSQLAddress, myParamSource, keyHolder, new String[]{"ADDRESS_ID"});
        int addressId = keyHolder.getKey() != null ? keyHolder.getKey().intValue() : 0;
        
        if (addressId > 0) {*/
        String myUpdateSQLPariente = "INSERT INTO PARIENTE(RELATION,PARIENTE_NAME,PARIENTE_TELEPHONE,PARIENTE_ADDRESS, EMPLOYEE) VALUES(:relation,:name,:telef,:address,:employee)";
        SqlParameterSource myParamSource2 = new MapSqlParameterSource().addValue("relation", familiar.getRelation())
                .addValue("name", familiar.getName()).addValue("telef", familiar.getTelephone())
                .addValue("address", familiar.getAddress().getId())
                .addValue("employee", idEmployee);
        //      .addValue("address", addressId);
        KeyHolder keyHolder2 = new GeneratedKeyHolder();
        this.oracleJdbcTemplate.update(myUpdateSQLPariente, myParamSource2, keyHolder2, new String[]{"PARIENTE_ID"});
        int familiarId = keyHolder2.getKey() != null ? keyHolder2.getKey().intValue() : 0;
        //}

        return familiarId;
    }

    public void insertFamiliar(Employee employee) {
        String myUpdateSQLPariente = "INSERT INTO PARIENTE(RELATION,PARIENTE_NAME,PARIENTE_TELEPHONE,PARIENTE_ADDRESS, EMPLOYEE) VALUES(?,?,?,?,?)";

        this.jdbcTemplate.batchUpdate(myUpdateSQLPariente, new BatchPreparedStatementSetter() {
            public List<Familiar> familiars = employee.getFamiliars();

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, familiars.get(i).getRelation());
                ps.setString(2, familiars.get(i).getName());
                ps.setLong(3, familiars.get(i).getTelephone());
                ps.setInt(4, addressDao.insertAndReturnId(familiars.get(i).getAddress()));
                ps.setLong(5, employee.getId());
            }

            @Override
            public int getBatchSize() {
                return familiars.size();
            }
        });
    }
}
