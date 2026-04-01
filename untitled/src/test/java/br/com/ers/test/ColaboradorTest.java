package br.com.ers.test;

import br.com.ers.model.Colaborador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColaboradorTest {
    private Colaborador dev;

    @BeforeEach
    void setUp(){
        dev = new Colaborador(1, "João", "Desenvolvedor Junior", 3000.0);
    }

    @Test // this annotation tells Maven that this is a unit test
    void recemAdmitidoDeveSerAtivo(){
        // Act
        boolean status = dev.isAtivo();

        // Assert
        assertTrue(status, "Um colaborador recém-admitido deve iniciar como ativo.");
    }

    @Test
    void recemAdmitidoNaoDeveTerHome(){
        boolean status = dev.isHomeOffice();

        assertFalse(status, "Um colaborador deve começar sem Home Office");
    }

    @Test
    void promoverDeveAtualizarCargoESalario() {

        // Act
        dev.promover("Desenvolvedor Pleno", 5500.0);

        // Assert
        assertEquals("Desenvolvedor Pleno", dev.getCargo(), "O cargo não foi atualizado corretamente.");
        assertEquals(5500.0, dev.getSalario(), "O salario não foi atualizado corretamente.");
    }
}
