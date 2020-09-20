package kr.or.connect.guestbook.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
/*
@Configuration
@EnableTransactionManagement // 트랜잭션과 관련된 설정을 자동을 해줌. 단, 사용자 간의 트랜잭션 처리를 위한 PlatformTransactionManager를
							 // 설정하기 위해서는 annotationDrivenTransactionManager 메서드를 오버라이딩 해야함.
@ComponentScan(basePackages = {"kr.or.connect.guestbook.dao"})
*/
public class DBConfig //implements TransactionManagementConfigurer 
	{
	/*
	/* mariadb
	private String driverClassName = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://springboottoy.c2cczg1ppooa.ap-northeast-2.rds.amazonaws.com:3306/springbootToy";
	*/
	/* oracle */
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@portfordev.c2cczg1ppooa.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
	
	/* mysql
	 * private String driverClassName = "com.mysql.cj.jdbc.Driver";
	 * private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	 * */
	private String username = "admin";
	private String password = "song8420";
	
	//@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	/*
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
*/	
}
