/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.dao;

import com.inmobiliaria.dao.util.OracleJdbcTemplate;
import com.inmobiliaria.entities.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
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
        String sqlWithoutSupervisor = "INSERT INTO EMPLOYEE(EMPLOYEE_NAME,EMPLOYEE_ADDRESS,EMPLOYEE_TELEPHONE,EMPLOYEE_BIRTHDAY,DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE) VALUES(?,?,?,?,?,?,?,?,?,?)"; 
        String sqlWithSupervisor = "INSERT INTO EMPLOYEE(EMPLOYEE_NAME,EMPLOYEE_ADDRESS,EMPLOYEE_TELEPHONE,EMPLOYEE_BIRTHDAY,DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE,EMPLOYEE_SUPERVISOR) VALUES(?,?,?,?,?,?,?,?,?,?,?)"; 
        
        int var =(employee.getSupervisor()== null) ? 
                this.jdbcTemplate.update(sqlWithoutSupervisor,employee.getName(), employee.getAddress().getId(), employee.getTelephone(), employee.getBirthday(),employee.getDni(), employee.getJob(), employee.getDateIn(), employee.getSalary(), employee.getSpeedWrite(), employee.getOffice().getId()) 
              : this.jdbcTemplate.update(sqlWithoutSupervisor,employee.getName(), employee.getAddress().getId(), employee.getTelephone(), employee.getBirthday(),employee.getDni(), employee.getJob(), employee.getDateIn(), employee.getSalary(), employee.getSpeedWrite(), employee.getOffice().getId(),employee.getSupervisor().getId());
            

        /*this.jdbcTemplate.update("INSERT INTO EMPLOYEE(EMPLOYEE_NAME,EMPLOYEE_ADDRESS,EMPLOYEE_TELEPHONE,EMPLOYEE_BIRTHDAY,\n"
                // + "DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE,EMPLOYEE_SUPERVISOR,EMPLOYEE_PARIENTE)\n"
                + "DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)", employee.getName(), employee.getAddress().getId(), employee.getTelephone(), employee.getBirthday(),employee.getDni(), employee.getJob(), employee.getDateIn(), employee.getSalary(), employee.getSpeedWrite(), employee.getOffice().getId());
                // + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)", employee.getName(), addressId, employee.getTelephone(), employee.getBirthday(),
                employee.getDni(), employee.getJob(), employee.getDateIn(), employee.getSalary(), employee.getSpeedWrite(), employee.getOffice().getId());
                // ,employee.getSupervisor().getId());
   */
    }
    
    public Long insertEmployeeReturnId(Employee employee) {
        Calendar birth = Calendar.getInstance(),in = Calendar.getInstance();
        birth.setTime(employee.getBirthday());
        birth.add(Calendar.DATE, 1);
        in.setTime(employee.getDateIn());
        in.add(Calendar.DATE, 1);
        String myUpdateSQLPariente = employee.getSupervisor()== null ? "INSERT INTO EMPLOYEE(EMPLOYEE_NAME,EMPLOYEE_ADDRESS,EMPLOYEE_TELEPHONE,EMPLOYEE_BIRTHDAY,DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE) "
                + "VALUES(:name,:address,:telef,:birthday,:dni,:job,:dateIn,:salary,:speed,:office)" 
        : "INSERT INTO EMPLOYEE(EMPLOYEE_NAME,EMPLOYEE_ADDRESS,EMPLOYEE_TELEPHONE,EMPLOYEE_BIRTHDAY,DNI,EMPLOYEE_JOB,EMPLOYEE_DATEIN,SALARY,WRITE_SPEED,EMPLOYEE_OFFICE,EMPLOYEE_SUPERVISOR) "
                + "VALUES(:name,:address,:telef,:birthday,:dni,:job,:dateIn,:salary,:speed,:office,:supervisor)";  
        
        SqlParameterSource myParamSource = new MapSqlParameterSource().addValue("birthday", birth)
                    .addValue("name", employee.getName())
                    .addValue("telef", employee.getTelephone())
                    .addValue("address", employee.getAddress().getId())
                    .addValue("dni", employee.getDni())
                    .addValue("job", employee.getJob())
                    .addValue("dateIn", in)
                    .addValue("salary", employee.getSalary())
                    .addValue("speed", employee.getSpeedWrite())
                    .addValue("office", employee.getOffice().getId());
       if(employee.getSupervisor()== null)
           ((MapSqlParameterSource) myParamSource).addValue("supervisor", employee.getDateIn());
       KeyHolder keyHolder = new GeneratedKeyHolder();   
       this.oracleJdbcTemplate.update(myUpdateSQLPariente, myParamSource, keyHolder, new String[]{"EMPLOYEE_ID"});
       return keyHolder.getKey().longValue();
    }
    
    public List<Employee> getSupervisors(int officeId) {
        return this.jdbcTemplate.query("SELECT EMPLOYEE_ID,EMPLOYEE_NAME FROM EMPLOYEE\n"
                + "where WRITE_SPEED > 0 and EMPLOYEE_OFFICE=?", new EmployeeMapper(),officeId);
    }

    private static final class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

            Employee employee = new Employee();
            employee.setId(rs.getLong("EMPLOYEE_ID"));
            employee.setName(rs.getString("EMPLOYEE_NAME"));
            return employee;
        }
    }
}
