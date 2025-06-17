package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class ClassOne {

    @Test
    @DisplayName("Exercício 1: usando métodos 'of', 'empty' e 'ofNullable' para definir o Optional")
    void exercise1() {
        // valor não-nulo
        Optional<String> name = Optional.of("Mary");

        // valor ausente
        Optional<String> empty = Optional.empty();

        // pode ser nulo
        Optional<String> canBeNull = Optional.ofNullable(null);

        List<Optional<String>> optionalList = List.of(name, empty, canBeNull);
//        optionalList.forEach(System.out::println);
        optionalList.forEach(content -> System.out.println("Contents: " + content));
    }

    @Test
    @DisplayName("Exercício 2: Acessando valores de Optional")
    void exercise2() {
        Optional<String> name = Optional.of("Mary");

        // pelo metodo 'get()' que acessamos o conteúdo do Optional
        if(name.isPresent()) {
            System.out.println("Nome: " + name.get());
        } else {
            System.out.println("Nome não está presente.");
        }
    }

    @Test
    @DisplayName("Exercício 3: usando o ifPresent()")
    void exercise3() {
        Optional<String> name = Optional.of("John");
//        name.ifPresent(System.out::println);
        name.ifPresent(value -> System.out.println("Name: " + value));
    }

    @Test
    @DisplayName("Exercício 4: usando o orElse()")
    void exercise4() {
        Optional<String> noData = Optional.ofNullable(null);

        /* caso não tenha dados na variável 'semDados' (que foi o que houve quando setei null),
         ele exibirá o que estiver no conteúdo de 'orElse' */
        String message = noData.orElse("Exiba esse valor padrão");
        System.out.println(message);
    }

    @Test
    @DisplayName("Exercício 5: usando o orElseGet()")
    void exercise5() {
        // Exemplo 1
        Optional<String> nullData = Optional.empty();
        String someValue = nullData.orElseGet(() -> "Valor do String obtido dinamicamente pelo Consumer");
        System.out.println(someValue);

        // Exemplo 2
        Optional<Integer> someNumberOptional = Optional.empty();
        Integer someNumber = someNumberOptional.orElseGet(() -> 1);
        System.out.println(someNumber);
    }

    @Test
    @DisplayName("Exercício 6: usando o orElseThrow() caso não tenha dado")
    void exercise6() {
        Optional<String> noData = Optional.ofNullable(null);
        String message = noData.orElseThrow(() -> new IllegalArgumentException("Num tem nada aqui não ein"));
        System.out.println(message);
    }
}
