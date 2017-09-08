package com.example.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CountryDao implements InitializingBean, DisposableBean {

	static Log log = LogFactory.getLog(CountryDao.class);

	public CountryDao() {
	}

	BasicDataSource ds;

	public void setDataSource(BasicDataSource ds) {
		this.ds = ds;
	}

	@PostConstruct
	private void PostConstruct() {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	public void init() {
	}

	public List<String> select() throws SQLException {
		Connection conn = ds.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select name from country");


		ResultSet rs = pstmt.executeQuery();

		List<String> list = new ArrayList<>();
		while (rs.next()) {
			list.add(rs.getString("name"));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

	@PreDestroy
	private void PreDestroy() {

	}

	@Override
	public void destroy() throws Exception {
	}

	public void close() {
	}

}
