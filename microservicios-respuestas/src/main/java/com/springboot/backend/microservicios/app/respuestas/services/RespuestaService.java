package com.springboot.backend.microservicios.app.respuestas.services;

import com.springboot.backend.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaService {
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);
	public Iterable<Respuesta> findRespuestaByAlmunoByExamen(Long alumnoId, Long examenId);
	public Iterable<Long> findExamenesIdsConRespuestasByAlmuno(Long alumnoId);
	public Iterable<Respuesta> findByAlumnoId(Long alumnoId);
}
