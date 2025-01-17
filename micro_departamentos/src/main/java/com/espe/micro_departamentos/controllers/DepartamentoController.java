package com.espe.micro_departamentos.controllers;

import com.espe.micro_departamentos.models.entities.Departamento;
import com.espe.micro_departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
@Validated
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Departamento departamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departamento));
    }

    @GetMapping
    public List<Departamento> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Departamento> libroOptional = service.findById(id);

        if (libroOptional.isPresent()) {
            return ResponseEntity.ok(libroOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Departamento departamento, @PathVariable Long id) {
        Optional<Departamento> libroOptional = service.findById(id);

        if (libroOptional.isPresent()) {
            Departamento departamentoDB = libroOptional.get();
            departamentoDB.setNombre(departamento.getNombre());
            departamentoDB.setJefe(departamento.getJefe());
            departamentoDB.setEmpleados(departamento.getEmpleados());
            departamentoDB.setFechaCreacion(departamento.getFechaCreacion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(departamentoDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Departamento> libroOptional = service.findById(id);
        if (libroOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().body("El registro se eliminó correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro con el ID " + id + " no fue encontrado.");
    }

}
