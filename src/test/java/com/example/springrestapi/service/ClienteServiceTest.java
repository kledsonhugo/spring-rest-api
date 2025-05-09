package com.example.springrestapi.service;

import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Investimento;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private final ClienteService clienteService = new ClienteService();

    @Test
    void listarClientes_deveRetornarListaDeClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        assertNotNull(clientes);
        assertEquals(2, clientes.size());
    }

    @Test
    void buscarClientePorId_deveRetornarClienteQuandoIdExistir() {
        Cliente cliente = clienteService.buscarClientePorId(1L);
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
    }

    @Test
    void buscarClientePorId_deveLancarExcecaoQuandoIdNaoExistir() {
        Exception exception = assertThrows(RuntimeException.class, () -> clienteService.buscarClientePorId(99L));
        assertEquals("Cliente não encontrado", exception.getMessage());
    }

    @Test
    void listarInvestimentosPorClienteId_deveRetornarInvestimentosQuandoIdExistir() {
        List<Investimento> investimentos = clienteService.listarInvestimentosPorClienteId(1L);
        assertNotNull(investimentos);
        assertEquals(2, investimentos.size());
    }

    @Test
    void listarInvestimentosPorClienteId_deveLancarExcecaoQuandoIdNaoExistir() {
        Exception exception = assertThrows(RuntimeException.class, () -> clienteService.listarInvestimentosPorClienteId(99L));
        assertEquals("Cliente não encontrado", exception.getMessage());
    }
}
