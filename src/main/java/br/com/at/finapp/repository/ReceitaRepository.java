package br.com.at.finapp.repository;

import br.com.at.finapp.abstractClasses.AbstractInterface;
import br.com.at.finapp.model.Receita;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends AbstractInterface<Receita,Long> {
}
