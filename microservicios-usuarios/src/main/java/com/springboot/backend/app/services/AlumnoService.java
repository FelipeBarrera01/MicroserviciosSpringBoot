package com.springboot.backend.app.services;



import java.util.List;

import com.springboot.backend.commons.microservicios.services.CommonService;
import com.springboot.backend.microservicios.commons.alumnos.models.entity.Alumno;

public interface AlumnoService extends CommonService<Alumno> {
	
	public List<Alumno> findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllById(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
 }
