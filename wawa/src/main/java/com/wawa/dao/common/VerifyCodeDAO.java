package com.wawa.dao.common;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class VerifyCodeDAO {

	private final Logger logger = LoggerFactory.getLogger( VerifyCodeDAO.class );
	
	@Autowired
	@Qualifier("wawaJdbcTemplate")
	JdbcTemplate wawaJdbcTemplate;
	
	public int insertVerifyCode(Map<String, Object> verifyCodeData) {
		String sql = "INSERT INTO verify_code (create_date, modify_date, expire_date, phone_num, status, code) VALUES (now(), now(), DATE_ADD(NOW(), INTERVAL 10 MINUTE), ?, '0', ?);";
		return wawaJdbcTemplate.update(sql, ps -> {
			ps.setString(1, (String) verifyCodeData.get("phoneNumber"));
			ps.setString(2, (String) verifyCodeData.get("verifyCode"));
		});
	}
}
