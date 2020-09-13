package com.springboot.backend.microservicios.app.respuestas.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.backend.commons.examenes.models.entity.Examen;
import com.springboot.backend.commons.examenes.models.entity.Pregunta;
import com.springboot.backend.microservicios.app.respuestas.clients.ExamenFeignClient;
import com.springboot.backend.microservicios.app.respuestas.models.entity.Respuesta;
import com.springboot.backend.microservicios.app.respuestas.models.repository.RespuestaRespository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private ExamenFeignClient examenclient;

	@Autowired
	private RespuestaRespository repository;

	@Override
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {

		return repository.saveAll(respuestas);
	}

	@Override
	public Iterable<Respuesta> findRespuestaByAlmunoByExamen(Long alumnoId, Long examenId) {
		/*
		 * Examen examen = examenclient.obtenerExamenPorId(examenId); List<Pregunta>
		 * preguntas = examen.getPreguntas(); List<Long> preguntasIds =
		 * preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		 * List<Respuesta> respuestas = (List<Respuesta>)
		 * repository.findRespuestaByAlmunoByPreguntasIds(alumnoId, preguntasIds);
		 * respuestas = respuestas.stream().map(r -> { preguntas.forEach(p -> {
		 * if(p.getId() == r.getPreguntaId()) { r.setPregunta(p); } }); return r;
		 * }).collect(Collectors.toList());
		 */
		List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlmunoByExamen(alumnoId, examenId);
		return respuestas;
	}

	@Override
	public Iterable<Long> findExamenesIdsConRespuestasByAlmuno(Long alumnoId) {
		/*
		 * List<Respuesta> respuestasAlumno = (List<Respuesta>)
		 * repository.findByAlumnoId(alumnoId); List<Long> examenesIds =
		 * Collections.emptyList();
		 * 
		 * if(respuestasAlumno.size() > 0) { List<Long> preguntasIds =
		 * respuestasAlumno.stream().map(r ->
		 * r.getPreguntaId()).collect(Collectors.toList()); examenesIds =
		 * examenclient.obtenerExamenesIdsPorPreguntasIdRespondidas(preguntasIds); }
		 */
		List<Respuesta> respuestasAlumno = (List<Respuesta>) repository.findExamenesIdsConRespuestasByAlumno(alumnoId);
		List<Long> examenesIds = respuestasAlumno.stream().map(r -> r.getPregunta().getExamen().getId()).distinct()
				.collect(Collectors.toList());
		return examenesIds;
	}

	@Override
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
		return repository.findByAlumnoId(alumnoId);
	}

}
