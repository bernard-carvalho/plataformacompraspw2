package com.example.plataformacompraspw2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plataformacompraspw2.Entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
