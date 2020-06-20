package com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.config;

import com.yurets_y.spring_tutor_001.ch8_jpa.config.DataJpaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by iuliana.cosmina on 4/29/17.
 */
@Configuration
@EnableTransactionManagement
// Все настройки БД импортируем из DataJpaConfig.class
@Import(DataJpaConfig.class)
@ComponentScan(basePackages = {"com.yurets_y.spring_tutor_001.ch8_jpa.jparepository"})
@EnableJpaRepositories(basePackages = {"com.yurets_y.spring_tutor_001.ch8_jpa.jparepository.repo"})
public class RepoDataJpaConfig {

	private static Logger logger = LoggerFactory.getLogger(RepoDataJpaConfig.class);


}
