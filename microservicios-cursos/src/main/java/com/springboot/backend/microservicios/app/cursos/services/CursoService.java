package com.springboot.backend.microservicios.app.cursos.services;



import java.util.List;

import com.springboot.backend.commons.microservicios.services.CommonService;
import com.springboot.backend.microservicios.app.cursos.models.entity.Curso;
import com.springboot.backend.microservicios.commons.alumnos.models.entity.Alumno;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByAlumnoId(Long id);
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
	public List<Alumno> obtenerAlumnosPorCurso(List<Long> ids);
	public void eliminarCursoAlumnoPorId(Long id);
}
