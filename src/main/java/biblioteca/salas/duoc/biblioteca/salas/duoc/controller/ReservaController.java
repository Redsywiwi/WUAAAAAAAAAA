package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@Tag (name = "Reservas", description = "Operaciones relacionadas con las reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    @Operation(summary = "Obtener todas las reservas", description = "Contiene una lista de todas las reservas")
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reserva", description = "trae una reserva especifica por su id")
    public Reserva getReservaById(@PathVariable Integer id) {
        return reservaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear reserva", description = "Crea una reserva")
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar reserva", description = "Actualiza una reserva existente con su id")
    public Reserva updateReserva(@PathVariable Integer id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar reserva", description = "Borra una reserva que tenga la id especificada")
    public void deleteReserva(@PathVariable Integer id) {
        reservaService.deleteById(id);
    }
}