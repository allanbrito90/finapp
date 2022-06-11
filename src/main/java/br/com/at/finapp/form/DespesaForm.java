package br.com.at.finapp.form;

import br.com.at.finapp.dto.CategoriaDto;
import br.com.at.finapp.enumeration.EnumRepetirDespesas;
import br.com.at.finapp.model.Categoria;
import br.com.at.finapp.model.Despesa;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

public class DespesaForm {


    private String descricao;

    @NotNull
    @PositiveOrZero
    private Double valor;

    @NotNull @NotEmpty
    private LocalDate dtVencimento;

    @NotNull
    private CategoriaDto categoriaDto;

    @Size(min = 10, max = 200, message = "O texto deve conter entre 1 à 200 caracteres")
    private String nomeResponsavel;
    private Integer parcelas;
    private EnumRepetirDespesas repetir;

    public static Despesa toDespesa(DespesaForm form, Categoria categoria) {
        return new Despesa(
                form.getDescricao(),
                form.getValor(),
                form.getDtVencimento(),
                categoria,
                form.getNomeResponsavel(),
                form.getParcelas(),
                form.getRepetir());
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

    public CategoriaDto getCategoria() {
        return categoriaDto;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoriaDto = categoria;
    }

    public Despesa atualizar(Despesa despesa) {
        BeanUtils.copyProperties(this, despesa);
        return despesa;
    }
}
