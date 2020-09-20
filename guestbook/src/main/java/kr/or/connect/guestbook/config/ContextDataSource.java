package kr.or.connect.guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * 데이터베이스 설정
 * 
 */

@Configuration

// 아노 테이션 기반 트랜잭션 관리를 사용 합니다.

// <tx:annotation-driven>

@EnableTransactionManagement

public class ContextDataSource {

	/**
	 * 
	 * 데이터소스 등록
	 * 
	 * @return
	 * 
	 */

	@Bean(destroyMethod = "close")

	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");

		dataSource.setUrl("jdbc:oracle:thin:@portfordev.c2cczg1ppooa.ap-northeast-2.rds.amazonaws.com:1521:ORCL");

		dataSource.setUsername("admin");

		dataSource.setPassword("song8420");

		dataSource.setDefaultAutoCommit(false);

		return dataSource;

	}

	/**
	 * 
	 * 트랜잭션 매니저 등록
	 * 
	 * @return
	 * 
	 */

	@Bean

	public DataSourceTransactionManager transactionManager() {

		return new DataSourceTransactionManager(dataSource());

	}

}