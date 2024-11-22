package com.project.api.service;

import com.project.api.model.Contacto;
import com.project.api.repository.ContactoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactoServiceImpl implements IContactoService{

    @Autowired
    ContactoRepository contactoRepository;


    @Override
    public List<Contacto> obtenerContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public Long guardarContacto(Contacto contacto) {
        return contactoRepository.save(contacto).getId();
    }

    @Override
    public void eliminarContacto(Long id) {
        contactoRepository.deleteById(id);
    }

    @Override
    public void actualizarContactos(List<Contacto> contactos) {
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactoRepository.findById(contactos.get(i).getId()).orElseThrow(() -> new EntityNotFoundException("Contacto no encontrado"));
            contacto.setOrden(i);
            contactoRepository.save(contacto);
        }
    }
}
