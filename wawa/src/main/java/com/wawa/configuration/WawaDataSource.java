package com.wawa.configuration;

import javax.annotation.Resource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WawaDataSource {


	private static final String DATABASE_DRIVER = "datasource.driverClassName";
	private static final String DATABASE_URL = "datasource.url";
	private static final String DATABASE_USER = "datasource.username";
	private static final String DATABASE_PASSWORD = "datasource.password";
	private static final String INITIALSIZE = "datasource.initialSize";
	private static final String MINIDLE = "datasource.minIdle";
	private static final String TIME_BETWEEN_EVICTION = "datasource.TimeBetweenEvictionRunsMillis";
	private static final String VALIDATION_INTERVAL = "datasource.ValidationInterval";
	private static final String VALIDATION_QUERY = "datasource.ValidationQuery";
	private static final String VALIDATION_QUERY_TIMEOUT = "datasource.ValidationQueryTimeout";
	private static final String TEST_WHILE_IDLE = "datasource.TestWhileIdle";

	@Resource
	private Environment env;
	
	@Bean(name = "wawadataSource")
	@Qualifier("wawadataSource")
	@Primary
	public DataSource wawadataSource() {
		DataSource wawadataSource = new DataSource();
		wawadataSource.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
		wawadataSource.setUrl(env.getRequiredProperty(DATABASE_URL));
		wawadataSource.setUsername(env.getRequiredProperty(DATABASE_USER));
		wawadataSource.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));
		wawadataSource.setInitialSize(Integer.valueOf(env.getRequiredProperty(INITIALSIZE)));
		wawadataSource.setMinIdle(Integer.valueOf(env.getRequiredProperty(MINIDLE)));
		wawadataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(env.getRequiredProperty(TIME_BETWEEN_EVICTION)));
		wawadataSource.setValidationInterval(Long.valueOf(env.getRequiredProperty(VALIDATION_INTERVAL)));
		wawadataSource.setValidationQuery(env.getRequiredProperty(VALIDATION_QUERY));
		wawadataSource.setValidationQueryTimeout(Integer.valueOf(env.getRequiredProperty(VALIDATION_QUERY_TIMEOUT)));
		wawadataSource.setTestWhileIdle(Boolean.valueOf(env.getRequiredProperty(TEST_WHILE_IDLE)));
		return wawadataSource;
	}
	
	@Bean(name = "wawaJdbcTemplate")
	JdbcTemplate wawaJdbcTemplate(@Qualifier("wawadataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
