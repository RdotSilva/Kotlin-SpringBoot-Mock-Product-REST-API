package com.rdotsilva.mockproductrestapi

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
/**
 * Configuration class used for the web server
 */
class WebConfig: WebMvcConfigurer {
    /**
     * Enable CORS so we can use this service on the frontend
     */
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000", "http://localhost:8080", "http://localhost:4200")
    }
}