package br.com.ers.test;

import br.com.ers.model.Recurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecursoTest {

    @Test
    void naoPodeSerAlocadoSemAutorizacao(){
        // Arrange
        Recurso recurso = new Recurso(1, "Recurso 1", "Categoria 1", 5000.0);

        // Act
        boolean status = recurso.podeSerAlocado();

        // Assert
        assertTrue(status, "Esse recurso deveria poder ser alocado");
    }
}
