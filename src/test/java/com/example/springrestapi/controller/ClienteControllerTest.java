package com.example.springrestapi.controller;

import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Investimento;
import com.example.springrestapi.service.ClienteService;
import com.example.springrestapi.service.InvestimentoService;
import com.example.springrestapi.exception.ClienteNaoEncontradoException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private InvestimentoService investimentoService;

    @Test
    void listarClientes_deveRetornarStatus401ParaNaoAutenticado() throws Exception {
        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isUnauthorized()); // Atualizado para 401
    }

    @Test
    @WithMockUser // Simula um usuário autenticado
    void listarClientes_deveRetornarStatus200() throws Exception {
        when(clienteService.listarClientes()).thenReturn(List.of(new Cliente(1L, "João Silva", "joao.silva@example.com")));
        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("João Silva"));
    }

    @Test
    @WithMockUser // Simula um usuário autenticado
    void buscarClientePorId_deveRetornarStatus200QuandoClienteExistir() throws Exception {
        when(clienteService.buscarClientePorId(1L)).thenReturn(new Cliente(1L, "João Silva", "joao.silva@example.com"));
        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João Silva"));
    }

    @Test
    @WithMockUser // Simula um usuário autenticado
    void buscarClientePorId_deveRetornarStatus404QuandoClienteNaoExistir() throws Exception {
        // Configura o mock para lançar uma exceção quando o cliente não for encontrado
        when(clienteService.buscarClientePorId(anyLong())).thenThrow(new ClienteNaoEncontradoException("Cliente não encontrado"));

        mockMvc.perform(get("/api/clientes/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser // Simula um usuário autenticado
    void listarInvestimentosPorClienteId_deveRetornarStatus200QuandoInvestimentosExistirem() throws Exception {
        when(clienteService.listarInvestimentosPorClienteId(1L)).thenReturn(List.of(new Investimento(1L, "Ações", 10000.0)));
        mockMvc.perform(get("/api/clientes/1/investimentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipo").value("Ações"));
    }

    @Test
    @WithMockUser // Simula um usuário autenticado
    void listarInvestimentosPorClienteId_deveRetornarStatus404QuandoClienteNaoExistir() throws Exception {
        // Configura o mock para lançar uma exceção quando o cliente não for encontrado
        when(clienteService.listarInvestimentosPorClienteId(anyLong())).thenThrow(new ClienteNaoEncontradoException("Cliente não encontrado"));

        mockMvc.perform(get("/api/clientes/999/investimentos"))
                .andExpect(status().isNotFound());
    }
}
