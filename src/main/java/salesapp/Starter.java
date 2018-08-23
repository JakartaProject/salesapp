package salesapp;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Starter {
	// 新需求
	// 1、维持我的消息
	// 2.增加查房条件
	// 3.客户可以在系统保持多份备份，每个销售都可以增加一个备份，避免销售之间查看各自跟进信息，导致矛盾
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	@Configuration
	@MapperScan(basePackages = "salesapp.mybatis.mapper", sqlSessionTemplateRef = "salesSqlSessionTemplate")
	public static class DataSourceSalesConfig {
		@Bean(name = "salesDataSource")
		@ConfigurationProperties(prefix = "spring.datasource.sales")
		@Primary
		public DataSource testDataSource() {
			return DataSourceBuilder.create().build();
		}

		@Bean(name = "salesSqlSessionFactory")
		@Primary
		public SqlSessionFactory testSqlSessionFactory(@Qualifier("salesDataSource") DataSource dataSource)
				throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		}

		@Bean(name = "salesTransactionManager")
		@Primary
		public DataSourceTransactionManager testTransactionManager(
				@Qualifier("salesDataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

		@Bean(name = "salesSqlSessionTemplate")
		@Primary
		public SqlSessionTemplate testSqlSessionTemplate(
				@Qualifier("salesSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory);
		}
	}

	@Configuration
	@MapperScan(basePackages = "salesapp.roommybatis.mapper", sqlSessionTemplateRef = "roomSqlSessionTemplate")
	public static class DataSourceRoomsConfig {
		@Bean(name = "roomDataSource")
		@ConfigurationProperties(prefix = "spring.datasource.room")
		public DataSource testDataSource() {
			return DataSourceBuilder.create().build();
		}

		@Bean(name = "roomSqlSessionFactory")
		public SqlSessionFactory testSqlSessionFactory(@Qualifier("roomDataSource") DataSource dataSource)
				throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		}

		@Bean(name = "roomTransactionManager")
		public DataSourceTransactionManager testTransactionManager(
				@Qualifier("roomDataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

		@Bean(name = "roomSqlSessionTemplate")
		public SqlSessionTemplate testSqlSessionTemplate(
				@Qualifier("roomSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory);
		}
	}
}
