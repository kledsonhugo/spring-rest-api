package com.example.springrestapi.service;

import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Investimento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public List<Cliente> listarClientes() {
        // Implementação simulada
        return List.of(new Cliente(1L, "João Silva", "joao.silva@example.com"));
    }

    public Cliente buscarClientePorId(Long id) {
        // Implementação simulada
        if (id == 1L) {
            return new Cliente(1L, "João Silva", "joao.silva@example.com");
        }
        throw new RuntimeException("Cliente não encontrado");
    }

    public List<Investimento> listarInvestimentosPorClienteId(Long clienteId) {
        // Implementação simulada
        if (clienteId == 1L) {
            return List.of(new Investimento(1L, "Ações", 10000.0));
        }
        throw new RuntimeException("Cliente não encontrado");
    }
}
