package com.springboot.backend.microservicios.app.cursos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.commons.microservicios.services.CommonServiceImpl;
import com.springboot.backend.microservicios.app.cursos.clients.AlumnoFeignClient;
import com.springboot.backend.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.springboot.backend.microservicios.app.cursos.models.entity.Curso;
import com.springboot.backend.microservicios.app.cursos.models.repository.CursoRepository;
import com.springboot.backend.microservicios.commons.alumnos.models.entity.Alumno;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient client;
	
	@Autowired AlumnoFeignClient alumnoClient;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {
		return alumnoClient.obtenerAlumnosPorCurso(ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		repository.eliminarCursoAlumnoPorId(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		eliminarCursoAlumnoPorId(id);
	}

}
