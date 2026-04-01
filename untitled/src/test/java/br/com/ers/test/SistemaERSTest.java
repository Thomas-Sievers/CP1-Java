package br.com.ers.test;

import br.com.ers.model.Colaborador;
import br.com.ers.model.Recurso;
import br.com.ers.model.SistemaERS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaERSTest {

    private SistemaERS sistema;
    private Colaborador colaboradorMock;
    private Recurso recursoMock;

    // Run this method every single test
    @BeforeEach
    void setUp(){
        sistema = new SistemaERS();

        colaboradorMock = new Colaborador(1, "João", "Desenvolvedor Junior", 3000.0);
        recursoMock = new Recurso(1, "Recurso 1", "Categoria 1", 1200.0);
    }

    @Test
    void cadastrarColaboradorComSucesso() {
        //Act
        sistema.cadastrarColaborador(colaboradorMock);

        assertEquals(1, sistema.getColaboradores().size(), "A lista deve conter um colaborador");
    }

    @Test
    void desligarColaboradorComSucesso() {
        // Arrange
        sistema.cadastrarColaborador(colaboradorMock);

        // Act
        sistema.desligarColaborador(colaboradorMock);

        // Assert
        assertTrue(sistema.getColaboradores().isEmpty(), "A lista de colaboradores deve estar vazia após a remoção.");
    }

    @Test
    void buscarColaborador() {
        // Arrange
        sistema.cadastrarColaborador(colaboradorMock);

        // Act
        Colaborador resultado = sistema.buscarColaborador("  joão  "); // Testing trim() and ignoreCase()

        // Assert
        assertNotNull(resultado, "O colaborador deve ser encontrado.");
        assertEquals("João", resultado.getNome(), "O nome do colaborador deve bater com o mock.");
    }

    @Test
    void buscarRecurso() {

        sistema.adicionarRecurso(recursoMock);

        Recurso resultado = sistema.buscarRecurso(1);

        assertNotNull(resultado, "O recurso deve ser encontrado");
        assertEquals(1, resultado.getId(), "O id do recurso deve bater com o mock.");
    }

    @Test
    void retornarNullAoBuscarColaboradorInexistente() {
        // Act
        Colaborador resultado = sistema.buscarColaborador("Maria");

        // Assert
        assertNull(resultado, "Deve retornar null pois a Maria não foi cadastrada.");
    }
}
