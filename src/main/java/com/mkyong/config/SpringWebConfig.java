package com.mkyong.config;
 
import com.inmobiliaria.dao.util.OracleJdbcTemplate;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@EnableWebMvc
@Configuration
//@ComponentScan({ "com.mkyong.web" })
@ComponentScan({ "com" })
//@EnableTransactionManagement
public class SpringWebConfig extends WebMvcConfigurerAdapter {
 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
        
        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
            dataSource.setUsername("Inmobiliaria");
            dataSource.setPassword("admin");
            dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            return dataSource;
        }
        
        /*@Bean
        public PlatformTransactionManager txManager() {
            return new DataSourceTransactionManager(dataSource());
        }*/
 
        @Bean
        public JdbcTemplate jdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
            return jdbcTemplate;
        }
        /*
        @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
            return namedParameterJdbcTemplate;
        }*/
        
        @Bean
        public OracleJdbcTemplate oracleJdbcTemplate() {
            OracleJdbcTemplate oracleJdbcTemplate = new OracleJdbcTemplate(dataSource());
            return oracleJdbcTemplate;
        }
}