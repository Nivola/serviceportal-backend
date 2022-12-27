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

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import it.csi.nivola.nivolasp.integration.rest.api.service.AuthorityApi;
import it.csi.nivola.nivolasp.security.AuthoritiesConstants;
import it.csi.nivola.nivolasp.security.ShibbolethFilter;
import it.csi.nivola.nivolasp.service.LoggingAccessiService;
import it.csi.nivola.nivolasp.service.UserService;
import it.csi.nivola.nivolasp.service.mapper.cmp.AbilitazioneMapper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final ShibbolethFilter shibbolethFilter;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder,
        LoggingAccessiService servzio, ApplicationProperties proprieta, UserService userService, AbilitazioneMapper mapper, DecodificaRuoliCMP decodificaRuoliCMP, AuthorityApi authorityApi) {
    	
        shibbolethFilter = new ShibbolethFilter(servzio, proprieta, userService, mapper, decodificaRuoliCMP, authorityApi);
    }

    @PostConstruct
    public void init() {
//        try {
//            authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                    .passwordEncoder(passwordEncoder());
//        } catch (Exception e) {
//            throw new BeanInitializationException("Security configuration failed", e);
//        }
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger-ui/index.html")
            .antMatchers("/test/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();

        http
            .addFilterAfter(shibbolethFilter, BasicAuthenticationFilter.class)
            .exceptionHandling()
        .and()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .authorizeRequests()
            .antMatchers("/api/authenticate").permitAll()
            .antMatchers("/api/authentication").permitAll()
            .antMatchers("/api/account").permitAll()
            .antMatchers("/api/profile-info").hasAnyAuthority(AuthoritiesConstants.BOADMIN)
            .antMatchers("/api/public/**").permitAll()
            .antMatchers("/api/**").authenticated()
            .antMatchers("/websocket/tracker").hasAnyAuthority(AuthoritiesConstants.BOADMIN)
            .antMatchers("/websocket/**").permitAll()
            .antMatchers("/management/health").permitAll()
            .antMatchers("/management/**").hasAnyAuthority(AuthoritiesConstants.BOADMIN)
            .antMatchers("/v2/api-docs/**").hasAnyAuthority(AuthoritiesConstants.BOADMIN)
            .antMatchers("/swagger-resources/configuration/ui").hasAnyAuthority(AuthoritiesConstants.BOADMIN)
            .antMatchers("/swagger-ui/index.html").hasAnyAuthority(AuthoritiesConstants.BOADMIN);
    }
    
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}
