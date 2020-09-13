package com.springboot.backend.microservicios.examenes.services;

import java.util.List;

import com.springboot.backend.commons.examenes.models.entity.Asignatura;
import com.springboot.backend.commons.examenes.models.entity.Examen;
import com.springboot.backend.commons.microservicios.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	public List<Examen> findByNombre(String term);
	public List<Asignatura> findAllAsignaturas();
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntasIds);
}
