package br.com.lorran.optionalexercises.entities;

import lombok.Data;

import java.util.Optional;

@Data
public class UserEntity {

    private String name;
    private AddressEntity address;

    public Optional<AddressEntity> getAddressOptional(){
        return Optional.ofNullable(address);
    }
}
