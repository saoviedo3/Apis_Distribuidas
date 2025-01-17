package com.espe.micro_departamentos.services;
import com.espe.micro_departamentos.models.entities.Departamento;
import com.espe.micro_departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository repository;

    @Override
    public List<Departamento> findAll() {

        return (List<Departamento>) repository.findAll();
    }

    @Override
    public Optional<Departamento> findById(Long id) {

        return repository.findById(id);
    }

    @Override
    public Departamento save(Departamento departamento) {

        return repository.save(departamento);
    }

    @Override
    public void deleteById(Long id) {

            repository.deleteById(id);
    }
}
