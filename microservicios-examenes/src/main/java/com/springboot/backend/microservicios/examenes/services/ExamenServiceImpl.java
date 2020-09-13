package com.springboot.backend.microservicios.examenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.commons.examenes.models.entity.Asignatura;
import com.springboot.backend.commons.examenes.models.entity.Examen;
import com.springboot.backend.commons.microservicios.services.CommonServiceImpl;
import com.springboot.backend.microservicios.examenes.repository.AsignaturaRepository;
import com.springboot.backend.microservicios.examenes.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		return (List<Asignatura>) asignaturaRepository.findAll();
}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntasIds) {
		return repository.findExamenesIdsConRespuestasByPreguntaIds(preguntasIds);
	}



}
