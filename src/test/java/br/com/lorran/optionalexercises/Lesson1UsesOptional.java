package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson1UsesOptional {

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
