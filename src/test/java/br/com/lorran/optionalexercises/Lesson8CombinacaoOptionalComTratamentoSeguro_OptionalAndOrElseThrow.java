package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Lesson8CombinacaoOptionalComTratamentoSeguro_OptionalAndOrElseThrow {

    /**
     Optional<String> token = Optional.empty();
     // Lance uma IllegalStateException com a mensagem "Token inválido" se não estiver presente
     */

    @Test
    void exercicio1(){
        Optional<String> token = Optional.empty();
        String resultado = token.orElseThrow(() -> new IllegalStateException("Token inválido"));
        System.out.println(resultado);
    }
}
