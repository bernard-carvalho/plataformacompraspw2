package com.example.plataformacompraspw2;

import javax.validation.ConstraintViolation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.plataformacompraspw2.Entity.Produto;
import com.example.plataformacompraspw2.Entity.Cliente.ClientePF;



@SpringBootApplication
public class Plataformacompraspw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Plataformacompraspw2Application.class, args);
		
		Produto clientepf = new Produto();
		clientepf.isValid();
		for(ConstraintViolation<Produto> violacao : clientepf.getErros()){
			System.out.println(violacao);
		}
		System.out.println(clientepf.getId());
		
	}

}
