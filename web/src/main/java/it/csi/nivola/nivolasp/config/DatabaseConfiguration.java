/*-
 * ========================LICENSE_START=================================
 * Nivola Web
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages="it.csi.nivola.nivolasp.repository", entityManagerFactoryRef="serviceportalManagerFactory", transactionManagerRef="serviceportalTransactionManager")
@EnableTransactionManagement
public class DatabaseConfiguration {

    private final Environment env;

    public DatabaseConfiguration(Environment env) {
        this.env = env;
    }


	public Environment getEnv() {
		return env;
	}
    
	@Bean("servicePortalDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
    public DataSource servicePortalDataSource() {
    	DataSource prova = DataSourceBuilder.create().type(HikariDataSource.class).build();
        return prova;
    }
	
    @Bean(name="serviceportalManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean serviceportalManagerFactory(
    		EntityManagerFactoryBuilder builder, @Qualifier("servicePortalDataSource") DataSource dataSource) {
    	LocalContainerEntityManagerFactoryBean emf = builder
                .dataSource(dataSource)
                .packages("it.csi.nivola.nivolasp.domain")
                .build();
    	return emf;
    }
    
    @Primary
    @Bean(name="serviceportalTransactionManager")
    public PlatformTransactionManager serviceportalTransactionManager(
            final @Qualifier("serviceportalManagerFactory") LocalContainerEntityManagerFactoryBean serviceportalTransactionManager) {
        return new JpaTransactionManager(serviceportalTransactionManager.getObject());
    }
    
	
    
}
