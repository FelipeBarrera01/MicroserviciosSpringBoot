package com.springboot.backend.microservicios.app.cursos.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.backend.microservicios.commons.alumnos.models.entity.Alumno;

@FeignClient(name = "microservicio-usuarios")
public interface AlumnoFeignClient {
	
	@GetMapping("/alumnos-por-curso")
	public List<Alumno> obtenerAlumnosPorCurso(@RequestParam List<Long> ids);
}
