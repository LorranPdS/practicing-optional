package br.com.lorran.optionalexercises;

import br.com.lorran.optionalexercises.entities.AddressEntity;
import br.com.lorran.optionalexercises.entities.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LearningOptionalExercises {

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
        assertThrows(IllegalArgumentException.class, () -> noData.orElseThrow(() -> new IllegalArgumentException("Num tem nada aqui não ein")));
    }

    @Test
    @DisplayName("Exercício 7: usando o optional com o map para deixar todas as letras em maiúsculo")
    void exercise7() {
        Optional<String> name = Optional.of("mary");
        Optional<String> upperCaseName = name.map(String::toUpperCase);
        upperCaseName.ifPresent(System.out::println);
    }

    @Test
    @DisplayName("Exercício 8: usando o optional com o flatMap")
    void exercise8() {
        /**
         - map() é usado quando a função passada retorna um valor normal (não Optional).
         - flatMap() é usado quando a função passada já retorna um Optional — ou seja, evita um Optional<Optional<T>>.

         PORTANTO, A REGRA BÁSICA É:
         - map(): quando sua função retorna um tipo normal (ex: String, Integer, etc).
         - flatMap(): quando sua função já retorna um Optional.
         */

        Optional<UserEntity> userOpt = Optional.of(new UserEntity());

        String city = userOpt
                .flatMap(UserEntity::getAddressOptional) // retorna Optional<AddressEntity>
                .map(AddressEntity::getCity)      // retorna Optional<String>
                .orElse("Cidade desconhecida");

        System.out.println(city);
    }

    @Test
    @DisplayName("Exercício 9: usando o optional para trabalhar com formas aninhadas de null tradicional")
    void exercise9() {
        /**
         * Essa seria a forma tradicional de fazermos uma verificação se é nulo ou não

            UserEntity user = new UserEntity();
            if (user != null && user.getAddress() != null) {
                System.out.println(user.getAddress().getCity());
            }
         */

        // Abaixo vamos ver como fazemos as conferências acima com o Optional
        UserEntity user = new UserEntity();
        Optional.ofNullable(user)
                .map(UserEntity::getAddress)
                .map(AddressEntity::getCity)
                .ifPresent(System.out::println);
    }
}
