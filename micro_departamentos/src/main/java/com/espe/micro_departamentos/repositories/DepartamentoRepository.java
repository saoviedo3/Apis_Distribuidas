package com.espe.micro_departamentos.repositories;
import com.espe.micro_departamentos.models.entities.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
}
