package com.github.maikoncanuto.cidade.entities.dtos;

import com.github.maikoncanuto.cidade.entities.enums.UF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO implements Serializable {

    private Long id;
    private String nome;
    private UF uf;

}
