package com.springboot.backend.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.app.client.CursoFeignClient;
import com.springboot.backend.app.repository.AlumnoRepository;
import com.springboot.backend.commons.microservicios.services.CommonServiceImpl;
import com.springboot.backend.microservicios.commons.alumnos.models.entity.Alumno;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService{

	@Autowired
	private CursoFeignClient cursoClient;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		cursoClient.eliminarCursoAlumnoPorId(id);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
		eliminarCursoAlumnoPorId(id);
	}

	

}
