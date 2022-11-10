package com.example.plataformacompraspw2.Entity.Cliente;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.val;


@Data
@Table(name="ClientePF")
@Entity
public class ClientePF extends Cliente implements Serializable {
    
    @NotNull(message = "CPF NÃO PODE SER NULO")
    @NotBlank(message = "CPF NÃO PODE SER VAZIO")
    private String cpf;

    @Transient
    private Set<ConstraintViolation<ClientePF>> erros;

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