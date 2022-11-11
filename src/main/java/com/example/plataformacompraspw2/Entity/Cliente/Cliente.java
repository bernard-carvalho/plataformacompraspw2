package com.example.plataformacompraspw2.Entity.Cliente;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import lombok.Data;


@Data// notação do lombok.Data que permite que não precisemos informar getters e setters
@Table(name = "tb_cliente")
@Entity//notação que identifica a classe como entidade, isto é, uma tabela deve ser criada no banco para representá-la
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente implements Serializable {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    @Email
    private String email;

}