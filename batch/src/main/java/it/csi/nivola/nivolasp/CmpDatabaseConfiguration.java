/*-
 * ========================LICENSE_START=================================
 * Nivola Batch
 * %%
 * Copyright (C) 2022 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2022 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.nivola.nivolasp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages="it.csi.nivola.nivolasp.domain.cmp",  entityManagerFactoryRef="cmpEM", transactionManagerRef="cmpTransactionManager")
public class CmpDatabaseConfiguration {

    private final Environment env;

    public CmpDatabaseConfiguration(Environment env) {
        this.env = env;
    }


	public Environment getEnv() {
		return env;
	}
    
    @ConfigurationProperties(prefix="cmp.datasource")
    @Bean("cmpDataSource")
    public DataSource remedyDataSource() {
    	DataSource prova = DataSourceBuilder.create().type(HikariDataSource.class).build();
        return prova;
    }
    
    @Bean(name="cmpEM")
    public LocalContainerEntityManagerFactoryBean remedyEMFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("cmpDataSource") DataSource dataSource) {
    	LocalContainerEntityManagerFactoryBean emf = builder
                .dataSource(dataSource)
                .packages("it.csi.nivola.nivolasp.domain.cmp")
                .build();
        return emf;
    }
    
    @Bean(name="cmpTransactionManager")
    public PlatformTransactionManager remedyTransactionManager(
    		final @Qualifier("cmpEM") LocalContainerEntityManagerFactoryBean entityManager) {
    	return new JpaTransactionManager(entityManager.getObject());
    }
}
