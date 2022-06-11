package br.com.at.finapp.repository;

import br.com.at.finapp.abstractClasses.AbstractInterface;
import br.com.at.finapp.model.Objetivo;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoRepository extends AbstractInterface<Objetivo, Long> {
}
