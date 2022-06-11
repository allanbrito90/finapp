package br.com.at.finapp.model;

import br.com.at.finapp.abstractClasses.AbstractModel;

import javax.persistence.Entity;

@Entity
public class Categoria extends AbstractModel {
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
