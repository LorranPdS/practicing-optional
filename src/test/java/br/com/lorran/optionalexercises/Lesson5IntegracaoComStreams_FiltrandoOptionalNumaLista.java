package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson5IntegracaoComStreams_FiltrandoOptionalNumaLista {

    /**
     List<Optional<String>> nomes = List.of(
     Optional.of("Maria"),
     Optional.empty(),
     Optional.of("João"),
     Optional.empty()
     );

     // Crie uma lista apenas com os nomes presentes
     */

    @Test
    void exercicio1(){
        List<Optional<String>> nomes = List.of(
                Optional.of("Maria"),
                Optional.empty(),
                Optional.of("João"),
                Optional.empty()
        );

        List<String> nomesPresentes =
                nomes.stream()
                .flatMap(Optional::stream)
                .toList(); // Pode ser feito assim com Java 9+

//        List<String> presentes = nomes.stream()
//                .flatMap(opt -> opt.map(Stream::of)
//                .orElseGet(Stream::empty)) // Pode ser feito assim com Java 8
//                .collect(Collectors.toList());

        System.out.println(nomesPresentes); // [Maria, João]

    }
}
