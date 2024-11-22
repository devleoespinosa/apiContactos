package com.project.api.repository;


import com.project.api.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto,Long> {
}
