package org.example;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class AchaEndereco {

    public static String resolveEndereco(String end) {

        if (end.isEmpty())
            return null;

        final Retorno ret = new Retorno();

        final String[] parts = end.split("\\d+\\d+\\w|(No)+\\s+\\d+\\d|^\\d+|\\d+\\d+\\s+\\w+$|\\d+\\d+$");

        ret.setRua(parts[0].isBlank() ? parts[1].replace(",", "").trim() : parts[0].replace(",", "").trim());
        ret.setNumero(end.replace(ret.getRua(), "").replace(",", "").trim());

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(ret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
