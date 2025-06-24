package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson2EvitandoNullPointerException {

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
        return Optional.ofNullable(nome) // Situação 1 para evitar o NullPointer: verificando se ele é nulo
                .map(String::toUpperCase)
                .orElse("Unknown"); // Situação 2 para evitar o NullPointer: definindo um comportamento caso seja NullPointer
    }
}
