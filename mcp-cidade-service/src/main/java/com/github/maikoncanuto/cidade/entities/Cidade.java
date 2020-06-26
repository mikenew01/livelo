package com.github.maikoncanuto.cidade.entities;

import com.github.maikoncanuto.cidade.entities.enums.UF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_CIDADE")
@Getter
@Setter
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CIDADE", nullable = false, unique = true)
    private Long id;

    @Column(name = "DS_CIDADE", nullable = false, length = 100)
    private String nome;

    @Enumerated(STRING)
    @Column(name = "DS_UF", length = 2, nullable = false)
    private UF uf;

}
