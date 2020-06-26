package com.github.maikoncanuto.cidade.resources;

import com.github.maikoncanuto.cidade.entities.Cidade;
import com.github.maikoncanuto.cidade.entities.dtos.ResponseDTO;
import com.github.maikoncanuto.cidade.entities.enums.UF;
import com.github.maikoncanuto.cidade.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    private final CidadeService cidadeService;

    @Autowired
    public CidadeResource(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cidade cidade) {
        final ResponseDTO<Cidade> response = cidadeService.save(cidade);
        return new ResponseEntity<>(response, CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findByNomeOuUf(@RequestParam(name = "nome", required = false) final String nome,
                                            @RequestParam(name = "uf", required = false) final UF uf) {
        final ResponseDTO<List<Cidade>> response = cidadeService.findByNomeOrUf(nome, uf);
        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final ResponseDTO<Cidade> response = cidadeService.findById(id);
        return new ResponseEntity<>(response, OK);
    }

}
