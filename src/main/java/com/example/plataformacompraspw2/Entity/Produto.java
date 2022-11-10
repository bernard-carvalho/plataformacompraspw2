package com.example.plataformacompraspw2.Entity;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;



@Data
@Table(name = "Produto")
@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String nome;
    private Double valor;

    @Transient  
    private Set<ConstraintViolation<Produto>> erros;
    
    public boolean isValid(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        erros = validator.validate(this);
        if(erros.size()!=0)
            return false;
        else
            return true;
    }

}