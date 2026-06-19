package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag (name = "estudiante", description = "Operaciones relacionadas con los estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    @Operation(summary = "Obtener todos los estudiantes", description = "Contiene una lista de todos los estudiantes")
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estudiantes", description = "trae un estudiante especifico por su id")
    public Estudiante getEstudianteById(@PathVariable Integer id) {
        return estudianteService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear estudiante", description = "Crea un estudiante")
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar estudiante", description = "Actualiza un estudiante existente con su id")
    public Estudiante updateEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteService.save(estudiante);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar estudiante", description = "Borra un estudiante que tenga la id especificada")
    public void deleteEstudiante(@PathVariable Integer id) {
        estudianteService.deleteById(id);
    }
}
