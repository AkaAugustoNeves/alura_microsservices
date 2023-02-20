package com.pilares.mspagamentos.model.dto;

import java.math.BigDecimal;

import com.pilares.mspagamentos.model.enuns.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDto {
	
	private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long formaDePagamentoId;
    private Long pedidoId;

}
