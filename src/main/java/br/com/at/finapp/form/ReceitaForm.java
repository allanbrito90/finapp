package br.com.at.finapp.form;

import br.com.at.finapp.model.Receita;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class ReceitaForm {

    @NotNull @NotEmpty
    private LocalDate data;

    private String descricao;

    @NotNull @PositiveOrZero
    private Double valor;

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

    public Receita toReceita() {
        return new Receita(this.data, this.descricao, this.valor);
    }

    public Receita atualizar(Receita receita) {
        BeanUtils.copyProperties(this, receita);
        return receita;
    }
}
