package br.com.lorran.optionalexercises;

import br.com.lorran.optionalexercises.entities.AddressEntity;
import br.com.lorran.optionalexercises.entities.UserEntity;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Lesson4EncadeamentosETransformacoes_FlatMapComRetornoEncadeado {

    /**
     class Usuario {
     private Endereco endereco;
     public Optional<Endereco> getEndereco() { return Optional.ofNullable(endereco); }
     }

     class Endereco {
     private String cidade;
     public Optional<String> getCidade() { return Optional.ofNullable(cidade); }
     }

     // Dado um Optional<Usuario>, recupere a cidade usando flatMap e orElse

     */

    @Test
    void exercicio1(){
        Optional<UserEntity> userOptional = Optional.of(new UserEntity());
        String city = userOptional.flatMap(UserEntity::getAddressOptional)
                .flatMap(AddressEntity::getCityOptional)
                .orElse("Unknown City");
        System.out.println(city);
    }

    @Test
    void exercicio2(){
        var addressEntity = new AddressEntity("any address", "London");
        var userEntity = new UserEntity("Kate", "", "", addressEntity);

        Optional<UserEntity> userOptional = Optional.of(userEntity);
        String city = userOptional.flatMap(UserEntity::getAddressOptional)
                .flatMap(AddressEntity::getCityOptional)
                .orElse("Unknown City");
        System.out.println(city);
    }
}
