package com.recuperacao.API.Model.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogWriter {

    private static final String FILE = "logs_frete.txt";

    public static void registrar(String tipo, double distancia, double valor) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE, true))) {
            String linha = LocalDateTime.now()
                    + " - " + tipo.toUpperCase()
                    + " - " + distancia + " KM"
                    + " - R$ " + valor;
            bw.write(linha);
            bw.newLine();
        }
    }
}
