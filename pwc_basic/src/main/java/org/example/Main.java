package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] enderecos = new String[]{"Miritiba 339","Babaçu 500",
                "Cambuí 804B","Rio Branco 23","Quirino dos Santos 23 b",
                "4, Rue de la République","100 Broadway Av","Calle Sagasta, 26",
                "Calle 44 No 1991"};

        Arrays.asList(enderecos).forEach(e -> {
            System.out.println(e);
            System.out.println(AchaEndereco.resolveEndereco(e));
        });
    }
}