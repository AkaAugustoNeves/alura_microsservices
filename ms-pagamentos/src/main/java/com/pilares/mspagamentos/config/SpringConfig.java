package com.pilares.mspagamentos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
    public ModelMapper obterModelMapper() {
        return new ModelMapper();
    }
	
}
