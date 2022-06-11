package br.com.at.finapp.model;

import br.com.at.finapp.abstractClasses.AbstractModel;
import br.com.at.finapp.enumeration.EnumRepetirDespesas;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Despesa extends AbstractModel {

    private String descricao;
    private Double valor;
    private LocalDate dtVencimento;

    @ManyToOne
    private Categoria categoria;
    private String nomeResponsavel;
    private Integer parcelas;

    @Enumerated(EnumType.STRING)
    private EnumRepetirDespesas repetir;


    public Despesa() {
    }

    public Despesa(String descricao, Double valor, LocalDate dtVencimento,
                   Categoria categoria, String nomeResponsavel, Integer parcelas,
                   EnumRepetirDespesas repetir) {
        this.descricao = descricao;
        this.valor = valor;
        this.dtVencimento = dtVencimento;
        this.categoria = categoria;
        this.nomeResponsavel = nomeResponsavel;
        this.parcelas = parcelas;
        this.repetir = repetir;
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

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public EnumRepetirDespesas getRepetir() {
        return repetir;
    }

    public void setRepetir(EnumRepetirDespesas repetir) {
        this.repetir = repetir;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
