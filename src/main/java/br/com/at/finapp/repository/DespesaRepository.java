package br.com.at.finapp.repository;

import br.com.at.finapp.abstractClasses.AbstractInterface;
import br.com.at.finapp.model.Despesa;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends AbstractInterface<Despesa,Long> {
}
