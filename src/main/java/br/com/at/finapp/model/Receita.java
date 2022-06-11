package br.com.at.finapp.model;

import br.com.at.finapp.abstractClasses.AbstractModel;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Receita extends AbstractModel {

    private LocalDate data;
    private String descricao;
    private Double valor;

    public Receita(LocalDate data, String descricao, Double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Receita() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
