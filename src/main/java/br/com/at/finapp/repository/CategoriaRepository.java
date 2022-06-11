package br.com.at.finapp.repository;

import br.com.at.finapp.abstractClasses.AbstractInterface;
import br.com.at.finapp.model.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends AbstractInterface<Categoria,Long> {
}
