package com.recuperacao.API.Service;

public class FreteEconomico implements FreteService {

    @Override
    public double calcularFrete(double distancia) {
        return distancia * 0.50;
    }
}
