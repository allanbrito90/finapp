package br.com.at.finapp.dto;

import br.com.at.finapp.model.Objetivo;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ObjetivoDto {

    private Long id;
    private Double valor;
    private String titulo;
    private LocalDate prazo;
    private Integer porcentagem;
    private Double arrecadado;
    private boolean ativo;

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

    public Integer getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Integer porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Long getId() { return id; }

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ObjetivoDto() {
    }

    public ObjetivoDto(Objetivo objetivo) {
        BeanUtils.copyProperties(objetivo, this);
    }

    public static List<ObjetivoDto> converter(List<Objetivo> objetivos) {
        return objetivos.stream().map(ObjetivoDto::new).collect(Collectors.toList());
    }
}
