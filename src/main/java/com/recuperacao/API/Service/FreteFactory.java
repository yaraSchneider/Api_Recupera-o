package com.recuperacao.API.Service;

import org.springframework.stereotype.Component;

@Component
public class FreteFactory {

    public FreteService obterEstrategia(String tipo) {

        switch (tipo.toLowerCase()) {
            case "economico":
                return new FreteEconomico();
            case "expresso":
                return new FreteExpresso();
            default:
                throw new IllegalArgumentException("Tipo de frete inválido: " + tipo);
        }
    }
}
