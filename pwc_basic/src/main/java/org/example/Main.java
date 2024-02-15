package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] enderecos = new String[]{"Miritiba 339","Babaçu 500",
                "Cambuí 804B","Rio Branco 23","Quirino dos Santos 23 b",
                "4, Rue de la République","100 Broadway Av","Calle Sagasta, 26",
                "Calle 44 No 1991"};

        Arrays.asList(enderecos).forEach(e -> {
            StringBuffer reverse = (new StringBuffer(e)).reverse();

            System.out.println(e);

            System.out.println(AchaEndereco.resolveEndereco(e));
        });
    }
}