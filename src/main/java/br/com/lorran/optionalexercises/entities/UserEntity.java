package br.com.lorran.optionalexercises.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private String name;
    private AddressEntity address;

    public Optional<AddressEntity> getAddressOptional(){
        return Optional.ofNullable(address);
    }
}
