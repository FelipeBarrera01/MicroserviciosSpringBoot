package com.springboot.backend.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;

@FeignClient(name = "microservicio-cursos")
public interface CursoFeignClient {
	
	@DeleteMapping("/eliminar-alumno/{id}")
	public void eliminarCursoAlumnoPorId( Long id);
}
