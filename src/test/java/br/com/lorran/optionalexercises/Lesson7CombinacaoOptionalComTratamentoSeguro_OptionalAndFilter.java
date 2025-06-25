package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Lesson7CombinacaoOptionalComTratamentoSeguro_OptionalAndFilter {

    /**
     Optional<String> nome = Optional.of("Fernando");

     - use filter para verificar se o nome começa com "F"
     - retorne "Aprovado" se sim, ou "Reprovado" se não

     */

    @Test
    void exercicio1(){
        Optional<String> nome = Optional.of("Luíza");
        String status = nome
                .filter(n -> n.startsWith("L"))
                .map(n -> "Aprovado")
                .orElse("Reprovado");

        System.out.println(status); // Aprovado
    }
}
