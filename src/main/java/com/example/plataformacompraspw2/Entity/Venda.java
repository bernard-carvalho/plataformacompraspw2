package com.example.plataformacompraspw2.Entity;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.plataformacompraspw2.Entity.Cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Data;


@Data// notação do lombok.Data que permite que não precisemos informar getters e setters
@Table(name = "tb_venda")
@Entity//notação que identifica a classe como entidade, isto é, uma tabela deve ser criada no banco para representá-la
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private LocalDate data = LocalDate.now();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)//notação que informa a multiplicidade do proximo atributo
    @JoinColumn(name="cod_venda") //nome da coluna
    private List<ItemVenda> itensVenda = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cod_cliente")
    private Cliente cliente;

    @Transient
    private Set<ConstraintViolation<Venda>> erros;

    public boolean isValid(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        erros = validator.validate(this);
        return erros.isEmpty();
    }
    
    

    
}