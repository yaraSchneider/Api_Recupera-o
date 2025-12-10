package com.recuperacao.API.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultadoFrete {
    private double valor;
    private String tipoFrete;
    private double distancia;
}
