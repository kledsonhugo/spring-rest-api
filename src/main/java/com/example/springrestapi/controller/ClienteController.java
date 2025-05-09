package com.example.springrestapi.controller;

import com.example.springrestapi.exception.ClienteNaoEncontradoException;
import com.example.springrestapi.model.Cliente;
import com.example.springrestapi.model.Investimento;
import com.example.springrestapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping("/{id}/investimentos")
    public List<Investimento> listarInvestimentosPorClienteId(@PathVariable Long id) {
        return clienteService.listarInvestimentosPorClienteId(id);
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<String> handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
