package br.com.at.finapp.service;

import br.com.at.finapp.abstractClasses.AbstractService;
import br.com.at.finapp.model.Receita;
import br.com.at.finapp.repository.ReceitaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService extends AbstractService<Long, Receita, ReceitaRepository> {
}
