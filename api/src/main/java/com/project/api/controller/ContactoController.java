package com.project.api.controller;

import com.project.api.model.Contacto;
import com.project.api.service.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ContactoController {

    @Autowired
    IContactoService contactoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("contactos/add")
    private ResponseEntity<Long> guardarContacto(@RequestBody Contacto contacto){
        Long id = contactoService.guardarContacto(contacto);
        return new ResponseEntity<>(Long.valueOf(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("contactos/delete/{id}")
    private ResponseEntity<String> eliminarContactos(@PathVariable Long id){
        contactoService.eliminarContacto(id);
        return new ResponseEntity<>("Eliminado correctamente", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("contactos/")
    private ResponseEntity<List<Contacto>> obtenerContactos(){
        List<Contacto> contactos = contactoService.obtenerContactos();
        return new ResponseEntity<>(contactos, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("contactos/")
    private ResponseEntity<String> actualizarContactos(@RequestBody List<Contacto> contactos){
        contactoService.actualizarContactos(contactos);
        return new ResponseEntity<>("Enviado correctamente", HttpStatus.OK);
    }
}
