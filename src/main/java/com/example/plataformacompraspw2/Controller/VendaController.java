package com.example.plataformacompraspw2.Controller;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContext;

import com.example.plataformacompraspw2.Entity.Venda;
import com.example.plataformacompraspw2.Repository.VendaRepository;




@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/vendas")
@Transactional
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    Venda carrinho;

    //##
    //##  VIEW ENDPOINTS
    //##


    //##
    //##  REST API ENDPOINTS
    //##
    
    @GetMapping("carrinho")
    public ResponseEntity<?> find() {
        try {
            return new ResponseEntity<>(carrinho, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("carrinho")
    public ResponseEntity<?> save_carrinho(HttpServletRequest request,@RequestBody Venda carrinho) {
        try {
            if(carrinho.isValid()){
                vendaRepository.save(carrinho);
                request.getSession().invalidate();
                return new ResponseEntity<>(carrinho, HttpStatus.OK);
            }
            return new ResponseEntity<>(carrinho, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("carrinho")
    public ResponseEntity<?> update_carrinho(@RequestBody Venda carrinho) {
        try {
            //TODO Implement Your Logic To Update Data And Return Result Through ResponseEntity
            if(carrinho.isValid())
            {
                this.carrinho=carrinho;
                return new ResponseEntity<>(carrinho, HttpStatus.OK);
            }
            return new ResponseEntity<>(carrinho, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("carrinho")
    public ResponseEntity<?> destroy_carrinho() {
        try {
            carrinho = new Venda();
            return new ResponseEntity<>("{\"message\":\"ok\"}", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(vendaRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        try {
            //TODO Implement Your Logic To Get Data From Service Layer Or Directly From Repository Layer
            return new ResponseEntity<>(vendaRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Venda venda) {
        try {
            //TODO Implement Your Logic To Save Data And Return Result Through ResponseEntity
            if(venda.isValid()){
                vendaRepository.save(venda);
                return new ResponseEntity<>(venda, HttpStatus.OK);
            }
            return new ResponseEntity<>(venda, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Venda venda) {
        try {
            //TODO Implement Your Logic To Update Data And Return Result Through ResponseEntity
            if(venda.isValid())
            {
                vendaRepository.save(venda);
                return new ResponseEntity<>(vendaRepository.save(venda), HttpStatus.OK);
            }
            return new ResponseEntity<>(venda, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        try {
            vendaRepository.deleteById(id);
            return new ResponseEntity<>("{\"message\":\"ok\"}", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
