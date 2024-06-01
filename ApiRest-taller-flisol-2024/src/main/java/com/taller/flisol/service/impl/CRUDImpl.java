package com.taller.flisol.service.impl;

import java.util.List;

import com.taller.flisol.exception.NewModelNotFoundException;
import com.taller.flisol.repo.IGenericoRepo;
import com.taller.flisol.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{
	
	//Método abstracto que debe ser implementado por las subclases para proporcionar el repositorio específico.
	protected abstract IGenericoRepo<T, ID> getRepo();

	@Override
	public T save(T t) {
		return getRepo().save(t);
	}

	@Override
	public T update(T t, ID id) {
		 getRepo().findById(id).orElseThrow(() -> new NewModelNotFoundException("ERROR AL ELIMINAR -> " + id));
	     return getRepo().save(t);
	}

	@Override
	public List<T> findAll() {
		return getRepo().findAll();
	}

	@Override
	public T findById(ID id) {
		return getRepo().findById(id).orElseThrow(() -> new NewModelNotFoundException("NO EXISTE REGISTRO CON ID -> " + id));
	}

	@Override
	public void delete(ID id) {
		getRepo().findById(id).orElseThrow(() -> new NewModelNotFoundException("ERROR AL ELIMINAR -> " + id));
        getRepo().deleteById(id);	
	}
}
