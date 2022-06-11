package br.com.at.finapp.abstractClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AbstractInterface<T extends AbstractModel, L extends Long> extends JpaRepository<T,L>{

    @Query(value = "SELECT t FROM #{#entityName} t WHERE t.ativo = ?1")
    public List<T> findByAtivo(boolean ativo);

}
