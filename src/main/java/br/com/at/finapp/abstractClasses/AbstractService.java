package br.com.at.finapp.abstractClasses;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<L extends Long , T extends AbstractModel , U extends AbstractInterface<T, L>> {

    @Autowired
    private U repository;

    public T save (T object){
        if(object.getDataCriacao() == null) {
            object.setDataCriacao(LocalDateTime.now());
            object.setAtivo(true);
        }
        object.setDataAtualizacao(LocalDateTime.now());
        repository.save(object);
        return object;
    }

    public Boolean deactivate (L id){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()) {
            object.get().setAtivo(false);
            this.save(object.get());
            return true;
        }
        return false;
    }

    public Optional<T> findById(L id){ return repository.findById(id);}

    public void delete (L id){
        repository.deleteById(id);
    }

    public List<T> list() {return repository.findAll();}

    public List<T> findAllByActive(boolean active){
        return repository.findByAtivo(active);
    }


}
