package com.pilares.mspedidos.model.dto;

import com.pilares.mspedidos.model.enuns.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {
	private Status status;
}
