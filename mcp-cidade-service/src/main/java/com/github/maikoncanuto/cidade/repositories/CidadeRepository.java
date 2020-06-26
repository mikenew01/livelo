package com.github.maikoncanuto.cidade.repositories;

import com.github.maikoncanuto.cidade.entities.Cidade;
import com.github.maikoncanuto.cidade.entities.enums.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<List<Cidade>> findAllByNomeOrUf(String nome, UF uf);

}
