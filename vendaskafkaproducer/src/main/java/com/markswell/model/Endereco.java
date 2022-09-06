package com.markswell.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private Long id;
    private String cep;
    private String pais;
    private String bairro;
    private String cidade;
    private String estado;
    private String logradouro;
}
