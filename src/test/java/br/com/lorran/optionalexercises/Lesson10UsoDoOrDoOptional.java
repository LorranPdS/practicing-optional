package br.com.lorran.optionalexercises;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class Lesson10UsoDoOrDoOptional {

    /**
     O QUE FAZ O .or(...)?
     O método .or(Supplier<? extends Optional<T>>) permite encadear um Optional
     alternativo sem quebrar o fluxo fluente.
     É como dizer: “Se este Optional estiver vazio, use esse outro aqui.”

     Exemplo prático:
     Imagine que você está tentando buscar o nome de um usuário em várias fontes.
     A prioridade é:
        1. Banco de dados
        2. Cache
        3. Valor padrão

     Façamos no primeiro teste como que ficaria
     */

    @Test
    void exercicio1UsandoMetodoOr() {
        String nome = buscarNomeDoBanco()
                .or(() -> buscarNomeDoCache()) // Se banco falhar, tenta cache
                .or(() -> Optional.of("Desconhecido")) // Se tudo falhar, usa padrão
                .get(); // ou .orElse(...)

        System.out.println(nome); // Saída: Nome do Cache
    }

    public static Optional<String> buscarNomeDoBanco() {
        return Optional.empty(); // Simula que o banco está fora
    }

    public static Optional<String> buscarNomeDoCache() {
        return Optional.of("Nome do Cache");
    }

    @Test
    void exercicio2OutroExemploUsandoOr(){
        Optional<String> valorDoArquivo = Optional.empty();
        Optional<String> valorDoBanco = Optional.of("ConfigBanco");

        String valorFinal = valorDoArquivo
                .or(() -> valorDoBanco)
                .or(() -> Optional.of("Padrão"))
                .get();

        System.out.println(valorFinal); // Saída: ConfigBanco
    }
}
