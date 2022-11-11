package com.example.plataformacompraspw2.Entity;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;



@Data// notação do lombok.Data que permite que não precisemos informar getters e setters
@Table(name = "tb_produto")
@Entity//notação que identifica a classe como entidade, isto é, uma tabela deve ser criada no banco para representá-la
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @NotBlank(message = "NOME NÃO PODE ESTAR EM BRANCO")
    @NotNull(message = "NOME NÃO PODE SER NULO")
    private String nome;
    
    @NotNull(message = "VALOR NÃO PODE SER NULO")
    @Min(value=0, message="PRECO DEVE SER SUPERIOR A {1}")
    private Double valor;

    @Transient  
    private Set<ConstraintViolation<Produto>> erros;
    
    public boolean isValid(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        erros = validator.validate(this);
        return erros.isEmpty();
    }

}