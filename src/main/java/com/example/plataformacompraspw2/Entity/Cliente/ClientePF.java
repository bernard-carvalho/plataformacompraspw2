package com.example.plataformacompraspw2.Entity.Cliente;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;


@Data// notação do lombok.Data que permite que não precisemos informar getters e setters
@Table(name="tb_clientepf")
@Entity//notação que identifica a classe como entidade, isto é, uma tabela deve ser criada no banco para representá-la
public class ClientePF extends Cliente implements Serializable {
    
    @NotNull(message = "CPF NÃO PODE SER NULO")
    @NotBlank(message = "CPF NÃO PODE SER VAZIO")
    @CPF
    private String cpf;

    @Transient
    private Set<ConstraintViolation<ClientePF>> erros;

    public boolean isValid(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        erros = validator.validate(this);
        return erros.isEmpty();
    }

    

    
}