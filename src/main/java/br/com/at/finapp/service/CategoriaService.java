package br.com.at.finapp.service;

import br.com.at.finapp.abstractClasses.AbstractService;
import br.com.at.finapp.model.Categoria;
import br.com.at.finapp.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends AbstractService<Long, Categoria, CategoriaRepository> {
}
