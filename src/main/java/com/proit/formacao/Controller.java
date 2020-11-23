package com.proit.formacao;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private RepositorioCliente repositorioCliente;

    @PostMapping
    private Cliente save(@RequestBody Cliente cliente) {
        return repositorioCliente.save(cliente);
    }
    
    @GetMapping
    public List<Cliente> list() {
        return repositorioCliente.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable String id) {
        Optional<Cliente> clienteOp = repositorioCliente.findById(id);
        if( clienteOp.isEmpty() )
        return ResponseEntity.notFound().build();
        return ResponseEntity.ok(clienteOp.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente,@PathVariable String id) {
        Optional<Cliente> clienteOp = repositorioCliente.findById(id);
        if (clienteOp.isEmpty())
            return ResponseEntity.notFound().build();
        cliente.setId(id);
        return ResponseEntity.ok(repositorioCliente.save(cliente));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable String id) {
        repositorioCliente.deleteById(id);
    }

    
}
