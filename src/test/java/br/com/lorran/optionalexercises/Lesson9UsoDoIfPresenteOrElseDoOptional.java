package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Lesson9UsoDoIfPresenteOrElseDoOptional {

    /**
     Ao comparar o teste 1 com o teste 2, vemos que o uso do teste 2 do
     'isPresent()' e do '.get()' são meio que ultrapassados, então
     FARIA MAIS SENTIDO se usássemos o '.ifPresentOrElse(..., ...)'
     ou o 'ifPresent(...)' em vez deles
     */

    @Test
    void exercicio1ComIfPresentOrElseJava9() {
        Optional<String> opcional1 = Optional.of("Java");
        Optional<String> opcional2 = Optional.empty();
        String nomePossivelmenteNulo = null;
        Optional<String> opcional3 = Optional.ofNullable(nomePossivelmenteNulo);

        List<Optional<String>> listOpt = List.of(opcional1, opcional2, opcional3);

        listOpt.forEach(opt ->
                opt.ifPresentOrElse( // uso do 'ifPresentOrElse'
                        valor -> System.out.println("Valor: " + valor),
                        () -> System.out.println("Vazio")
                )
        );
    }

    @Test
    void exercicio2ComIfPresentOrElseJava8() {
        Optional<String> opcional1 = Optional.of("Java");
        Optional<String> opcional2 = Optional.empty();
        String nomePossivelmenteNulo = null;
        Optional<String> opcional3 = Optional.ofNullable(nomePossivelmenteNulo);

        List<Optional<String>> listOpt = List.of(opcional1, opcional2, opcional3);

        // O método 'ifPresentOrElse' não existe no Java 8. Foi criado no Java 9
        listOpt.forEach(opt -> {
            if (opt.isPresent()) {
                System.out.println("Valor: " + opt.get());
            } else {
                System.out.println("Vazio");
            }
        });
    }
}
