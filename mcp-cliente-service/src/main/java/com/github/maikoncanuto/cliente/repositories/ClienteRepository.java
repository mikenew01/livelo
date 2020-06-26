package com.github.maikoncanuto.cliente.repositories;

import com.github.maikoncanuto.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<List<Cliente>> findAllByNome(String nome);

}
