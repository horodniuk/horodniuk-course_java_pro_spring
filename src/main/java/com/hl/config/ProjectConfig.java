package com.hl.config;


import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.hl.repositories", "com.hl.services"})
public class ProjectConfig {
}
