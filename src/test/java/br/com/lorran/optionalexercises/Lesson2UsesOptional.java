package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson2UsesOptional {

    @Test
    void exercicio1(){
        String name1 = "Melissa";
        String name2 = "Kate";

        List<String> listNames = List.of(name1, name2);
        listNames.forEach(n -> {
            String result = getUpperCaseName(n);
            System.out.println(result);
        });
    }

    @Test
    void exercicio2(){
        String nameNull = null;
        System.out.println(getUpperCaseName(nameNull));
    }

    public static String getUpperCaseName(String nome) {
        return Optional.ofNullable(nome)
                .map(String::toUpperCase)
                .orElse("Unknown");
    }
}
