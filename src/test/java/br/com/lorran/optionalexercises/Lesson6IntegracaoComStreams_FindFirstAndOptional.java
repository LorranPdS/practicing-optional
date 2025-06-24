package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Lesson6IntegracaoComStreams_FindFirstAndOptional {

    /**
     List<String> linguagens = List.of("C", "C++", "Python", "Java", "Kotlin");

     - Use stream() + filter() + findFirst() para buscar a primeira linguagem com mais de 4 letras
     - Use Optional para imprimir o resultado ou uma mensagem padrão

     */

    @Test
    void exercicio1(){
        List<String> linguagens = List.of("C", "C++", "Python", "Java", "Kotlin");
        String nome = linguagens.stream()
                .filter(l -> l.length() >4) // filter() retorna Stream
                .findFirst() // findFirst() retorna Optional
                .orElse("Nenhuma encontrada"); // orElse() está no Optional e retorna T

        System.out.println(nome);
    }
}
