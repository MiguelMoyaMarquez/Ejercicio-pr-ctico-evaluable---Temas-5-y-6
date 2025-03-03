package com.example.miguelmoya_ejpracticoevaluablet4t5.controller;

import com.example.miguelmoya_ejpracticoevaluablet4t5.model.Item;
import com.example.miguelmoya_ejpracticoevaluablet4t5.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para gestionar los items en la API.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    /**
     * Constructor del controlador que inyecta el servicio de items.
     *
     * @param itemService Servicio de gestión de items.
     */
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Obtiene la lista de todos los items.
     *
     * @return Lista de items disponibles.
     */
    @GetMapping("/")
    public List<Item> obtenerTodosLosItems() {
        return itemService.obtenerTodosLosItems();
    }

    /**
     * Obtiene un item por su ID.
     *
     * @param id ID del item a buscar.
     * @return Respuesta con el item si se encuentra, o un estado 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Item> obtenerItemPorId(@PathVariable Long id) {
        Optional<Item> item = itemService.obtenerItemPorId(id);
        return item.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Obtiene la lista de Items filtrado por su categoria
     *
     * @param categoria Categoria del item.
     * @return
     */
    @GetMapping("/categoria/{categoria}")
    public List<Item> obtenerItemsPorCategoria(@PathVariable String categoria) {
        return itemService.obtenerItemsPorCategoria(categoria);
    }

    /**
     * Crea un nuevo Item en la base de datos.
     *
     * @param item Objeto Item con los datos del item a crear.
     * @return Respuesta con el item creado y estado 201 si tiene éxito,
     *         o 400 si los datos no son válidos, o 500 si hay un error interno.
     */
    @PostMapping("/")
    public ResponseEntity<Item> crearItem(@RequestBody Item item) {
        if (item.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        try {
            Item nuevoItem = itemService.guardarItem(item);
            return new ResponseEntity<>(nuevoItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Elimina un item por su ID.
     *
     * @param id ID del item a eliminar.
     * @return Respuesta con estado 200 si se eliminó correctamente,
     *         o 404 si el item no existe.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        if (itemService.obtenerItemPorId(id).isPresent()) {
            itemService.eliminarItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
