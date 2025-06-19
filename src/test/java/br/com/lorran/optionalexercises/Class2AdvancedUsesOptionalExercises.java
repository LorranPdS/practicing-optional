package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

// TODO: fazer os exercícios que coloquei no ChatGPT
    // Lembrar de entrar no Optional, ver quais são os métodos que existem e testar com cada um
public class Class2AdvancedUsesOptionalExercises {

    @Test
    void exercicio1(){
        Optional<String> opcional1 = Optional.of("Java");
        Optional<String> opcional2 = Optional.empty();
        String nomePossivelmenteNulo = null;
        Optional<String> opcional3 = Optional.ofNullable(nomePossivelmenteNulo);

        List<Optional<String>> listOpt = List.of(opcional1, opcional2, opcional3);
        listOpt.forEach(opt ->
                opt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Vazio")
        ));
    }

    @Test
    void exercicio2(){
    }
}
