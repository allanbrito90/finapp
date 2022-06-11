package br.com.at.finapp.form;

import br.com.at.finapp.model.Objetivo;
import br.com.at.finapp.service.ObjetivoService;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.Optional;

public class ObjetivoForm {

    private Long id;

    @NotNull @PositiveOrZero
    private Double valor;

    @NotNull @NotEmpty
    private String titulo;

    @NotNull @NotEmpty
    private LocalDate prazo;

    private String descricao;
    private Integer porcentagem;
    private Double arrecadado;

    public Double getValor() {
        return valor;
    }

    public static Objetivo toObjetivo(ObjetivoForm form) {
        return new Objetivo(form.getValor(), form.getTitulo(), form.getPrazo(), form.getDescricao(), form.getPorcentagem(), form.getArrecadado());
    }

    public Objetivo atualizar(Objetivo objetivo){
        BeanUtils.copyProperties(this, objetivo);
        return objetivo;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
