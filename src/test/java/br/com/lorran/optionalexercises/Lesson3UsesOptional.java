package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson3UsesOptional {

    /**
     Optional<String> linguagem = Optional.of("java");
     // Transforme em maiúsculas e retorne "INDEFINIDO" caso esteja vazio

     */

    @Test
    void exercicio1(){
        Optional<String> language = Optional.of("java");
        Optional<String> nullData = Optional.ofNullable(null);

        var result1 = language.map(String::toUpperCase).orElse("UNDEFINED");
        var result2 = nullData.map(String::toUpperCase).orElse("UNDEFINED");

        List.of(result1, result2).forEach(System.out::println);
    }
}
