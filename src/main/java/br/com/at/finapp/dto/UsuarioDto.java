package br.com.at.finapp.dto;

import br.com.at.finapp.model.Usuario;
import org.springframework.beans.BeanUtils;

public class UsuarioDto{

    private String nome;
    private String email;
    private boolean ativo;

    public UsuarioDto() {}

    public UsuarioDto(Usuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
