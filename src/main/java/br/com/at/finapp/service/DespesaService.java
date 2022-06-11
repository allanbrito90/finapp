package br.com.at.finapp.service;

import br.com.at.finapp.abstractClasses.AbstractService;
import br.com.at.finapp.model.Despesa;
import br.com.at.finapp.repository.DespesaRepository;
import org.springframework.stereotype.Service;

@Service
public class DespesaService extends AbstractService<Long, Despesa, DespesaRepository> {
}
