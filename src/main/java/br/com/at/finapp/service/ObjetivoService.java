package br.com.at.finapp.service;

import br.com.at.finapp.abstractClasses.AbstractService;
import br.com.at.finapp.model.Objetivo;
import br.com.at.finapp.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivoService extends AbstractService<Long, Objetivo, ObjetivoRepository> {

}
