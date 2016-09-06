/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.dao.util.OracleJdbcTemplate;
import com.inmobiliaria.entities.Familiar;
import javax.annotation.Resource;
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

    public OracleJdbcTemplate getOracleJdbcTemplate() {
        return oracleJdbcTemplate;
    }

    public void setOracleJdbcTemplate(OracleJdbcTemplate oracleJdbcTemplate) {
        this.oracleJdbcTemplate = oracleJdbcTemplate;
    }

    public int insertFamiliar(Familiar familiar) {
        /*int familiarId = 0;
        String myUpdateSQLAddress = "INSERT INTO address(city,street,house_no) values(:city,:street,:numb)";
        SqlParameterSource myParamSource = new MapSqlParameterSource().addValue("city", familiar.getAddress().getCity())
                .addValue("street", familiar.getAddress().getStreet()).addValue("numb", familiar.getAddress().getNumber());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.oracleJdbcTemplate.update(myUpdateSQLAddress, myParamSource, keyHolder, new String[]{"ADDRESS_ID"});
        int addressId = keyHolder.getKey() != null ? keyHolder.getKey().intValue() : 0;
        
        if (addressId > 0) {*/
            String myUpdateSQLPariente = "INSERT INTO PARIENTE(RELATION,PARIENTE_NAME,PARIENTE_TELEPHONE,PARIENTE_ADDRESS) VALUES(:relation,:name,:telef,:address)";
            SqlParameterSource myParamSource2 = new MapSqlParameterSource().addValue("relation", familiar.getRelation())
                    .addValue("name", familiar.getName()).addValue("telef", familiar.getTelephone())
                    .addValue("address", familiar.getAddress().getId());
            //      .addValue("address", addressId);
            KeyHolder keyHolder2 = new GeneratedKeyHolder();
            this.oracleJdbcTemplate.update(myUpdateSQLPariente, myParamSource2, keyHolder2, new String[]{"PARIENTE_ID"});
            int familiarId = keyHolder2.getKey() != null ? keyHolder2.getKey().intValue() : 0;
        //}

        return familiarId;
    }

}
