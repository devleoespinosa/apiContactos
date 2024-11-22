package com.project.api.service;

import com.project.api.model.Contacto;

import java.util.List;

public interface IContactoService {
    List<Contacto> obtenerContactos();

    Long guardarContacto(Contacto contacto);

    void eliminarContacto(Long id);

    void actualizarContactos(List<Contacto> contactos);
}
