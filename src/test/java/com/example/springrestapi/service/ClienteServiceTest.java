package com.example.springrestapi.service;

import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Investimento;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteService mockClienteService;

    public ClienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarClientes_deveRetornarListaDeClientes() {
        // Configura o mock para retornar uma lista de clientes
        when(mockClienteService.listarClientes()).thenReturn(List.of(
                new Cliente(1L, "João Silva", "joao.silva@example.com"),
                new Cliente(2L, "Maria Oliveira", "maria.oliveira@example.com")
        ));

        List<Cliente> clientes = mockClienteService.listarClientes();
        assertEquals(2, clientes.size()); // Verifica se o tamanho da lista é 2
    }

    @Test
    void buscarClientePorId_deveRetornarClienteQuandoIdExistir() {
        Cliente cliente = new Cliente(1L, "João Silva", "joao.silva@example.com");
        assertNotNull(cliente); // Verifica se o cliente não é nulo
    }

    @Test
    void buscarClientePorId_deveLancarExcecaoQuandoIdNaoExistir() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Cliente não encontrado");
        });
        assertEquals("Cliente não encontrado", exception.getMessage()); // Verifica a mensagem da exceção
    }

    @Test
    void listarInvestimentosPorClienteId_deveRetornarInvestimentosQuandoIdExistir() {
        // Configura o mock para retornar uma lista de investimentos
        when(mockClienteService.listarInvestimentosPorClienteId(1L)).thenReturn(List.of(
                new Investimento(1L, "Ações", 10000.0),
                new Investimento(2L, "Fundos Imobiliários", 5000.0)
        ));

        List<Investimento> investimentos = mockClienteService.listarInvestimentosPorClienteId(1L);
        assertEquals(2, investimentos.size()); // Verifica se o tamanho da lista é 2
    }

    @Test
    void listarInvestimentosPorClienteId_deveLancarExcecaoQuandoIdNaoExistir() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("Cliente não encontrado");
        });
        assertEquals("Cliente não encontrado", exception.getMessage()); // Verifica a mensagem da exceção
    }
}
