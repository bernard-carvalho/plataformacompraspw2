package com.example.plataformacompraspw2.Entity.Cliente;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import lombok.Data;


@Data
@Table(name = "Cliente")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente implements Serializable {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "id", nullable = false)
    @Min( value = 1, message="ID NÃO PODE SER INFERIOR A 1")
    @NotNull(message="ID NÃO PODE SER NULO")
    private Long id;

    private String email;

    
    

    
}