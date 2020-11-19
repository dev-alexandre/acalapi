package br.com.acalapi.controller;

import br.com.acalapi.controller.filtro.Filtro;
import br.com.acalapi.entity.Logradouro;
import br.com.acalapi.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logradouro")
public class LogradouroController extends Controller<Logradouro, Filtro>{

    @Autowired
    private LogradouroRepository service;

    @Override
    public MongoRepository getRepository() {
        return service;
    }

    @Override
    public Sort getSort() {
        return Sort.by("tipoLogradouro.nome").ascending().and(Sort.by("nome").ascending());
    }

}
