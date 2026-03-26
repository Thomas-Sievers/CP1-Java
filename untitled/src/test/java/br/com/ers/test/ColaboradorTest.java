package br.com.ers.test;

import br.com.ers.model.Colaborador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColaboradorTest {

    @Test // this annotation tells Maven that this is a unit test
    void recemAdmitidoDeveSerAtivo(){
        // Arrage
        Colaborador dev = new Colaborador(1, "João", "Desenvolvedor Junior", 3000.0);

        // Act
        boolean status = dev.isAtivo();

        // Assert
        assertTrue(status, "Um colaborador recém-admitido deve iniciar como ativo.");
    }

    @Test
    void promoverDeveAtualizarCargoESalario() {
        // Arrange
        Colaborador dev = new Colaborador(2, "Maria", "Desenvolvedor Junior", 3000.0);

        // Act
        dev.promover("Desenvolvedor Pleno", 5500.0);

        // Assert
        assertEquals("Desenvolvedor Pleno", dev.getCargo(), "O cargo não foi atualizado corretamente.");
        assertEquals(5500.0, dev.getSalario(), "O salario não foi atualizado corretamente.");
    }
}
