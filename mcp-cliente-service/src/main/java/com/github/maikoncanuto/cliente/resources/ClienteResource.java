package com.github.maikoncanuto.cliente.resources;

import com.github.maikoncanuto.cliente.entities.Cliente;
import com.github.maikoncanuto.cliente.entities.dtos.ResponseDTO;
import com.github.maikoncanuto.cliente.services.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteResource.class);

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody final Cliente cliente) {
        LOGGER.info(format("[ClienteResource-create] - request %s", cliente));
        final ResponseDTO<Cliente> response = clienteService.save(cliente);
        return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody Cliente cliente) {
        LOGGER.info(format("[ClienteResource-update] - request id[%s]", id));
        final ResponseDTO<Cliente> response = clienteService.update(id, cliente);
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        LOGGER.info(format("[ClienteResource-findById] - request id[%s]", id));
        final ResponseDTO<Cliente> response = clienteService.findById(id);
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping
    public ResponseEntity<?> findByNome(@RequestParam(name = "nome", required = false) final String nome) {
        LOGGER.info(format("[ClienteResource-findByNome] - request nome[%s]", nome));
        final ResponseDTO<List<Cliente>> response = clienteService.findByNome(nome);
        return new ResponseEntity<>(response, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        LOGGER.info(format("[ClienteResource-delete] - request id[%s]", id));
        final ResponseDTO<Cliente> response = clienteService.delete(id);
        return new ResponseEntity<>(response, OK);
    }
}
