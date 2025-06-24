package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson1AtribuicaoDeValores {

    /**
     Então temos 3 tipos de atribuição
        1. atribuição de um valor que sabemos não ser nulo - Optional.of(...);
        2. atribuição de um valor vazio - Optional.empty();
        3. atribuição de um valor que tem a possibilidade de ser nulo - Optional.ofNullable(...);
     */

    @Test
    void exercicio1(){
        Optional<String> opcional1 = Optional.of("Java"); // uso da atribuição 1
        Optional<String> opcional2 = Optional.empty(); // uso da atribuição 2
        String nomePossivelmenteNulo = null;
        Optional<String> opcional3 = Optional.ofNullable(nomePossivelmenteNulo); // uso da atribuição 3

        List<Optional<String>> listOpt = List.of(opcional1, opcional2, opcional3);
        listOpt.forEach(opt ->
                opt.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Vazio")
        ));

        opcional1.ifPresent(System.out::println);
    }

    @Test
    void exercicio2(){
        Optional<Integer> valor = Optional.of(1);
        Optional<Integer> vazio = Optional.empty();
        Optional<Integer> nulo = Optional.ofNullable(null);

        List<Optional<Integer>> listIntegerOpt = List.of(valor, vazio, nulo);
        listIntegerOpt.forEach(opt -> {
            opt.ifPresentOrElse(
                    novoOpt -> System.out.println(novoOpt * 12),
                    () -> System.out.println(0)
            );
        });
    }
}
