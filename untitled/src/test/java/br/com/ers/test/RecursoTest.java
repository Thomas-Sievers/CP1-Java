package br.com.ers.test;

import br.com.ers.model.Recurso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    void recursoAdicionadoNaoPodeSerPortatil(){
        Recurso recurso = new Recurso(1, "Recurso 1", "Categoria 1", 5000.0);

        boolean status = recurso.isPortatil();

        assertFalse(status, "O recurso deveria começar sem ser portátil");
    }
}
