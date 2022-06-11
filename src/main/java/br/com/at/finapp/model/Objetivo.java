package br.com.at.finapp.model;

import br.com.at.finapp.abstractClasses.AbstractModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Objetivo extends AbstractModel {

    @NotNull
    private Double valor;

    @NotNull
    private String titulo;

    @NotNull
    private LocalDate prazo;

    private String descricao;
    private Integer porcentagem;
    private Double arrecadado;

    public Objetivo() {
    }

    public Objetivo(Double valor, String titulo, LocalDate prazo, String descricao, Integer porcentagem, Double arrecadado) {
        this.valor = valor;
        this.titulo = titulo;
        this.prazo = prazo;
        this.descricao = descricao;
        this.porcentagem = porcentagem;
        this.arrecadado = arrecadado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Integer porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getArrecadado() {
        return arrecadado;
    }

    public void setArrecadado(Double arrecadado) {
        this.arrecadado = arrecadado;
    }
}
