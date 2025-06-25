package br.com.lorran.optionalexercises;

import br.com.lorran.optionalexercises.entities.AddressEntity;
import br.com.lorran.optionalexercises.entities.UserEntity;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class LessonXAplicacaoVariasSituacoes {

    /**
     class Usuario {
     private String login;
     private String senha;

     public String getLogin() { return login; }
     public String getSenha() { return senha; }
     }

     List<Usuario> bancoDeUsuarios = List.of(
     new Usuario("admin", "123"),
     new Usuario("user", "abc")
     );

     // Crie um método:
     // Optional<Usuario> autenticar(String login, String senha)
     // O método deve usar stream() para procurar o usuário correspondente
     // Se encontrar, retorne Optional.of(usuario)
     // Caso contrário, Optional.empty()

     // Depois, use orElseThrow() para lançar exceção se a autenticação falhar

     */

    @Test
    void exercicio1(){
        UserEntity userEntity1 = new UserEntity("Bianca", "biancag", "12345", new AddressEntity());
        UserEntity userEntity2 = new UserEntity("Fran", "franp", "qualquer", new AddressEntity());
        List<UserEntity> listUsers = List.of(userEntity1, userEntity2);

        UserEntity autenticado = autenticar("franp", "qualquer", listUsers)
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        System.out.println("Bem-vindo, " + autenticado.getLogin());
    }

    private static Optional<UserEntity> autenticar(String login, String password, List<UserEntity> usuarios) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst();
    }
}
