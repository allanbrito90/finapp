package br.com.at.finapp.dto;

import br.com.at.finapp.enumeration.EnumRepetirDespesas;
import br.com.at.finapp.model.Categoria;
import br.com.at.finapp.model.Despesa;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DespesaDto {

    private Long id;
    private String descricao;
    private Double valor;
    private LocalDate dtVencimento;
    private CategoriaDto categoriaDto = new CategoriaDto();
    private String nomeResponsavel;
    private Integer parcelas;
    private EnumRepetirDespesas repetir;
    private boolean ativo;

    public static List<DespesaDto> converter(List<Despesa> despesas){
        return despesas.stream().map(DespesaDto::new).collect(Collectors.toList());
    }

    public DespesaDto(Despesa despesa) {
        BeanUtils.copyProperties(despesa,this);
        BeanUtils.copyProperties(despesa.getCategoria(), this.categoriaDto);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CategoriaDto getCategoriaDto() {
        return categoriaDto;
    }

    public void setCategoriaDto(CategoriaDto categoriaDto) {
        this.categoriaDto = categoriaDto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
