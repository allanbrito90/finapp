package br.com.at.finapp.repository;

import br.com.at.finapp.abstractClasses.AbstractInterface;
import br.com.at.finapp.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends AbstractInterface<Usuario,Long> {
}
