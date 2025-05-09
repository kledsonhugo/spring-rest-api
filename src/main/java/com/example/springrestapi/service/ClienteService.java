package com.example.springrestapi.service;

import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Investimento;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {
    private final List<Cliente> clientes = Arrays.asList(
        new Cliente(1L, "João Silva", "joao.silva@example.com"),
        new Cliente(2L, "Maria Oliveira", "maria.oliveira@example.com")
    );

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Investimento> listarInvestimentosPorClienteId(Long clienteId) {
        if (clienteId == 1L) {
            return Arrays.asList(
                new Investimento(1L, "Ações", 10000.0),
                new Investimento(2L, "Fundos Imobiliários", 5000.0)
            );
        } else if (clienteId == 2L) {
            return Arrays.asList(
                new Investimento(3L, "Tesouro Direto", 8000.0)
            );
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }
}
