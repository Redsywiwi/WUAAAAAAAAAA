package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
@Tag (name = "Salas", description = "Operaciones relacionadas con las Salas")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @GetMapping
    @Operation(summary = "Obtener todas las Salas", description = "Contiene una lista de todas las Salas")
    public List<Sala> getAllSalas() {
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una sala", description = "Muestra la sala especificada con la ID")
    public Sala getSalaById(@PathVariable Integer id) {
        return salaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una sala", description = "Crea una sala")
    public Sala createSala(@RequestBody Sala sala) {
        return salaService.save(sala);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar sala", description = "Actualiza la sala especificada con su id")
    public Sala updateSala(@PathVariable Integer id, @RequestBody Sala sala) {
        sala.setCodigo(id);
        return salaService.save(sala);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Sala", description = "Borra una sala especifica con su ID")
    public void deleteSala(@PathVariable Integer id) {
        salaService.deleteById(id);
    }
}
