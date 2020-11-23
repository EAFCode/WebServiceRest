package com.proit.formacao;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cliente {

    @Id
    private String id;
    private LocalDate dataNascimento;
    private String bi;
    private String provincia;
    private String municipio;
    private String telefone;
    private String email;
}
