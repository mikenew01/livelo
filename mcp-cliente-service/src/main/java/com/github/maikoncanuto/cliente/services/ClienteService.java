package com.github.maikoncanuto.cliente.services;

import com.github.maikoncanuto.cliente.entities.Cliente;
import com.github.maikoncanuto.cliente.entities.dtos.ResponseDTO;
import com.github.maikoncanuto.cliente.repositories.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.springframework.transaction.annotation.Propagation.*;

@Service
public class ClienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(propagation = NEVER)
    public ResponseDTO<Cliente> save(final Cliente cliente) {
        LOGGER.info(format("[ClienteService-save] - Salvando cliente %s", cliente));
        clienteRepository.save(cliente);
        return new ResponseDTO<>(cliente);
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public ResponseDTO<List<Cliente>> findByNome(final String nome) {
        LOGGER.info(format("[ClienteService-findByNome] - Buscando por NOME[%s]", nome));
        final Optional<List<Cliente>> clientes = clienteRepository.findAllByNome(nome);
        return new ResponseDTO<>(clientes.orElse(null));
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public ResponseDTO<Cliente> findById(final Long id) {
        LOGGER.info(format("[ClienteService-findById] - Buscando por ID[%s]", id));
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return new ResponseDTO<>(cliente.orElse(null));
    }

    @Transactional(propagation = REQUIRED)
    public ResponseDTO<Cliente> update(final Long id, final Cliente cliente) {
        final Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            final Cliente clienteUpdate = clienteRepository.saveAndFlush(cliente);
            return new ResponseDTO<>(clienteUpdate);
        }

        return new ResponseDTO<>(null);
    }

    @Transactional(propagation = REQUIRED)
    public ResponseDTO<Cliente> delete(final Long id) {
        final Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            clienteRepository.delete(clienteOptional.get());
            return new ResponseDTO<>(clienteOptional.get());
        }

        return new ResponseDTO<>(null);
    }
}
