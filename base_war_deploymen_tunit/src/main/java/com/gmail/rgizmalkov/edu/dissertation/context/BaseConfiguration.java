package com.gmail.rgizmalkov.edu.dissertation.context;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.net.URL;

@Configuration
@ComponentScan("com.gmail.rgizmalkov.edu.dissertation.controller")
public class BaseConfiguration {
}
