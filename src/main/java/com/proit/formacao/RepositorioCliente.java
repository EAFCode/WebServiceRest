package com.proit.formacao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente  extends JpaRepository<Cliente, Long>{
    
}
