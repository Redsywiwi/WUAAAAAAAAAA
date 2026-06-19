package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-salas")
@Tag (name = "Tipos de salas", description = "Operaciones relacionadas con los tipos de salas")
public class TipoSalaController {
    @Autowired
    private TipoSalaService tipoSalaService;

    @GetMapping
    @Operation(summary = "Obtener todas los tipo de salas", description = "Contiene una lista de todas los tipos de salas")
    public List<TipoSala> getAllTipoSalas() {
        return tipoSalaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de sala", description = "trae un tipo de sala por su id")
    public TipoSala getTipoSalaById(@PathVariable Integer id) {
        return tipoSalaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear tipo de sala", description = "Crea un tipo de sala")
    public TipoSala createTipoSala(@RequestBody TipoSala tipoSala) {
        return tipoSalaService.save(tipoSala);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar tipo de sala", description = "Actualiza un tipo de sala existente con su id")
    public TipoSala updateTipoSala(@PathVariable Integer id, @RequestBody TipoSala tipoSala) {
        tipoSala.setIdTipo(id);
        return tipoSalaService.save(tipoSala);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar tipo de sala", description = "Borra un tipo de sala que tenga la id especificada")
    public void deleteTipoSala(@PathVariable Integer id) {
        tipoSalaService.deleteById(id);
    }
}
