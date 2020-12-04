package br.marcioazevedo.estudos.java.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class TestController{
     
    @Autowired
    RestTemplate restTemplate;
    
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
 
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value="/ok")
    public String ok() 
    {
        LOG.info("Teste de comunicação com o Graylog - [OK]");
        
        return "Done!";
    }
    
    @GetMapping(value="/erro")
    public String error() 
    {
        throw new RuntimeException("Erro interno!!!");
    }
}
