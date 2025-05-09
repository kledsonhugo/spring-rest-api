package com.example.springrestapi.model;

public class Investimento {
    private Long id;
    private String tipo;
    private Double valor;

    // Construtores, getters e setters
    public Investimento(Long id, String tipo, Double valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
