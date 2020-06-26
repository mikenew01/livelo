package com.github.maikoncanuto.cliente.entities;

import com.github.maikoncanuto.cliente.entities.enums.Genero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@ToString
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CLIENTE", nullable = false, unique = true)
    private Long id;

    @Column(name = "DS_NOME", length = 150, nullable = false)
    private String nome;

    @Enumerated(STRING)
    @Column(name = "DS_SEXO", nullable = false, length = 10)
    private Genero sexo;

    @Column(name = "DT_DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "ID_CIDADE")
    private Long idCidade;

}
