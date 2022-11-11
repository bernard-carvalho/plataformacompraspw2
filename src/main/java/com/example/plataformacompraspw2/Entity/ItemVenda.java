package com.example.plataformacompraspw2.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity //notação que identifica a classe como entidade, isto é, uma tabela deve ser criada no banco para representá-la
@Data // notação do lombok.Data que permite que não precisemos informar getters e setters
@Table(name="tb_item_venda") // notação opcional que informa o nome da tabela a ser criada
public class ItemVenda implements Serializable {
    /*######################################
    * ATRIBUTOS
    #######################################*/
       
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Min(value=0, message = "PREÇO NÃO PODE SER NEGATIVO")
        private Double precoUnitario;

        @Min(value = 1, message = "QUANTIDADE NÃO PODE SER INFERIOR A 1")
        private Integer quantidade;

        @OneToOne
        @JoinColumn(name="cod_produto")
        @NotNull(message = "PRODUTO INEXISTENTE")
        private Produto produto;

        @Transient
        private Set<ConstraintViolation<ItemVenda>> erros;

        public boolean isValid(){
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            erros = validator.validate(this);
            return erros.isEmpty();
        }

        public Double getValorItem(){
            return precoUnitario*quantidade;
        }
}