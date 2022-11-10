package com.example.plataformacompraspw2.Entity.Cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
@Table(name = "ClientePF")
@Entity
public class ClientePF extends Cliente implements Serializable {
    
    
    private String cpf;

    @Transient
    private List<String> erros;

    public void validate(){
        
    }

    

    
}