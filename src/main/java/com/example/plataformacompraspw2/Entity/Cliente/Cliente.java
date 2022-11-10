package com.example.plataformacompraspw2.Entity.Cliente;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import lombok.Data;


@Data
@Table(name = "Cliente")
@Entity
public abstract class Cliente implements Serializable {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    
    

    
}