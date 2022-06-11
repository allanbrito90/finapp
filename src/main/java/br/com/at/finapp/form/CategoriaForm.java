package br.com.at.finapp.form;

import br.com.at.finapp.dto.CategoriaDto;
import br.com.at.finapp.model.Categoria;
import br.com.at.finapp.service.CategoriaService;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoriaForm {

    @NotNull @NotEmpty
    private String nome;

    public static List<CategoriaForm> converter(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaForm::new).collect(Collectors.toList());
    }

    public CategoriaForm() {
    }

    public CategoriaForm(Categoria categoria) {
        BeanUtils.copyProperties(categoria, this);
    }

    public static Categoria toCategoria(CategoriaForm form) {
        return new Categoria(form.getNome());
    }

    public CategoriaDto atualizar(Categoria categoria, CategoriaService service) {
        BeanUtils.copyProperties(this, categoria);
        service.save(categoria);
        return new CategoriaDto(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
