package com.taller.flisol.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Data
public class RespuestaGenerica<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String mensaje;
    @JsonInclude(value = Include.NON_EMPTY)
    private T respuesta;
    @JsonInclude(value = Include.NON_EMPTY)
    private List<T> listRespuesta;

    public RespuestaGenerica<T> respuestaExitosa(T respuesta,String msj) {
        this.codigo= HttpStatus.OK.value();
        this.mensaje=msj;
        this.respuesta = respuesta;
        return this;
    }
    
    public RespuestaGenerica<T> respuestaExitosaList(List<T> respuesta,String msj) {
        this.codigo= HttpStatus.OK.value();
        this.mensaje=msj;
        this.respuesta = null;
        this.listRespuesta = respuesta;
        return this;
    }
    
    public RespuestaGenerica<T> respuestaCREATED(T respuesta,String msj) {
        this.codigo= HttpStatus.CREATED.value();
        this.mensaje=msj;
        this.respuesta = respuesta;
        return this;
    }
    
    public RespuestaGenerica<T> respuestaCONFLICT (T respuesta,String msj) {
        this.codigo= HttpStatus.CONFLICT.value();
        this.mensaje=msj;
        this.respuesta = respuesta;
        return this;
    }

    public RespuestaGenerica<T> respuestaNOT_FOUND(T respuesta,String msj) {
        this.codigo= HttpStatus.NOT_FOUND.value();
        this.mensaje=msj;
        this.respuesta = respuesta;
        return this;
    }
    
    public RespuestaGenerica<T> respuestaNO_CONTENT(T respuesta,String msj) {
        this.codigo= HttpStatus.NO_CONTENT.value();
        this.mensaje=msj;
        this.respuesta = respuesta;
        return this;
    }  
    
    public RespuestaGenerica<T> respuestaINTERNAL_SERVER_ERROR(T respuesta,String msj) {
        this.codigo= HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.mensaje=msj;
        this.respuesta = respuesta;
        return this;
    } 
}
