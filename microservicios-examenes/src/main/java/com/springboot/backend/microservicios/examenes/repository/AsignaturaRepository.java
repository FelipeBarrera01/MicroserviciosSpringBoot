package com.springboot.backend.microservicios.examenes.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.commons.examenes.models.entity.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {

}
