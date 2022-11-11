package com.example.plataformacompraspw2.Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.plataformacompraspw2.Entity.Produto;
import com.example.plataformacompraspw2.Repository.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    //##
    //##  VIEW ENDPOINTS
    //##

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("produtos", produtoRepository.findAll());
        return new ModelAndView("/produtos/list",model);
    }


    //##
    //##  REST API ENDPOINTS
    //##

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            
            //TODO Implement Your Logic To Get Data From Service Layer Or Directly From Repository Layer
            return new ResponseEntity<>( produtoRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            //TODO Implement Your Logic To Get Data From Service Layer Or Directly From Repository Layer
            return new ResponseEntity<>(produtoRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Produto produto) {
        try {
            if(produto.isValid())
                return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Produto produto) {
        try {
            //TODO Implement Your Logic To Update Data And Return Result Through ResponseEntity
            return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        try {
            //TODO Implement Your Logic To Destroy Data And Return Result Through ResponseEntity
            produtoRepository.deleteById(id);

            return new ResponseEntity<>("{\"message\":\"ok\"}", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
