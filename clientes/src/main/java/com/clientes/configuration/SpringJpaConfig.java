package com.clientes.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.clientes.models.Cliente;
import com.clientes.repositories.ClienteRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses=ClienteRepository.class)
@ComponentScan(basePackageClasses=ClienteRepository.class)
@EnableTransactionManagement
public class SpringJpaConfig  {
	
	@Bean
	public DataSource getDataSource() {
		JndiDataSourceLookup ds = new JndiDataSourceLookup();
		ds.setResourceRef(true);
		return ds.getDataSource("jdbc/clientesDS");
	}
	
	@Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(Cliente.class.getPackage().getName());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();
		return factory.getObject();
    }
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		 JpaTransactionManager transactionManager = new JpaTransactionManager();
		 transactionManager.setEntityManagerFactory(entityManagerFactory);
         return transactionManager;
	}

	private Properties jpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.show.sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        //props.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
  		return props;
	}

	private JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		
		return adapter;
	}
	
	
	
	

}
