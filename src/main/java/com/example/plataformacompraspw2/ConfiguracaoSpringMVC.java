package com.example.plataformacompraspw2;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@Controller
public class ConfiguracaoSpringMVC implements WebMvcConfigurer {
    


    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addRedirectViewController("/", "/produtos/list");
        //registry.addRedirectViewController("/", "/home");
        //registry.addRedirectViewController("/home", "/produtos/list");
        registry.addViewController("/home").setViewName("index");
    }
}