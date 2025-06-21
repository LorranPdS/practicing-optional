package br.com.lorran.optionalexercises.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private String name;
    private String city;

    public Optional<String> getCityOptional() {
        return Optional.ofNullable(city);
    }
}
