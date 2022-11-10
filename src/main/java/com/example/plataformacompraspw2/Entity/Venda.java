package com.example.plataformacompraspw2.Entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Table(name = "Venda")
@Entity
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
    

    
}