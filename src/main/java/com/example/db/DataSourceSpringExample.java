package com.example.db;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DataSourceSpringExample {

	public static void main(String[] args) throws SQLException {
		// DI Container, BeanFactory
		// LifeCycle
		// 1. 객체 생성
		// 2. 객체 초기화
		// 3. dependency injection
		// 3. 객체 사용
		// 4. 객체 소멸
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/spring/beans.xml");

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@ after BeanFactory Create @@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
//		BasicDataSource ds = ctx.getBean(BasicDataSource.class);
//		System.out.println(ds.getDriverClassName());
//		System.out.println(ds.getUrl());
//		System.out.println(ds.getUsername());
//		System.out.println(ds.getPassword());
//		ds.getConnection();
		
		CityDao dao = ctx.getBean(CityDao.class);
		System.out.println(dao.selectAll());
		
		CountryDao dao1 = ctx.getBean(CountryDao.class);
		System.out.println(dao1.select());

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@ before BeanFactory ctx.close @@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		ctx.close();
	}
}
