package com.taller.flisol.service;

import java.util.Optional;

import com.taller.flisol.model.Cuenta;


public interface ICuentaService extends ICRUD<Cuenta, Long>{
	
    Optional<Cuenta> edit(Long id, Cuenta obj);
    
    Cuenta getCuentaByNumero(String numeroCuenta);

}
