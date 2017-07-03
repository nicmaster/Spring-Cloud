package com.nicmaster.troll.sink.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("squid:S2094")
@Configuration
@EnableJpaRepositories(basePackages = "com.nicmaster.troll.sink.persistence.repository",
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EnableJpaAuditing
public class DatabaseConfiguration {

}
