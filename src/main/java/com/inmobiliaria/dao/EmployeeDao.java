/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.dao.util.OracleJdbcTemplate;
import com.inmobiliaria.entities.Address;
import com.inmobiliaria.entities.Employee;
import com.inmobiliaria.entities.Manager;
import com.inmobiliaria.entities.Office;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
public class EmployeeDao {

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

    public void insertEmployee(Employee employee) {

        /*String myUpdateSQL = "INSERT INTO address(city,street,house_no) values(:city,:street,:numb)";
        SqlParameterSource myParamSource = new MapSqlParameterSource().addValue("city", employee.getAddress().getCity())
                .addValue("street", employee.getAddress().getStreet()).addValue("numb", employee.getAddress().getNumber());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.oracleJdbcTemplate.update(myUpdateSQL, myParamSource, keyHolder, new String[]{"ADDRESS_ID"});
        int addressId = keyHolder.getKey() != null ? keyHolder.getKey().intValue() : 0;
        
        if (addressId > 0) {*/
        this.jdbcTemplate.update("INSERT INTO EMPLOYEE(EMPLOYEE_NAME,EMPLOYEE_ADDRESS,EMPLOYEE_TELEPHONE,EMPLOYEE_BIRTHDAY,\n"
                // + "DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE,EMPLOYEE_SUPERVISOR,EMPLOYEE_PARIENTE)\n"
                + "DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE,EMPLOYEE_PARIENTE)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)", employee.getName(), employee.getAddress().getId(), employee.getTelephone(), employee.getBirthday(),
                // + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)", employee.getName(), addressId, employee.getTelephone(), employee.getBirthday(),
                employee.getDni(), employee.getJob(), employee.getDate_in(), employee.getSalary(), employee.getSpeed_write(), employee.getOffice().getId(),
                // employee.getSupervisor().getId(), employee.getFamiliar().getId());
                employee.getFamiliar().getId());
        //}   
    }

    public List<Employee> getSupervisors(int officeId) {
        return this.jdbcTemplate.query("SELECT EMPLOYEE_ID,EMPLOYEE_NAME FROM EMPLOYEE\n"
                + "where WRITE_SPEED > 0 and EMPLOYEE_OFFICE=?", new EmployeeMapper(),officeId);
    }

    private static final class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

            Employee employee = new Employee();
            employee.setId(rs.getInt("EMPLOYEE_ID"));
            employee.setName(rs.getString("EMPLOYEE_NAME"));
            return employee;
        }
    }
}
