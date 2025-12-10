package com.recuperacao.API.Service;

public class FreteExpresso implements FreteService {

    private static final double TAXA_FIXA = 15.0;

    @Override
    public double calcularFrete(double distancia) {
        return (distancia * 0.80) + TAXA_FIXA;
    }
}
