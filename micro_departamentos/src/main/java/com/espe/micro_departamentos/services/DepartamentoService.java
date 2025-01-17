package com.espe.micro_departamentos.services;

import com.espe.micro_departamentos.models.entities.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoService {

    List<Departamento> findAll();
    Optional<Departamento> findById(Long id);
    Departamento save(Departamento departamento);
    void deleteById(Long id);
}
