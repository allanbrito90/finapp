package br.com.at.finapp.service;

import br.com.at.finapp.abstractClasses.AbstractService;
import br.com.at.finapp.model.Objetivo;
import br.com.at.finapp.model.Usuario;
import br.com.at.finapp.repository.ObjetivoRepository;
import br.com.at.finapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService extends AbstractService<Long, Usuario, UsuarioRepository> {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar(){return repository.findAll();}

}
