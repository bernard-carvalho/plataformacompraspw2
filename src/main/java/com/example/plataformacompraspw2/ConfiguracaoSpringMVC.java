package com.example.plataformacompraspw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@Controller
public class ConfiguracaoSpringMVC implements WebMvcConfigurer {
    


    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //List<Produto> produtos = produtoRepository.findAll();
        /*
         * Verificar uma forma de enviar a /home um list<Produto>.
        */
        registry.addRedirectViewController("/", "/home");
        //registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("index");
    }
}