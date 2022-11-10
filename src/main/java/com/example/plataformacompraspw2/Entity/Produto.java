package com.example.plataformacompraspw2.Entity;

import javax.persistence.*;
import java.io.Serializable;
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


}