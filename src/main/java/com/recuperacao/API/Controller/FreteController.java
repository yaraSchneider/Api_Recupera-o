package com.recuperacao.API.Controller;


import com.recuperacao.API.Model.Entity.Pedido;
import com.recuperacao.API.Model.Entity.ResultadoFrete;
import com.recuperacao.API.Model.Util.LogWriter;
import com.recuperacao.API.Service.FreteFactory;
import com.recuperacao.API.Service.FreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fretes")
public class FreteController {

    private final FreteFactory freteFactory;

    public FreteController(FreteFactory freteFactory) {
        this.freteFactory = freteFactory;
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody Pedido pedido) {

        if (pedido.getDistancia() <= 0) {
            return ResponseEntity.badRequest().body("Distância deve ser maior que zero.");
        }

        try {
            FreteService estrategia = freteFactory.obterEstrategia(pedido.getTipoFrete());
            double valor = estrategia.calcularFrete(pedido.getDistancia());

            ResultadoFrete resultado = new ResultadoFrete(
                    valor,
                    pedido.getTipoFrete(),
                    pedido.getDistancia()
            );

            // grava log
            LogWriter.registrar(pedido.getTipoFrete(), pedido.getDistancia(), valor);

            return ResponseEntity.ok(resultado);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro inesperado no cálculo.");
        }
    }

    @GetMapping("/tabela")
    public ResponseEntity<?> tabela() {

        return ResponseEntity.ok(
                new String[]{
                        "Economico - R$ 0,50 por KM",
                        "Expresso - R$ 0,80 por KM + taxa fixa R$ 15"
                }
        );
    }
}