package com.pilares.mspedidos.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pilares.mspedidos.model.enuns.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

	private Long id;
    private LocalDateTime dataHora;
    private Status status;
    private List<ItemDoPedidoDto> itens = new ArrayList<>();
	
}
