package com.taller.flisol.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.taller.flisol.dto.CuentaDTO;
import com.taller.flisol.model.Cuenta;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Utils {
	
	private final ModelMapper mapper;

	public  CuentaDTO convertToDtoCuenta(Cuenta obj) {
		return mapper.map(obj, CuentaDTO.class);
	}

	public  Cuenta convertToEntityCuenta(CuentaDTO dto) {
		return mapper.map(dto, Cuenta.class);
	}
}
