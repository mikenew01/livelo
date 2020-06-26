package com.github.maikoncanuto.cidade.services;

import com.github.maikoncanuto.cidade.entities.Cidade;
import com.github.maikoncanuto.cidade.entities.dtos.ResponseDTO;
import com.github.maikoncanuto.cidade.entities.enums.UF;
import com.github.maikoncanuto.cidade.repositories.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service
public class CidadeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CidadeService.class);

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional(propagation = REQUIRED)
    public ResponseDTO<Cidade> save(final Cidade cidade) {
        LOGGER.info(format("[CidadeService-save] - Salvando cidade %s", cidade));
        this.cidadeRepository.save(cidade);
        return new ResponseDTO<>(cidade);
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public ResponseDTO<List<Cidade>> findByNomeOrUf(final String nomeCidade, final UF uf) {
        LOGGER.info(format("[CidadeService-findByNomeOrUf] - Buscando por NOME[%s] e UF[%s]", nomeCidade, uf));
        final Optional<List<Cidade>> cidades = this.cidadeRepository.findAllByNomeOrUf(nomeCidade, uf);
        return new ResponseDTO<>(cidades.orElse(null));
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public ResponseDTO<Cidade> findById(final Long id) {
        LOGGER.info(format("[CidadeService-findById] - Buscando por ID[%s]", id));
        final Optional<Cidade> cidade = this.cidadeRepository.findById(id);
        return new ResponseDTO<>(cidade.orElse(null));
    }

}
