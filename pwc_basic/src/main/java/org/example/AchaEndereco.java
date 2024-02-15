package org.example;


import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AchaEndereco {

    public static String resolveEndereco(String end) {

        if (end.isEmpty())
            return null;

        final Retorno ret = new Retorno();

        final Pattern patternForNumberAndCharacter = Pattern.compile("([0-9]+[ ]+[a-zA-Z])");

        if (end.contains(",")) {
            String[] spl = end.split("([,])");
            Arrays.asList(spl).forEach(
                    rest -> {
                        if (rest.matches("([0-9]+[A-Za-z])|([0-9]+[ ]+[A-Za-z])|([0-9]*)"))
                            ret.setNumero(rest);

                        if (rest.matches("([a-zA-Z \u0080-\u9fff]*)"))
                            ret.setRua((ret.getRua() + " " +rest).trim());
                    });
        } else if (end.contains("No")) {

        } else if (patternForNumberAndCharacter.matcher(end).find()) {
            System.out.println("deu bom");
        } else {
            String[] spl = end.split("([ ])");
            Arrays.asList(spl).forEach(
                    rest -> {
                        if (rest.matches("([0-9]+[A-Za-z])|([0-9]+[ ]+[A-Za-z])|([0-9]*)"))
                            ret.setNumero(rest);

                        if (rest.matches("([a-zA-Z \u0080-\u9fff]*)"))
                            ret.setRua((ret.getRua() + " " + rest).trim());
                    });
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(ret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
