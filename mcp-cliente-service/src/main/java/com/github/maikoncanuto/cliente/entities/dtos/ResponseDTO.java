package com.github.maikoncanuto.cliente.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {

    private T data;

}
