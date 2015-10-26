package by.bsuir.drahun.database.application;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import by.bsuir.drahun.database.business.BusinessComponents;
import by.bsuir.drahun.database.dao.DaoComponents;

@Configuration
@ComponentScan(basePackageClasses = { BusinessComponents.class, DaoComponents.class })
@EnableTransactionManagement
@PropertySources({
	@PropertySource("classpath:core.properties")
})
public class SpringConfiguration {

	private static final String STORAGE_PERSISTENCE_UNIT = "storage";
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.userName";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	
	private static final String PROPERTY_NAME_DATABASE_DIALECT = "db.dialect";
	private static final String PROPERTY_NAME_DATABASE_SHOW_SQL = "db.showSql";
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;
	}
	
	 @Bean
     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
             LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
             entityManagerFactoryBean.setDataSource(dataSource());
             entityManagerFactoryBean.setPersistenceUnitName(STORAGE_PERSISTENCE_UNIT);
             entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
             return entityManagerFactoryBean;
     }

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(env.getRequiredProperty(PROPERTY_NAME_DATABASE_SHOW_SQL, Boolean.class));
		hibernateJpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DIALECT));
		return hibernateJpaVendorAdapter;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	

}
