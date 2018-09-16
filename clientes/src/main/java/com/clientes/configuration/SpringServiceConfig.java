package com.clientes.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.clientes.services.impl.ClienteServiceImpl;

@Configuration
@ComponentScan(basePackageClasses=ClienteServiceImpl.class)
public class SpringServiceConfig {

}
